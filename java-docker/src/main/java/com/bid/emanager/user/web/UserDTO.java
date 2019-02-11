package com.bid.emanager.user.web;

import lombok.Data;

@Data
public class UserDTO {
	private String firstName;
	private String lastName;
	private String password;
	private String repeatPassword;
	private String email; 
}
