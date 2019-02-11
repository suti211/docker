package com.bid.emanager.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bid.emanager.user.web.UserDTO;
import com.bid.emanager.validators.exception.CredentialValidationException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor= @__({ @Autowired }))
public class UserValidator {
	
	private final EmailValidator emailValidator;
	private final PasswordValidator passwordValidator;
	
	public boolean validateUser(UserDTO userDTO) {
		boolean isValidUser = false;
		try {
			if (emailValidator.validateEmail(userDTO.getEmail()) && passwordValidator.isPasswordValid(userDTO.getPassword(), userDTO.getRepeatPassword())) {
				isValidUser = true;
			}
			
		} catch (CredentialValidationException e) {
			log.error("Failed to validate user credentials!", e);
		}
		
		return isValidUser;
	}
}
