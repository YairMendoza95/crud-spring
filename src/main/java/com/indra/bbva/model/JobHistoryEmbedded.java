package com.indra.bbva.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class JobHistoryEmbedded implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer employeeId;
	private Date startDate;

	public JobHistoryEmbedded() {
	}

	public JobHistoryEmbedded(Integer employeeId, Date startDate) {
		this.employeeId = employeeId;
		this.startDate = startDate;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Job History: [ employeeId: " + employeeId + ", startDate: " + startDate + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof JobHistoryEmbedded)) {
			return false;
		}
		JobHistoryEmbedded other = (JobHistoryEmbedded) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(startDate, other.startDate);
	}

}
