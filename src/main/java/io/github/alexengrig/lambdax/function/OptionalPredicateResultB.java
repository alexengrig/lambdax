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

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * TODO: Add JavaDoc
 */
/* package */class OptionalPredicateResultB<T, V> implements OptionalPredicateResultI<T> {
    /**
     * TODO: Add JavaDoc
     */
    protected final Function<T, V> function;

    /**
     * TODO: Add JavaDoc
     */
    protected final Predicate<V> predicate;

    /**
     * TODO: Add JavaDoc
     */
    /* package */OptionalPredicateResultB(Function<T, V> function, Predicate<V> predicate) {
        this.function = function;
        this.predicate = predicate;
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public Predicate<T> orElse(Predicate<T> checker) {
        return t -> {
            V value = function.apply(t);
            if (value != null) {
                return predicate.test(value);
            } else {
                return checker.test(t);
            }
        };
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public Predicate<T> orElse(boolean check) {
        return t -> {
            V value = function.apply(t);
            if (value != null) {
                return predicate.test(value);
            } else {
                return check;
            }
        };
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public Predicate<T> orTruth() {
        return t -> {
            V value = function.apply(t);
            if (value != null) {
                return predicate.test(value);
            } else {
                return true;
            }
        };
    }

    /**
     * TODO: Add JavaDoc
     */
    @Override
    public Predicate<T> orLie() {
        return t -> {
            V value = function.apply(t);
            if (value != null) {
                return predicate.test(value);
            } else {
                return false;
            }
        };
    }
}
