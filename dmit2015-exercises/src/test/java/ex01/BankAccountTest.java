package ex01;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void testSetBalance() {
		fail("Not yet implemented");
		
		BankAccount  account1 = new BankAccount();
		
		// set the balcne to 1000 
		account1.setBalance(BigDecimal.valueOf(1000));
		// the balance sjhould be 1000;
		assertEquals(1000.00, account1.getBalance().doubleValue(),0);
		// set the balance to -5000
		account1.setBalance(BigDecimal.valueOf(-5000));
		// the balance shoudl be still 1000
		assertEquals(1000.00, account1.getBalance().doubleValue(),0);
		
		
	}
	@Test
	public void testMonthlyInterstRate(){
		BankAccount  account1 = new BankAccount();
		// set the balnace to 1000
		account1.setBalance(BigDecimal.valueOf((1000)));
		// set annul rate to 1.5
		account1.setAnnualInterestRate(1.5);
		// the monthly interstr rate should be 
		assertEquals(0.125, account1.getMonthlyInterestRate(),0);
	}

}
