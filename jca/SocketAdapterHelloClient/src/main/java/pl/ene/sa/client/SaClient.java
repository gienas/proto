package pl.ene.sa.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.adapter.RAConnection;
import com.sample.adapter.RAConnectionFactoryImpl;

/**
 * Servlet implementation class SaClient
 */
public class SaClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// @Resource( mappedName = "java:/eis/SocketAdapterHello")
	//public RAConnectionFactory connectionFactory;

	// (mappedName = "java:/eis/SocketAdapter")
	// 06.private RAConnectionFactory connectionFactory;

	/**
	 * Default constructor.
	 */
	public SaClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// OutputStream out = response.getOutputStream();
		
		RAConnectionFactoryImpl cfa = null;
		try {
			Context initCtx = new InitialContext();
			cfa = (RAConnectionFactoryImpl) initCtx
					.lookup("java:/eis/SocketAdapterHello");
			
			RAConnection connection=null;
			connection = cfa.getConnection();
			PrintWriter out = response.getWriter();
			out.println("Message sent");
			String result1 = connection.write("Hello adapter !!! ");
			out.println("Result = " + result1);
			out.flush();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//response.getOutputStream().println("Hello world " + cfa);
		
		// PrintWriter pw = new PrintWriter(out);
		// pw.println("Hello world form connector adapter client");
		// response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}



}
