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

import io.github.alexengrig.lambdax.function.FunctionX;
import io.github.alexengrig.lambdax.function.PredicateX;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A safe predicate container which may manipulate its value.
 *
 * @param <T> the type of predicate value
 * @author Grig Alex
 * @version 0.6.0
 * @since 0.6.0
 */
public class SafePredicateChainX<T, R> {
    protected final Function<T, R> function;

    protected SafePredicateChainX(Function<T, R> function) {
        this.function = function;
    }

//    Create

    public static <T, R> SafePredicateChainX<T, R> of(Function<T, R> function) {
        return new SafePredicateChainX<>(Objects.requireNonNull(function, "The function must not be null"));
    }

//    Flow

    public <V> SafePredicateChainX<T, V> map(Function<? super R, ? extends V> mapper) {
        return of(function.andThen(FunctionX.nullSafe(mapper)));
    }

//    Predicate

    public PredicateX<T> isNull() {
        return t -> null == function.apply(t);
    }

    public PredicateX<T> nonNull() {
        return t -> null != function.apply(t);
    }

//    Result

    public Result check(Predicate<? super R> checker) {
        return new Result(checker::test);
    }

    public Result equal(R other) {
        return new Result(r -> Objects.equals(r, other));
    }

    @SuppressWarnings("unchecked")
    public Result less(R other) {
        return less(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public Result less(R other, Comparator<? super R> comparator) {
        return new Result(r -> 0 > Objects.compare(r, other, comparator));
    }

    @SuppressWarnings("unchecked")
    public Result greater(R other) {
        return greater(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public Result greater(R other, Comparator<? super R> comparator) {
        return new Result(r -> 0 < Objects.compare(r, other, comparator));
    }

    @SuppressWarnings("unchecked")
    public Result lessOrEqual(R other) {
        return lessOrEqual(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public Result lessOrEqual(R other, Comparator<? super R> comparator) {
        return new Result(r -> 0 >= Objects.compare(r, other, comparator));
    }

    @SuppressWarnings("unchecked")
    public Result greaterOrEqual(R other) {
        return greaterOrEqual(other, (Comparator<R>) Comparator.naturalOrder());
    }

    public Result greaterOrEqual(R other, Comparator<? super R> comparator) {
        return new Result(r -> 0 <= Objects.compare(r, other, comparator));
    }

    public class Result {
        protected final Predicate<R> predicate;

        public Result(Predicate<R> predicate) {
            this.predicate = predicate;
        }

        public Predicate<T> orElse(Predicate<? super T> checker) {
            return t -> {
                R value = function.apply(t);
                if (value != null) {
                    return predicate.test(value);
                }
                return checker.test(t);
            };
        }

        public Predicate<T> orElse(boolean check) {
            return t -> {
                R value = function.apply(t);
                if (value != null) {
                    return predicate.test(value);
                }
                return check;
            };
        }

        public Predicate<T> orElse(Supplier<? extends Boolean> producer) {
            return t -> {
                R value = function.apply(t);
                if (value != null) {
                    return predicate.test(value);
                }
                return producer.get();
            };
        }

        public Predicate<T> orTruth() {
            return t -> {
                R value = function.apply(t);
                if (value != null) {
                    return predicate.test(value);
                }
                return true;
            };
        }

        public Predicate<T> orLie() {
            return t -> {
                R value = function.apply(t);
                if (value != null) {
                    return predicate.test(value);
                }
                return false;
            };
        }
    }
}
