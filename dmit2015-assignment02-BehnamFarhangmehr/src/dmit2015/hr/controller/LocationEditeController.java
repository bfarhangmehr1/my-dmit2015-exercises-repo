package dmit2015.hr.controller;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Faces;
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
	
	@NotNull(message="Search value is required.")
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
	public String updateLocation() {
		String nextPage = null;
		try {
			currentHumanResourceService.updateLocation(exsitingLocation);
			Messages.addGlobalInfo("Update successful");
			nextPage = "viewLocations?faces-redirect=true";
		} catch (Exception e) {
			Messages.addGlobalError("Update unsuccessful");			
		}
		return nextPage;
	}
	public String deleteLocation() {
		String nextPage = null;
		try {
			currentHumanResourceService.deleteLocation(exsitingLocation);
			exsitingLocation = null;
			idQueryValue = null;
			Messages.addGlobalInfo("Delete successful");
			nextPage = "viewLocations?faces-redirect=true";
		} catch (Exception e) {
			Messages.addGlobalError("Delete unsuccessful");			
		}
		return nextPage;
	}
	public void cancel() {
		exsitingLocation = null;
	}
	
	public void findByQueryParameterId() {
		if (!Faces.isPostback() && !Faces.isValidationFailed() ) {
			if (idQueryValue != null && exsitingLocation == null) {
				findLocation();		
			}
		}
	}
	
}
