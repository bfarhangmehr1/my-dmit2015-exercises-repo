package dmit2015.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class LoanSchedule {
      private int  paymentNumber;
      private double interestPaid;
      private  double remainingBalance;
      private double principlePaid;
      
	public int getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(int paymentNumber) {
		if (paymentNumber >0) {
			this.paymentNumber = paymentNumber;
		}		
	}
	
	public double getInterestPaid() {		 
			return interestPaid;	
		
	}
	public void setInterestPaid(double interestPaid) {
		if (interestPaid >0) {
			this.interestPaid = interestPaid;
		}		
	}	public double getRemainingBalance() {
		
		return remainingBalance;
	}
	public void setRemainingBalance(double remainingBalance) {
		if (remainingBalance >0) {
			this.remainingBalance = remainingBalance;
		}
		
	}
	public double getPrinciplePaid() {
		return principlePaid;
	}
	public void setPrinciplePaid(double principlePaid) {
		if (principlePaid >0) {
			this.principlePaid = principlePaid;
		}		
	}      
	public LoanSchedule() {
		super();
		this.paymentNumber = 1;
		this.principlePaid = 0;
		this.remainingBalance = 0;
		this.interestPaid = 0;
	}
	
	public LoanSchedule(int paymentNumber, double interestPaid, double remainingBalance, double principlePaid) {
		super();
		this.paymentNumber = paymentNumber;
		this.interestPaid = interestPaid;
		this.remainingBalance = remainingBalance;
		this.principlePaid = principlePaid;
	}
	@Override
	public String toString() {
		return "LoanSchedule [paymentNumber=" + paymentNumber + ", interestPaid=" + interestPaid + ", remainingBalance="
				+ remainingBalance + ", principlePaid=" + principlePaid + "]";
	}  
	public double getMounthlyPayment() {
		Random rand = new Random();
		double mortgageAmount = rand.nextInt(1000000) + 1;
		double annualInterestRate = 1;
		int amortizationPeriod = 1;		
		return Math.round(((mortgageAmount * (Math.pow(1+(annualInterestRate/200),(1/6)))-1)/(1-(Math.pow(Math.pow(1 + (annualInterestRate/200), (1/6)), (-12* amortizationPeriod))))) * 100.0)/100.0 ;
	}
	public Object[] getLoanScheduleArray() {
		double annualInterestRate = 1;
		List<String> LoanSchedule = new ArrayList <String>();  
		
		String monthlyPercentageRate = double.toString(Math.pow(1+(annualInterestRate/200), (1/6))-1);
		double interestPaid = monthlyPercentageRate * remainingBalance;
		double principlePaid = getMounthlyPayment() * interestPaid;
	}
	
}
