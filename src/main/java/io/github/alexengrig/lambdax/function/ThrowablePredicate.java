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

import java.util.Objects;

public interface ThrowablePredicate<T, X extends Throwable> {
    static <T, X extends Throwable> ThrowablePredicate<T, X> isEqual(Object o) {
        return o == null ? Objects::isNull : o::equals;
    }

    boolean test(T t) throws X;

    default ThrowablePredicate<T, X> and(ThrowablePredicate<? super T, ? extends X> other) {
        return t -> test(t) && other.test(t);
    }

    default ThrowablePredicate<T, X> negate() {
        return t -> !test(t);
    }

    default ThrowablePredicate<T, X> or(ThrowablePredicate<? super T, ? extends X> other) {
        return t -> test(t) || other.test(t);
    }
}
