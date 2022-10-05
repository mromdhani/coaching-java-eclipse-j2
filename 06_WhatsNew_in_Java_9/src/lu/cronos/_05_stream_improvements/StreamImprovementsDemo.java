package lu.cronos._05_stream_improvements;

import java.util.stream.Stream;

public class StreamImprovementsDemo {

	public static void main(String[] args) {
		iterate();
		iterate_takewhile();
		iterate_dropwhile();

	}
	
	private static void iterate() { 
		System.out.println("iterate ...");
		Stream<Integer> stream = Stream.iterate(0, i -> i < 5, i -> i + 1);
		stream.forEach(System.out::println);         
	}

	private static void iterate_takewhile() {
		System.out.println("iterate takeWhile...");
		Stream<Integer> stream = Stream
				                   .iterate(0, i -> i < 5, i -> i + 1)
				                   .takeWhile(i -> i <= 2);
		stream.forEach(System.out::println);    
		
	}

	private static void iterate_dropwhile() {
		System.out.println("iterate dropWhile...");
		Stream<Integer> stream = Stream
				                   .iterate(0, i -> i < 5, i -> i + 1)
				                   .dropWhile(i -> i<=2);
		stream.forEach(System.out::println);    
		
	}

}
