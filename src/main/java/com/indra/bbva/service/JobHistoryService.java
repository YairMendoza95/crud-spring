package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.JobHistoryBean;

public interface JobHistoryService {
	List<JobHistoryBean> getAllJobHistory();

	JobHistoryBean findJobHistoryByid(JobHistoryBean jobHistory) throws NoSuchElementException;

	boolean saveJobHistory(JobHistoryBean jobHistory);

	boolean updateJobHistory(JobHistoryBean jobHistory);

	boolean deleteJobHistory(JobHistoryBean jobHistory);
}
