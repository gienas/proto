package listners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListner implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());	
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());	
	}

}
