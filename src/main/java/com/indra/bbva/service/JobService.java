package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.model.JobBean;

public interface JobService {
	List<JobBean> getAllJobs();

	JobBean findJobByid(JobBean job) throws NoSuchElementException;

	boolean saveJob(JobBean job);

	boolean updateJob(JobBean job);

	boolean deleteJob(JobBean job);
}
