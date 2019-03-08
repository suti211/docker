package com.bid.emanager.validators.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CredentialValidationException extends Exception {
	protected String message;
	protected Throwable payload;
}
