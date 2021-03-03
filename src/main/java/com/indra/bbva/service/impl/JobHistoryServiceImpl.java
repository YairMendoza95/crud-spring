package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.JobHistoryBean;
import com.indra.bbva.repository.JobHistoryRepository;
import com.indra.bbva.service.JobHistoryService;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {
	@Autowired
	private final JobHistoryRepository jobHistoryRepository;

	public JobHistoryServiceImpl(JobHistoryRepository jobHistoryRepository) {
		this.jobHistoryRepository = jobHistoryRepository;
	}

	@Override
	public List<JobHistoryBean> getAllJobHistory() {
		try {
			return (List<JobHistoryBean>) jobHistoryRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los registros");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public JobHistoryBean findJobHistoryByid(JobHistoryBean jobHistory) throws NoSuchElementException {
		try {
			return jobHistoryRepository.findById(jobHistory.getJobHistoryID()).get();
		} catch (Exception e) {
			System.out.println("Error al consultar el registro");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveJobHistory(JobHistoryBean jobHistory) {
		try {
			jobHistoryRepository.save(jobHistory);
			return true;
		} catch (Exception e) {
			System.out.println("Error al insertar registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJobHistory(JobHistoryBean jobHistory) {
		try {
			if (jobHistoryRepository.findById(jobHistory.getJobHistoryID()).isPresent()) {
				jobHistoryRepository.save(jobHistory);
				return true;
			} else {
				System.out.println("No existe el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJobHistory(JobHistoryBean jobHistory) {
		try {
			if (jobHistoryRepository.findById(jobHistory.getJobHistoryID()).isPresent()) {
				jobHistoryRepository.delete(jobHistory);
				return true;
			} else {
				System.out.println("No existe el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro");
			e.printStackTrace();
			return false;
		}
	}
}
