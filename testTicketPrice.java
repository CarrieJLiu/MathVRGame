//Student Name: Jiali Liu
import java.util.Scanner;

public class testTicketPrice {
	

	public static void main(String[] args) {
		int age = 0;
		//Create a Scanner
		Scanner keyboard = new Scanner(System.in);
		//Promote customer to enter age
		System.out.print("enter age: ");
		age = keyboard.nextInt();	
		
		if(age>=0 & age < 130) {
		if(age  < 2) {
			   System.out.println("free"); //display free if age is 0 to 2
			  }
			  else {
			   if(age <= 18) {
			    System.out.printf("Price is $ %.2f\n", 15.00); // display $15 if age is less than or equals to 18
			   }
			   else {
			    if(age < 65) {
			     System.out.printf("Price is $ %.2f\n", 20.00); // display $20 if age is less than 65
			    }
			    else {
			     if(age < 130) {
			      System.out.printf("Price is $ %.2f\n", 12.00);//display $12 if age is less than 130
			     } 
			    }
			   }
			  }
		}
		else {
				System.out.println("invalid age enter!"); //if age is less than 0, or greater than or
				                                          //equals to 130,display "invalid age enter" message.
			}

			  System.out.println("program by Jiali Liu.");
		
	}

}
