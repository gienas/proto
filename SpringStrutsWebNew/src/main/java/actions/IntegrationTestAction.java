package actions;

import java.util.ArrayList;
import java.util.List;

import integration.Account;
import integration.AccountService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.bcel.internal.generic.NEW;

import service.UserService;

@ParentPackage(value = "json-default")
@Namespace(value = "/str")
@Results(
		{ @Result(name = "success",  location = "/str/integration.jsp"), 
		  @Result(name="json", type="json")	
		}
)
public class IntegrationTestAction {

	public String test = " Ala ma kota";
	
	public List<Account> accountList = new ArrayList<Account>();
	
	//Wstrzykniêcie poprzez konfiguracjê
	private AccountService service;
	
	@Action(value = "integration")
	public String go()
	{	
		accountList = service.getAccounts("");
		System.out.println("pobrano listê" + accountList);
		return "success";
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public AccountService getService() {
		return service;
	}

	public void setService(AccountService service) {
		this.service = service;
	}
	
	
}
