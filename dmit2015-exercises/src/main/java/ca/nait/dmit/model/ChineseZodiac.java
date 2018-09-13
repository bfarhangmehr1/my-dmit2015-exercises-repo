package ca.nait.dmit.model;

public class ChineseZodiac {
	private int birthYear;

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	 public String animal( int birthYear){
		  String currentAnimal = "Unknown";			
		  int Animal = (birthYear-1900) % 12;
		   
		  if (Animal == 0 ){
			  currentAnimal = "Rat";
		  } else if(Animal == 1) {
			  currentAnimal = "Ox";
		  }else if(Animal == 2) {
			  currentAnimal = "Tiger";
		  }else if(Animal == 3) {
			  currentAnimal = "Rabbit";
		  }else if(Animal == 4) {
			  currentAnimal = "Dragon";
		  }else if(Animal == 5) {
			  currentAnimal = "Snake";
		  }else if(Animal == 6) {
			  currentAnimal = "Horse";
		  }else if(Animal == 7) {
			  currentAnimal = "Goat";
		  }else if(Animal == 8) {
			  currentAnimal = "Monkey";
		  }else if(Animal == 9) {
			  currentAnimal = "Rooster";
		  }else if(Animal == 10) {
			  currentAnimal = "Dog";
		  }else {			  
			  currentAnimal = "Pig";
		  }		  
		  return currentAnimal;
	 }
}
