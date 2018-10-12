package dmit2015.hr.controller;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;


import org.omnifaces.util.Faces;
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
	
	@NotBlank(message="Search value is required.")
	private String idQueryValue; // +getter +setter

	public String getIdQueryValue() {
		return idQueryValue;
	}

	public void setIdQueryValue(String idQueryValue) {
		this.idQueryValue = idQueryValue;
	}

	public void findJob() {
		try {
			existingJob = currentHumanresourceService.findOneJob(idQueryValue);
			if (existingJob != null) {
				Messages.addGlobalInfo("Query successful");
			} else {
				Messages.addGlobalInfo("Query unsuccessful");
			}
			Messages.addGlobalInfo("Query successful");
		} catch (Exception e) {
			Messages.addGlobalInfo("Query unsuccessful");
		}
	}

	public String updateJob() {
		String nextPage = null;
		try {
			currentHumanresourceService.updateJob(existingJob);
			Messages.addGlobalInfo("Update successful");
			nextPage = "viewJobs?faces-redirect=true";
		} catch (Exception e) {
			Messages.addGlobalError("Update unsuccessful");
		}
		return nextPage;
	}

	public String deleteJob() {
		String nextPage = null;
		try {
			currentHumanresourceService.deleteJob(existingJob);
			existingJob = null;			
			idQueryValue = null;
			Messages.addGlobalInfo("Delete successful");
			nextPage = "viewJobs?faces-redirect=true";
		} catch (Exception e) {
			Messages.addGlobalError("Delete unsuccessful");
		}
		return nextPage;
	}

	public void cancel() {
		existingJob = null;
	}

	public void findByQueryParameterId() {
		if (!Faces.isPostback() && !Faces.isValidationFailed() ) {
			if (idQueryValue != null && existingJob == null) {
				findJob();		
			}
		}
	}
}

	

