package org.cuatrovientos.springEmployDepart.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.cuatrovientos.springEmployDepart.dao.EmployeeDAO;
import org.cuatrovientos.springEmployDepart.dtos.EmployeeDTO;
import org.cuatrovientos.springEmployDepart.mapper.EmployeeMapper;
import org.cuatrovientos.springEmployDepart.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeDAO employeeDAO;


	/**
	 * handles default /employees
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/", "/employees"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/employees" })
	public String showDepartments(Map<String, Object> model) {
		logger.info("Show employees. ");

		
		List<Employee> employees = employeeDAO.selectAll(Employee.class);
		model.put("employees", employees);

		return "employee/employees";
	}

	/**
	 * handles default /employees/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/employees/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/employees/{id}" })
	public String employeeDetail(@PathVariable(value = "id") Integer id,
			Map<String, Object> model) {
		logger.info("Employee detail");

		Employee employee = employeeDAO.selectById(id, Employee.class);
		//The employee gets his own collection of tasks load
		model.put("employee", employee);
		

		return "employee/employeeDetail";
	}
	
	
	/**
	 * handles /employees/new by GET
	 * 
	 * @return the name of the view to show RequestMapping({"/employees/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/employees/new" })
	public String newEmployee(Map<String, Object> model) {
		logger.info("Showing custom view GET ");

		
		model.put("employee", new EmployeeDTO());
		model.put("department", employeeDAO.getDepartmentsId());
		
		return "employee/newEmployee";
	}

	/**
	 * handles /employees/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/employees/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/employees/new" })
	public ModelAndView createEmployee(@ModelAttribute("employee") @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
		logger.info("Saveview POST " + employeeDTO.getId());
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			logger.info(bindingResult.getAllErrors().toString());
			modelAndView.setViewName("employee/newEmployee");
			modelAndView.addObject("employee", employeeDTO);
			modelAndView.addObject("department", employeeDAO.getDepartmentsId());
			return modelAndView;
		}
		
		Employee employee = EmployeeMapper.toEmployee(employeeDTO, employeeDAO.getDepartment(employeeDTO.getIdDepartment()));


		if (employeeDAO.insert(employee)) {
			// We return view name
			modelAndView.setViewName("employee/created");
			modelAndView.addObject("employee", employee);
		} else {
			modelAndView.setViewName("error");
			modelAndView
					.addObject("error",
							"An error ocurred while trying to create a new employee. Please, try again");
		}
		return modelAndView;
	}

	
	/**
	 * Delete the specific employee
	 */
	@RequestMapping(value = "/employees/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer employeeId, Model model) {
		logger.info("Employee delete");
		
		
		employeeDAO.delete(employeeDAO.selectById(employeeId, Employee.class));
		model.addAttribute("employeeId", employeeId);

		return "employee/deleted";
	}
	
	
	/**
	 * Delete the specific employee
	 */
	@RequestMapping(value = "/employees/deleteall", method = RequestMethod.GET)
	public String deleteAll() {
		logger.info("Employee deleteAll");
		employeeDAO.deleteAll();

		return "employee/employees";
	}
	
	
	/**
	 * Simply selects the employee view
	 */
	@RequestMapping(value = "/employees/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer employeeId, Model model) {
		logger.info("Showing update view GET ");

		// We find the employee through DAO and load into model
		model.addAttribute("employee", employeeDAO.selectById(employeeId, Employee.class));

		return "employee/update";
	}
	
	
	/**
	 * Handles the POST from the Custom.jsp page to update the employee.
	 */
	@RequestMapping(value = "/employees/saveUpdated", method = RequestMethod.POST)
	public ModelAndView saveUpdate(Employee employee) {
		logger.info("Save employee " + employee.getId());

		employeeDAO.update(employee);

		ModelAndView modelAndView = new ModelAndView();

		// We pass the employee received through this object
		modelAndView.addObject("employee", employee);

		// The same as return "employee/saveUpdate"
		modelAndView.setViewName("employee/created");
		return modelAndView;
	}

}
