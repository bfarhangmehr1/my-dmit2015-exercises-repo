package ca.nait.dmit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BMITest {

	@Test
	public void testBmiCategory() {
		fail("Not yet implemented");
		BMI bmi = new BMI();
	    bmi.setHeight(66);
	    bmi.setWeight(100);
	    assertEquals(16.1, bmi.bmi(),0.005);
	    assertEquals("underweight",bmi.bmiCategory());
	    bmi.setHeight(66);
	    bmi.setWeight(140);
	    assertEquals(22.6, bmi.bmi(),0.005);
	    assertEquals("normal",bmi.bmiCategory());
	    bmi.setHeight(66);
	    bmi.setWeight(175);
	    assertEquals(28.2, bmi.bmi(),0.005);
	    assertEquals("overweight",bmi.bmiCategory());
	    bmi.setHeight(66);
	    bmi.setWeight(200);
	    assertEquals(32.3, bmi.bmi(),0.005);
	    assertEquals("obese",bmi.bmiCategory());
	    bmi.setHeight(66);
	    bmi.setWeight(100);	   
	}
}
