package com.recruitathon.suitup.dto;

import java.util.List;

import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Skills;

public interface CandidateProfile {
	String getCity();

	String getcountry();

	byte[] getProfilePicture();
	
	List<Skills> getSkills();

	List<Experience> getExperience();
	
	User getUser();
	
	public interface User {
		String getFirstName();

		String getLastName();

		long getId();

		long getContactNumber();

		String getUserName();
	}
}
