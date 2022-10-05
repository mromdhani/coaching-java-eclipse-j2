package lu.cronos._01_lambda_helloworld;

import java.util.List;

interface StringConcat {
	String sconcat(String a, String b);
}

public class HelloWorld_Lambda {

	public static void main(String[] args) {

		// Lambda as an argument for forEach
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.forEach(n -> System.out.print(n + " "));
		System.out.println();

		// Lambda as filtering Predicate
		numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
		System.out.println();

		// A user defined Lambda StringConcat
		StringConcat s = (str1, str2) -> str1 + str2;
		System.out.println("Result: " + s.sconcat("Hello ", "World"));
	}
}
