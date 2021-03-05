package com.indra.bbva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeBean {
	@Id
	@GeneratedValue(generator = "secuenciaPrueba")
	@SequenceGenerator(name = "secuenciaPrueba", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "HIRE_DATE")
	@Temporal(TemporalType.DATE)
	private Date hireDate;

	@Column(name = "JOB_ID")
	private String jobId;

	@ManyToOne
	@JoinColumn(name = "JOB_ID", nullable = false, updatable = false, insertable = false)
	private JobBean job;

	@Column(name = "SALARY")
	private Double salary;

	@Column(name = "COMMISSION_PCT")
	private Double commissionPct;

	@Column(name = "MANAGER_ID")
	private Integer managerId;

	@Column(name = "DEPARTMENT_ID")
	private Integer departmentId;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false, updatable = false, insertable = false)
	private DepartmentBean department;

	public EmployeeBean() {
	}

	public EmployeeBean(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeBean(String firstName, String lastName, String email, String phoneNumber, Date hireDate, JobBean job,
			Double salary, Double commissionPct, Integer managerId, DepartmentBean department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.department = department;
	}

	public EmployeeBean(Integer employeeId, String firstName, String lastName, String email, String phoneNumber,
			Date hireDate, JobBean job, Double salary, Double commissionPct, Integer managerId,
			DepartmentBean department) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.department = department;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public JobBean getJob() {
		return job;
	}

	public void setJob(JobBean job) {
		this.job = job;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public DepartmentBean getDepartment() {
		return department;
	}

	public void setDepartmentId(DepartmentBean department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employees:  [ employeeId: " + employeeId + ", firstName: " + firstName + ", lastName: " + lastName
				+ ", email: " + email + ", phoneNumber: " + phoneNumber + ", hireDate: " + hireDate + ", jobId: "
				+ jobId + ", salary: " + salary + ", commissionPct: " + commissionPct + ", managerId: " + managerId
				+ ", departmentId: " + departmentId + " ]";
	}
}
