package org.cuatrovientos.springEmployDepart.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Please enter your name.")
	@Pattern(regexp = "[A-Za-z]+", message = "Must only contain chars")
	private String name;
	
	@NotNull(message = "Please enter your birth date")
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date birthDate;
	
	@NotNull(message = "Please enter your phone number")
	@Pattern(regexp = "[0-9]+", message = "Must only contain numbers")
	private String telephone;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Department department;
	

	public Employee(){
		
	}
	
	/**
	 * @param name
	 * @param birthDate
	 * @param telephone
	 */
	public Employee(String name, Date birthDate, String telephone, Department depart) {
		this.name = name;
		this.birthDate = birthDate;
		this.telephone = telephone;
		this.department = depart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
