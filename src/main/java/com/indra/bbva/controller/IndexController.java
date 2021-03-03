package com.indra.bbva.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.indra.bbva.model.EmployeeBean;
import com.indra.bbva.service.DepartmentService;
import com.indra.bbva.service.EmployeeService;
import com.indra.bbva.service.JobService;

@Controller
public class IndexController {
	private final static Logger LOG = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private final EmployeeService employeeService;

	@Autowired
	private final DepartmentService departmentService;

	@Autowired
	private final JobService jobService;

	public IndexController(EmployeeService employeeService, DepartmentService departmentService,
			JobService jobService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
		this.jobService = jobService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartments());
		model.addAttribute("jobs", jobService.getAllJobs());
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "index";
	}

	@PostMapping("/guardar")
	public String guardar(EmployeeBean employee, BindingResult result, Model model) {
		LOG.info(employee.toString());
		if (employeeService.saveEmployee(employee))
			return "redirect:/";
		else
			return "commons/error";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
