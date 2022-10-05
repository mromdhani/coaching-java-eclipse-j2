package lu.cronos._08_reactive_streams;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class MyReactiveApp {

	public static void main(String args[]) throws InterruptedException {

		// Create Publisher
		SubmissionPublisher<Employee> publisher = new SubmissionPublisher<>();

		// Register Subscriber
		MySubscriber subs = new MySubscriber();
		publisher.subscribe(subs);

		List<Employee> emps = EmployeeHelper.getAllEmployees();

		// Publish items
		System.out.println("Publishing Items to Subscriber");
		emps.stream().forEach(i -> publisher.submit(i));

		// logic to wait till processing of all messages are over
		while (emps.size() != subs.getCounter()) {
			Thread.sleep(20);
		}
		// close the Publisher
		publisher.close();

		System.out.println("Ending the app");
	}
}
