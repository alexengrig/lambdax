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
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>The base implementation of the {@link
 * io.github.alexengrig.lambdax.function.PredicateI} interface.</p>
 *
 * @param <T> the type of the input to the predicate
 * @param <R> the type of the mapper result
 * @author Grig Alex
 * @version 0.2.0
 * @see java.util.Comparator
 * @see java.util.Objects
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see io.github.alexengrig.lambdax.function.PredicateI
 * @since 0.2.0
 */
/* package */ class PredicateB<T, R> implements PredicateI<T, R> {
  /**
   * <p>The mapper of the input to the predicate.</p>
   *
   * @see java.util.function.Function
   * @since 0.2.0
   */
  protected final Function<T, R> function;

  /**
   * <p>The constructor with the mapper.</p>
   *
   * @param mapper a function for map the predicate input
   * @see java.util.function.Function
   * @since 0.2.0
   */
  /* package */ PredicateB(Function<T, R> mapper) { function = mapper; }

  /**
   * <p>
   * Returns the {@link io.github.alexengrig.lambdax.function.PredicateB} with
   * the new mapper for the input to the predicate.
   * </p>
   *
   * @param mapper a function of map the input
   * @param <V>    a new type of the mapper result
   * @return The {@link io.github.alexengrig.lambdax.function.PredicateI} with
   * the new mapper
   * @see io.github.alexengrig.lambdax.function.PredicateI
   * @see java.util.function.Function
   * @see io.github.alexengrig.lambdax.function.PredicateB
   * @see java.util.function.Function#andThen(Function)
   * @since 0.2.0
   */
  @Override
  public <V> PredicateI<T, V> map(Function<R, V> mapper) {
    return new PredicateB<>(function.andThen(mapper));
  }

  /**
   * <p>
   * Returns the {@link
   * io.github.alexengrig.lambdax.function.ComparablePredicateB} with the new
   * mapper with comparable result for the input to the predicate.
   * </p>
   *
   * @param mapper a function of map the input to the comparable result
   * @param <V>    a new comparable type of the mapper result
   * @return The {@link
   * io.github.alexengrig.lambdax.function.ComparablePredicateI} with the
   * new mapper
   * @see java.lang.Comparable
   * @see io.github.alexengrig.lambdax.function.ComparablePredicateI
   * @see io.github.alexengrig.lambdax.function.ComparableResultFunction
   * @see io.github.alexengrig.lambdax.function.ComparablePredicateB
   * @see java.util.function.Function#andThen(Function)
   * @since 0.2.0
   */
  @Override
  public <V extends Comparable<V>> ComparablePredicateI<T, V>
  map(ComparableResultFunction<R, V> mapper) {
    return new ComparablePredicateB<>(function.andThen(mapper));
  }

  /**
   * TODO: Add JavaDoc
   */
  @Override
  public <V> OptionalPredicateI<T, V> mapToNullable(Function<R, V> mapper) {
    return new OptionalPredicateB<>(function.andThen(mapper));
  }

  /**
   * TODO: Add JavaDoc
   */
  @Override
  public <V extends Comparable<V>> ComparableOptionalPredicateI<T, V>
  mapToNullable(ComparableResultFunction<R, V> mapper) {
    return new ComparableOptionalPredicateB<>(function.andThen(mapper));
  }

  /**
   * <p>
   * Returns the {@link java.util.function.Predicate} that checks the mapper
   * result is {@code null}.
   * </p>
   *
   * @return The {@link java.util.function.Predicate} with compare
   * @see java.util.function.Predicate
   * @see java.util.Objects#isNull(Object)
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.0
   */
  @Override
  public Predicate<T> isNull() {
    return t -> Objects.isNull(function.apply(t));
  }

  /**
   * <p>
   * Returns the {@link java.util.function.Predicate} that checks the mapper
   * result is not {@code null}.
   * </p>
   *
   * @return The {@link java.util.function.Predicate} with compare
   * @see java.util.function.Predicate
   * @see java.util.Objects#nonNull(Object)
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.0
   */
  @Override
  public Predicate<T> nonNull() {
    return t -> Objects.nonNull(function.apply(t));
  }

  /**
   * <p>
   * Returns the {@link java.util.function.Predicate} that checks the mapper
   * result via the checker.
   * </p>
   *
   * @param checker a predicate for check the mapper result
   * @return The {@link java.util.function.Predicate} with compare
   * @see java.util.function.Predicate
   * @see java.util.function.Predicate#test(Object)
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.0
   */
  @Override
  public Predicate<T> check(Predicate<R> checker) {
    return t -> checker.test(function.apply(t));
  }

  /**
   * <p>
   * Returns the {@link java.util.function.Predicate} that checks if the input
   * object is equals to the other object.
   * </p>
   *
   * @param other an object for compare
   * @return The {@link java.util.function.Predicate} with compare
   * @see java.util.function.Predicate
   * @see java.util.Objects#equals(Object, Object)
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.0
   */
  @Override
  public Predicate<T> equal(R other) {
    return t -> Objects.equals(function.apply(t), other);
  }

  /**
   * <p>
   * Returns the {@link java.util.function.Predicate} that checks if the input
   * object is less than the other object via the comparator.
   * </p>
   *
   * @param other      an object for compare
   * @param comparator a comparison function for compare the input object with
   *                   the other object
   * @return The {@link java.util.function.Predicate} with compare
   * @see java.util.function.Predicate
   * @see java.util.Comparator
   * @see java.util.Comparator#compare(Object, Object)
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.0
   */
  @Override
  public Predicate<T> less(R other, Comparator<R> comparator) {
    return t -> comparator.compare(function.apply(t), other) < 0;
  }

  /**
   * <p>
   * Returns the {@link java.util.function.Predicate} that checks if the input
   * object is greater than the other object via the comparator.
   * </p>
   *
   * @param other      an object for compare
   * @param comparator a comparison function for compare the input object with
   *                   the other object
   * @return The {@link java.util.function.Predicate} with compare
   * @see java.util.function.Predicate
   * @see java.util.Comparator
   * @see java.util.Comparator#compare(Object, Object)
   * @see java.util.function.Function#apply(Object)
   * @since 0.2.0
   */
  @Override
  public Predicate<T> greater(R other, Comparator<R> comparator) {
    return t -> comparator.compare(function.apply(t), other) > 0;
  }
}
