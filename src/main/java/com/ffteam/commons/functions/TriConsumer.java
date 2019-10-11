package com.ffteam.commons.functions;

import java.util.Objects;

/**
 * Represents an operation that accepts three input arguments and returns no
 * result.  The three-arity specialization of {@link Consumer}.
 * Unlike most other functional interfaces, {@code TriConsumer} is expected
 * to operate via side-effects.
 * <p>
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object, Object, Object)}.
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <O> the type of the third argument to the operation
 * @see Consumer
 * @since 1.8
 */

@FunctionalInterface
public interface TriConsumer<T, U, O> {
	
	 /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param o the third input argument
     */
	void accept(final T t, final U u, final O o);
	
	/**
     * Returns a composed {@code TriConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code TriConsumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
	default TriConsumer<T, U, O> andThen(final TriConsumer<T, U, O> after) {
		Objects.requireNonNull(after);

		return (T t, U u, O o) -> {
			accept(t, u, o);
			after.accept(t, u, o);
		};
	}
}
