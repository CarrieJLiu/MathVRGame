
public class CatHandler {
//	static
//	No enclosing instance of type CatHandler is accessible. 
//	Must qualify the allocation with an enclosing instance of type CatHandler 
//	(e.g. x.new A() where x is an instance of CatHandler).

	public static class ExceptionAlpha extends Exception {
	}
	
	public static class ExceptionBeta extends  ExceptionAlpha {
	}
	
	public static class ExceptionGammer extends ExceptionBeta {
	}
	/*
	 * 
	 */
  public static void main(String[] args) {
	  //try block 
	  try {
		  System.out.println("Throw Gammer now"); 
		  throw new ExceptionGammer();
		 //catch block
		  //ExceptionGammer caught
	  } catch (ExceptionAlpha e) {
		  System.out.println("Catch Alpha now");
		  //print error if ExceptionGammer caught
		  System.err.println("Exception type: "+ e);
	      e.printStackTrace();
	  }
	  
	  System.out.println();
	  //try block
	  try {
		  System.out.println("Throw Beta now");
		  throw new ExceptionBeta();
		  //catch block
		  //ExcetionBata caught
	  } catch (ExceptionAlpha e) {
		  System.out.println("Catch Alpha now");
		  //print error if ExcetionBata caught
		  System.err.println("Exception type: "+ e);
	      e.printStackTrace();
	  }
  }

}
