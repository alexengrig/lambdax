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

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>This utility class contains useful lambdas for {@link
 * java.util.function.Predicate}.</p>
 *
 * @author Grig Alex
 * @version 0.2.0
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
 * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @since 0.2.0
 */
public final class PredicateX {
    /**
     * <p>The private constructor.</p>
     *
     * @since 0.2.0
     */
    private PredicateX() {
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate}: t -&gt; true.</p>
     *
     * @param <T> a type of the input to the predicate
     * @return The {@link java.util.function.Predicate} that always returns {@code
     * true}
     * @see java.util.function.Predicate
     * @since 0.2.0
     */
    public static <T> Predicate<T> truth() {
        return t -> true;
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate}: t -&gt; false.</p>
     *
     * @param <T> a type of the input to the predicate
     * @return The {@link java.util.function.Predicate} that always returns {@code
     * false}
     * @see java.util.function.Predicate
     * @since 0.2.0
     */
    public static <T> Predicate<T> lie() {
        return t -> false;
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate} that is the negation of
     * the supplied predicate.</p> <p>Like in JDK 11.</p>
     *
     * @param <T>       a type of the input to the predicate
     * @param predicate a supplied predicate to negate
     * @return The {@link java.util.function.Predicate} that negates the results
     * of the supplied predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#negate
     * @since 0.2.0
     */
    @SuppressWarnings("unchecked")
    public static <T> Predicate<T> not(Predicate<? super T> predicate) {
        return (Predicate<T>) predicate.negate();
    }

    /**
     * <p>Returns the same {@link java.util.function.Predicate} as passed to the
     * method.</p>
     *
     * @param checker a predicate
     * @param <T>     a type of the input to the predicate
     * @return The same {@link java.util.function.Predicate} - checker
     * @see java.util.function.Predicate
     */
    @SuppressWarnings("unchecked")
    public static <T> Predicate<T> from(Predicate<? super T> checker) {
        return (Predicate<T>) checker;
    }

    /**
     * <p>Returns the {@link io.github.alexengrig.lambdax.function.PredicateB}
     * with the mapper.</p>
     *
     * @param mapper a function of map the input
     * @param <T>    a type of the input to the predicate
     * @param <R>    a type of the mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.PredicateI}
     * @see io.github.alexengrig.lambdax.function.PredicateI
     * @see java.util.function.Function
     * @see io.github.alexengrig.lambdax.function.PredicateB
     * @since 0.2.0
     */
    public static <T, R> PredicateI<T, R> of(Function<T, R> mapper) {
        return new PredicateB<>(mapper);
    }

    /**
     * <p>Returns the {@link
     * io.github.alexengrig.lambdax.function.ComparablePredicateB} with the mapper
     * with comparable result.</p>
     *
     * @param mapper a function of map the input to comparable result
     * @param <T>    a type of the input to the predicate
     * @param <R>    a comparable type of the mapper result
     * @return The {@link
     * io.github.alexengrig.lambdax.function.ComparablePredicateI}
     * @see java.lang.Comparable
     * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
     * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
     * @see io.github.alexengrig.lambdax.function.ComparablePredicateB
     * @since 0.2.0
     */
    public static <T, R extends Comparable<R>> ComparablePredicateI<T, R> of(ComparableResultFunction<T, R> mapper) {
        return new ComparablePredicateB<>(mapper);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateB} with
     * the mapper.
     * </p>
     *
     * @param mapper a function of map the input
     * @param <T>    a type of the input to the predicate
     * @param <R>    a type of the optional mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateI}
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateI
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateB
     * @see java.util.function.Function
     * @since 0.2.1
     */
    public static <T, R> OptionalPredicateI<T, R> ofNullable(Function<T, R> mapper) {
        return new OptionalPredicateB<>(mapper);
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.ComparableOptionalPredicateB} with
     * the mapper with comparable optional result.
     * </p>
     *
     * @param mapper a function of map the input to comparable optional result
     * @param <T>    a type of the input to the predicate
     * @param <R>    a comparable type of the optional mapper result
     * @return The {@link io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI}
     * @see java.lang.Comparable
     * @see io.github.alexengrig.lambdax.function.ComparableOptionalPredicateI
     * @see io.github.alexengrig.lambdax.function.ComparableOptionalPredicateB
     * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
     * @since 0.2.1
     */
    public static <T, R extends Comparable<R>> ComparableOptionalPredicateI<T, R> ofNullable(
            ComparableResultFunction<T, R> mapper) {
        return new ComparableOptionalPredicateB<>(mapper);
    }
}
