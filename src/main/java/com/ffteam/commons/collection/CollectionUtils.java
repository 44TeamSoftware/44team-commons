package com.ffteam.commons.collection;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class CollectionUtils {
	
	private CollectionUtils() {
		
	}
	
	public static <E> Collector<E, ?, LinkedHashSet<E>> toLinkedHasSet() {
		return Collectors.toCollection(LinkedHashSet::new);
	}

	public static <E> Collector<E, ?, TreeSet<E>> toTreeSet() {
		return Collectors.toCollection(TreeSet::new);
	}
	
	public static boolean isEmpty(final Collection<?> collections) {
		return Objects.isNull(collections) || collections.isEmpty();
	}
	
	public static boolean isNotEmpty(final Collection<?> collections) {
		return !isEmpty(collections);
	}
}
