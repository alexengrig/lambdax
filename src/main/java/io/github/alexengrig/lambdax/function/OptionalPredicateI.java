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

package io.github.alexengrig.lambdax.function;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * TODO: Add JavaDoc
 */
public interface OptionalPredicateI<T, R> {
  /**
   * TODO: Add JavaDoc
   */
  <V> OptionalPredicateI<T, V> map(Function<R, V> mapper);

  /**
   * TODO: Add JavaDoc
   */
  <V extends Comparable<V>> ComparableOptionalPredicateI<T, V>
  map(ComparableResultFunction<R, V> mapper);

  /**
   * TODO: Add JavaDoc
   */
  ResultI<T> check(Predicate<R> checker);

  /**
   * TODO: Add JavaDoc
   */
  default Predicate<T> isNull() { return check(Objects::isNull).orTruth(); }

  /**
   * TODO: Add JavaDoc
   */
  default Predicate<T> nonNull() { return check(Objects::nonNull).orLie(); }

  /**
   * TODO: Add JavaDoc
   */
  default ResultI<T> equal(R other) { return check(other::equals); }

  /**
   * TODO: Add JavaDoc
   */
  default ResultI<T> less(R other, Comparator<R> comparator) {
    return check(r -> comparator.compare(r, other) < 0);
  }

  /**
   * TODO: Add JavaDoc
   */
  default ResultI<T> greater(R other, Comparator<R> comparator) {
    return check(r -> comparator.compare(r, other) > 0);
  }

  /**
   * TODO: Add JavaDoc
   */
  default ResultI<T> lessOrEqual(R other, Comparator<R> comparator) {
    return check(r -> comparator.compare(r, other) <= 0);
  }

  /**
   * TODO: Add JavaDoc
   */
  default ResultI<T> greaterOrEqual(R other, Comparator<R> comparator) {
    return check(r -> comparator.compare(r, other) >= 0);
  }

  /**
   * TODO: Add JavaDoc
   */
  interface ResultI<T> {
    /**
     * TODO: Add JavaDoc
     */
    Predicate<T> orElse(Predicate<T> checker);

    /**
     * TODO: Add JavaDoc
     */
    default Predicate<T> orElse(boolean check) { return orElse(t -> check); }

    /**
     * TODO: Add JavaDoc
     */
    default Predicate<T> orTruth() { return orElse(PredicateX.truth()); }

    /**
     * TODO: Add JavaDoc
     */
    default Predicate<T> orLie() { return orElse(PredicateX.lie()); }
  }
}
