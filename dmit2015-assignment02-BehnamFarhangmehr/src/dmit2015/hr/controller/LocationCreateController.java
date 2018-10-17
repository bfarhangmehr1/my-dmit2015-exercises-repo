package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message="country must be selected.")
	private String selectedCountryId;	// +getter +setter
	@Produces
	@Named
	private Location newLocation;     
	
	@PostConstruct
	public void initnewLocation() {
		newLocation = new Location();
		
	}
	public void createNewLocation() {
		try {
			if(selectedCountryId !=null && !selectedCountryId.isEmpty()) {
				Country country = currentHumanResourceService.findOneConuntry(selectedCountryId);
				newLocation.setCountry(country);
			}
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
	
	public String getSelectedCountryId() {
		return selectedCountryId;
	}
	public void setSelectedCountryId(String selectedCountryId) {
		this.selectedCountryId = selectedCountryId;
	}
	public void cancel() {
		newLocation = null;
	}
	
	}
