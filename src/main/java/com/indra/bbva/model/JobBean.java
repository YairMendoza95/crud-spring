package com.indra.bbva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class JobBean {
	@Id
	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "MAX_SALARY")
	private Integer maxSalary;

	@Column(name = "MIN_SALARY")
	private Integer minSalary;

	public JobBean() {
	}

	public JobBean(String jobId) {
		this.jobId = jobId;
	}

	public JobBean(String jobId, String jobTitle, Integer maxSalary, Integer minSalary) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}

	public JobBean(String jobTitle, Integer maxSalary, Integer minSalary) {
		this.jobTitle = jobTitle;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	@Override
	public String toString() {
		return "Jobs: [ jobId: " + jobId + ", jobTitle: " + jobTitle + ", maxSalary: " + maxSalary + ", minSalary: "
				+ minSalary + " ]";
	}
}
