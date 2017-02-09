package org.cuatrovientos.springEmployDepart.controllers;

import java.util.List;
import java.util.Map;

import org.cuatrovientos.springEmployDepart.dao.GenericDAO;
import org.cuatrovientos.springEmployDepart.models.Department;
import org.cuatrovientos.springEmployDepart.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private GenericDAO<Department> departmentDAO;

	
	/**
	 * handles default /departments
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/departments"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = { "/departments" })
	public String showDepartments(Map<String, Object> model) {
		logger.info("Show departments. ");

		
		List<Department> departments = departmentDAO.selectAll(Department.class);
		model.put("departments", departments);

		return "department/departments";
	}
	
	/**
	 * handles /departments/task/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/departments/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/departments/new" })
	public ModelAndView createDepartment(Department department) {

		ModelAndView modelAndView = new ModelAndView();

		departmentDAO.insert(department);
		// We return view name
		modelAndView.setViewName("department/created");
		modelAndView.addObject("department", department);
		logger.info("Saveview POST " + department.getId());

		return modelAndView;
	}

	/**
	 * Simply selects the update view for tasks
	 */
	@RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
	public String departmentDetail(@PathVariable(value = "id") Integer departmentId, Model model) {
		logger.info("Showing department view GET ");

		// We find the task through DAO and load into model
		model.addAttribute("department", departmentDAO.selectById(departmentId, Department.class));

		return "department/departmentDetail";
	}
	
	/**
	 * Simply selects the update view for tasks
	 */
	@RequestMapping(value = "/departments/update/{id}", method = RequestMethod.GET)
	public String updateTask(@PathVariable(value = "id") Integer departmentId, Model model) {
		logger.info("Showing update department view GET ");

		// We find the task through DAO and load into model
		model.addAttribute("department", departmentDAO.selectById(departmentId, Department.class));

		return "department/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the User.
	 */
	@RequestMapping(value = "/departments/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdateTask(Department department) {
		logger.info("Save update department " + department.getId());

		departmentDAO.update(department);

		ModelAndView modelAndView = new ModelAndView();

		// We pass the user received through this object
		modelAndView.addObject("department", department);

		// The same as return "department/saveUpdate"
		modelAndView.setViewName("department/saveUpdated");
		return modelAndView;
	}

	/**
	 * Delete the specific task
	 */
	@RequestMapping(value = "/departments/delete/{id}", method = RequestMethod.GET)
	public String deleteDepartment(@PathVariable(value = "id") Integer departmentId, Model model) {
		logger.info("Department detail /delete department: " + departmentId);

		departmentDAO.delete(departmentDAO.selectById(departmentId, Department.class));

		model.addAttribute("departmentId", departmentId);
		
		return "department/deleted";
	}

}
