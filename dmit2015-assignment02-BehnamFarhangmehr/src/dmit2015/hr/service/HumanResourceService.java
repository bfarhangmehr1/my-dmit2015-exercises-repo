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
	
	public void addJob(Job newJob) {
		entityManager.persist(newJob);
	}
	
	public void updateJob(Job existingJob) {
		entityManager.merge( existingJob );
	}	
	public void deleteJob(Job existingJob) throws Exception {
		existingJob = entityManager.merge(existingJob);
		if (existingJob.getJobHistories().size() > 0) {
			throw new Exception("You are not allowed to delete a job with existing histories.");
		}
		entityManager.remove( existingJob );
	}
	
	public Job findOneJob(String jobid) {
		return entityManager.find(Job.class, jobid);	
	}	
	public List<Job> findAllJob(){
		return entityManager.createQuery(
				"SELECT j FROM Job j ORDER BY j.jobId", Job.class
				).getResultList();
	}
	public List<Location> findAllLocation(){
		return entityManager.createQuery(
				"SELECT l FROM Location l ORDER BY l.locationId", Job.class
				).getResultList();
	}
	
	
	
}
