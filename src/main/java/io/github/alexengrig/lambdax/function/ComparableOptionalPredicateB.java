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

/* package */class ComparableOptionalPredicateB<T, R extends Comparable<R>> implements ComparableOptionalPredicateI<T, R> {
    protected final Function<T, R> function;

    /* package */ComparableOptionalPredicateB(Function<T, R> mapper) {
        function = mapper;
    }

    @Override
    public <V> OptionalPredicateI<T, V> map(Function<R, V> mapper) {
        return new OptionalPredicateB<>(function.andThen(FunctionX.nullSafe(mapper)));
    }

    @Override
    public <V extends Comparable<V>> ComparableOptionalPredicateI<T, V> map(ComparableResultFunction<R, V> mapper) {
        return new ComparableOptionalPredicateB<>(function.andThen(FunctionX.nullSafe(mapper)));
    }

    @Override
    public OptionalPredicateResultI<T> check(Predicate<R> checker) {
        return new OptionalPredicateResultB<>(function, checker);
    }

    @Override
    public OptionalPredicateResultI<T> less(R other) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, Comparator.naturalOrder()) < 0);
    }

    @Override
    public OptionalPredicateResultI<T> greater(R other) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, Comparator.naturalOrder()) > 0);
    }

    @Override
    public OptionalPredicateResultI<T> lessOrEqual(R other) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, Comparator.naturalOrder()) <= 0);
    }

    @Override
    public OptionalPredicateResultI<T> greaterOrEqual(R other) {
        return new OptionalPredicateResultB<>(function, r -> Objects.compare(r, other, Comparator.naturalOrder()) >= 0);
    }
}
