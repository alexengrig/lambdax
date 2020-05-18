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
 * <p>Represents a function that accepts one argument and produces a comparable result.</p>
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the comparable result of the function
 * @author Grig Alex
 * @version 0.2.0
 * @see java.lang.Comparable
 * @see java.util.function.Function
 * @since 0.2.0
 */
@Deprecated
@FunctionalInterface
public interface ComparableResultFunction<T, R extends Comparable<R>> extends Function<T, R> {
}
