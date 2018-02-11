package com.jplanes.blog.examples.validations;


import java.util.List;

public class ValidationResult {
	private boolean valid;
	private String messsage;

	public static ValidationResult ok() {
		return new ValidationResult(true, null);
	}

	public static ValidationResult fail(String message) {
		return new ValidationResult(false, message);
	}

	private ValidationResult(boolean valid, String messsage) {
		this.valid = valid;
		this.messsage = messsage;
	}

	public boolean isvalid() {
		return valid;
	}

	public void throwIfInvalid() {
		if (!isvalid()) throw new IllegalArgumentException(getMesssage());
	}

	public void throwIfInvalid(String fieldName) {
		if ( ! isvalid()) throw new IllegalArgumentException(fieldName + " : " + getMesssage());
	}

	// supplant the message with a new message
	public void collectIfInvalid(String message, List<ValidationResult> results) {
		if ( ! isvalid()) results.add(new ValidationResult(false, message));
	}

	// just the message itself
	public void collectIfInvalid(List<ValidationResult> results) {
		if ( ! isvalid()) results.add(new ValidationResult(false, getMesssage()));
	}

	// orepend the fieldname to message
	public void collectIfInvalid(List<ValidationResult> results, String fieldName) {
		if ( ! isvalid()) results.add(new ValidationResult(false, fieldName + " : " + getMesssage()));
	}

	public String getMesssage() {
		return messsage;
	}
}
