package dmit2015.hr.service;


import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



import dmit2015.hr.entity.Job;


public class MaxSalaryValidator implements ConstraintValidator< ValidMaxSalary, Job> {
	
	@Override
	public boolean isValid(Job currentJob, ConstraintValidatorContext context) {
		if (currentJob == null) {
			return true;			
		}
		BigDecimal val1 = currentJob.getMinSalary();
		BigDecimal val2 = currentJob.getMaxSalary();
		if(val1 ==null) {
			return true;
		} else if(val2 == null) {
			return true;
		}
			if(val2.doubleValue() >= val1.doubleValue() * 1.25) {
			
				return true;		
			}
			else {
				return false;
			} 					
	}	
}
