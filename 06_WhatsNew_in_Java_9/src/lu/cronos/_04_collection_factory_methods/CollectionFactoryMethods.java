package lu.cronos._04_collection_factory_methods;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CollectionFactoryMethods {

	public static void main(String[] args) {
		createCollections();
	//	collectionsAreImmutable();
	}

	private static void createCollections() {
		System.out.println("CREATING COLLECTIONS");
		
		List<String> list = List.of("a", "b", "c");
		System.out.println("=======> "+ list.getClass().getName());
		list.add("AZERTY");
	
		
		Set<String> set = Set.of("a", "b", "c");
		Map<String, Integer> mapImmediate = Map.of(
				"one", 1,
				"two", 2,
				"three", 3);
		Map<String, Integer> mapEntries = Map.ofEntries(
				entry("one", 1),
				entry("two", 2),
				entry("three", 3));

		Stream.of(list, set, mapImmediate.entrySet(), mapEntries.entrySet())
				.map(CollectionFactoryMethods::joinElementsToString)
				.forEach(System.out::print);

		System.out.println();
	}

	private static String joinElementsToString(Collection<?> collection) {
		return collection.stream()
				.map(Object::toString)
				.collect(Collectors.joining(", ", "", "\n"));
	}

	@SuppressWarnings("unused")
	private static void collectionsAreImmutable() {
		System.out.println("COLLECTIONS CAN NOT BE MUTATED");

		addToCollection(List.of("a", "b", "c"), "d");
		addToCollection(Set.of("a", "b", "c"), "d");
		addToCollection(
				Map.ofEntries(entry("one", 1)).entrySet(),
				entry("two", 2));

		System.out.println();
	}

	private static <T> void addToCollection(Collection<T> collection, T item) {
		try {
			collection.add(item);
			throw new IllegalStateException();
		} catch (UnsupportedOperationException ex) {
			System.out.println("Could not mutate " + collection);
		}
	}

}
