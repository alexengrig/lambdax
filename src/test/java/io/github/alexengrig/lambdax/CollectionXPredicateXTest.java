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

import io.github.alexengrig.lambdax.collection.CollectionX;
import io.github.alexengrig.lambdax.entity.Holder;
import io.github.alexengrig.lambdax.function.PredicateX;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionXPredicateXTest {
    protected Holder<Collection<Integer>> holder;

    @Before
    public void before() {
        holder = new Holder<>(new ArrayList<>());
    }

    @Test
    public void checkCollectionContains() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.contains(1)))
                .isPresent());
    }

    @Test
    public void checkCollectionContainsAll() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.containsAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkCollectionNotContains() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.notContains(1)))
                .isPresent());
    }

    @Test
    public void checkCollectionNotContainsAll() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.notContainsAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkCollectionAdd() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.add(1)))
                .isPresent());
    }

    @Test
    public void checkCollectionAddAll() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.addAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkCollectionRemove() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.remove(1)))
                .isPresent());
    }

    @Test
    public void checkCollectionRemoveAll() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.removeAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkCollectionRetainAll() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.retainAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkCollectionEqualsTo() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.equalsTo(Collections.emptyList())))
                .isPresent());
    }

    @Test
    public void checkCollectionNotEqualsTo() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Collection<Integer>>::get)
                        .check(CollectionX.notEqualsTo(Collections.emptyList())))
                .isPresent());
    }
}
