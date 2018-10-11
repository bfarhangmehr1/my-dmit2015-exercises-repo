package dmit2015.hr.controller;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.hr.entity.Location;
import dmit2015.hr.service.HumanResourceService;

@Named
@ViewScoped
public class LocationEditeController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private HumanResourceService currentHumanResourceService;

	@Produces
	@Named
	private Location exsitingLocation;
	private Long idQueryValue;

	public Long getIdQueryValue() {
		return idQueryValue;
	}

	public void setIdQueryValue(Long idQueryValue) {
		this.idQueryValue = idQueryValue;
	}
	
	public void findLocation() {
		try {
			exsitingLocation = currentHumanResourceService.findOneLocation(idQueryValue);
			if( exsitingLocation !=null)
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
	public void updateLocation() {
		try {
			currentHumanResourceService.updateLocation(exsitingLocation);
			Messages.addGlobalInfo("Update successful");
		} catch (Exception e) {
			Messages.addGlobalError("Update unsuccessful");			
		}
	}
	public void deleteLocation() {
		try {
			currentHumanResourceService.deleteLocation(exsitingLocation);
			exsitingLocation = null;
			idQueryValue = null;
			Messages.addGlobalInfo("Delete successful");
		} catch (Exception e) {
			Messages.addGlobalError("Delete unsuccessful");			
		}
	}
	public void cancel() {
		exsitingLocation = null;
	}
	
	
}
