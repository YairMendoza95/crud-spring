package com.indra.bbva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "JOB_HISTORY")
public class JobHistoryBean {
	@EmbeddedId
	private JobHistoryEmbedded jobHistoryID;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "JOB_ID")
	private String jobId;

	@Column(name = "DEPARTMENT_ID")
	private Integer department_id;

	public JobHistoryBean() {
	}

	public JobHistoryBean(JobHistoryEmbedded jobHistoryID) {
		this.jobHistoryID = jobHistoryID;
	}

	public JobHistoryBean(JobHistoryEmbedded jobHistoryID, Date endDate, String jobId, Integer department_id) {
		this.jobHistoryID = jobHistoryID;
		this.endDate = endDate;
		this.jobId = jobId;
		this.department_id = department_id;
	}

	public JobHistoryEmbedded getJobHistoryID() {
		return jobHistoryID;
	}

	public void setJobHistoryID(JobHistoryEmbedded jobHistoryID) {
		this.jobHistoryID = jobHistoryID;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "Job History:  [ jobHistoryID: " + jobHistoryID.toString() + ", endDate: " + endDate + ", jobId: "
				+ jobId + ", department_id: " + department_id + " ]";
	}
}
