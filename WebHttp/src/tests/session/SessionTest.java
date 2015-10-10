package tests.session;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  PrintWriter lvOut =  response.getWriter();
	  HttpSession lvSession =  request.getSession();
	  lvSession.setMaxInactiveInterval(10);
	  
	  lvOut.println("ID =" + lvSession.getId());
	  Calendar lvCal =  Calendar.getInstance();
	  lvCal.setTimeInMillis(lvSession.getCreationTime());
	  lvOut.println("getCreationTime():"  + lvCal.getTime());
	  lvCal.setTimeInMillis(lvSession.getLastAccessedTime());
	  lvOut.println("getLastAccessedTime():"  +  lvCal.getTime());
	  lvOut.println("getMaxInactiveInterval():"  + lvSession.getMaxInactiveInterval());
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
