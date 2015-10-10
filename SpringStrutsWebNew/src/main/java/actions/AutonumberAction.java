package actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import domain.Autonumber;

import service.AutonumberService;
import service.MessagingService;

/**
 * 
 * @author eneugebauer
 *
 */

@ParentPackage(value = "json-default")
@Namespace(value = "/str")
@Results({ @Result(name = "success", location = "/str/autonumer.jsp"),
		@Result(name = "json", type = "json") })
public class AutonumberAction {

	private Autonumber autonumber;
	
	@Autowired
	private AutonumberService service;
	
	@Action(value = "getAutonumber")
	public final String sendRightEmail() {
		
		autonumber = service.getNextValue(autonumber.getKey());
		
		return "success";
	}

	public Autonumber getAutonumber() {
		return autonumber;
	}

	public void setAutonumber(Autonumber autonumber) {
		this.autonumber = autonumber;
	}

	public AutonumberService getService() {
		return service;
	}

	public void setService(AutonumberService service) {
		this.service = service;
	}
	
	
	
}
