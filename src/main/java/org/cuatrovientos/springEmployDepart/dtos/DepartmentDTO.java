package org.cuatrovientos.springEmployDepart.dtos;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class DepartmentDTO {

	private Integer id;
	@NotNull(message = "Please enter your name.")
	@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars")
	private String name;
	
	@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars")
	@Size(max = 255, message = "Description must be less than 255 characters long")
	@NotNull(message = "Please enter your name.")
	private String description;
	
	//Adding new fields
	private String[] idsEmployees;
	
	/**
	 * default constructor
	 */
	public DepartmentDTO () {
		
	}

	public DepartmentDTO(Integer id, String name, String description, String[] idsEmployees) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.idsEmployees = idsEmployees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getIdsEmployees() {
		return idsEmployees;
	}

	public void setIdsEmployees(String[] idsEmployees) {
		this.idsEmployees = idsEmployees;
	}
	
	
}
