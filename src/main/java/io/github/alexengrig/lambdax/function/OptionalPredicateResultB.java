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
 * {@inheritDoc}
 *
 * @author Grig Alex
 * @version 0.3.0
 * @see io.github.alexengrig.lambdax.function.OptionalPredicateResultI
 * @since 0.3.0
 */
@Deprecated
/* package */class OptionalPredicateResultB<T, V> implements OptionalPredicateResultI<T> {
    /**
     * @since 0.3.0
     */
    protected final Function<T, V> function;

    /**
     * @since 0.3.0
     */
    protected final Predicate<V> predicate;

    /**
     * @since 0.3.0
     */
    /* package */OptionalPredicateResultB(Function<T, V> function, Predicate<V> predicate) {
        this.function = function;
        this.predicate = predicate;
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
     * {@inheritDoc}
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
