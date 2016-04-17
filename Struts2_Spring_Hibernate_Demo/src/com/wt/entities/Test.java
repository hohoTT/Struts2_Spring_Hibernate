package com.wt.entities;

public class Test {

	private String lastName;
	private String email;
	
	public Test(String lastName, String email) {
		super();
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
