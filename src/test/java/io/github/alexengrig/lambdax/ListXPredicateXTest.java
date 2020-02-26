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

package io.github.alexengrig.lambdax;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.github.alexengrig.lambdax.collection.ListX;
import io.github.alexengrig.lambdax.entity.Holder;
import io.github.alexengrig.lambdax.function.PredicateX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class ListXPredicateXTest {
  protected Holder<List<Integer>> holder;

  @Before
  public void before() {
    holder = new Holder<>(new ArrayList<>());
  }

  @Test
  public void checkListContains() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                                .check(ListX.contains(1)))
                    .isPresent());
  }

  @Test
  public void checkListContainsAll() {
    assertFalse(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.containsAll(Collections.singleton(1))))
            .isPresent());
  }

  @Test
  public void checkListNotContains() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                               .check(ListX.notContains(1)))
                   .isPresent());
  }

  @Test
  public void checkListNotContainsAll() {
    assertTrue(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.notContainsAll(Collections.singleton(1))))
            .isPresent());
  }

  @Test
  public void checkListAdd() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                               .check(ListX.add(1)))
                   .isPresent());
  }

  @Test
  public void checkListAddAll() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                               .check(ListX.addAll(Collections.singleton(1))))
                   .isPresent());
  }

  @Test
  public void checkListAddAllWithIndex() {
    assertTrue(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.addAll(0, Collections.singleton(1))))
            .isPresent());
  }

  @Test
  public void checkListRemove() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                                .check(ListX.remove(1)))
                    .isPresent());
  }

  @Test
  public void checkListRemoveAll() {
    assertFalse(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.removeAll(Collections.singleton(1))))
            .isPresent());
  }

  @Test
  public void checkListRetainAll() {
    assertFalse(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.retainAll(Collections.singleton(1))))
            .isPresent());
  }

  @Test
  public void checkListEqualsTo() {
    assertFalse(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.equalsTo(Collections.singleton(1))))
            .isPresent());
  }

  @Test
  public void checkListNotEqualsTo() {
    assertTrue(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<List<Integer>>::getValue)
                        .check(ListX.notEqualsTo(Collections.singleton(1))))
            .isPresent());
  }
}
