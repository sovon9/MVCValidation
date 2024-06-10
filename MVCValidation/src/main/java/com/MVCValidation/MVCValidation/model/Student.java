package com.MVCValidation.MVCValidation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

	@NotNull(message = "firstName must be provided")
	@Size(min=2, message = "name size must be minimum two charecters")
	private String firstName;
	
	@NotNull(message = "lastName must be provided")
	@Size(min=2, message = "name size must be minimum two charecters")
	private String lastName;

	
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
