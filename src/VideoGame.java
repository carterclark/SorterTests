/**
 * This class represents one job in the technology sector
 * 
 * @author Carter Clark
 */


public class VideoGame implements Comparable<VideoGame>{
	
	//instance variables
	private String name;
	private int date;
	private int rating;
	
	/**
	 * Constructor
	 * @param job - name of job
	 * @param percentGrowth - projected job growth in percent
	 * @param avgSalary - average salary of job
	 */
	VideoGame(String name, int yearMade, int rating){
		
		this.name = name;
		this.date = 2020 - yearMade;
		this.rating = rating;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsOld() {
		return date;
	}

	public void setYearsOld(int yearsOld) {
		this.date = yearsOld;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Constructor
	 * @param job - name of job
	 */
	VideoGame(String name){
		this.name = name;
		this.date = 0;
		this.rating = 0;
	}
	
	VideoGame(){
		this.name = "";
		this.date = 0;
		this.rating = 0;
	}
	
	/**
	 * returns the properties of TechJob into a formatted string
	 * 
	 * @return Formated string
	 */
	@Override
	public String toString() {
		
		return this.makeSpaces(name)
				+ date + "\t\t\t"
				+ rating
				+ "\n";
		
		//return str;
	}
	
	/**
	 * determines the equality of two TechJobs by there names
	 * 
	 * @param other - Object of type TechJob
	 * 
	 * @return 	TRUE if the TechJobs have the same name
	 * 			FALSE if the TechJobs do not have the same name
	 */
	@Override
	public boolean equals(Object other) {
		
		if(other instanceof VideoGame) {
			return this.name.equalsIgnoreCase(((VideoGame) other).getName());
		}
		
		else {
			return false;
		}
		
	}
	
	/**
	 * compares one TechJob to a different TechJob
	 * 
	 * @param other - the other TechJob to compare
	 * 
	 * @return 	an number less than 0		if the other TechJob has a higher precedence
	 * 			0 							if the TechJobs have equal precedence
	 * 			an number greater than 0	if the other TechJob has lower precedence
	 */
	@Override
	public int compareTo(VideoGame other) {
		
		return this.getName().compareToIgnoreCase(other.getName());
	}
	
	/**
	 * creates a certain number of spaces after a string for formatting the toString method
	 * 
	 * @param str - a string to be formatted
	 * 
	 * @return a string with the correct number of spaces after it
	 */

	public String makeSpaces(String str) {
		
		int len = 35 - str.length();
		
		for(int i=0; i<len; i++) {
			str += " ";
		}
		
		return str + "\t";
	}
	
}
