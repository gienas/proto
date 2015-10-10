package pl.ene.business;

import javax.ejb.Local;

@Local
public interface HelloWorld {

	public String sayHello();
	
}
