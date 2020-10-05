package com.ffteam.commons.collection;

import java.lang.String;
import java.lang.Object;
import java.util.Objects;

/**
 * This class consists of {@code static} utility methods for operating with strings
 */
public final class StringUtils {

	/**
	 * Hide constructor
	 */
	private StringUtils() {
		
	}
	
	/**
	 * Check if {@code string} is empty
	 * 
	 * @param string a reference to be checked
	 * @return {@link Boolean} {@code true} if {@code string} is {@code null} or has no symbols
	 */
	public static boolean isEmpty(final String string) {
		return Objects.isNull(string) || string.isEmpty();
	}
	
	/**
	 * Check if {@code string} is not empty
	 * 
	 * @param string a reference to be checked
	 * @return {@link Boolean} {@code true} if {@code string} is not {@code null} and has at lesat one symbol
	 */
	public static boolean isNotEmpty(final String string) {
		return !isEmpty(string);
	}
	
	/**
	 * Returns safe length of {@code string} or -1 if {@code string} is {@code null}
	 */
	public static int length(final String string) {
		return !Objects.isNull(string) ? string.length() : -1;
	}
	
	/**
	 * Returns safe string represantation of {@code object} or empty string if {@code object} is {@code null}
	 */
	public static String toString(final Object object) {
		return !Objects.isNull(object) ? object.toString() : "";
	}
}