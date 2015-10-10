package listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @author eneugebauer
 *
 */
public class MyContextListner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub		
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

}
