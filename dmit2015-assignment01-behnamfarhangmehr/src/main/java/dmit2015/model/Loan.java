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
		if (mortgageAmout > 0) {
			this.mortgageAmout = mortgageAmout;
		}

	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate > 0) {
			this.annualInterestRate = annualInterestRate;
		}

	}

	public int getAmortizationPeriod() {
		return amortizationPeriod;
	}

	public void setAmortizationPeriod(int amortizationPeriod) {
		if (amortizationPeriod > 0) {
			this.amortizationPeriod = amortizationPeriod;
		}
	}

	public Loan() {
		super();
		this.amortizationPeriod = 0;
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

		return Math.round(mortgageAmout * (Math.pow(1 + (annualInterestRate / 200), (1.0 / 6.0)) - 1)
				/ (1 - Math.pow(Math.pow(1 + (annualInterestRate / 200), 1.0 / 6.0), -12 * amortizationPeriod)) * 100.0)
				/ 100.0;
	}

	public ArrayList<LoanSchedule> getLoanScheduleArray() {
		ArrayList<LoanSchedule> loansckedule = new ArrayList<LoanSchedule>();

		double remaingBalance = mortgageAmout;
		for (int paymentNumber = 1; paymentNumber <= (12 * amortizationPeriod); paymentNumber++) {
			LoanSchedule link = new LoanSchedule();
			link.setRemainingBalance(Math.round(remaingBalance * 100.0 )/100.0);
			link.setPaymentNumber(paymentNumber);
			link.setInterestPaid( Math.round((getMonthlyPercentageRate() * remaingBalance) * 100.0) /100.0);
			link.setPrinciplePaid(Math.round((getMounthlyPayment() - link.getInterestPaid()) * 100.0) / 100.0);
			if (getMounthlyPayment() > remaingBalance) {
				
				link.setPrinciplePaid(remaingBalance);
			}
			remaingBalance = Math.round((remaingBalance - link.getPrinciplePaid()) * 100.0)/100.0;
			link.setRemainingBalance(remaingBalance);
			loansckedule.add(link);
		}

		return loansckedule;

	}

	public double getMonthlyPercentageRate() {
		return  Math.pow(1 + (annualInterestRate / 200), (1.0 / 6.0)) - 1;
	}

	@Override
	public String toString() {
		return "Loan [mortgageAmout=" + mortgageAmout + ", annualInterestRate=" + annualInterestRate
				+ ", amortizationPeriod=" + amortizationPeriod + "]";
	}
}
