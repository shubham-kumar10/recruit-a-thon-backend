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

@Entity
@Table(name = "applications")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private Long applicationId;

	@Column(name = "applied_on")
	private Date appliedOn;

	@Column(name = "status")
	private String status;

	@Column(name = "complete")
	private boolean isComplete;

	@Column(name = "skillMatch")
	private double skillMatch;

	@Column(name = "percentile")
	private double percentile;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "job_app_fk")
	private Job job;

	public Application() {
		super();
	}

	public Application(Date appliedOn, String status, boolean isComplete, double skillMatch, double percentile,
			Job job) {
		super();
		this.appliedOn = appliedOn;
		this.status = status;
		this.isComplete = isComplete;
		this.skillMatch = skillMatch;
		this.percentile = percentile;
		this.job = job;
	}

	public Application(long id, Date appliedOn, String status, boolean isComplete, double skillMatch, double percentile,
			Job job) {
		super();
		this.applicationId = id;
		this.appliedOn = appliedOn;
		this.status = status;
		this.isComplete = isComplete;
		this.skillMatch = skillMatch;
		this.percentile = percentile;
		this.job = job;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public double getSkillMatch() {
		return skillMatch;
	}

	public void setSkillMatch(double skillMatch) {
		this.skillMatch = skillMatch;
	}

	public double getPercentile() {
		return percentile;
	}

	public void setPercentile(double percentile) {
		this.percentile = percentile;
	}

	public Date getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (applicationId ^ (applicationId >>> 32));
		result = prime * result + ((appliedOn == null) ? 0 : appliedOn.hashCode());
		result = prime * result + (isComplete ? 1231 : 1237);
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentile);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(skillMatch);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Application other = (Application) obj;
		if (applicationId != other.applicationId)
			return false;
		if (appliedOn == null) {
			if (other.appliedOn != null)
				return false;
		} else if (!appliedOn.equals(other.appliedOn))
			return false;
		if (isComplete != other.isComplete)
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (Double.doubleToLongBits(percentile) != Double.doubleToLongBits(other.percentile))
			return false;
		if (Double.doubleToLongBits(skillMatch) != Double.doubleToLongBits(other.skillMatch))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", appliedOn=" + appliedOn + ", status=" + status
				+ ", isComplete=" + isComplete + ", skillMatch=" + skillMatch + ", percentile=" + percentile + ", job="
				+ job + "]";
	}
}
