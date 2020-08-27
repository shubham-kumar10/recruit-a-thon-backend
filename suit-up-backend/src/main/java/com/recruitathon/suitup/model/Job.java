package com.recruitathon.suitup.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Long jobId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="posted_on")
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
	private Date postedOn;
	
	@Column(name="description")
	private String description;
	
	@Column(name="location")
	private String location;
	
	@Column(name="poc")
	private String pointOfContact;
	
	@Column(name="compensation")
	private String compensation;
	
	@Column(name="travel_required")
	private boolean travelRequired;
	
	@Column(name="travel_percent")
	private int travelPercent;
	
	@Column(name="vacancies")
	private int vacancies;

	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="process_id")
	private HiringProcess process;
	
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public HiringProcess getProcess() {
		return process;
	}

	public void setProcess(HiringProcess process) {
		this.process = process;
	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	public boolean isTravelRequired() {
		return travelRequired;
	}

	public void setTravelRequired(boolean travelRequired) {
		this.travelRequired = travelRequired;
	}

	public int getTravelPercent() {
		return travelPercent;
	}

	public void setTravelPercent(int travelPercent) {
		this.travelPercent = travelPercent;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((compensation == null) ? 0 : compensation.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pointOfContact == null) ? 0 : pointOfContact.hashCode());
		result = prime * result + ((postedOn == null) ? 0 : postedOn.hashCode());
		result = prime * result + ((process == null) ? 0 : process.hashCode());
		result = prime * result + travelPercent;
		result = prime * result + (travelRequired ? 1231 : 1237);
		result = prime * result + vacancies;
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
		Job other = (Job) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (compensation == null) {
			if (other.compensation != null)
				return false;
		} else if (!compensation.equals(other.compensation))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (pointOfContact == null) {
			if (other.pointOfContact != null)
				return false;
		} else if (!pointOfContact.equals(other.pointOfContact))
			return false;
		if (postedOn == null) {
			if (other.postedOn != null)
				return false;
		} else if (!postedOn.equals(other.postedOn))
			return false;
		if (process == null) {
			if (other.process != null)
				return false;
		} else if (!process.equals(other.process))
			return false;
		if (travelPercent != other.travelPercent)
			return false;
		if (travelRequired != other.travelRequired)
			return false;
		if (vacancies != other.vacancies)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", companyName=" + companyName + ", postedOn=" + postedOn + ", description="
				+ description + ", location=" + location + ", pointOfContact=" + pointOfContact + ", compensation="
				+ compensation + ", travelRequired=" + travelRequired + ", travelPercent=" + travelPercent
				+ ", vacancies=" + vacancies + ", process=" + process + "]";
	}
	
}
