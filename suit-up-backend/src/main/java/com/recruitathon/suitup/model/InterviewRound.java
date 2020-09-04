package com.recruitathon.suitup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interview_round")
public class InterviewRound {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "round_id")
	private Long roundId;
	
	@Column(name="location")
	private String location;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="poc")
	private String pointOfContact;
	
	@Column(name="description")
	private String description;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getRoundId() {
		return roundId;
	}

	public void setRoundId(Long roundId) {
		this.roundId = roundId;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InterviewRound() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pointOfContact == null) ? 0 : pointOfContact.hashCode());
		result = prime * result + ((roundId == null) ? 0 : roundId.hashCode());
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
		InterviewRound other = (InterviewRound) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
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
		if (roundId == null) {
			if (other.roundId != null)
				return false;
		} else if (!roundId.equals(other.roundId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InterviewRound [roundId=" + roundId + ", location=" + location + ", duration=" + duration
				+ ", pointOfContact=" + pointOfContact + ", description=" + description +  "]";
	}
	
}
