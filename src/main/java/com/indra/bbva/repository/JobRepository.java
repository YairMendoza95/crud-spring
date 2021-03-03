package com.indra.bbva.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.bbva.model.JobBean;

public interface JobRepository extends CrudRepository<JobBean, String> {

}
