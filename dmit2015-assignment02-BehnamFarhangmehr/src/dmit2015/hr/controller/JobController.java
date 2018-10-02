package dmit2015.hr.controller;

import java.io.Serializable;

import javax.ejb.EJBAccessException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.hr.entity.Job;
import dmit2015.hr.service.HumanResourceService;
import northwind.entity.Region;








@Named("currentJobController")
@ViewScoped
public class JobController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private HumanResourceService humanResourceService;
		
	private Job JobDetail;		
	
	private String id;						
	
	private boolean editMode = false; 
	
	
	
	public void init() {
		// create a new Job for adding a new job
		JobDetail = new Job();
	}
	
	public String CreateJob() {
      String result = null;
		
		try {
			humanResourceService.addJob(JobDetail);
			JobDetail = new Job();
			Messages.addFlashGlobalInfo("Create was successful.");
			result = "viewJobs?faces-redirect=true";
		} catch(EJBAccessException e) {
			Messages.addGlobalError(e.getMessage());
		} catch(Exception e) {
			Messages.addGlobalError("Create was not successful.");
		}		
		
		return result;
		
	}



	public void findJobById() {
		if (id==null) {
			Job item  = humanResourceService.findOneJob(id);
			if (item == null) {
				Messages.addGlobalError("Bad request. Unknown id {0}.", id);
			} else {
				editMode = true;
				regionDetail = item;							
			}
		}
	}
	
	
	
	
	
	

	public Job getJobDetail() {
		return JobDetail;
	}
	public void setJobDetail(Job jobDetail) {
		this.JobDetail = jobDetail;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	
}
