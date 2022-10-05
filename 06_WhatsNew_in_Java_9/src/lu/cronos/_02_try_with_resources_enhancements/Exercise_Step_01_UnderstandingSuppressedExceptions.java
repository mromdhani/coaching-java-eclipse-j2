package lu.cronos._02_try_with_resources_enhancements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise_Step_01_UnderstandingSuppressedExceptions{

	public static void demoSuppressedException(String filePath) throws IOException {
	    
		 Throwable firstException = null;
		 FileInputStream fileIn = null;
	    try {
	        fileIn = new FileInputStream(filePath);
	    } catch (FileNotFoundException e) {
	    	firstException = e;
	    } finally {	    	
	    	try {
	            fileIn.close();
	        } catch (NullPointerException npe) {
	            if (firstException != null) {
	                npe.addSuppressed(firstException);
	            }
	            throw npe;
	        }

	    }
	}	
	 
	public static void main(String[] args) {
		 
		try {
			demoSuppressedException("/non-existent-path/non-existent-file.txt");
		}  catch (Exception e) {
			System.out.println("See, we have got the exception: "+ e + " - The IOException has been suppressed !");
			System.out.println("     The size of suprresed exception: "+  e.getSuppressed().length);
			System.out.println("     The suppressed exception is: "+ e.getSuppressed()[0]);
					
		}

	}

}
