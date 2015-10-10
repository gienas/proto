package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author eneugebauer
 *
 */
public class FirstFilter implements Filter{

	private FilterConfig mConfig = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		mConfig.getServletContext().log("Informacje o uzytkowniku" +  ((HttpServletRequest)request).getRemoteUser() != null ? ((HttpServletRequest)request).getRemoteUser(): " brak informacji o u¿ytkowniku" );
		System.out.println("Filter to ja");
		request.setAttribute("paramFilter", mConfig.getInitParameter("paramFilter")); 
		//ENE 2012-03-04
		chain.doFilter(request, response);
		response.getWriter().println("Hello from filter");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		mConfig = config;
	}

}
