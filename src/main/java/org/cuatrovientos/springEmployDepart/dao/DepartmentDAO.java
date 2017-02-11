package org.cuatrovientos.springEmployDepart.dao;

import java.util.ArrayList;
import java.util.List;

import org.cuatrovientos.springEmployDepart.models.Department;
import org.cuatrovientos.springEmployDepart.models.Employee;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

public class DepartmentDAO extends GenericDAO<Department> {

	/**
	 * Selects all product types by name
	 * 
	 * @return List of products
	 */
	@Transactional(readOnly = true)
	public List<Department> selectByName(String name) {

		List<Department> departments = null;

		Query query = getSession().createQuery("from Department d where d.name LIKE :nam");
		query.setParameter("nam", "%" + name + "%");

		// We get a generic object list
		departments = query.list();

		return departments;
	}

	@Transactional(readOnly = true)
	public List<Department> takeEmployees(String name) {

		List<Department> departments = null;

		Query query = getSession().createQuery("select d.employees from Department d where d.name LIKE :nam");
		query.setParameter("nam", "%" + name + "%");

		// We get a generic object list
		departments = query.list();

		return departments;
	}

	@Transactional(readOnly = true)
	public List<Integer> getEmployeeIds() {

		List<Integer> employees = null;

		Query query = getSession().createQuery("SELECT id FROM Employee");

		// We get a generic object list
		employees = query.list();

		return employees;
	}

	@Transactional(readOnly = true)
	public List<Employee> getList(String[] ids) {

		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		for (int i = 0; i < ids.length; i++) {
			employee = (Employee) getSession().createQuery("FROM Employee WHERE id = :ids").setParameter("ids", Integer.parseInt(ids[i]))
					.uniqueResult();
		}
		if (employee != null) {
			employees.add(employee);
		}
		return employees;
	}

}
