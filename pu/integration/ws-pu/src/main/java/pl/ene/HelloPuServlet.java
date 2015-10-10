package pl.ene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ene.beans.TestBean;

/**
 * Servlet implementation class FormDataAction
 */

public class HelloPuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	TestBean testBean;
	
    /**
     * Default constructor. 
     */
    public HelloPuServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello PU");
		response.getWriter().println("Hello PU, EJB state = "  + (testBean == null ? " null": testBean.go()) );
	}

	

}
