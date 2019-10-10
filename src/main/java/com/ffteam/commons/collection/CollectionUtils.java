package com.ffteam.commons.collection;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * This class consists of {@code static} utility methods for operating with collections
 */
public final class CollectionUtils {
	
	/**
	 * Hide constructor
	 */
	private CollectionUtils() {
		
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
	

	/**
	 * Check if {@code collection} is empty
	 * 
	 * @param collection a reference to be checked
	 * @return {@link Boolean} {@code true} if {@code collection} is {@code null} or contains no elements
	 */
	public static boolean isEmpty(final Collection<?> collection) {
		return Objects.isNull(collection) || collection.isEmpty();
	}
	
	/**
	 * Check if {@code collection} is not empty
	 * 
	 * @param collection a reference to be checked
	 * @return {@link Boolean} {@code true} if {@code collection} is not {@code null} and contains elements
	 */
	public static boolean isNotEmpty(final Collection<?> collection) {
		return !isEmpty(collection);
	}
}