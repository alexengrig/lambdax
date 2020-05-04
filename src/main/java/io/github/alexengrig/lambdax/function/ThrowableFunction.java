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

@FunctionalInterface
public interface ThrowableFunction<T, R, X extends Throwable> {
    static <T, X extends Throwable> ThrowableFunction<T, T, X> identity() {
        return t -> t;
    }

    R apply(T t) throws X;

    default <V> ThrowableFunction<V, R, X> compose(ThrowableFunction<? super V, ? extends T, ? extends X> before) {
        return v -> apply(before.apply(v));
    }

    default <V> ThrowableFunction<T, V, X> andThen(ThrowableFunction<? super R, ? extends V, ? extends X> after) {
        return t -> after.apply(apply(t));
    }
}
