public class testProgrammer {
	public static void main(String[] args) {	
		
		
		 Invoice i1= new Invoice("22776", "(steering) ", 3, 300);
		 Invoice i2= new Invoice("33442", "(cruise) ", 5, 90.99);
		 
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
		 
		
//	CommissionProgrammer cp = new CommissionProgrammer("Matthew", "Goodman", "123-45-6789", 16500, 0.44);
////	System.out.printf(cp.toString());
//	System.out.printf("%s\n%s: $%,.2f\n\n",cp, "payment due", cp.earnings());
		
		
//		HourlyProgrammer hp = new HourlyProgrammer("Cheng", "Lui", "234-56-7890", 18.95, 40);
//		System.out.printf(hp.toString());
//		System.out.printf("%s\n%s: $%,.2f\n\n",hp, "payment due", hp.earnings());
		
//		SalariedProgrammer sp = new SalariedProgrammer("Chioma", "Chidimma", "345-67-8901", 320.00);
//		System.out.printf(sp.toString());
//		System.out.printf("%s\n%s: $%,.2f\n\n", sp, "payment due", sp.earnings());
		
//		BasePlusCommissionProgrammer bp = new BasePlusCommissionProgrammer("Ramjeet", "Patel", "102-34-5678", 1200, .04, 720);
//		System.out.printf(bp.toString());
//		System.out.printf("%s\n%s: $%,.2f\n\n", bp, "payment due", bp.earnings());	

		
		

		 

//		System.out.println(bp.getBirthDate());
//		String[]  date=bp.getBirthDate().split(" ");
//		String enteredDate=date[4].toString();
//		String[]  enteredMonth=enteredDate.split("/");
//		String month=enteredMonth[0].toString();
//		System.out.println(month);
//		int intMonth = Integer.parseInt(month);
//		System.out.println(intMonth);

		
//		ActionProgrammer ap = new ActionProgrammer("aaa", "bbb", "123-11-4567", 3, 1997, 500.00,6);
//		System.out.printf(ap.toString());
//		System.out.printf("%s\n%s: $%,.2f\n\n", ap, "earned", ap.earnings());
		

	}

	
}