package com.ffteam.commons.stream;

//a simple program to demonstrate the use of stream in java 
import java.util.*;
import java.util.stream.*;

class StreamExamples {
	public static void main(String args[]) {

		// create a list of integers
		final List<Integer> number = Arrays.asList(2, 3, 4, 5);

		// demonstration of map method
		final List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

		// create a list of String
		final List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

		// demonstration of filter method
		final List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);

		// demonstration of sorted method
		final List<String> show = names.stream().sorted().collect(Collectors.toList());
		System.out.println(show);

		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);

		// collect method returns a set
		final Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println(squareSet);

		// demonstration of forEach method
		number.stream().map(x -> x * x).forEach(y -> System.out.println(y));

		// demonstration of reduce method
		final int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);

		System.out.println(even);
	}
}
