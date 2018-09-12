package ca.nait.dmit.model;

public class ChineseZodiac {
	private int birthYear;

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public ChineseZodiac() {
       birthYear = 1900;
	}

	public ChineseZodiac(int birthYear) {
		super();
		this.birthYear = birthYear;
	}
	 

}
