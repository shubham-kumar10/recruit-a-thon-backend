package com.recruitathon.suitup.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Long id;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;

	@Column(name = "date_of_birth")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Column(name = "profile_pic", length = 1000000)
	private byte profilePicture[];
	
	@Column(name = "resume", length = 1000)
	private byte resume[];
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="app_fk")
	private List<Application> applications;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="edu_fk")
	private List<Education> education;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="exp_fk")
	private List<Experience> experience;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="project_fk")
	private List<Project> project;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="skill_fk")
	private List<Skills> skills;

	public Candidate() {
		super();
	}

	public Candidate(Long id, User user, Date dateOfBirth, String gender, String bio, String country, String city,
			byte[] profilePicture, byte[] resume, List<Application> applications, List<Education> education,
			List<Experience> experience, List<Project> project, List<Skills> skills) {
		super();
		this.id = id;
		this.user = user;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.bio = bio;
		this.country = country;
		this.city = city;
		this.profilePicture = profilePicture;
		this.resume = resume;
		this.applications = applications;
		this.education = education;
		this.experience = experience;
		this.project = project;
		this.skills = skills;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applications == null) ? 0 : applications.hashCode());
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(profilePicture);
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + Arrays.hashCode(resume);
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		if (applications == null) {
			if (other.applications != null)
				return false;
		} else if (!applications.equals(other.applications))
			return false;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(profilePicture, other.profilePicture))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (!Arrays.equals(resume, other.resume))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", user=" + user + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", bio=" + bio + ", country=" + country + ", city=" + city + ", profilePicture="
				+ Arrays.toString(profilePicture) + ", resume=" + Arrays.toString(resume) + ", applications="
				+ applications + ", education=" + education + ", experience=" + experience + ", project=" + project
				+ ", skills=" + skills + "]";
	}

	
}
