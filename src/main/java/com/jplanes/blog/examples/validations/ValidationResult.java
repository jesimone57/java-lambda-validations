package com.jplanes.blog.examples.validations;


import java.util.List;

public class ValidationResult {
	private boolean valid;
	private String messsage;
	
	public static ValidationResult ok(){
		return new ValidationResult(true, null);
	}
	
	public static ValidationResult fail(String message){
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
		if(!isvalid()) throw new IllegalArgumentException(getMesssage());
	}
	
	public void throwIfInvalid(String fieldName) {
		if(!isvalid()) throw new IllegalArgumentException(fieldName + " : " + getMesssage());
	}

	public void collectIfInvalid(String message, List<ValidationResult> results) {
		if(!isvalid()) results.add(new ValidationResult(false, message));
	}
	
	public String getMesssage() {
		return messsage;
	}
}
