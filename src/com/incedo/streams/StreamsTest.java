package com.incedo.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	/*
	 * // Stream pipeline (a common structure): (a) set-up stream source (~ tables
	 * in SQL world) (b) 0 or more intermediate operations (~ WHERE clause) -- lazy
	 * & return Stream<T>, i.e., transforms a stream into another stream (c)
	 * terminal operation (~ column names) -- eager & return NON-STREAM. Terminates
	 * (closes) a stream
	 */

	// Print at most 5 DISTINCT books with rating >= 4.5
	// DB world: select distinct (ISBN) from book where rating >= 4.5 limit 0, 5;
	private static void slice(List<Book> books) {
		System.out.println("\nSlice ... ");

		List<String> result = books.stream()
				// Intermediate operations returning a stream
				.filter((d -> d.getRating() >= 4.5))
				.distinct()
				.limit(5)
				.map(d -> d.getTitle())

				// Terminal operations
//		.forEach(System.out::println);
				.collect(Collectors.toList());

		for (String title : result) {
			System.out.println(title);
		}

		System.out.println("-------------");

		Stream<Book> booksStream = books.stream()
				// Intermediate operations returning a stream
				.filter((d -> d.getRating() >= 4.5)).distinct().limit(5);
//				

		Stream<String> titleStream = booksStream.map(d -> d.getTitle());
		titleStream.forEach(System.out::println);

		// Terminal operations
//				.forEach(System.out::println);
//				 .collect(Collectors.toList());

	}

	// findFirst needs more work in parallel env. Use findAny if it does the job.
	// java.util.Optional ~
	// (a) to avoid dealing with null -- in case of find,
	// (b) to know if stream is empty -- in case of reduction operation
	private static void find(List<Book> books) {
		System.out.println("\nFinding ...");
		Optional<Book> result = books.parallelStream().filter((d) -> d.getRating() >= 4.8 && d.getPrice() <= 50.0)
				.findAny();

//			System.out.println(result);
//			if(result !=null)
		if (result.isPresent()) {
			System.out.println(result.get());
		} else {
			System.out.println("No record found!!");
		}

	}

	private static void print(Book b) {
		System.out.println(b);
	}

	private static Book getDefault() {
		System.out.println("default ...");
		return new Book(0, "", 4.0, 25.0, "Amazon");
	}

	// Queries:
	// (a) Is there at least one highly rated book (>= 4.8) that is inexpensive (<=
	// $50)?
	// (b) Do all the books have a rating >= 4.8
	// (c) Check if none of books have bad rating (2.0)?
	private static void match(List<Book> books) {
		System.out.println("\nMatching ... ");
//			(a)
		boolean anyMatch = books.stream().anyMatch((d) -> d.getRating() >= 4.8 && d.getPrice() <= 50.0);
		System.out.println(anyMatch);

//			(b)
		boolean allMatch = books.stream().allMatch((d) -> d.getRating() >= 4.8);
		System.out.println(allMatch);

//			(c )
		boolean noneMatch = books.stream().noneMatch((d) -> d.getRating() < 2.0);
		System.out.println(noneMatch);
		System.out.println(noneMatch);

	}

	// Find the lowest priced book with a rating > 4.5
	private static void reduce(List<Book> books) {
		books.parallelStream().filter(b -> b.getRating() >= 4.5)
				.reduce((b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2).ifPresent(System.out::println);
	}

	// Limitations:
//		1. Cumbersome
//		2. Parallelizing is painful
	private static void reduceImperatively(List<Book> books) {
		Book result = null;
		for (Book book : books) {
			if (result == null) {
				if (book.getRating() >= 4.5) {
					result = book;
				}
				continue;
			}

			if (book.getRating() >= 4.5 && result.getPrice() > book.getPrice()) {
				result = book;
			}
		}
		System.out.println("result: " + result);
	}

	// Print DISTINCT books with rating >= 4.5
	private static void collectToCollection(List<Book> books) {
		List<Book> list1 = books.stream().filter(b -> b.getRating() >= 4.5).distinct()
//			.collect(Collectors.toList());
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(list1.size());

		Set<Book> set2 = books.stream().filter(b -> b.getRating() >= 4.5)
		// This is not going to be needed sets only allow unique
//			.distinct()
				.collect(Collectors.toSet());
		System.out.println(set2.size());

		TreeSet<Book> set3 = books.stream().filter(b -> b.getRating() >= 4.5)
				.collect(Collectors.toCollection(() -> new TreeSet()));

		System.out.println(set3.size());
		set3.forEach(System.out::println);
	}

	private static void collectToMap(List<Book> books) {
		Map<Long, Book> bookMap = books.stream().collect(Collectors.toMap(b -> b.getIsbn(), b -> b));

//			for(Entry<Long,Book> entry: bookMap.entrySet()){
//				System.out.println("isbn: " + entry.getKey() + " - book" + entry.getValue());
//			}

		Map<Long, Book> treeMap = books.stream().collect(Collectors.toMap(Book::getIsbn, Function.identity(),
				(b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2, () -> new TreeMap()));

		for (Entry<Long, Book> entry : treeMap.entrySet()) {
			System.out.println("isbn: " + entry.getKey() + " - book" + entry.getValue());
		}

		// Get a treeMap
	}

	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

	}

}
