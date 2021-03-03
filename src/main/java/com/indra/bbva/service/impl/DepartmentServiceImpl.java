package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.DepartmentBean;
import com.indra.bbva.repository.DepartmentRepository;
import com.indra.bbva.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<DepartmentBean> getAllDepartments() {
		try {
			return (List<DepartmentBean>) departmentRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los departamentos");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DepartmentBean findDepartmentByid(DepartmentBean department) throws NoSuchElementException {
		try {
			return departmentRepository.findById(department.getDepartmentId()).get();
		} catch (Exception e) {
			System.out.println("Error al encontrar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveDepartment(DepartmentBean department) {
		try {
			departmentRepository.save(department);
			return true;
		} catch (Exception e) {
			System.out.println("Error al guardar el departamento");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateDepartment(DepartmentBean department) {
		try {
			if (departmentRepository.findById(department.getDepartmentId()).isPresent()) {
				departmentRepository.save(department);
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
	public boolean deleteDepartment(DepartmentBean department) {
		try {
			if (departmentRepository.findById(department.getDepartmentId()).isPresent()) {
				departmentRepository.deleteById(department.getDepartmentId());
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
