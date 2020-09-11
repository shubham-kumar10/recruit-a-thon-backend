package com.recruitathon.suitup.dto;

public class Profile {
	private UserProfile userDetails;
	private CandidateProfile canidate;
	public UserProfile getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserProfile userDetails) {
		this.userDetails = userDetails;
	}
	public CandidateProfile getCanidate() {
		return canidate;
	}
	public void setCanidate(CandidateProfile canidate) {
		this.canidate = canidate;
	}
	public Profile(UserProfile userDetails, CandidateProfile canidate) {
		super();
		this.userDetails = userDetails;
		this.canidate = canidate;
	}
}
