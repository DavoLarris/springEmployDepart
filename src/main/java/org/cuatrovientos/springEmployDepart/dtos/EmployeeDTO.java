package org.cuatrovientos.springEmployDepart.dtos;

import java.util.Date;


public class EmployeeDTO {

	private int id;
	private String name;
	private Date birthDate;
	private String telephone;
	//Adding new fields
	private int idDepartment;
	private String nameDepartment;
	
	/**
	 * default constructor
	 */
	public EmployeeDTO () {
		
	}
	
	public EmployeeDTO(int id, String name, Date birthDate, String telephone, int idDepartment, String nameDepartment) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.telephone = telephone;
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
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

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

}
