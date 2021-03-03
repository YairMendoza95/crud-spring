package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.EmployeeBean;

public interface EmployeeService {
	List<EmployeeBean> getAllEmployees();

	EmployeeBean findEmployeeByid(EmployeeBean employee) throws NoSuchElementException;

	boolean saveEmployee(EmployeeBean employee);

	boolean updateEmployee(EmployeeBean employee);

	boolean deleteEmployee(EmployeeBean employee);
}
