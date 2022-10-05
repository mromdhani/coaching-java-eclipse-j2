package lu.cronos._02_lambda_use_cases;

public class Lambda_01_Threads {
	public static void main(String[] args) {

		// Before
		Thread thread_old_way = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("I am running (old style)...");
			}
		});

		// After
		Thread thread_modern_way = new Thread(() -> System.out.println("I am running (Java 8 style)..."));
		
		//Starting the threadd race		
		thread_old_way.start();
		thread_modern_way.start();		
		
		System.out.println("This message is send by the main thread ");	
	}

}
