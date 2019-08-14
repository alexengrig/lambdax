/*
 * Copyright 2019 LambdaX contributors
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
import java.util.function.Predicate;

/**
 * <p>This interface describes the useful predicate with the comparable result of the mapper.</p>
 *
 * @param <T> the type of the input to the predicate
 * @param <R> the type of the mapper comparable result
 * @author Grig Alex
 * @version 0.2.0
 * @see java.lang.Comparable
 * @see java.util.Comparator
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @since 0.2.0
 */
public interface ComparablePredicateI<T, R extends Comparable<R>> extends PredicateI<T, R> {
    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that checks if the input object is less than the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateI#less(Object, Comparator)
     * @see java.util.Comparator#comparing(java.util.function.Function)
     * @see java.lang.Comparable#compareTo(Object)
     * @see java.util.Comparator#reversed()
     * @since 0.2.0
     */
    default Predicate<T> less(R other) {
        return less(other, Comparator.comparing(other::compareTo).reversed());
    }

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that checks if the input object is greater than the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateI#greater(Object, Comparator)
     * @see java.util.Comparator#comparing(java.util.function.Function)
     * @see java.lang.Comparable#compareTo(Object)
     * @see java.util.Comparator#reversed()
     * @since 0.2.0
     */
    default Predicate<T> greater(R other) {
        return greater(other, Comparator.comparing(other::compareTo).reversed());
    }

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that checks if the input object is less than or
     * equals to the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateI#lessOrEqual(Object, Comparator)
     * @see java.util.Comparator#comparing(java.util.function.Function)
     * @see java.lang.Comparable#compareTo(Object)
     * @see java.util.Comparator#reversed()
     * @since 0.2.0
     */
    default Predicate<T> lessOrEqual(R other) {
        return lessOrEqual(other, Comparator.comparing(other::compareTo).reversed());
    }

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that checks if the input object is greater than or
     * equals to the other object.
     * </p>
     *
     * @param other an object for compare
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.PredicateI#greaterOrEqual(Object, Comparator)
     * @see java.util.Comparator#comparing(java.util.function.Function)
     * @see java.lang.Comparable#compareTo(Object)
     * @see java.util.Comparator#reversed()
     * @since 0.2.0
     */
    default Predicate<T> greaterOrEqual(R other) {
        return greaterOrEqual(other, Comparator.comparing(other::compareTo).reversed());
    }
}
