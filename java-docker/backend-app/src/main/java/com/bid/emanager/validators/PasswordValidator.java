package com.bid.emanager.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.bid.emanager.validators.exception.CredentialValidationException;
import com.bid.emanager.validators.exception.NotMatchingPasswordException;
import com.bid.emanager.validators.exception.NotStrongEnoughException;
import com.bid.emanager.validators.exception.PasswordTooShortException;

@Component
public class PasswordValidator {

	/**
	 * Validates password length, password strength (min 8 characters, at least 1
	 * digit, at least lower and Uppercase letters)
	 */
	private static final int MIN_PW_LENGTH = 8;
	private static final String PASSWORD_STRENGTH_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
	private static Pattern pattern = Pattern.compile(PASSWORD_STRENGTH_REGEX, Pattern.CASE_INSENSITIVE);

	private boolean isLengthValid(String password) throws PasswordTooShortException {
		boolean isLengthValid = password.length() >= MIN_PW_LENGTH;
		if (isLengthValid) {
			return true;
		} else {
			throw new PasswordTooShortException();
		}
	}

	private boolean isMatchingValid(String password, String repeatPassword) throws NotMatchingPasswordException {
		boolean isMatching = StringUtils.equals(password, repeatPassword);
		if (isMatching) {
			return true;
		} else {
			throw new NotMatchingPasswordException();
		}
	}

	private boolean isStrengthValid(String password) throws NotStrongEnoughException {
		Matcher matcher = pattern.matcher(password);
		boolean isStrongEnough = matcher.matches();

		if (isStrongEnough) {
			return true;
		} else {
			throw new NotStrongEnoughException();
		}
	}

	public boolean isPasswordValid(String password, String repeatPassword) throws CredentialValidationException {
		return isLengthValid(password) && isMatchingValid(password, repeatPassword) && isStrengthValid(password);
	}
}
