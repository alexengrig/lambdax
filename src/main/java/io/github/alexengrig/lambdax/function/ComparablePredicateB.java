package io.github.alexengrig.lambdax.function;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>The base implementation of {@link io.github.alexengrig.lambdax.function.ComparablePredicateI} interface.</p>
 *
 * @param <T> a type
 * @param <R> a comparable result
 * @author Grig Alex
 * @version 0.2.0
 * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
 * @see java.lang.Comparable
 * @see java.util.function.Predicate
 * @see java.util.function.Function
 * @since 0.2.0
 */
/* package */final class ComparablePredicateB<T, R extends Comparable<R>> implements ComparablePredicateI<T, R> {
    private final static int ZERO = 0;

    private final Function<T, R> function;

    /* package */ComparablePredicateB(Function<T, R> mapper) {
        function = mapper;
    }

    @Override
    public <V extends Comparable<V>> ComparablePredicateB<T, V> map(Function<R, V> mapper) {
        return new ComparablePredicateB<>(function.andThen(mapper));
    }

    @Override
    public Predicate<T> less(R other) {
        return t -> function.apply(t).compareTo(other) < ZERO;
    }

    @Override
    public Predicate<T> more(R other) {
        return t -> function.apply(t).compareTo(other) > ZERO;
    }
}
