    /*
	 * Student Name: Jiali Liu
	 * Lab Professor: Siju Philip
	 * Due Date: Nov 12,2021
	 * Modified: Nov 7, 2021
	 * Description: This class describes the different ticket prices according to different ranges of ages.
	 */
public class TicketPrice {
	//customer's age
	private int age;
	

	public TicketPrice() {
		this(0);
	}
	//constructors which set the default
	public TicketPrice(int age) {
		this.age = age;
	}

	// getter for age
	public int getAge() {
		return age;
	}
	

	//setter for age
	public void setAge(int age) {
		this.age = age;
	}
	
	
	//display the ticket price
	public double ticketPrice() {
		double price = -1.0; // set to -1 in case the age is invalid.
		
		// if the age is less than zero, or greater than or equal 
		// to 130 return -1.0
		// use nested if statements with ranges to determine the price.
		// return the determined price 
		
		return price; 
	}
	
}
