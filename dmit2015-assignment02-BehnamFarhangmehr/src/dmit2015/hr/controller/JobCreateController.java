package dmit2015.hr.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJBAccessException;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.hr.entity.Job;
import dmit2015.hr.service.HumanResourceService;


@Named
@ViewScoped
public class JobCreateController implements Serializable {
	private static final long serialVersionUID = 1L;	
	@Inject
	private HumanResourceService currentHumanResourceService; 
	
	@Produces
	@Named	
	private Job newJob; 		
	@PostConstruct 
	public void initnewJob() {
		newJob = new Job();
	}
	
	
	
	
	public void createNewJob() {
		try {
		
			currentHumanResourceService.addJob(newJob);
			initnewJob();
			Messages.addGlobalInfo("Add successful");
		} catch(EJBAccessException e) {
			Messages.addGlobalError(e.getMessage());
		} catch (Exception e) {
			Messages.addGlobalError("Add unsuccessful");			
		}
	
	}
	public void cancel() {
		newJob = null;
	}
	
}
