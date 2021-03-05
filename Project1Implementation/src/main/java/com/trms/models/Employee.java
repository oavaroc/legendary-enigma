package com.trms.models;

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
@Table(name="employee")
public class Employee {
/*
 * id serial primary key,
first_name varchar not null,
last_name varchar not null,
username varchar not null,
pass varchar not null,
reimbursement_claimed numeric,
direct_supervisor integer references employee(id),
department integer references departments(id)
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String username;
	@Column(name="pass")
	private String pass;
	@Column(name="reimbursement_claimed")
	private Float reimbursementClaimed;
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="direct_supervisor")
	private Employee directSupervisor;
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="department")
	private Departments department;
	private boolean head;
	public Employee() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.pass = "";
		this.reimbursementClaimed = 0f;
		this.directSupervisor = null;
		this.department = null;
		this.head = false;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", pass=" + pass + ", reimbursementClaimed=" + reimbursementClaimed + ", directSupervisor="
				+ directSupervisor + ", department=" + department + ", head=" + head + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.getId().hashCode());
		result = prime * result + ((directSupervisor == null) ? 0 : directSupervisor.getId().hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (head ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((reimbursementClaimed == null) ? 0 : reimbursementClaimed.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (directSupervisor == null) {
			if (other.directSupervisor != null)
				return false;
		} else if (!directSupervisor.equals(other.directSupervisor))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (head != other.head)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (reimbursementClaimed == null) {
			if (other.reimbursementClaimed != null)
				return false;
		} else if (!reimbursementClaimed.equals(other.reimbursementClaimed))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Float getReimbursementClaimed() {
		return reimbursementClaimed;
	}
	public void setReimbursementClaimed(Float reimbursementClaimed) {
		this.reimbursementClaimed = reimbursementClaimed;
	}
	public Employee getDirectSupervisor() {
		return directSupervisor;
	}
	public void setDirectSupervisor(Employee directSupervisor) {
		this.directSupervisor = directSupervisor;
	}
	public Departments getDepartment() {
		return department;
	}
	public void setDepartment(Departments department) {
		this.department = department;
	}
	public boolean isHead() {
		return head;
	}
	public void setHead(boolean head) {
		this.head = head;
	}
}
