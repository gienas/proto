package pl.ene.business;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldImpl implements HelloWorld {

	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello World from session bean";
	}

}
