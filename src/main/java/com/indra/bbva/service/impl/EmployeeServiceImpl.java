package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.EmployeeBean;
import com.indra.bbva.repository.EmployeeRepository;
import com.indra.bbva.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeBean> getAllEmployees() {
		try {
			return (List<EmployeeBean>) employeeRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al consultar la base de datos");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeBean findEmployeeByid(EmployeeBean employee) throws NoSuchElementException {
		try {
			return employeeRepository.findById(employee.getEmployeeId()).get();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean saveEmployee(EmployeeBean employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			System.out.println("Error al guardar el empleado");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateEmployee(EmployeeBean employee) {
		try {
			if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
				employeeRepository.save(employee);
				return true;
			} else {
				System.out.println("No se encontró el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(EmployeeBean employee) {
		try {
			if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
				employeeRepository.deleteById(employee.getEmployeeId());
				return true;
			} else {
				System.out.println("No se encontró el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro");
			e.printStackTrace();
			return false;
		}
	}

}
