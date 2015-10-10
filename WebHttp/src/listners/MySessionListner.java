package listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListner implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

}
