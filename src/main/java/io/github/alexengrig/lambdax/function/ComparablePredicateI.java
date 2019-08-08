package io.github.alexengrig.lambdax.function;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>This interface describes a useful comparable predicate.</p>
 *
 * @param <T> a type
 * @param <R> a result
 * @author Grig Alex
 * @version 0.2.0
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @see java.lang.Comparable
 * @see java.util.function.Predicate
 * @since 0.2.0
 */
/* package */interface ComparablePredicateI<T, R extends Comparable<R>> {
    <V extends Comparable<V>> ComparablePredicateB<T, V> map(Function<R, V> mapper);

    Predicate<T> less(R other);

    Predicate<T> more(R other);

    default Predicate<T> lessOrEquals(R other) {
        return less(other).or(this::equals);
    }

    default Predicate<T> moreOrEquals(R other) {
        return more(other).or(this::equals);
    }
}
