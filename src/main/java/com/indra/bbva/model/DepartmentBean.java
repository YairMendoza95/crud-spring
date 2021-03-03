package com.indra.bbva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentBean {
	@Id
	@GeneratedValue(generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
	@Column(name = "DEPARTMENT_ID")
	private int departmentId;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@Column(name = "MANAGER_ID")
	private Integer managerId;

	@Column(name = "LOCATION_ID")
	private Integer locationId;

	public DepartmentBean() {
	}

	public DepartmentBean(int departmentId) {
		this.departmentId = departmentId;
	}

	public DepartmentBean(int departmentId, String departmentName, Integer managerId, Integer locationId) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public DepartmentBean(String departmentName, Integer managerId, Integer locationId) {
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Departments:  [ departmentId: " + departmentId + ", departmentName: " + departmentName + ", managerId: "
				+ managerId + ", locationId: " + locationId + " ]";
	}
}
