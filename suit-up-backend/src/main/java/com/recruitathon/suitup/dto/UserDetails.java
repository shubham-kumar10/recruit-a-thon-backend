package com.recruitathon.suitup.dto;

public class UserDetails {
	private long id;
	private String firstname;
	private String lastname;
	private String username;
	private String token;
	private String role;
	private long contactnumber;
	private boolean confirmedSignup;
	
	public UserDetails() {
		super();
	}
	public UserDetails(long id, String firstname, String lastname, String username, String token, String role,
			long contactnumber, boolean confirmedSignup) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.token = token;
		this.role = role;
		this.contactnumber = contactnumber;
		this.confirmedSignup = confirmedSignup;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public boolean isConfirmedSignup() {
		return confirmedSignup;
	}
	public void setConfirmedSignup(boolean confirmedSignup) {
		this.confirmedSignup = confirmedSignup;
	}
	
}
