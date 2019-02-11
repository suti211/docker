package com.bid.emanager.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.bid.emanager.validators.exception.InvalidEmailAddressException;

@Component
public class EmailValidator {

	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	private static Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 * @throws InvalidEmailAddressException 
	 */
	public boolean validateEmail(String email) throws InvalidEmailAddressException {
		Matcher matcher = pattern.matcher(email);
		boolean isValid = matcher.matches();
		if (isValid) {
			return true;
		} else {
			throw new InvalidEmailAddressException();
		}
	}
}
