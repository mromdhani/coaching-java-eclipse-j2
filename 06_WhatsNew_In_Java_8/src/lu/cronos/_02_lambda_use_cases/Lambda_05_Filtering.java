package lu.cronos._02_lambda_use_cases;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda_05_Filtering {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// old style
		Predicate<Integer> odd = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {			
				return t % 2 != 0;
			}
		};
		List<Integer> oddNumbers = list.stream().filter(odd).collect(Collectors.toList());
		
		// Java 8 style
		List<Integer> evenNumbers = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		System.out.println("Odd numbers:  "+ oddNumbers);
		System.out.println("Even numbers: "+ evenNumbers);
	}
}
