package com.recruitathon.suitup.dto;

import java.util.List;

import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Skills;

public class Profile {
	private String firstname;
	private String lastname;
	private long userId;
    private long contact;
    private String email;
    private String city;
    private String country;
    private byte[] profilePicture;
    private List<Skills> skills;
    private List<Experience> experience;
	public String getFirstname() {
		return firstname;
	}
	
	public Profile(String firstname, String lastname, long userId, long contact, String email, String city,
			String country, byte[] profilePicture, List<Skills> skills, List<Experience> experience) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.userId = userId;
		this.contact = contact;
		this.email = email;
		this.city = city;
		this.country = country;
		this.profilePicture = profilePicture;
		this.skills = skills;
		this.experience = experience;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	public List<Experience> getExperience() {
		return experience;
	}
	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}
}
