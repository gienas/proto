package listners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyContextAttributeListner  implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());		
	}

}
