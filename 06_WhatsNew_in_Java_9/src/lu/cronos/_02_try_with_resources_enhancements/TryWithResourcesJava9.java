package lu.cronos._02_try_with_resources_enhancements;

class Connection implements AutoCloseable {

	void makeImportantPreparations() {
	}

	void doSomething() {
		System.out.println("Doing something ...");
	}

	@Override
	public void close() throws Exception {
	}
}

class InJava8 {

	void doSomethingWith(Connection connection) throws Exception {
		// in Java 8, try-with-resources can only manage resources
		// that are declared for the statement
		try (Connection c = connection) {
			c.doSomething();
		}
	}
}

class InJava9 {

	void doSomethingWith(Connection connection) throws Exception {
		// in Java 9, all effectively final variables work
		try (connection) {
			connection.doSomething();
		}
	}
}

public class TryWithResourcesJava9 {

	public static void main(String[] args) {

		InJava9 inJava9 = new InJava9();
		Connection connection = new Connection();
		try {
			inJava9.doSomethingWith(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
