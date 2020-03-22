package io.github.alexengrig.lambdax.function;

import java.util.Optional;
import java.util.function.Function;

/**
 * Represents a function that accepts one argument and produces an optional result.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the optional value of the result of the function
 * @author Grig Alex
 * @version 0.4.0
 * @see java.util.Optional
 * @see java.util.function.Function
 * @since 0.4.0
 */
@FunctionalInterface
public interface OptionalResultFunction<T, R> extends Function<T, Optional<R>> {
}
