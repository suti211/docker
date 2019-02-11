package com.bid.emanager.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter{

	private final DaoAuthenticationProvider authenticationProvider;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
}
