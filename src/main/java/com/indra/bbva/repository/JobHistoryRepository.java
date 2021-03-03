package com.indra.bbva.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.bbva.model.JobHistoryBean;
import com.indra.bbva.model.JobHistoryEmbedded;

public interface JobHistoryRepository extends CrudRepository<JobHistoryBean, JobHistoryEmbedded> {

}
