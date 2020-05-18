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

import java.util.function.Predicate;

/**
 * <p>This interface describes the useful mappable predicate with an optional result.</p>
 *
 * @param <T> the type of the input to the predicate
 * @author Grig Alex
 * @version 0.3.0
 * @see java.util.function.Predicate
 * @since 0.3.0
 */
@Deprecated
public interface OptionalPredicateResultI<T> {
    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that
     * if the mapper result is not {@code null}
     * then checks it via the previous checker
     * else checks the input value via the checker.
     * </p>
     *
     * @param checker a predicate for check the initial value
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    Predicate<T> orElse(Predicate<T> checker);

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that
     * if the mapper result is not {@code null}
     * then checks it via the previous checker
     * else return the check value.
     * </p>
     *
     * @param check a check result if the mapper result is not {@code null}
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    default Predicate<T> orElse(boolean check) {
        return orElse(t -> check);
    }

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that
     * if the mapper result is not {@code null}
     * then checks it via the previous checker
     * else return {@code true}.
     * </p>
     *
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    default Predicate<T> orTruth() {
        return orElse(PredicateX.truth());
    }

    /**
     * <p>
     * Returns the {@link java.util.function.Predicate} that
     * if the mapper result is not {@code null}
     * then checks it via the previous checker
     * else return {@code false}.
     * </p>
     *
     * @return The {@link java.util.function.Predicate} with compare
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    default Predicate<T> orLie() {
        return orElse(PredicateX.lie());
    }
}
