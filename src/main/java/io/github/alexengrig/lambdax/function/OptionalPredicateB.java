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
 * {@inheritDoc}
 *
 * @author Grig Alex
 * @version 0.2.1
 * @see io.github.alexengrig.lambdax.function.OptionalPredicateI
 * @since 0.2.1
 */
/* package */class OptionalPredicateB<T, R> implements OptionalPredicateI<T, R> {
    /**
     * @since 0.2.1
     */
    protected final Function<T, R> function;

    /**
     * {@inheritDoc}
     */
    /* package */OptionalPredicateB(Function<T, R> mapper) {
        function = mapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> OptionalPredicateI<T, V> map(Function<R, V> mapper) {
        return new OptionalPredicateB<>(function.andThen(FunctionX.nullSafe(mapper)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V extends Comparable<V>> ComparableOptionalPredicateI<T, V> map(ComparableResultFunction<R, V> mapper) {
        return new ComparableOptionalPredicateB<>(function.andThen(FunctionX.nullSafe(mapper)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptionalPredicateResultI<T> check(Predicate<R> checker) {
        return new OptionalPredicateResultB<>(function, checker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<T> isNull() {
        return t -> function.apply(t) == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<T> nonNull() {
        return t -> function.apply(t) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptionalPredicateResultI<T> equal(R other) {
        return new OptionalPredicateResultB<>(function, r -> Objects.equals(r, other));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptionalPredicateResultI<T> less(R other, Comparator<R> comparator) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, comparator) < 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptionalPredicateResultI<T> greater(R other, Comparator<R> comparator) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, comparator) > 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptionalPredicateResultI<T> lessOrEqual(R other, Comparator<R> comparator) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, comparator) <= 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptionalPredicateResultI<T> greaterOrEqual(R other, Comparator<R> comparator) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, comparator) >= 0);
    }
}
