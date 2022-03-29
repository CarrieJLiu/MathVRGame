
// THIS IS A CODE FILE FOR LAB 7. THIS CODE FILE REQUIRES SOME MODIFICATIONS!!!

//CommissionProgrammer.java

//CommissionProgrammer class extends Programmer.

public class CommissionProgrammer extends Programmer { 

private double grossSales; // gross weekly sales
private double commissionRate; // commission percentage

//constructor
public CommissionProgrammer(String firstName, String lastName, 
String socialSecurityNumber, double grossSales, double commissionRate) {
super(firstName, lastName, socialSecurityNumber);

if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate 
  throw new IllegalArgumentException(
     "Commission rate must be > 0.0 and < 1.0");
}

if (grossSales < 0.0) { // validate
  throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
this.commissionRate = commissionRate;
} 

//set gross sales amount on the creation of apps
public void setGrossSales(double grossSales) {
if (grossSales < 0.0) { // validate
  throw new IllegalArgumentException("Gross sales must be >= 0.0");
}

this.grossSales = grossSales;
} 

//return gross sales amount 
public double getGrossSales() {
return grossSales;
} 

//set commission rate
public void setCommissionRate(double commissionRate) {
if (commissionRate <= 0.0 || commissionRate >= 1.0) { // validate
  throw new IllegalArgumentException(
     "Commission rate must be > 0.0 and < 1.0");
}

this.commissionRate = commissionRate;
} 

//return commission rate
public double getCommissionRate() {
return commissionRate;
} 

//calculate earnings; override abstract method earnings in Programmer.

//MODIFY THIS PORTION. WHY WILL THIS PORTION OF YOUR CODE REQUIRE MODIFICATION?
//PROVIDE THE ANSWER TO THIS QUESTION TO YOUR PROFESSOR DURING DEMO

@Override                                                           
public double getPaymentAmount() {                                            
return getCommissionRate() * getGrossSales();                    
}      


//return String representation of CommissionProgrammer object

@Override      
public String toString() {
return String.format("%s: %s %s\n%s: %s\n%s: $%,.2f; %s: %s", 
  "commission programmer",getFirstName(), getLastName(), 
  "social security number", getSocialSecurityNumber(), 
  "gross sales", getGrossSales(),
  "commission rate", getCommissionRate());
}                                               

}

