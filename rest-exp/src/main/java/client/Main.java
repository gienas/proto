package client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://localhost:8080/rest-exp/todos").build());

		System.out.println(service.accept(MediaType.TEXT_XML)
				.get(String.class));
		
	}

}
