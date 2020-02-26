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

import io.github.alexengrig.lambdax.collection.DequeX;
import io.github.alexengrig.lambdax.entity.Holder;
import io.github.alexengrig.lambdax.function.PredicateX;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class DequeXPredicateXTest {
  protected Holder<Deque<Integer>> holder;

  @Before
  public void before() {
    holder = new Holder<>(new ArrayDeque<>());
  }

  @Test
  public void checkDequeContains() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                                .check(DequeX.contains(1)))
                    .isPresent());
  }

  @Test
  public void checkDequeNotContains() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                               .check(DequeX.notContains(1)))
                   .isPresent());
  }

  @Test
  public void checkDequeAdd() {
    assertTrue(
        Optional.of(holder)
            .filter(
                PredicateX.of(Holder<Deque<Integer>>::get).check(DequeX.add(1)))
            .isPresent());
  }

  @Test
  public void checkDequeOffer() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                               .check(DequeX.offer(1)))
                   .isPresent());
  }

  @Test
  public void checkDequeOfferFirst() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                               .check(DequeX.offerFirst(1)))
                   .isPresent());
  }

  @Test
  public void checkDequeOfferLast() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                               .check(DequeX.offerLast(1)))
                   .isPresent());
  }

  @Test
  public void checkDequeRemove() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                                .check(DequeX.remove(1)))
                    .isPresent());
  }

  @Test
  public void checkDequeRemoveFirstOccurrence() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                                .check(DequeX.removeFirstOccurrence(1)))
                    .isPresent());
  }

  @Test
  public void checkDequeRemoveLastOccurrence() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<Deque<Integer>>::get)
                                .check(DequeX.removeLastOccurrence(1)))
                    .isPresent());
  }
}
