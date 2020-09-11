package com.recruitathon.suitup.model;

import java.util.Date;
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
	
	@Column(name="position")
	private String position;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="job_skills_fk")
	private List<JobRequirement> skillsRequired;
	
	@Column(name="min_exp")
	private double minimumExperience;
	
	@Column(name="min_education")
	private String minimumEducation;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="process_id")
	private HiringProcess process;
	
	public Job() {
		super();
	}

	public Job(Long jobId, String companyName, Date postedOn, String description, String location,
			String pointOfContact, String compensation, boolean travelRequired, int travelPercent, int vacancies,
			String position, List<JobRequirement> skillsRequired, double minimumExperience, String minimumEducation,
			HiringProcess process) {
		super();
		this.jobId = jobId;
		this.companyName = companyName;
		this.postedOn = postedOn;
		this.description = description;
		this.location = location;
		this.pointOfContact = pointOfContact;
		this.compensation = compensation;
		this.travelRequired = travelRequired;
		this.travelPercent = travelPercent;
		this.vacancies = vacancies;
		this.position = position;
		this.skillsRequired = skillsRequired;
		this.minimumExperience = minimumExperience;
		this.minimumEducation = minimumEducation;
		this.process = process;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<JobRequirement> getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(List<JobRequirement> skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public double getMinimumExperience() {
		return minimumExperience;
	}

	public void setMinimumExperience(double minimumExperience) {
		this.minimumExperience = minimumExperience;
	}

	public String getMinimumEducation() {
		return minimumEducation;
	}

	public void setMinimumEducation(String minimumEducation) {
		this.minimumEducation = minimumEducation;
	}

	public HiringProcess getProcess() {
		return process;
	}

	public void setProcess(HiringProcess process) {
		this.process = process;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
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
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", companyName=" + companyName + ", postedOn=" + postedOn + ", description="
				+ description + ", location=" + location + ", pointOfContact=" + pointOfContact + ", compensation="
				+ compensation + ", travelRequired=" + travelRequired + ", travelPercent=" + travelPercent
				+ ", vacancies=" + vacancies + ", position=" + position + ", skillsRequired=" + skillsRequired
				+ ", minimumExperience=" + minimumExperience + ", minimumEducation=" + minimumEducation + ", process="
				+ process + "]";
	}

}


