/*
 * Copyright 2019 Alexengrig Dev.
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

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * This utility class contains useful lambdas for {@link java.util.Optional}.
 *
 * @author Grig Alex
 * @version 0.1.1
 * @see java.util.Optional
 * @see java.util.function.Consumer
 * @see java.util.function.Supplier
 * @see java.util.function.UnaryOperator
 * @since 0.1.0
 */
public final class OptionalX {
    private OptionalX() {
    }

    /**
     * <p>Returns an {@link java.util.Optional} describing the given value
     * from {@link java.util.function.Supplier}.</p>
     *
     * @param generator a {@link java.util.function.Supplier} of value
     *                  the result of which is passed as the argument to {@link java.util.Optional#ofNullable(Object)}
     * @param <T>       a type of {@link java.util.Optional} value
     * @return an {@link java.util.Optional} with the given value from {@link java.util.function.Supplier}
     * @see java.util.Optional#ofNullable(Object)
     * @see java.util.Optional
     * @see java.util.Optional#ofNullable(Object)
     * @see java.util.Optional
     * @see java.util.function.Supplier
     * @since 0.1.0
     */
    public static <T> Optional<T> of(Supplier<? extends T> generator) {
        return Optional.ofNullable(generator.get());
    }

    /**
     * <p>Returns an {@link java.util.function.UnaryOperator}
     * that execute the action ({@link java.util.function.Consumer}) for a value and return it.</p>
     *
     * @param action a {@link java.util.function.Consumer} that execute an action on a value
     * @param <T>    a type of the operand and result of the operator
     * @return an {@link java.util.function.UnaryOperator}
     * @see java.util.Optional#map(java.util.function.Function)
     * @see java.util.function.UnaryOperator
     * @see java.util.function.Consumer
     * @see java.util.stream.Stream#peek(Consumer)
     * @since 0.1.0
     */
    public static <T> UnaryOperator<T> peek(Consumer<? super T> action) {
        return t -> {
            action.accept(t);
            return t;
        };
    }
}
