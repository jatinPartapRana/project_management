package com.jpr.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@GenericGenerator(name = "native_generator", strategy = "native")
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GenericGenerator(name = "native_generator", strategy = "native")
	@GeneratedValue(generator = "native_generator")
	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
