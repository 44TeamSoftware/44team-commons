package com.ffteam.commons.collection;

import java.util.Collection;
import java.util.Objects;

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