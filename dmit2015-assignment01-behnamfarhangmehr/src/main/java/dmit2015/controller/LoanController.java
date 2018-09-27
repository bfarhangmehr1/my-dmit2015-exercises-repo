package dmit2015.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;

import org.omnifaces.util.Messages;
import org.primefaces.model.chart.BarChartModel;
import dmit2015.model.Loan;
import dmit2015.model.LoanSchedule;

@Named
@ViewScoped
public class LoanController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Loan currentLoan = new Loan(); // + getter
	private BarChartModel loanChart = new BarChartModel();

	public void calculate() {
		Messages.addGlobalInfo("Your montly payment is ${0}", currentLoan.getMounthlyPayment());
		
		
		ChartSeries amor = new ChartSeries();
	    
		for (int amoritization=1; amoritization<=(currentLoan.getAmortizationPeriod());amoritization++)
		{	  
		 double remainig =  currentLoan.getLoanScheduleArray().get(amoritization*12-1).getRemainingBalance();
		 amor.set(amoritization,remainig);
		  
		}	
		 loanChart.addSeries(amor);
		 
		Axis xAxis = loanChart.getAxis(AxisType.X);
		xAxis.setLabel("Amoritization In Year");		
		Axis yAxis = loanChart.getAxis(AxisType.Y);
		yAxis.setLabel("Mortgage Amount");		
		
		
		
		

	}

	public Loan getCurrentLoan() {
		return currentLoan;
	}

	public void setCurrentLoan(Loan currentLoan) {
		this.currentLoan = currentLoan;
	}

	public BarChartModel getLoanChart() {
		return loanChart;
	}

	public void setLoanChart(BarChartModel loanChart) {
		this.loanChart = loanChart;
	}

}
