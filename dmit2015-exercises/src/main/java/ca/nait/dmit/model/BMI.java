package ca.nait.dmit.model;

public class BMI {
    
	 private int weight; 
	   private int height;
	   
	   
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BMI() {
		weight = 100;
		height = 65;	
	}

	public BMI(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
	}   
	   public double bmi() {
		   return 703 * weight /Math.pow(height, 2);
	   }
	   public String bmiCategory() {
		   String curentCategory = "Invalid Category";
		  double currentBMI = bmi();
		  if(currentBMI <18.5) {
			  curentCategory = "Underweight"; 
			   
		   } else if(currentBMI < 25) {
			   curentCategory = "Normal"; 
		   } else if (currentBMI <30) {
			   curentCategory = "Over";
			   
		   }else {
			   curentCategory = "Obese";
		   }
		  return curentCategory;
	   }
}
