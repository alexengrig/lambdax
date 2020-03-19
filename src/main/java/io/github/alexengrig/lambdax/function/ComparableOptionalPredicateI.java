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

/**
 * <p>This interface describes the useful predicate with the comparable optional result of the mapper.</p>
 *
 * @param <T> the type of the input to the predicate
 * @param <R> the type of the mapper comparable result
 * @author Grig Alex
 * @version 0.3.0
 * @see java.lang.Comparable
 * @see java.util.Comparator
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.OptionalPredicateI
 * @since 0.3.0
 */
public interface ComparableOptionalPredicateI<T, R extends Comparable<R>> extends OptionalPredicateI<T, R> {
    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is less than the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> less(R other) {
        return less(other, Comparator.comparing(other::compareTo).reversed());
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is greater than the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> greater(R other) {
        return greater(other, Comparator.comparing(other::compareTo).reversed());
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is less than or equals to the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> lessOrEqual(R other) {
        return lessOrEqual(other, Comparator.comparing(other::compareTo).reversed());
    }

    /**
     * <p>
     * Returns the {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} that
     * if the mapper result is not {@code null} then
     * checks if the input object is greater than or
     * equals to the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link io.github.alexengrig.lambdax.function.OptionalPredicateResultI} with compare
     * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
     * @since 0.3.0
     */
    default OptionalPredicateResultI<T> greaterOrEqual(R other) {
        return greaterOrEqual(other, Comparator.comparing(other::compareTo).reversed());
    }
}
