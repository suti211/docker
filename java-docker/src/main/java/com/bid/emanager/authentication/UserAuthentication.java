package com.bid.emanager.authentication;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthentication implements Authentication {
	
	// ide felvehetünk propertyket amik sessionben az
	// autentikációval le lesznek tárolva

	private static final long serialVersionUID = -7781593065963404044L;
	private final Authentication authentication;
	
	@Override
	public String getName() {
		return this.authentication.getName();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authentication.getAuthorities();
	}

	@Override
	public Object getCredentials() {
		return this.authentication.getCredentials();
	}

	@Override
	public Object getDetails() {
		return this.authentication.getDetails();
	}

	@Override
	public Object getPrincipal() {
		return this.authentication.getPrincipal();
	}

	@Override
	public boolean isAuthenticated() {
		return this.authentication.isAuthenticated();
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authentication.setAuthenticated(isAuthenticated);

	}

}
