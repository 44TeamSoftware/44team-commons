package com.ffteam.commons.functions;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
	
	 /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @param v the third function argument
     * @return the function result
     */
	public R apply(final T t, final U u, final V v);
	
	 /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <W>   the type of output of the {@code after} function, and of the
     *              composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     */
	public default <W> TriFunction<T, U, V, W> andThen(final Function<? super R, ? extends W> after) {
		Objects.requireNonNull(after);
		return (T t, U u, V v) -> after.apply(apply(t, u, v));
	}
}
