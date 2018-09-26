package dmit2015.controller;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
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
@ManagedBean
public class LoanController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Loan currentLoan = new Loan();  // + getter 	
	private BarChartModel loanChart;
	
	@PostConstruct
    public void init() {
        createBarModels();
    }
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
         double Amount = currentLoan.getMortgageAmout();
         for (int amoritization = 1 ; amoritization <=currentLoan.getAmortizationPeriod(); amoritization++) {
        	 LoanSchedule  link = new LoanSchedule ();
        	 ChartSeries amor = new ChartSeries();        	 
        	 amor.set(amoritization, Amount );
        	 Amount = Amount-link.getPrinciplePaid(); 
        	 model.addSeries(amor);

         }
         
       return model;
	}

	    public BarChartModel getBarModel() {
	        return loanChart;
	    }
	
	    private void createBarModels() {
	    	 createBarModel();
	       
	    }
	    private void createBarModel() {
	    	loanChart = initBarModel();
	    	Axis xAxis = loanChart.getAxis(AxisType.X);
	        xAxis.setLabel("Amoritization Period");
	        xAxis.setMin(1);
	        xAxis.setMax(currentLoan.getAmortizationPeriod());
	        Axis yAxis = loanChart.getAxis(AxisType.Y);
	        yAxis.setLabel("Mortgage Amount");
	        yAxis.setMin(0);
	        yAxis.setMax(currentLoan.getMortgageAmout());
	    }
	    
	public void calculate() {		
		Messages.addGlobalInfo(
		 "Your montly payment is {0}", 
		 currentLoan.getMounthlyPayment());	
		
	}	
	public Loan getCurrentLoan() {
		return currentLoan;
	}
	public void setCurrentLoan(Loan currentLoan) {
		this.currentLoan = currentLoan;
	}
	
	


	
}
