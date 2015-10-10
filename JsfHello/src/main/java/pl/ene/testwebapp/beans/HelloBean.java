
package pl.ene.testwebapp.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 
@ManagedBean(name="helloBean", eager=true)
@SessionScoped   
public class HelloBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
 
	private String name;

	
	public HelloBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
}