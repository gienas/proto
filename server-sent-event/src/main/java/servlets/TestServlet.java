package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getOutputStream().println("Hello World");
//		response.getOutputStream().println("servlet patch = " + request.getServletPath());
//		response.getOutputStream().println("servlet patch info = " + request.getPathInfo());
//		response.getOutputStream().println("context patch = " + request.getContextPath());
		
		HttpSession session = request.getSession(true);
		List<String> loggedUsers = (ArrayList<String>)session.getAttribute("loggedUsers");
		if ( loggedUsers == null)
		{
			loggedUsers = new ArrayList<String>();
		}	
		loggedUsers.add(Thread.currentThread().getName());
		session.setAttribute("loggedUsers", loggedUsers);
		
		response.setContentType("text/event-stream");
		PrintWriter out = response.getWriter();
		while(true)
		{
			out.print("event: server-time\n");
			out.print("data: "  + "/" + loggedUsers + " /" + new Date().toString()+"\n\n");
			out.flush() ;
			try{
				Thread.sleep(2000);
			}
			catch ( InterruptedException e)
			{
				e.printStackTrace();
			}
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getOutputStream().println("Hello World");
	}

}
