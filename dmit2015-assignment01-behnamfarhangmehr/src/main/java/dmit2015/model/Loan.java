package dmit2015.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

 public  List<Loan> getLoanScheduleArray() {
	LoanSchedule  loansckedule = new LoanSchedule();
	List<Loan> loans = new ArrayList<>();
	
	for(Loan result: loans) {
	double monthlyPercentageRate = Math.round((Math.pow(1+(annualInterestRate/200), (1/6))-1) *100.0)/100.0;
	double interestPaid =Math.round( monthlyPercentageRate * loansckedule.getRemainingBalance() *100.0)/100.0;
	double principlePaid = Math.round( getMounthlyPayment() * interestPaid * 100.0)/100.0;
	  result.add(interestPaid);
	}
	
	
}

@Override
public String toString() {
	return "Loan [mortgageAmout=" + mortgageAmout + ", annualInterestRate=" + annualInterestRate
			+ ", amortizationPeriod=" + amortizationPeriod + "]";
}
}
