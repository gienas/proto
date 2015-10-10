package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private String muser;
	private String mpassword;
	
	public MyUserDetails(String user, String password)
	{
		muser = user;
		mpassword = password;
	}	
	

	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	     authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
		return authorities;
	}

	
	public String getPassword() {
		// TODO Auto-generated method stub
		return mpassword;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return muser;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
