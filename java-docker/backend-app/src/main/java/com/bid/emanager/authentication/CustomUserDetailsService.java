package com.bid.emanager.authentication;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.bid.emanager.entity.Role;
import com.bid.emanager.entity.User;
import com.bid.emanager.user.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class CustomUserDetailsService implements UserDetailsService {

	private final UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByEmail(username);
		
		if (user != null) {
			Set<Role> roles = user.getRoles();
			return new org.springframework.security.core.userdetails.User(user.getFirstName() + " " + user.getLastName(), user.getPassword(), user.getActive() == 1, user.getAccountExpired() != 1, user.getCredentialsExpired() != 1, user.getLocked() != 1, roles );
		} else {
			throw new UsernameNotFoundException("User couldn't find user with userid:" + "'" + username +"'!");
		}
	}

}
