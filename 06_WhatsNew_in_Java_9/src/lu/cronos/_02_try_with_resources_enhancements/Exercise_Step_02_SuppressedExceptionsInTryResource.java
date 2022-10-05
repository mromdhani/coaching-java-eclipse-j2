package lu.cronos._02_try_with_resources_enhancements;

class ExceptionalResource implements AutoCloseable {
    
    public void processSomething() {
        throw new IllegalArgumentException("Thrown from processSomething()");
    }

    @Override
    public void close() throws Exception {
        throw new NullPointerException("Thrown from close()");
    }
}
public class Exercise_Step_02_SuppressedExceptionsInTryResource{

	public static void demoExceptionalResource() throws Exception {
	    
		try (ExceptionalResource exceptionalResource = new ExceptionalResource()) {
	        exceptionalResource.processSomething();
	    }
	}	
	 
	public static void main(String[] args) {
		 
		try {
		    demoExceptionalResource();
		} catch (Exception e) {
		    System.out.println("The exception caught is: "+e.getClass());
		    System.out.println("Thrown from processSomething(): "+ e.getMessage());
		    System.out.println("The length of the suppressed array: "+ e.getSuppressed().length);
		    System.out.println("The suppressed exception is: "+ (e.getSuppressed()[0]).getClass());
		    System.out.println("The suppressed exception message is: "+ e.getSuppressed()[0].getMessage());
		}

	}

}
