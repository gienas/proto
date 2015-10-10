package pl.ene.testwebapp.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.ene.testwebapp.services.Service;
 
@ManagedBean
@SessionScoped
public class HelloWorldBean implements Serializable {
 
  public HelloWorldBean() {
		super();
		// TODO Auto-generated constructor stub
	}

private String name = "";
 
  @ManagedProperty(value = "#{demoService}")
  private Service service;
 
  public String getName() {
    return name;
  }
 
  public void setName(String name) {
    this.name = name;
  }
 
  public void setService(Service service) {
    this.service = service;
  }
 
  public String getReverseName() {
    return service.reverse(name);
  }
}