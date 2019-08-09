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
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>The base implementation of the {@link io.github.alexengrig.lambdax.function.PredicateI} interface.</p>
 *
 * @param <T> the type of the input to the predicate
 * @param <R> the type of the mapper result
 * @author Grig Alex
 * @version 0.2.0
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @see java.util.function.Predicate
 * @see java.util.function.Function
 * @see java.util.Objects
 * @since 0.2.0
 */
/* package */class PredicateB<T, R> implements PredicateI<T, R> {
    private final static int ZERO = 0;

    protected final Function<T, R> function;

    /**
     * <p>The constructor with the mapper.</p>
     *
     * @param mapper a function for map the predicate input
     * @see java.util.function.Function
     * @since 0.2.0
     */
    /* package */PredicateB(Function<T, R> mapper) {
        function = mapper;
    }

    @Override
    public <V> PredicateI<T, V> map(Function<R, V> mapper) {
        return new PredicateB<>(function.andThen(mapper));
    }

    @Override
    public <V extends Comparable<V>> ComparablePredicateI<T, V> map(ComparableResultFunction<R, V> mapper) {
        return new ComparablePredicateB<>(function.andThen(mapper));
    }

    @Override
    public Predicate<T> check(Predicate<R> checker) {
        return t -> checker.test(function.apply(t));
    }

    @Override
    public Predicate<T> equal(R other) {
        return t -> Objects.equals(t, other);
    }

    @Override
    public Predicate<T> less(R other, Comparator<R> comparator) {
        return t -> comparator.compare(function.apply(t), other) < ZERO;
    }

    @Override
    public Predicate<T> greater(R other, Comparator<R> comparator) {
        return t -> comparator.compare(function.apply(t), other) > ZERO;
    }
}
