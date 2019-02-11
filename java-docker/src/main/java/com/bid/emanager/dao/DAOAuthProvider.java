package com.bid.emanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bid.emanager.authentication.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class DAOAuthProvider {

	private final CustomUserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptEncoder;
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(bCryptEncoder);
		dao.setUserDetailsService(userDetailsService);
		return dao;
	}
}
