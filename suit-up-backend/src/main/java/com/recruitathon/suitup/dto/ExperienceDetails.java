package com.recruitathon.suitup.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExperienceDetails {

	private Long id;
	private String organization;
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
	private Date startDate;
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
	private Date endDate;
	private String designation;
	private String type;
	private String location;
	private boolean current;
	
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
