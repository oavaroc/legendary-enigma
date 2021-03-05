package com.trms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grading_format")
public class GradingFormat {
/*
 * id serial primary key,
format varchar
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String format;
	public GradingFormat() {
		this.id = 0;
		this.format = "";
	}
	@Override
	public String toString() {
		return "GradingFormat [id=" + id + ", format=" + format + "]";
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
		GradingFormat other = (GradingFormat) obj;
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
		case "GRADE":
			return 1;
		case "PRESENTATION":
		default:
			return 2;

		}
	}

	public String eventType(Integer format) {
		switch (format) {
		case 1:
			return "GRADE";
		case 2:
		default:
			return "PRESENTATION";

		}
	}
}
