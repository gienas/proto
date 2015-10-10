package actions;

import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import domain.User;

public class BaseUserAction extends ActionSupport implements ModelDriven<User> {

	private String emailId;

	@Autowired
	private UserService service;

	private User user;

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public UserService getService() {
		System.out.println(getClass().getName() + " /" + " getService "
				+ service);
		return service;
	}

	public void setService(UserService service) {
		System.out.println(getClass().getName() + " /" + "setService "
				+ service);
		this.service = service;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	// @Override
	// public void prepare() throws Exception
	// {
	// System.out.println(getClass().getName() + " /" + " prepare " + user);
	// // TODO Auto-generated method stub
	// if (emailId == null || "".equals(emailId))
	// {
	// user = new User();
	// }
	// else
	// {
	// user = service.findByEmail(emailId);
	//
	// }
	// }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
