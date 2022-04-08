
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DogHandler {
	public static class ExceptionDog extends Exception {
	}
	
	public static class ExceptionPuppy extends ExceptionDog {
	}
	
	public static void main(String[] args) {
		System.out.println("a. ExceptionDog");
		try {
			System.out.println("Throw ExceptionDog now");
			throw new ExceptionDog();
		} catch (Exception e) {
		  System.out.println("Catch Exception now");
		  System.err.println("Exception type: "+ e);
	      e.printStackTrace();
		}
	  
		System.out.println();
	  System.out.println("b. ExceptionPuppy");
	  try {
		  System.out.println("Throw ExceptionPuppy now");
		  throw new ExceptionPuppy();
	  } catch (Exception e) {
		  System.out.println("Catch Exception now");
		  System.err.println("Exception type: "+ e);
	      e.printStackTrace();
	  }
	  
	  System.out.println();
	  System.out.println("c. NullPointerException");
	  try {
		  System.out.println("Throw NullPointerException now");
		  throw new NullPointerException();
	  } catch (Exception e) {
		  System.out.println("Catch Exception now");
		  System.err.println("Exception type: "+ e);
	      e.printStackTrace();
	  }
	  
	  	System.out.println();
		System.out.println("d. IOException");
        try {
        	System.out.println("Throw IOException now");
  		  	throw new IOException();
        } catch (Exception e) {
        	System.out.println("Catch Exception now: ");
        	System.err.println("Exception type: "+ e);
        	e.printStackTrace();
        }
	  
  }


}
