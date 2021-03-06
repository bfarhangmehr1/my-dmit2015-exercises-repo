package dmit2015.hr.entity;

import java.io.Serializable;
import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dmit2015.hr.service.ValidMaxSalary;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the JOBS database table.
 * 
 */
@Entity
@ValidMaxSalary
@Table(name="JOBS")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotBlank(message="Job Id is required.")
	@Size(max=10, message="Job ID can not exceed more than {max} charactores.")	
	@Column(name="JOB_ID")
	private String jobId;
	
    //columnDefinition="MEDIUMTEXT"
	@NotBlank(message="Job Title is reqired.")
	@Size(max=35, message="Job Title '${validatedValue}' can not exceed more than {max} charactors.")
	@Column(name="JOB_TITLE")	
	private String jobTitle;
   
	@Column(name="MAX_SALARY")
	private BigDecimal maxSalary;

	@Column(name="MIN_SALARY")
	private BigDecimal minSalary;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="job")
	private List<Employee> employees;

	//bi-directional many-to-one association to JobHistory
	@OneToMany(mappedBy="job")
	private List<JobHistory> jobHistories;

	public Job() {
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	public BigDecimal getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
	}

	public List<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	public JobHistory addJobHistory(JobHistory jobHistory) {
		getJobHistories().add(jobHistory);
		jobHistory.setJob(this);

		return jobHistory;
	}

	public JobHistory removeJobHistory(JobHistory jobHistory) {
		getJobHistories().remove(jobHistory);
		jobHistory.setJob(null);

		return jobHistory;
	}

}