package org.cuatrovientos.springEmployDepart.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


public class EmployeeDTO {

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
	
	//Adding new fields
	private int idDepartment;
	
	/**
	 * default constructor
	 */
	public EmployeeDTO () {
		
	}
	
	public EmployeeDTO(int id, String name, Date birthDate, String telephone, int idDepartment) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.telephone = telephone;
		this.idDepartment = idDepartment;
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

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

}
