package integration;

import java.io.Serializable;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService, Serializable {

//	static
//	{
//		System.setSecurityManager(new RMISecurityManager());
//	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -7569841120915689534L;

	public void insertAccount(Account acc) {
		// do something...
	}

	public List getAccounts(String name) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("ala ma psa");
		// do something...
		return list;
	}
}
