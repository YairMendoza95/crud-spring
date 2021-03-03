package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.DepartmentBean;

public interface DepartmentService {
	List<DepartmentBean> getAllDepartments();

	DepartmentBean findDepartmentByid(DepartmentBean department) throws NoSuchElementException;

	boolean saveDepartment(DepartmentBean department);

	boolean updateDepartment(DepartmentBean department);

	boolean deleteDepartment(DepartmentBean department);
}
