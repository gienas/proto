package security;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component 
public class MyUserDetailsService  implements UserDetailsService{

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername:  " + username);
		return new MyUserDetails(username, "");
	}
	
	
}
