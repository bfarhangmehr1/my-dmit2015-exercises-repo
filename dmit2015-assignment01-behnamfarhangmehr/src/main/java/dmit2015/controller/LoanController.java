package dmit2015.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dmit2015.model.Loan;
import dmit2015.model.LoanSchedule;



@Named
@ViewScoped
public class LoanController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Loan currentLoan = new Loan();  // + getter 
	private ArrayList<LoanSchedule> loanScheduleTable = new ArrayList<>();  //+getter 
	
	public void calculate() {
		
		currentLoan.getLoanScheduleArray();
				
	}

	public ArrayList<LoanSchedule> getLoanScheduleTable() {
		return loanScheduleTable;
	}
	public Loan getCurrentLoan() {
		return currentLoan;
	}
	public void setCurrentLoan(Loan currentLoan) {
		this.currentLoan = currentLoan;
	}
	


	
}
