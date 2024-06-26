package com.MVCValidation.MVCValidation.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {

	@NotNull(message = "firstName is required")
	/*
	 * notempty check only works when giving one space by providing multiple space this validation will fail
	 */
	@NotEmpty(message = "firstName can not be empty")
	/*
	 * notblank works even if you providing multiple spaces
	 */
	@NotBlank(message = "firstName can not be blank")
	@Size(min=2, message = "name size must be minimum two charecters")
	private String firstName;
	
	@NotEmpty(message = "lastName is required")
	@NotNull(message = "lastName is required")
	@Size(min=2, message = "name size must be minimum two charecters")
	private String lastName;

	@Pattern(regexp = "^[0-9]{10}", message = "incorrect phone number")
	private String phnumber;
	
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

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", phnumber=" + phnumber + "]";
	}
	
}
