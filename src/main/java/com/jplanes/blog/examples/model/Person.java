package com.jplanes.blog.examples.model;


public class Person {
	private String firstName;
	private String lastName;
	private String email;
	private int age;
	
	public Person(String firstName, String lastName, String email, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String s) {
		this.firstName = s;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String s) {
		this.lastName = s;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String s) {
		this.email = s;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
