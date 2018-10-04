package ca.nait.dmit.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import ca.nait.dmit.model.Rectangle;

@Named
@ViewScoped
public class rectangleContgroller implements Serializable {
	private static final long serialVersionUID = 1L;
   
	private Rectangle currentRectangle = new Rectangle();  //+ getter and setter
	private ArrayList<Rectangle> arrayOfRectangle = new ArrayList<>();  //+getter 
	private BarChartModel charts = new BarChartModel();   //+getter 
	
	


   public void createBar() {
	   ChartSeries seris = new ChartSeries();
	   Random currentRandom = new Random();
	   for ( int i = 1; i<=10 ; i++) {
		   seris.set(i,currentRandom.nextInt(100)+1);
	   }
	   charts.addSeries(seris);
	   
   }



	public void addRectangle() {
		arrayOfRectangle.add(currentRectangle);
		currentRectangle = new Rectangle();
	}
	
	
	
	
	
	public BarChartModel getCharts() {
		return charts;
	}
	
	public Rectangle getCurrentRectangle() {
		return currentRectangle;
	}
	public void setCurrentRectangle(Rectangle currentRectangle) {
		this.currentRectangle = currentRectangle;
	}
	public ArrayList<Rectangle> getArrayOfRectangle() {
		return arrayOfRectangle;
	}
	
	
}
