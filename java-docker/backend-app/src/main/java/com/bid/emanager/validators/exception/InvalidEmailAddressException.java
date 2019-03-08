package com.bid.emanager.validators.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidEmailAddressException extends CredentialValidationException {
	public InvalidEmailAddressException(String message) {
		super.message = message;
	}
		
}
