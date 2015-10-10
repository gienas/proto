package pl.ene.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ene.business.HelloWorld;

/**
 * Servlet implementation class TomeeServlet
 */
public class TomeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	public HelloWorld helloBean;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TomeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		if ( helloBean == null )
		{
			getServletContext().log(" Bean is null");
			out.println("Bean is null");
		}	
		out.println(helloBean==null ? "Hello world from servlet": helloBean.sayHello());
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
