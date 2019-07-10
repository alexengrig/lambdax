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

package io.github.alexengrig.lambdax;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * This utility class contains useful lambdas for {@link Optional}
 *
 * @author Grig Alex
 * @see Optional
 * @see Consumer
 * @see UnaryOperator
 * @since 0.1.0
 */
public final class OptionalX {
    private OptionalX() {
    }

    public static <T> Optional<T> of(Supplier<? extends T> generator) {
        return Optional.ofNullable(generator.get());
    }

    public static <T> UnaryOperator<T> peek(Consumer<? super T> action) {
        return t -> {
            action.accept(t);
            return t;
        };
    }
}