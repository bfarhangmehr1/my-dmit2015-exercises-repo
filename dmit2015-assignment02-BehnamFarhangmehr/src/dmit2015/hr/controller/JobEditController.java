package dmit2015.hr.controller;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.hr.entity.Job;
import dmit2015.hr.service.HumanResourceService;

@Named
@ViewScoped
public class JobEditController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HumanResourceService currentHumanresourceService; 
	
	
	
	@Produces
	@Named
	private Job existingJob;
	
	private String idQueryValue;   // +getter +setter

	public String getIdQueryValue() {
		return idQueryValue;
	}

	public void setIdQueryValue(String idQueryValue) {
		this.idQueryValue = idQueryValue;
	}
	
	public void findJob() {
		try {
			existingJob = currentHumanresourceService.findOneJob(idQueryValue);
			if( existingJob !=null)
			{
				Messages.addGlobalInfo("Query successful");
			} else {
				Messages.addGlobalInfo("Query unsuccessful");
			}					
			Messages.addGlobalInfo("Query successful");
		}catch( Exception e){
			Messages.addGlobalInfo("Query unsuccessful");
		}
	}
	public void updateJob() {
		try {
			currentHumanresourceService.updateJob(existingJob);
			Messages.addGlobalInfo("Update successful");
		} catch (Exception e) {
			Messages.addGlobalError("Update unsuccessful");			
		}
	}
	public void deleteJob() {
		try {
			currentHumanresourceService.deleteJob(existingJob);
			existingJob = null;
			idQueryValue = null;
			Messages.addGlobalInfo("Delete successful");
		} catch (Exception e) {
			Messages.addGlobalError("Delete unsuccessful");			
		}
	}
	public void cancel() {
		existingJob = null;
	}

	
}
