package com.ffteam.commons.stream;

import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This class consists of {@code static} utility methods for operating with streams
 */
public final class StreamUtils {
	
	/**
	 * Hide constructor
	 */
	private StreamUtils() {
		
	}
	
	/**
	 * Help easy create new {@link Collector} for {@link LinkedHashSet}
	 * 
	 * @return {@link Collector} for {@link LinkedHashSet}
	 */
	public static <E> Collector<E, ?, LinkedHashSet<E>> toLinkedHasSet() {
		return Collectors.toCollection(LinkedHashSet::new);
	}

	/**
	 * Help easy create new {@link Collector} for {@link TreeSet}
	 * 
	 * @return {@link Collector} for {@link TreeSet}
	 */
	public static <E> Collector<E, ?, TreeSet<E>> toTreeSet() {
		return Collectors.toCollection(TreeSet::new);
	}
}