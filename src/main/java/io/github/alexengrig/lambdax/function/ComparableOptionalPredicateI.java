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

import java.util.Comparator;

/**
 * TODO: Add JavaDoc
 */
public interface ComparableOptionalPredicateI<T, R extends Comparable<R>>
    extends OptionalPredicateI<T, R> {
  /**
   * TODO: Add JavaDoc
   */
  default OptionalPredicateResultI<T> less(R other) {
    return less(other, Comparator.comparing(other::compareTo).reversed());
  }

  /**
   * TODO: Add JavaDoc
   */
  default OptionalPredicateResultI<T> greater(R other) {
    return greater(other, Comparator.comparing(other::compareTo).reversed());
  }

  /**
   * TODO: Add JavaDoc
   */
  default OptionalPredicateResultI<T> lessOrEqual(R other) {
    return lessOrEqual(other,
                       Comparator.comparing(other::compareTo).reversed());
  }

  /**
   * TODO: Add JavaDoc
   */
  default OptionalPredicateResultI<T> greaterOrEqual(R other) {
    return greaterOrEqual(other,
                          Comparator.comparing(other::compareTo).reversed());
  }
}
