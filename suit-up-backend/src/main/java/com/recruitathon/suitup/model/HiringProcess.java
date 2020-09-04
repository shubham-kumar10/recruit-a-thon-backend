package com.recruitathon.suitup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="process")
public class HiringProcess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "process_id")
	private Long processId;

	@Column(name="description")
	private String description;
	
	@Column(name="location")
	private String location;
	
	@Column(name="duration")
	private String duration;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="process_round_fk",referencedColumnName = "process_id")
	private List<InterviewRound> rounds = new ArrayList<InterviewRound>();

	
	public HiringProcess() {
		super();
	}


	public List<InterviewRound> getRounds() {
		return rounds;
	}

	
	public void setRounds(List<InterviewRound> rounds) {
		this.rounds = rounds;
	}


	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "HiringProcess [processId=" + processId + ", description=" + description + ", location=" + location
				+ ", duration=" + duration + ", rounds=" + rounds + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((rounds == null) ? 0 : rounds.hashCode());
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
		HiringProcess other = (HiringProcess) obj;
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
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (rounds == null) {
			if (other.rounds != null)
				return false;
		} else if (!rounds.equals(other.rounds))
			return false;
		return true;
	}	
	
}
