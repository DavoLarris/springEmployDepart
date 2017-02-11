package org.cuatrovientos.springEmployDepart.mapper;


import java.util.List;

import org.cuatrovientos.springEmployDepart.dtos.DepartmentDTO;
import org.cuatrovientos.springEmployDepart.models.Department;
import org.cuatrovientos.springEmployDepart.models.Employee;

public class DepartmentMapper {

	public static Department toDepartment(DepartmentDTO departmentDTO, List<Employee> employees) {
		Department department = new Department();
		department.setName(departmentDTO.getName());
		department.setDescription(departmentDTO.getDescription());
		department.setEmployees(employees);
		
		return department;
	}

	public static DepartmentDTO toDTO(Department department) {
		String[] ids = new String[department.getEmployees().size()];
		
		for (int i = 0; i<= department.getEmployees().size(); i++){
			ids[i] = String.valueOf(department.getEmployees().get(i).getId());
		}
		
		
		DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName(),
				department.getDescription(), ids);
		return departmentDTO;
	}

}
