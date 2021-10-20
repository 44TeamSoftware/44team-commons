package com.ffteam.commons.string;

import java.lang.String;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.lang.Object;
import java.util.Locale;
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
	 * @return {@link Boolean} {@code true} if {@code string} is not {@code null} and has at least one symbol
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
	 * Returns safe string representation of {@code object} or empty string if {@code object} is {@code null}
	 */
	public static String toString(final Object object) {
		return !Objects.isNull(object) ? object.toString() : "";
	}
	
	public static String encodeUrlAsUTF8(final String value) {
		if (value == null || value.isBlank()) {
			return "";
		}
		
	    return URLEncoder.encode(value, StandardCharsets.UTF_8);
	}

	public static String decodeUrlAsUTF8(final String value) {
		if (value == null || value.isBlank()) {
			return "";
		}
		
	    return URLDecoder.decode(value, StandardCharsets.UTF_8);
	}

	public static String parseStringToSentence(final String inputString, final String separator) {
		if (inputString == null || inputString.isBlank()) {
			return "";
		}
		
	    final StringBuilder stringBuilder = new StringBuilder();
	    final char[] characters = inputString.toCharArray();

		for (int index = 0; index < characters.length; index++) {
			final char character = characters[index];
			
			if (index > 0 && Character.isUpperCase(character)) {
				stringBuilder.append(separator);
			}

			stringBuilder.append(character);
		}

	    return stringBuilder.toString().toLowerCase(Locale.getDefault()).trim();
	}

}