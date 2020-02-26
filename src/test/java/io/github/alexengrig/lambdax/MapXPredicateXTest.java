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

import io.github.alexengrig.lambdax.collection.MapX;
import io.github.alexengrig.lambdax.entity.Holder;
import io.github.alexengrig.lambdax.function.PredicateX;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class MapXPredicateXTest {
  protected Holder<Map<Integer, Integer>> holder;

  @Before
  public void before() {
    holder = new Holder<>(new HashMap<>());
  }

  @Test
  public void checkMapContainsKey() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<Map<Integer, Integer>>::get)
                                .check(MapX.containsKey(1)))
                    .isPresent());
  }

  @Test
  public void checkMapNotContainsKey() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Map<Integer, Integer>>::get)
                               .check(MapX.notContainsKey(1)))
                   .isPresent());
  }

  @Test
  public void checkMapContainsValue() {
    assertFalse(Optional.of(holder)
                    .filter(PredicateX.of(Holder<Map<Integer, Integer>>::get)
                                .check(MapX.containsValue(1)))
                    .isPresent());
  }

  @Test
  public void checkMapNotContainsValue() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Map<Integer, Integer>>::get)
                               .check(MapX.notContainsValue(1)))
                   .isPresent());
  }

  @Test
  public void checkMapEqualsTo() {
    assertTrue(Optional.of(holder)
                   .filter(PredicateX.of(Holder<Map<Integer, Integer>>::get)
                               .check(MapX.equalsTo(Collections.emptyMap())))
                   .isPresent());
  }

  @Test
  public void checkMapNotEqualsTo() {
    assertFalse(
        Optional.of(holder)
            .filter(PredicateX.of(Holder<Map<Integer, Integer>>::get)
                        .check(MapX.notEqualsTo(Collections.emptyMap())))
            .isPresent());
  }
}
