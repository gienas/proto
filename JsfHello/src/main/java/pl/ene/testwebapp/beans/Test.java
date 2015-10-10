package pl.ene.testwebapp.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Test {

	public String aaa = ""; 
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public String go()
	{
		aaa = "Ala ma kota"; 
		return "qweqwe";
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	
}
