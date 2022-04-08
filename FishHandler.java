
public class FishHandler {
	
	public static void easterEnding() throws Exception{
		System.out.println("Now in easterEnding() ");
		throw new Exception("Exception throw from easterEnding()");
		
	}
	
	public static void easterStarting() throws Exception{
		try {
			easterEnding();
		}
		catch(Exception e) {
			System.out.println("Now in easterStarting() : "+ e.getMessage());
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			easterStarting();
		} catch (Exception e) {
			System.out.println("Now in main : "+ e.getMessage());
			e.printStackTrace(System.out);
		}
	}

}
