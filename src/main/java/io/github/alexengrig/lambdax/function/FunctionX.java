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
 * <p>This utility class contains useful lambdas for {@link
 * java.util.function.Function}.</p>
 *
 * @author Grig Alex
 * @version 0.2.1
 * @see java.util.function.Function
 * @since 0.2.1
 */
public class FunctionX {
  /**
   * <p>The private constructor.</p>
   *
   * @since 0.2.1
   */
  private FunctionX() {}

  /**
   * <p>Returns the {@link java.util.function.Function} that is if the input
   * value is null then returns null, otherwise returns the result of the input
   * function.</p>
   *
   * @param <T>      the type of the input to the function
   * @param <R>      the type of the result of the function
   * @param function the function to apply the input value
   * @return The {@link java.util.function.Function} with the null safety input
   * value
   * @see java.util.function.Function
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.1
   */
  public static <T, R> Function<T, R>
  nullSafe(Function<? super T, ? extends R> function) {
    return t -> t == null ? null : function.apply(t);
  }
}
