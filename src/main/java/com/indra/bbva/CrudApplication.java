package com.indra.bbva;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indra.bbva.model.CountryBean;
import com.indra.bbva.model.DepartmentBean;
import com.indra.bbva.model.EmployeeBean;
import com.indra.bbva.model.JobBean;
import com.indra.bbva.model.JobHistoryBean;
import com.indra.bbva.model.JobHistoryEmbedded;
import com.indra.bbva.service.CountryService;
import com.indra.bbva.service.DepartmentService;
import com.indra.bbva.service.EmployeeService;
import com.indra.bbva.service.JobHistoryService;
import com.indra.bbva.service.JobService;
import com.indra.bbva.utils.Utils;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	private CountryService cs;

	@Autowired
	private DepartmentService ds;

	@Autowired
	private EmployeeService es;

	@Autowired
	private JobHistoryService jhs;

	@Autowired
	private JobService js;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (cs != null)
			System.out.println("\nEl repositorio se inyectó");
		System.out.println();

	}

	private void testCountries() {
		cs.getAllCountries().forEach(System.out::println);
		System.out.println();
		CountryBean country = new CountryBean("AT", "Austrias", 1);

		// cs.saveCountry(country);
		// cs.updateCountry(country);
		cs.deleteCountry(country);
		System.out.println();
		cs.getAllCountries().forEach(System.out::println);
	}

	private void testDepartments() {
		// DepartmentBean department = new DepartmentBean("cc", 200, 1500);
		// DepartmentBean department = new DepartmentBean(291, "cc", 200, 1700);
		DepartmentBean department = new DepartmentBean(291);
		ds.getAllDepartments().forEach(System.out::println);
		System.out.println();
		// ds.saveDepartment(department);
		ds.deleteDepartment(department);
		System.out.println();
		ds.getAllDepartments().forEach(System.out::println);
	}

	private void testEmployees() throws ParseException {
		/*
		 * EmployeeBean employee = new EmployeeBean("Jose", "Zamudio", "qwwwweqw",
		 * "123-456-9870", Utils.formatoFecha("23/02/2021"), "IT_PROG", 12000.00, 0.1,
		 * 207, 60);
		 */
		/*
		 * EmployeeBean employee = new EmployeeBean(212, "Jose", "Zamudio",
		 * "joseyair.95@gmail.com", "123-456-9870", Utils.formatoFecha("23/02/2021"),
		 * "IT_PROG", 12000.00, 0.1, 207, 60);
		 */
		JobHistoryBean jhb = new JobHistoryBean(new JobHistoryEmbedded(212, Utils.formatoFecha("23/02/21")));
		jhs.deleteJobHistory(jhb);
		EmployeeBean employee = new EmployeeBean(212);
		es.getAllEmployees().forEach(System.out::println);
		// System.out.println(es.findEmployeeByid(employee));
		// es.saveEmployee(employee);
		// es.updateEmployee(employee);
		es.deleteEmployee(employee);
		System.out.println();

		es.getAllEmployees().forEach(System.out::println);
	}

	private void testJobs() {
		// System.out.println(js.findJobByid(new JobBean("IT_PROG")));
		// JobBean job = new JobBean("AAA", "XXXXX", 18800, 12000);
		JobBean job = new JobBean("AAA");
		js.getAllJobs().forEach(System.out::println);
		System.out.println();
		// js.saveJob(job);
		// js.updateJob(job);
		js.deleteJob(job);
		System.out.println();
		js.getAllJobs().forEach(System.out::println);
	}

	// private void
}
