package com.bid.emanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.bid.emanager.authentication.RestAuthenticationEntryPoint;
import com.bid.emanager.authentication.SuccessfulAuthenticationHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final RestAuthenticationEntryPoint authenticationEntryPoint;
	private final SuccessfulAuthenticationHandler successHandler;
	private final AuthenticationFailureHandler failureHandler;
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	    .authorizeRequests()
	    	.antMatchers("/user/register").permitAll()
	    	.antMatchers("/user/signin").permitAll()
	    	.antMatchers("/user/logout").permitAll()
	    	.antMatchers("/login").permitAll()
	    	.antMatchers("/status").permitAll()
	    	.antMatchers("/v2/api-docs", "/configuration/ui",  "/swagger-resources", "/swagger-resources/**",
	    			"/configuration/security", "/swagger-ui.html", "/webjars/**", "/csrf").permitAll()
	    	.anyRequest().fullyAuthenticated()
	    .and().formLogin().loginProcessingUrl("/user/login").successHandler(successHandler).failureHandler(failureHandler)
	    .and().logout().logoutUrl("/user/logout").deleteCookies("SESSIONID").invalidateHttpSession(true)
	    	.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
	    .and().exceptionHandling()
	    .authenticationEntryPoint(authenticationEntryPoint).and()
	    .csrf().disable();
	  }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	@Bean
	@Profile("dev")
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    return loggingFilter;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
