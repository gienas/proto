package listners;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionParameter  implements HttpSessionBindingListener{

	private String name;
	private String value;
	
	
	
	public SessionParameter(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Klasa " + getClass().getName() + " metoda: "+ Thread.currentThread().getStackTrace()[3].getMethodName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
