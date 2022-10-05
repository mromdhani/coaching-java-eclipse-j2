package lu.cronos._02_lambda_use_cases;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lambda_04_Callable {
	@SuppressWarnings("unused")
	public static void main(String args[]) throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		// old style
		Callable<Integer> callable_old_style = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int result = 0;
				for (int i = 0; i < 10; i++) result+= i;
				return result;
			}
		};

		// Java 8 style
		Callable<Integer> callable_lambda_style = () -> { // Lambda Expression
			int result = 0;
			for (int i = 0; i < 10; i++) result+= i;
			return result;
		};
		Future<Integer> future = executor.submit(callable_lambda_style);
		try {
			Integer result = future.get(); // wait for a thread to complete
			System.out.println(result);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
}