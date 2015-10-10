package client.common;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import client.model.Hello;
import client.model.HelloService;

public class MainClient {

	public static void main(String[] args) {
		try {
			System.setProperty("http.proxyHost", "localhost");
			System.setProperty("http.proxyPort", "8888");

			// System.setProperty("http.proxyHost", "localhost");
			// System.setProperty("http.proxyPort", "8888");
			// System.setProperty("http.nonProxyHosts","aaa");

			HelloService service = new HelloService(new URL(
					"http://localhost:8080/JaxWsHello/JaxWsHello?wsdl"),
					new QName("http://endpoint.helloservice/", "HelloService"));
			System.out
					.println("Retrieving the port from the following service: "
							+ service);
			Hello port = service.getHelloPort();

			// CXF
			org.apache.cxf.endpoint.Client client = ClientProxy.getClient(port);
			org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
			Map<String, Object> outProps = new HashMap<String, Object>();
			outProps.put(WSHandlerConstants.ACTION, "Signature");
			//alias z certyfikatu
			outProps.put(WSHandlerConstants.USER, "clientx509v1");
			outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
					ClientPasswordCallback.class.getName());
			outProps.put(WSHandlerConstants.SIG_PROP_FILE,
					"etc/client_sign.properties");
//			outProps.put(WSHandlerConstants.ACTION,
//					WSHandlerConstants.TIMESTAMP + " "
//							+ WSHandlerConstants.SIGNATURE);
			outProps.put(WSHandlerConstants.ACTION,WSHandlerConstants.SIGNATURE);
			
			WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
			cxfEndpoint.getOutInterceptors().add(wssOut);
 
			// Map requestContext = ((BindingProvider)port).getRequestContext();
			// requestContext.put(BindingProvider.USERNAME_PROPERTY,
			// "eneugebauer");
			// requestContext.put(BindingProvider.PASSWORD_PROPERTY, "4844");
			System.out.println("Invoking the sayHello operation on the port.");

			String response = port.sayHello("Eugeniusz");
			System.out.println("Response:" + response);

		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("http.proxyHost = "
				+ System.getProperty("http.proxyHost"));
		System.out.println("http.proxyPort = "
				+ System.getProperty("http.proxyPort"));
		System.out.println("http.nonProxyHosts = "
				+ System.getProperty("http.nonProxyHosts"));
	}

}
