
import java.io.IOException;

public class OrderHandler {
	public static void main(String[] args) {
		
		try {
			//initiate Exception and IOException
			Exception e1= new Exception("superclass exception");
			IOException e2= new IOException("subclass exception");
			throw e2;  // Now in main catch IOException : subclass exception
//			throw e1;  //Now in main catch Exception  : superclass exception

			
		}catch (IOException e) {
			System.out.println("Now in main catch IOException : "+ e.getMessage());
		}catch (Exception e) {
			System.out.println("Now in main catch Exception  : "+ e.getMessage());
		}


		
		
//		try {
//			Exception e1= new Exception("superclass exception");
//			IOException e2= new IOException("subclass exception");
//			throw e2;
//			
//		}catch (Exception e) {
//			System.out.println("Now in main catch IOException : "+ e.getMessage());
//		}catch (IOException e) {
//			System.out.println("Now in main catch Exception  : "+ e.getMessage());
//		}
		
	}

}
