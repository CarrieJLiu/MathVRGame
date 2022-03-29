
// LAB 7: PaymeInterfaceTest.java

//This is the test for interface Payme.

public class PaymeInterfaceTest  {

public static void main(String[] args) {
	
 //TO DO: IN THIS PORTION OF THE CODE, SEVERAL CHANGES SHOULD BE MADE:
// CREATE SIX-ELEMENTS Payme array HERE 
	
 //START CODE 

//END CODE
	 Invoice i1= new Invoice("22776", "steering", 3, 300);
	 Invoice i2= new Invoice("33442", "cruise", 5, 90.99);
	 
	 SalariedProgrammer salariedProgrammer = new SalariedProgrammer("Chioma", "Chidimma", "345-67-8901", 320.00);
	
	 HourlyProgrammer hourlyProgrammer = new HourlyProgrammer("Cheng", "Lui", "234-56-7890", 18.95, 40);
	 
	 CommissionProgrammer commissionProgrammer = new CommissionProgrammer("Matthew", "Goodman", "123-45-6789", 16500, 0.44);

	 BasePlusCommissionProgrammer basePlusCommissionProgrammer = new BasePlusCommissionProgrammer("Ramjeet", "Patel", "102-34-5678", 1200, .04, 720);

	 int numberOfPayme = 6;
	 Payme[] paymeObjects = new Payme[numberOfPayme];
	 
	 paymeObjects[0] = i1;
	 paymeObjects[1] = i2;
		
	 paymeObjects[2] = salariedProgrammer;
	 paymeObjects[3] = hourlyProgrammer;
	 paymeObjects[4] = commissionProgrammer;
	 paymeObjects[5] = basePlusCommissionProgrammer;

// TO DO: POULATE THE ARRAY YOU CREATED WITH OBJECTS THAT IMPLEMENT Payable
//CHECK THE OUTPUT FILE AND REUSE EXACTLY THE DETAILS PROVIDED SUCH AS FIRST NAME
// LAST NAME, SOCIAL INSURANCE NUMBER, ETC.

 // START CODE

// END CODE


 System.out.println(
    "Payment for Invoices and Programmers are processed polymorphically:\n"); 

 // generically process each element in array paymeObjects
 
 for (Payme currentPayme : paymeObjects) {
    // output currentPayme and its appropriate payment amount
    System.out.printf("%s \n", currentPayme.toString()); 
   
    if (currentPayme instanceof BasePlusCommissionProgrammer) {
       // downcast Payme reference to 
       // BasePlusCommissioProgrammer reference
       BasePlusCommissionProgrammer programmer = 
          (BasePlusCommissionProgrammer) currentPayme;

       double oldBaseSalary = programmer.getBaseSalary();
       programmer.setBaseSalary(1.10 * oldBaseSalary);
       System.out.printf(
          "new base salary with 10%% increase is: $%,.2f\n",
          programmer.getBaseSalary());
    } 
    
    System.out.printf("%s: $%,.2f\n\n", "payment due", currentPayme.getPaymentAmount());
    

// TO DO: INSERT YOUR PRINT STATEMENT HERE: ENSURE THAT YOUR 
// OUTPUT FOLLOWS THE OUTPUT SAMPLE PROVIDED

// START CODE 

// END CODE

 }
}
}


