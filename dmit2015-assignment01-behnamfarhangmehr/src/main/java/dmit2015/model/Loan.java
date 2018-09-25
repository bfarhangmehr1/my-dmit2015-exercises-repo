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
		
	return mortgageAmout *(Math.pow(1+(annualInterestRate/200),(1.0/6.0))-1)/1- Math.pow(Math.pow(1+(annualInterestRate/200), 1.0/6.0), -12 * amortizationPeriod);
}

 public  ArrayList<LoanSchedule> getLoanScheduleArray() {	 
	 ArrayList<LoanSchedule> loansckedule = new ArrayList<LoanSchedule>();
	    
	    double remaingBalance = mortgageAmout;
	   for (int paymentNumber = 1; paymentNumber < (12 * amortizationPeriod); paymentNumber++) {
		LoanSchedule  link = new LoanSchedule ();
		link.setPaymentNumber(paymentNumber);
		link.setInterestPaid(Math.round(getMonthlyPercentageRate() * remaingBalance  *100.0)/100.0);
		link.setPrinciplePaid(Math.round(getMounthlyPayment() * link. getInterestPaid() * 100.0)/100.0);
		remaingBalance = remaingBalance - link.getPrinciplePaid();
		link.setRemainingBalance(remaingBalance);
		loansckedule.add(link);		
		}
	
	return loansckedule;
    
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
