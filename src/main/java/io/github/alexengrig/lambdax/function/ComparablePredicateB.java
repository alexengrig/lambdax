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
     * @see java.util.function.Function
     * @since 0.2.0
     */
    /* package */ComparablePredicateB(Function<T, R> mapper) {
        super(mapper);
    }
}
