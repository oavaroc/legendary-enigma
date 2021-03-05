package com.trms.models;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_form")
public class Reimbursement {
/*
 * id serial primary key,
employee_id integer references employee(id),
date_time timestamp not null,
loc varchar not null,
description varchar not null,
event_cost numeric not null,
format_id integer references grading_format(id),
event_id integer references event_type(id),
justification varchar not null,
attatchements bytea
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employeeId;
	@Column(name="date_time")
	private Timestamp date;
	@Column(name="loc")
	private String location;
	private String description;
	@Column(name="event_cost")
	private Float eventCost;
	@ManyToOne
	@JoinColumn(name="format_id")
	private GradingFormat format;
	@ManyToOne
	@JoinColumn(name="event_id")
	private EventType event;
	private String justification;
	@Column(name="attatchements")
	private byte[] attatchments;
	private Integer approval;
	public Reimbursement() {
		this.id = 0;
		this.employeeId = null;
		this.date = null;
		this.location = "";
		this.description = "";
		this.eventCost = 0f;
		this.format = null;
		this.event = null;
		this.justification = "";
		this.attatchments = null;
		this.approval = 0;
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", employeeId=" + employeeId.getId() + ", date=" + date + ", location=" + location
				+ ", description=" + description + ", eventCost=" + eventCost + ", format=" + format + ", event="
				+ event + ", justification=" + justification + ", attatchments=" + attatchments + ", approval="
				+ approval + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approval == null) ? 0 : approval.hashCode());
		result = prime * result + ((attatchments == null) ? 0 : attatchments.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.getId().hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((eventCost == null) ? 0 : eventCost.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (approval == null) {
			if (other.approval != null)
				return false;
		} else if (!approval.equals(other.approval))
			return false;
		if (attatchments == null) {
			if (other.attatchments != null)
				return false;
		} else if (!attatchments.equals(other.attatchments))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.getId().equals(other.employeeId.getId()))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (eventCost == null) {
			if (other.eventCost != null)
				return false;
		} else if (!eventCost.equals(other.eventCost))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getEventCost() {
		return eventCost;
	}
	public void setEventCost(Float eventCost) {
		this.eventCost = eventCost;
	}
	public GradingFormat getFormat() {
		return format;
	}
	public void setFormat(GradingFormat format) {
		this.format = format;
	}
	public EventType getEvent() {
		return event;
	}
	public void setEvent(EventType event) {
		this.event = event;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public byte[] getAttatchments() {
		return attatchments;
	}
	public void setAttatchments(byte[] attatchments) {
		this.attatchments = attatchments;
	}
	public Integer getApproval() {
		return approval;
	}
	public void setApproval(Integer approval) {
		this.approval = approval;
	}
}
