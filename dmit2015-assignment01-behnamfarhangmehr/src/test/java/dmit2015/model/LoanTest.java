package dmit2015.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LoanTest {

	@Test	
	  public void testGetMonthyPayment() {
	  
		Loan loanBean = new Loan(250000, 5.29, 25);
		assertEquals(1495.56, loanBean.getMounthlyPayment(), 0.00);

		loanBean = new Loan(250000, 3.09, 25);
		assertEquals(1194.69, loanBean.getMounthlyPayment(), 0.00);

		loanBean = new Loan(250000, 5.29, 20);
		assertEquals(1682.18, loanBean.getMounthlyPayment(), 0.00);

	  }
	
	 @Test
	  public void testGetMonthlyPayment_GetLoanScheduleArray1()
	  {
		Loan loanBean1 = new Loan();	
		
        loanBean1.setMortgageAmout(250000);
        loanBean1.setAnnualInterestRate(5.29);
        loanBean1.setAmortizationPeriod(25);
        assertEquals(1090.13, loanBean1.getLoanScheduleArray().get(0).getInterestPaid(), 0.00);
        assertEquals(1, loanBean1.getLoanScheduleArray().get(0).getPaymentNumber(), 0.00);
        assertEquals(405.43, loanBean1.getLoanScheduleArray().get(0).getPrinciplePaid(), 0.00);         
        assertEquals(249594.57, loanBean1.getLoanScheduleArray().get(0).getRemainingBalance(), 0.00);  
        
       Loan loanBean2 = new Loan();	
		
        loanBean2.setMortgageAmout(250000);
        loanBean2.setAnnualInterestRate(5.29);
        loanBean2.setAmortizationPeriod(25);
        assertEquals(12.95, loanBean2.getLoanScheduleArray().get(298).getInterestPaid(), 0.00);
        assertEquals(299, loanBean2.getLoanScheduleArray().get(298).getPaymentNumber(), 0.00);
        assertEquals(1482.61, loanBean2.getLoanScheduleArray().get(298).getPrinciplePaid(), 0.00);         
        assertEquals(1487.71, loanBean2.getLoanScheduleArray().get(298).getRemainingBalance(), 0.00);   
         
        Loan loanBean3 = new Loan();	
        
        loanBean3.setMortgageAmout(250000);
        loanBean3.setAnnualInterestRate(5.29);
        loanBean3.setAmortizationPeriod(25);
        assertEquals(6.49, loanBean3.getLoanScheduleArray().get(299).getInterestPaid(), 0.00);
        assertEquals(300, loanBean3.getLoanScheduleArray().get(299).getPaymentNumber(), 0.00);
        assertEquals(1487.71, loanBean3.getLoanScheduleArray().get(299).getPrinciplePaid(), 0.00);         
        assertEquals(0.00, loanBean3.getLoanScheduleArray().get(299).getRemainingBalance(), 0.00);
        
        
	  }
	
	  
}
