package com.indra.bbva.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.bbva.model.EmployeeBean;

public interface EmployeeRepository extends CrudRepository<EmployeeBean, Integer> {

}
