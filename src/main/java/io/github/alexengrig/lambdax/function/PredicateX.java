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

import java.util.function.Function;

/**
 * <p>This utility class contains useful lambdas for {@link java.util.function.Predicate}.</p>
 *
 * @author Grig Alex
 * @version 0.2.0
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @see java.util.function.Function
 * @since 0.2.0
 */
public final class PredicateX {
    private PredicateX() {
    }

    public static <T, R> PredicateI<T, R> of(Function<T, R> mapper) {
        return new PredicateB<>(mapper);
    }

    public static <T, R extends Comparable<R>> ComparablePredicateI<T, R> ofComparable(Function<T, R> mapper) {
        return new ComparablePredicateB<>(mapper);
    }
}
