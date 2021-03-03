package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.model.JobBean;
import com.indra.bbva.repository.JobRepository;
import com.indra.bbva.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private final JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobBean> getAllJobs() {
		try {
			return (List<JobBean>) jobRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error al listar los registros");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public JobBean findJobByid(JobBean job) throws NoSuchElementException {
		try {
			return jobRepository.findById(job.getJobId()).get();
		} catch (NoSuchElementException e) {
			System.out.println("No se encuentra el registro");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("Error al listar los registros");
			return null;
		}
	}

	@Override
	public boolean saveJob(JobBean job) {
		try {
			jobRepository.save(job);
			return true;
		} catch (Exception e) {
			System.out.println("Error al guardar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJob(JobBean job) {
		try {
			if (jobRepository.findById(job.getJobId()).isPresent()) {
				jobRepository.save(job);
				return true;
			} else {
				System.out.println("No se encontro el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJob(JobBean job) {
		try {
			if (jobRepository.findById(job.getJobId()).isPresent()) {
				jobRepository.deleteById(job.getJobId());
				return true;
			} else {
				System.out.println("No se encontro el registro");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro");
			e.printStackTrace();
			return false;
		}
	}

}
