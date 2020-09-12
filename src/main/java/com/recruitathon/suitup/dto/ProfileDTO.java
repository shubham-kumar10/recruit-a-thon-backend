package com.recruitathon.suitup.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Skills;
import com.recruitathon.suitup.service.FileService;

public class ProfileDTO implements Serializable {

	static final long serialVersionUID = 1098L;

	private String city;

	private String country;

	private byte[] profilePicture;

	private Collection<Skills> skills;

	private Collection<Experience> experience;

	private String firstName;

	private String lastName;

	private long id;

	private long contactNumber;

	private String userName;

	
	public ProfileDTO() {
		super();
	}

	public ProfileDTO(String city, String country, byte[] profilePicture, String firstName, String lastName, Long id, Long contactNumber,
			String userName) {
		super();
		this.city = city;
		this.country = country;
		this.profilePicture = profilePicture!=null && profilePicture.length>0 ? FileService.decompressBytes(profilePicture): profilePicture;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.contactNumber = contactNumber;
		this.userName = userName;
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

	public Collection<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public Collection<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
