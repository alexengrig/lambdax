package io.github.alexengrig.lambdax.function;

import java.util.function.Function;

/**
 * <p>The base implementation of the {@link io.github.alexengrig.lambdax.function.ComparablePredicateI} interface.</p>
 *
 * @param <T> the type of the input to the predicate
 * @param <R> the type of the mapper comparable result
 * @author Grig Alex
 * @version 0.2.0
 * @see java.lang.Comparable
 * @see java.util.function.Function
 * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
 * @see io.github.alexengrig.lambdax.function.PredicateB
 * @since 0.2.0
 */
/* package */final class ComparablePredicateB<T, R extends Comparable<R>> extends PredicateB<T, R> implements ComparablePredicateI<T, R> {
    /**
     * <p>The constructor with the mapper.</p>
     *
     * @param mapper a function for map the predicate input to the comparable result
     * @since 0.2.0
     */
    /* package */ComparablePredicateB(Function<T, R> mapper) {
        super(mapper);
    }
}
