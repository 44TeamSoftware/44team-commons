package com.ffteam.commons.functions;

import java.util.Objects;

@FunctionalInterface
public interface TriConsumer<T, U, O> {

	void accept(final T t, final U u, final O o);

	default TriConsumer<T, U, O> andThen(final TriConsumer<T, U, O> after) {
		Objects.requireNonNull(after);

		return (T t, U u, O o) -> {
			accept(t, u, o);
			after.accept(t, u, o);
		};
	}
}
