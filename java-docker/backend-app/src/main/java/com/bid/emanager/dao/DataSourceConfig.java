package com.bid.emanager.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataSourceConfig {
	
	@Value("${database.user}")
	private String dbUser;
	
	@Value("${database.pass}")
	private String dbPassword;
	
	@Value("${database.url}")
	private String dbUrl;
	
	@Value("${database.driver}")
	private String dbDriver;
	
	@Bean
	public DataSource mysqlConnection() {
		return DataSourceBuilder.create()
				.username(dbUser)
				.password(dbPassword)
				.url(dbUrl)
				.driverClassName(dbDriver)
				.build();
	}
}
