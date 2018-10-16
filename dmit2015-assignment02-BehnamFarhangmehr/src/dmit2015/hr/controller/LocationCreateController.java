package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import dmit2015.hr.entity.Country;
import dmit2015.hr.entity.Location;
import dmit2015.hr.service.HumanResourceService;


@Named
@ViewScoped
public class LocationCreateController implements Serializable {
	private static final long serialVersionUID = 1L;
   
	
	
	@Inject
	private HumanResourceService currentHumanResourceService;
	 
	private String selectedCoontryId;	// +getter +setter
	@Produces
	@Named
	private Location newLocation;     
	
	@PostConstruct
	public void initnewLocation() {
		newLocation = new Location();
	}
	public void createNewLocation() {
		try {
			currentHumanResourceService.addLocation(newLocation);
			initnewLocation();
			Messages.addGlobalError("Add successful");
		}catch (Exception e) {
			Messages.addGlobalError("Add unsuccessful");			
		}	
	}
	public List<Country> retreiveAllCountry() {
		return currentHumanResourceService.findAllCountries();
	}
	
	public String getSelectedCoontryId() {
		return selectedCoontryId;
	}
	public void setSelectedCoontryId(String selectedCoontryId) {
		this.selectedCoontryId = selectedCoontryId;
	}
	public void cancel() {
		newLocation = null;
	}
	
	}
