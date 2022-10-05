package lu.cronos_02_unmodifiable_collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UnModifiableCollections {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<String> authors = new ArrayList<>();
		authors.add("Martin Fowler");
		authors.add("Robert Martins");

		System.out.println(authors); 
		// New API added - Creates an UnModifiable List from a List.
		List<String> copyOfActors = List.copyOf(authors);
		System.out.println(copyOfActors); 

		// copyOfActors.add("Rod Johnson"); Will generate an UnsupportedOperationException

		authors.add("Rod Johnson");
		System.out.println(authors); 
		System.out.println(copyOfActors); 

		String str = "";
		Optional<String> name = Optional.ofNullable(str);
		// New API added - is preferred option then get() method
		name.orElseThrow(); // same as name.get()

		// New API added - Collectors.toUnmodifiableList
		List<String> collect = authors.stream().collect(Collectors.toUnmodifiableList());
		// collect.add("Gavin King"); // Will generate an UnsupportedOperationException

	}

}
