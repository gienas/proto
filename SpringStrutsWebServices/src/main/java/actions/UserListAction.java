package actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;
import domain.User;
@ParentPackage(value = "json-default")
@Namespace(value = "/str")
@Results(
		{ @Result(name = "success",  location = "/str/index.jsp"), 
		  @Result(name="json", type="json")	
		}
)
public class UserListAction {

	public List<User> users = new ArrayList<User>();

	public User user;

	public UserListAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserService userService;


	@Action(value="getAllJson")
	public final String getAllJson() {
		users = userService.getAll();
		user = null;
		Map<String, String> map= new HashMap<String, String>();
		map.put("ala", "aaa");
		return "json";
	}
	
	/**
	 * 
	 * @return
	 */
	@Action(value = "getAll")
	public final String getAll() {
		System.out.println("Get all action");
		users = userService.getAll();
		user = null;
		return "success";
	}

	/**
	 * 
	 * @return
	 */
	@Action(value = "updateUser")
	public final String updateUser() {
		userService.saveOrUpdate(user);
		users = userService.getAll();
		user = null;
		return "success";
	}

	/**
	 * 
	 * @return
	 */
	@Action(value = "editUser")
	public final String editUser() {
		users = userService.getAll();
		user = userService.get(user);
		return "success";
	}
	
	/**
	 * 
	 */
	@Action(value = "deleteUser")
	public final String  deleteUser() {
		userService.delete(user);
		users = userService.getAll();
		return "success";
	}
	
	/**
	 * 
	 * @return
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * 
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
