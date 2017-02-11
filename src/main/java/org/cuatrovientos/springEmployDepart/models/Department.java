package org.cuatrovientos.springEmployDepart.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Pattern(regexp = "[0-9]+", message = "Please, enter a number.")
	//@Size(min=1, message = "Size avaliable is 1 char long.")
	private Integer id;
	private String name;
	private String description;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy ="department")
	private List<Employee> employees;
	
	public Department(){
		
	}
	
	public Department(String name, String description, List<Employee> employees){
		this.name = name;
		this.description = description;
		this.employees = employees;
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
