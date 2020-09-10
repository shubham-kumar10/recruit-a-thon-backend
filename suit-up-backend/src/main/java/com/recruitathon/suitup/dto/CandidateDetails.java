package com.recruitathon.suitup.dto;

import java.sql.Date;
import java.util.List;

import com.recruitathon.suitup.model.Application;
import com.recruitathon.suitup.model.Education;
import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Project;
import com.recruitathon.suitup.model.Skills;

public class CandidateDetails {
	
	private Long id;
	private Date dateOfBirth;
	private String gender;
	private String bio;
	private String country;
	private String city;
	private byte profilePicture[];
	private byte resume[];
	private List<Application> applications;
	private List<Education> education;
	private List<Project> project;
	private List<Experience> experience;
	private List<Skills> skills;
	
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

	public CandidateDetails(Long id, Date dateOfBirth, String gender, String bio, String country, String city,
			List<Application> applications, List<Education> education, List<Project> project,
			List<Experience> experience, List<Skills> skills) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.country = country;
		this.city = city;
		this.applications = applications;
		this.education = education;
		this.project = project;
		this.experience = experience;
		this.skills = skills;
	}

	public CandidateDetails(Long id, Date dateOfBirth, String gender, String bio, String country, String city,
			byte[] profilePicture, byte[] resume, List<Application> applications, List<Education> education,
			List<Project> project, List<Experience> experience, List<Skills> skills) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.country = country;
		this.city = city;
		this.profilePicture = profilePicture;
		this.resume = resume;
		this.applications = applications;
		this.education = education;
		this.project = project;
		this.experience = experience;
		this.skills = skills;
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
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
		
}
