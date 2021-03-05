package com.indra.bbva.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indra.bbva.model.DepartmentBean;
import com.indra.bbva.model.EmployeeBean;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeBean, Integer> {
	// @Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEES WHERE
	// DEPARTMENT_ID = ?1")
	List<EmployeeBean> findByDepartment(DepartmentBean department);
}
