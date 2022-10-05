package lu.cronos._05_stream_improvements;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise_Step_02_PrimeNumbers_End {

	 public static void main(String[] args) {

	        long count = Stream.iterate(0, n -> n <= 1000,  n -> n + 1)
	                .filter(Exercise_Step_02_PrimeNumbers_End::isPrime)
	                .peek(x -> System.out.format("%s\t", x))
	                .count();

	        System.out.println("\nTotal: " + count);

	    }

	    public static boolean isPrime(int number) {

	        if (number <= 1) return false; // 1 is not prime and also not composite

	        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	    }

}