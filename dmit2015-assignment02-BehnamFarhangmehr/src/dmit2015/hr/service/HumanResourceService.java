package dmit2015.hr.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dmit2015.hr.entity.Job;





@Stateless 
public class HumanResourceService {
  
	@Inject
	private EntityManager entityManager; 
	  
	public void addJob( Job newJob) {
		
		Query currentQuery = entityManager.createQuery("SELECT MAX(r.jobId) + 1 FROM Job r");
		String nextjobId = (String) currentQuery.getSingleResult();
		newJob.setJobId(nextjobId);
		entityManager.persist(newJob);
	}
	
	
	
	
}
