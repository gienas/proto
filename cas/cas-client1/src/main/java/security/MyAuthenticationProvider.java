package security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component(value = "myAuthenticationProvider")
public class MyAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {


	
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String login,
			UsernamePasswordAuthenticationToken token)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println(token.getCredentials());
		
		if ( 1==0)
		{	
		throw new BadCredentialsException("nie uda³o siê");
		}
		
		UserDetails ud = new MyUserDetails(login, token.getPrincipal().toString());
		
		return  ud;
	}

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return super.authenticate(authentication);
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
