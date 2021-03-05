package com.trms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_type")
public class EventType {
	/*
	 * id serial primary key, format varchar
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String format;

	public EventType() {
		this.id = 0;
		this.format = "";
	}

	@Override
	public String toString() {
		return "EventType [id=" + id + ", format=" + format + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EventType other = (EventType) obj;
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
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer eventType(String format) {
		switch (format.toUpperCase()) {
		case "UNIVERSITY COURSES":
			return 1;
		case "SEMINARS":
			return 2;
		case "CERTIFICATION PREPARATION CLASSES":
			return 3;
		case "CERTIFICATION":
			return 4;
		case "TECHNICAL TRAINING":
			return 5;
		case "OTHER":
		default:
			return 6;

		}
	}

	public String eventType(Integer format) {
		switch (format) {
		case 1:
			return "UNIVERSITY COURSES";
		case 2:
			return "SEMINARS";
		case 3:
			return "CERTIFICATION PREPARATION CLASSES";
		case 4:
			return "CERTIFICATION";
		case 5:
			return "TECHNICAL TRAINING";
		case 6:
		default:
			return "OTHER";

		}
	}
}
