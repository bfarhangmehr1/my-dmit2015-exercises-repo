package ca.nait.dmit.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import ca.nait.dmit.model.Circle;
@Named
@RequestScoped
public class CircleController {
	//private double radius; // geter and setter
	private Circle currentCircle = new Circle(); // geter and setter

	//public double getRadius() {
	//	return radius;
	//}

	//public void setRadius(double radius) {
	//	this.radius = radius;
	//}
	public void calculatorArea() {
		//Circle currentCircle = new Circle(radius);
		Messages.addGlobalInfo("This is a literal message");
		// send message to FacesContext with the area of the circle
		Messages.addGlobalInfo("The area of circle with the radius of {0} is {1}", currentCircle.getRadius(),currentCircle.getArea());
	}
	public Circle getCurrentCircle() {
		return currentCircle;
	}
	public void setCurrentCircle(Circle currentCircle) {
		this.currentCircle = currentCircle;
	}
	public void calculateCircumference() {
		
		Messages.addGlobalInfo("This is a literal message");
		// send message to FacesContext with the area of the circle
		Messages.addGlobalInfo("The area of circle with the radius of {0} is {1}", currentCircle.getRadius(),currentCircle.getArea());
	}
	public void calculatediameter() {
		
		Messages.addGlobalInfo("This is a literal message");
		// send message to FacesContext with the area of the circle
		Messages.addGlobalInfo("The area of circle with the radius of {0} is {1}", currentCircle.getRadius(),currentCircle.getArea());
	}
}
