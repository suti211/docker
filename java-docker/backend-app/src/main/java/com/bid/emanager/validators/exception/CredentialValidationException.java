package com.bid.emanager.validators.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CredentialValidationException extends Exception {
	String message;
	Throwable payload;
}
