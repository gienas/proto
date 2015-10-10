package pl.ene.beans;

import javax.ejb.Stateless;

@Stateless
public class TestBeanImpl implements TestBean {

	
	public String go()
	{
		return "greetings from bean";
	}
}
