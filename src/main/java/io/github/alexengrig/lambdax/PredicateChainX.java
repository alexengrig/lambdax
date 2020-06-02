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

package io.github.alexengrig.lambdax;

import io.github.alexengrig.lambdax.function.PredicateX;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateChainX<T, R> {
    protected final Function<T, R> function;

    protected PredicateChainX(Function<T, R> function) {
        this.function = function;
    }

//    Create

    public static <T, R> PredicateChainX<T, R> of(Function<T, R> function) {
        return new PredicateChainX<>(Objects.requireNonNull(function, "The function must not be null"));
    }

//    Flow

    public <V> PredicateChainX<T, V> map(Function<? super R, ? extends V> mapper) {
        return of(function.andThen(mapper));
    }

    public <V> SafePredicateChainX<T, V> mapToSafe(Function<? super R, ? extends V> mapper) {
        return SafePredicateChainX.of(function.andThen(mapper));
    }

//    Predicate

    public PredicateX<T> isNull() {
        return t -> null == function.apply(t);
    }

    public PredicateX<T> nonNull() {
        return t -> null != function.apply(t);
    }

    public PredicateX<T> check(Predicate<? super R> checker) {
        return t -> checker.test(function.apply(t));
    }

    public PredicateX<T> equal(R other) {
        return t -> Objects.equals(function.apply(t), other);
    }

    @SuppressWarnings("unchecked")
    public PredicateX<T> less(R other) {
        return less(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public PredicateX<T> less(R other, Comparator<? super R> comparator) {
        return t -> 0 > Objects.compare(function.apply(t), other, comparator);
    }

    @SuppressWarnings("unchecked")
    public PredicateX<T> greater(R other) {
        return greater(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public PredicateX<T> greater(R other, Comparator<? super R> comparator) {
        return t -> 0 < Objects.compare(function.apply(t), other, comparator);
    }

    @SuppressWarnings("unchecked")
    public PredicateX<T> lessOrEqual(R other) {
        return lessOrEqual(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public PredicateX<T> lessOrEqual(R other, Comparator<? super R> comparator) {
        return t -> 0 >= Objects.compare(function.apply(t), other, comparator);
    }

    @SuppressWarnings("unchecked")
    public PredicateX<T> greaterOrEqual(R other) {
        return greaterOrEqual(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public PredicateX<T> greaterOrEqual(R other, Comparator<? super R> comparator) {
        return t -> 0 <= Objects.compare(function.apply(t), other, comparator);
    }
}
