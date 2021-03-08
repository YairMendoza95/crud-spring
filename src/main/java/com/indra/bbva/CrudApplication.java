package com.indra.bbva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indra.bbva.service.EmployeeService;
import com.indra.bbva.service.JobService;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	JobService jobs;

	@Autowired
	EmployeeService es;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (jobs != null)
			System.out.println("SERVICIO INYECTADO");

		/*
		 * es.saveEmployee(new EmployeeBean("José", "Zamudio", "joseyair.95@outlook.es",
		 * "7731012987", Utils.formatoFecha("16/02/2021"), new JobBean("IT_PROG"),
		 * 18000.0, 0.1, 107, new DepartmentBean(60)));
		 */
	}
}
