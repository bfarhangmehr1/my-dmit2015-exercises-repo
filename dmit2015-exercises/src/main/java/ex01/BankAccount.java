package ex01;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BankAccount {
   private UUID id;
   private BigDecimal balance;
   private double annualInterestRate;
   private LocalDate dateCreated;
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}
public BigDecimal getBalance() {
	return balance;
}
public void setBalance(BigDecimal balance) {
	if(balance.doubleValue() >= 0) {
		this.balance = balance;
	}	
}
public double getAnnualInterestRate() {
	return annualInterestRate;
}
public void setAnnualInterestRate(double annualInterestRate) {
	if(annualInterestRate >=0) {
		this.annualInterestRate = annualInterestRate;
	}	
}
public LocalDate getDateCreated() {
	return dateCreated;
}
//default constructor or supper class 
public BankAccount() {
	super();
	id = UUID.randomUUID();
	balance = BigDecimal.ZERO;
	annualInterestRate = 0;
	dateCreated = LocalDate.now();
}
//constructor using data fields (over loaded constructor)
public BankAccount(UUID id, BigDecimal balance) {
	super();
	this.id = id;
	this.balance = balance;
	this.annualInterestRate = 0;
	dateCreated = LocalDate.now();	
} 
 public double getMonthlyInterestRate() {
	 return annualInterestRate/100/12;
	 
 }
 public BigDecimal getMonthlyInterset() {
	 return BigDecimal.valueOf(balance.doubleValue() * getMonthlyInterestRate());
 }
 public BigDecimal addMontlhyInteres() {
	 balance = balance.add(getMonthlyInterset());
	 return balance;
 }
 public BigDecimal withdraw (BigDecimal amount) {
	 if(amount.doubleValue()>0 && amount.doubleValue() < balance.doubleValue()) {
		 balance = balance.subtract(amount);
		 return balance;

		 }else {
			 return balance;
		 }
 }
	 public BigDecimal deposit (BigDecimal amount) {
		 if(amount.doubleValue()>0 ) {
			 balance = balance.add(amount);
			 return balance;

			 }else {
				 return balance;
			 }
 } 
	 
}
