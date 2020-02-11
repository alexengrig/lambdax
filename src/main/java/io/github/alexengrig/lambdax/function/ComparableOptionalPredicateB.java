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
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * TODO: Add JavaDoc
 */
/* package */class ComparableOptionalPredicateB<T, R extends Comparable<R>> implements ComparableOptionalPredicateI<T, R> {
    /**
     * TODO: Add JavaDoc
     */
    protected final Function<T, R> function;

    /**
     * TODO: Add JavaDoc
     */
    /* package */ComparableOptionalPredicateB(Function<T, R> mapper) {
        function = mapper;
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public <V> OptionalPredicateI<T, V> map(Function<R, V> mapper) {
        return new OptionalPredicateB<>(function.andThen(mapper));
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public <V extends Comparable<V>> ComparableOptionalPredicateI<T, V> map(ComparableResultFunction<R, V> mapper) {
        return new ComparableOptionalPredicateB<>(function.andThen(mapper));
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public Predicate<T> isNull() {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public Predicate<T> nonNull() {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public ResultI<T> check(Predicate<R> checker) {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public ResultI<T> equal(R other) {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public ResultI<T> less(R other, Comparator<R> comparator) {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public ResultI<T> greater(R other, Comparator<R> comparator) {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public ResultI<T> lessOrEqual(R other, Comparator<R> comparator) {
        return null; //TODO: Add implementation
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public ResultI<T> greaterOrEqual(R other, Comparator<R> comparator) {
        return null; //TODO: Add implementation
    }
}
