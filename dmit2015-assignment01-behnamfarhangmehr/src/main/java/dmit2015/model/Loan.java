package dmit2015.model;

import java.util.ArrayList;

public class Loan {
  private double mortgageAmout;
  private double annualInterestRate;
  private int amortizationPeriod;
  
public double getMortgageAmout() {	 
		return mortgageAmout;	
	
}
public void setMortgageAmout(double mortgageAmout) {
	if(mortgageAmout> 0) {
		this.mortgageAmout = mortgageAmout;
	}
	
}
public double getAnnualInterestRate() {
	return annualInterestRate;
}
public void setAnnualInterestRate(double annualInterestRate) {
	if(annualInterestRate >0) {
		this.annualInterestRate = annualInterestRate;
	}
	
}
public int getAmortizationPeriod() {
	return amortizationPeriod;
}
public void setAmortizationPeriod(int amortizationPeriod) {
	if(amortizationPeriod>0) {
		this.amortizationPeriod = amortizationPeriod;
	}	
}
public Loan() {
	super();
	this.amortizationPeriod = 1;
	this.mortgageAmout = 1;
	this.annualInterestRate = 0;
}
public Loan(double mortgageAmout, double annualInterestRate, int amortizationPeriod) {
	super();
	this.mortgageAmout = mortgageAmout;
	this.annualInterestRate = annualInterestRate;
	this.amortizationPeriod = amortizationPeriod;
}
public double getMounthlyPayment() {
		
	return Math.round(((mortgageAmout * (Math.pow(1+(annualInterestRate/200),(1/6)))-1)/(1-(Math.pow(Math.pow(1 + (annualInterestRate/200), (1/6)), (-12* amortizationPeriod))))) * 100.0)/100.0 ;
}

 public  ArrayList<LoanSchedule> getLoanScheduleArray() {
	 
	 ArrayList<LoanSchedule> loansckedule = new ArrayList<LoanSchedule>();
	LoanSchedule  link = new LoanSchedule ();	
	
	
	do {
		loansckedule.add(link);
		link = new LoanSchedule();
	}while(link.getRemainingBalance()==0.00);
	
	return loansckedule;
	
	//link.getInterestPaid() = Math.round( getMonthlyPercentageRate() * loansckedule.getRemainingBalance() *100.0)/100.0;
	//link.getPrinciplePaid() = Math.round( getMounthlyPayment() * interestPaid * 100.0)/100.0;	
    
}
	public double getMonthlyPercentageRate() {
		return Math.round((Math.pow(1+(annualInterestRate/200), (1/6))-1) *100.0)/100.0;
	}

@Override
public String toString() {
	return "Loan [mortgageAmout=" + mortgageAmout + ", annualInterestRate=" + annualInterestRate
			+ ", amortizationPeriod=" + amortizationPeriod + "]";
}
}
