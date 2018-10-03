package dmit2015.hr.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dmit2015.hr.entity.Job;
import dmit2015.hr.entity.Location;





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
	
	public List<Job> findAllJob(){
		return entityManager.createQuery(
				"SELECT j FROM Job j ORDER BY j.jobId", Job.class
				).getResultList();
	}
	
	public List<Location> findAllLocation(){
		return entityManager.createQuery(
				"SELECT l FROM Location l ORDER BY l.locationId", Location.class
				).getResultList();
	}
}
