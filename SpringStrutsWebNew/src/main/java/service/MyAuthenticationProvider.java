package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import security.MyUserDetails;

@Component(value = "myAuthenticationProvider")
public class MyAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	@Autowired
	UserService userService;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String email,
			UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println(token.getCredentials());
		MyUserDetails myUserDetails =  userService.find(email, token.getCredentials().toString());
		if ( myUserDetails == null)
		throw new BadCredentialsException("nie uda³o siê");
		return myUserDetails;
	}

	// @Override
	// public boolean supports(Class<? extends Object> authentication) {
	// return authentication.equals(UsernamePasswordAuthenticationToken.class);
	// }
	//
	// @Override
	// public Authentication authenticate(Authentication authentication) {
	// System.out.println("NAME = " + authentication.getName());
	// System.out.println("NAME = " +
	// authentication.getCredentials().toString());
	//
	// //pobierz role
	// List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	// authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
	//
	// //stwórz return
	// UsernamePasswordAuthenticationToken lvToken =
	// new UsernamePasswordAuthenticationToken(authentication.getName(),
	// authentication.getCredentials(), authorities);
	// lvToken.setAuthenticated(true);
	//
	// return lvToken;
	// }

}
