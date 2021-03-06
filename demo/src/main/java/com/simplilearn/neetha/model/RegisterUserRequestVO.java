package com.simplilearn.neetha.model;

public class RegisterUserRequestVO {
	
	private int id;
	private String userId;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private int contactId;
	public String getUserId() {
		return userId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	@Override
	public String toString() {
		return "RegisterUserRequestVO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + role + ", contactId=" + contactId + "]";
	}
	
	

}
