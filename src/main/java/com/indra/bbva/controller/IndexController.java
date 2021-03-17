package com.indra.bbva.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.indra.bbva.model.EmployeeBean;
import com.indra.bbva.service.DepartmentService;
import com.indra.bbva.service.EmployeeService;
import com.indra.bbva.service.JobService;

@Controller
public class IndexController {
	private final static Logger LOG = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private JobService jobService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Control de empleados");
		model.addAttribute("departments", departmentService.getAllDepartments());
		model.addAttribute("jobs", jobService.getAllJobs());
		model.addAttribute("employees", employeeService.getAllEmployees());

		return "index";
	}

	@PostMapping("/guardar")
	public String guardar(EmployeeBean employee) {
		if (employee.getEmployeeId() == 0) {
			if (employeeService.saveEmployee(employee))
				return "redirect:/";
			else
				return "commons/error";
		} else {
			if (employeeService.updateEmployee(employee))
				return "redirect:/";
			else
				return "commons/error";
		}
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer employeeId, Model model) {
		model.addAttribute("empl", employeeService.findEmployeeByid(new EmployeeBean(employeeId)));
		model.addAttribute("jobs", jobService.getAllJobs());
		model.addAttribute("departments", departmentService.getAllDepartments());
		model.addAttribute("employees", employeeService.getAllEmployees());

		return "employees/edit_employee";
	}

	@GetMapping("/{id}")
	public String detalles(@PathVariable("id") Integer employeeId, Model model) {
		EmployeeBean employee = employeeService.findEmployeeByid(new EmployeeBean(employeeId));
		model.addAttribute("employee", employee);
		if (employee.getManagerId() != null)
			model.addAttribute("gerente", employeeService.findEmployeeByid(new EmployeeBean(employee.getManagerId())));

		return "employees/details_employee";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer employeeId) {
		if (employeeService.deleteEmployee(new EmployeeBean(employeeId))) {
			return "redirect:/";
		} else {
			return "commons/error";
		}
	}

	@InitBinder()
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
