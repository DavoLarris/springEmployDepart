package org.cuatrovientos.springEmployDepart.mapper;

import org.cuatrovientos.springEmployDepart.dtos.EmployeeDTO;
import org.cuatrovientos.springEmployDepart.models.Department;
import org.cuatrovientos.springEmployDepart.models.Employee;

public class TaskMapper {

	public static Employee toEmployee(EmployeeDTO employeeDTO, Department department) {
		Employee employee = new Employee();
		employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setName(employeeDTO.getName());
		employee.setDepartment(department);
		return employee;
	}

	public static EmployeeDTO toDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getName(),
				employee.getBirthDate(), employee.getTelephone(), employee.getDepartment().getId(), employee.getDepartment().getName());
		return employeeDTO;
	}

}
