package com.recruitathon.suitup.model;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Long id;
	
	@OneToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private User user;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Column(name = "profile_pic", length = 1000)
	private byte profilePicture[];
	
	@Column(name = "resume", length = 1000)
	private byte resume[];

	public Candidate() {
		super();
	}

	public Candidate(Long id, User user, Date dateOfBirth, String gender, String bio, String country, String city,
			byte[] profilePicture, byte[] resume) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(profilePicture);
		result = prime * result + Arrays.hashCode(resume);
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
		if (!Arrays.equals(resume, other.resume))
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
				+ Arrays.toString(profilePicture) + ", resume=" + Arrays.toString(resume) + "]";
	}

	
}
