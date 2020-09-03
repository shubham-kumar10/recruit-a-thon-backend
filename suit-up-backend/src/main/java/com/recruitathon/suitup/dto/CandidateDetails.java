package com.recruitathon.suitup.dto;

import java.sql.Date;
import java.util.List;

public class CandidateDetails {
	
	private Long id;
	private Date dateOfBirth;
	private String gender;
	private String bio;
	private String country;
	private String city;
	private byte profilePicture[];
	private byte resume[];
	private List<ApplicationDetails> applications;
	
	
	public CandidateDetails(Long id, Date dateOfBirth, String gender, String bio, String country, String city,
			byte[] profilePicture, byte[] resume) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.country = country;
		this.city = city;
		this.profilePicture = profilePicture;
		this.resume = resume;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public byte[] getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public List<ApplicationDetails> getApplications() {
		return applications;
	}
	public void setApplications(List<ApplicationDetails> applications) {
		this.applications = applications;
	}
		
}
