package dmit2015.hr.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dmit2015.hr.entity.Country;
import dmit2015.hr.entity.Location;
import dmit2015.hr.service.HumanResourceService;

@Named("currentLocationController")
@ViewScoped
public class LocationController implements Serializable{
  
	private static final long serialVersionUID = 1L;	
	
	@Inject
	private HumanResourceService humanResourceService;
	
	private List<Location> Locations;
	
	  
	@PostConstruct
	public void init() {
		Locations = humanResourceService.findAllLocation();
	}
	
	@Produces
	@Named
	public List<Location> getLocations() {
		return Locations;
	}



}
