package pl.ene.testwebapp.services;

import javax.faces.bean.*;

@ManagedBean(name="demoService")
@ApplicationScoped
public class Service {
 
  public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

public String reverse(String name) {
    return new StringBuffer(name).reverse().toString().toLowerCase();
  }
}
