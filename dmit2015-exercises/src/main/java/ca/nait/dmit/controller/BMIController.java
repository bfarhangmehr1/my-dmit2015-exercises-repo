package ca.nait.dmit.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import ca.nait.dmit.model.BMI;


@ViewScoped
@Named
public class BMIController implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private BMI currentBMI = new BMI();
	private ArrayList<BMI> arraysOfBmi = new ArrayList<>();
	private BarChartModel charts = new BarChartModel();
	
	
	public void addedbmi() {
		Messages.addGlobalInfo(
        "Your Body Mass Index is {0}",
        currentBMI.bmi());
		
		arraysOfBmi.add(currentBMI);
		currentBMI = new BMI();
	}
	public void graph() {
		ChartSeries bars = new ChartSeries(); 
		
		for(int i=1; i<=5; i++) {
			
			bars.set(i,currentBMI.getHeight());
		}
		charts.addSeries(bars);
	}
	
	public BarChartModel getCharts() {
		return charts;
	}
	public BMI getCurrentBMI() {
		return currentBMI;
	}
	public void setCurrentBMI(BMI currentBMI) {
		this.currentBMI = currentBMI;
	}
	public ArrayList<BMI> getArraysOfBmi() {
		return arraysOfBmi;
	}
	
	
	
}
