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

/**
 * Represents a function that accepts three arguments and produces a result.
 * This is the three-arity specialization of Function.
 * This is a functional interface whose functional method is apply(Object, Object, Object).
 *
 * @author Grig Alex
 * @version 0.4.0
 * @see java.util.function.Function
 * @since 0.4.0
 */
@FunctionalInterface
public interface TerFunction<T, U, S, R> {
    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @param s the third function argument
     * @return the function result
     * @since 0.4.0
     */
    R apply(T t, U u, S s);

    /**
     * Returns a composed function that first applies this function to its input,
     * and then applies the after function to the result.
     * If evaluation of either function throws an exception,
     * it is relayed to the caller of the composed function.
     *
     * @param after the function to apply after this function is applied
     * @param <V>   the type of output of the after function, and of the composed function
     * @return a composed function that first applies this function and then applies the after function
     * @since 0.4.0
     */
    default <V> TerFunction<T, U, S, V> andThen(Function<? super R, ? extends V> after) {
        return (t, u, s) -> after.apply(apply(t, u, s));
    }
}
