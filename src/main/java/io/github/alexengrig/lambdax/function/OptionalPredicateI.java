/*
 * Copyright 2019 - 2020 Alexengrig Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.alexengrig.lambdax.function;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>This interface describes the useful mappable predicate with an optional result.</p>
 *
 * @param <T> the type of the input to the predicate
 * @param <R> the type of the mapper result
 * @author Grig Alex
 * @version 0.3.0
 * @see java.lang.Comparable
 * @see java.util.Comparator
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI
 * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
 * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
 * @since 0.3.0
 */
public interface OptionalPredicateI<T, R> {
    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateI} with
     * the new mapper for the input to the predicate.
     * </p>
     *
     * @param mapper a function of map the input
     * @param <V>    a new type of the mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateI} with the new mapper
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateI
     * @see java.util.function.Function
     * @since 0.3.0
     */
    <V> OptionalPredicateI<T, V> map(Function<R, V> mapper);

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI} with
     * the new mapper with comparable result for the input to the predicate.
     * </p>
     *
     * @param mapper a function of map the input to the comparable result
     * @param <V>    a new comparable type of the mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI} with
     * the new mapper
     * @see java.lang.Comparable
     * @see io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI
     * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
     * @since 0.3.0
     */
    <V extends Comparable<V>> ComparableOptionalPredicateI<T, V> map(ComparableResultFunction<R, V> mapper);

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks the mapper result via the checker.
     * </p>
     *
     * @param checker a predicate for check the mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with the checker
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    OptionalPredicateResultI<T> check(Predicate<R> checker);

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that
     * checks the mapper result is {@code null}.
     * </p>
     *
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    default Predicate<T> isNull() {
        return check(Objects::isNull).orTruth();
    }

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that
     * checks the mapper result is not {@code null}.
     * </p>
     *
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    default Predicate<T> nonNull() {
        return check(Objects::nonNull).orLie();
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is equals to the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> equal(R other) {
        return check(other::equals);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is less than the other object via the comparator
     * </p>
     *
     * @param other      an object for compare
     * @param comparator a comparison function for compare the input object with
     *                   the other object
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @see java.util.Comparator
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> less(R other, Comparator<R> comparator) {
        return check(r -> Objects.compare(r, other, comparator) < 0);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is greater than the other object via the comparator.
     * </p>
     *
     * @param other      an object for compare
     * @param comparator a comparison function for compare the input object with
     *                   the other object
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @see java.util.Comparator
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> greater(R other, Comparator<R> comparator) {
        return check(r -> Objects.compare(r, other, comparator) > 0);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is less than or equals to the other object via the comparator.
     * </p>
     *
     * @param other      an object for compare
     * @param comparator a comparison function for compare the input object with
     *                   the other object
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @see java.util.Comparator
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> lessOrEqual(R other, Comparator<R> comparator) {
        return check(r -> Objects.compare(r, other, comparator) <= 0);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is greater than or equals to the other object via the comparator.
     * </p>
     *
     * @param other      an object for compare
     * @param comparator a comparison function for compare the input object with
     *                   the other object
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @see java.util.Comparator
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> greaterOrEqual(R other, Comparator<R> comparator) {
        return check(r -> Objects.compare(r, other, comparator) >= 0);
    }
}
