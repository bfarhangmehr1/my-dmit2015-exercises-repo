package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;



import dmit2015.hr.entity.Job;
import dmit2015.hr.service.HumanResourceService;

@Named("currentJobController")
@ViewScoped
public class JobController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private HumanResourceService humanResourceService;
	 
	private List<Job> Jobs;    // +getter 
  
	@PostConstruct
	public void init() {
		Jobs = humanResourceService.findAllJob();
	}
	
	@Produces
	@Named
	public List<Job> getJobs() {
		return Jobs;
	} 
//	public void onShipperListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Shipper shipper) {
//	retreiveAllShippers();
//}
	
	
}
