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

import io.github.alexengrig.lambdax.collection.SetX;
import io.github.alexengrig.lambdax.entity.Holder;
import io.github.alexengrig.lambdax.function.PredicateX;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetXPredicateXTest {
    protected Holder<Set<Integer>> holder;

    @Before
    public void before() {
        holder = new Holder<>(new HashSet<>());
    }

    @Test
    public void checkSetContains() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.contains(1)))
                .isPresent());
    }

    @Test
    public void checkSetContainsAll() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.containsAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkSetNotContains() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.notContains(1)))
                .isPresent());
    }

    @Test
    public void checkSetNotContainsAll() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.notContainsAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkSetAdd() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.add(1)))
                .isPresent());
    }

    @Test
    public void checkSetAddAll() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.addAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkSetRemove() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.remove(1)))
                .isPresent());
    }

    @Test
    public void checkSetRemoveAll() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.removeAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkSetRetainAll() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.removeAll(Collections.singleton(1))))
                .isPresent());
    }

    @Test
    public void checkSetEqualsTo() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.equalsTo(Collections.emptySet())))
                .isPresent());
    }

    @Test
    public void checkSetNotEqualsTo() {
        assertFalse(Optional.of(holder)
                .filter(PredicateX.of(Holder<Set<Integer>>::get)
                        .check(SetX.notEqualsTo(Collections.emptySet())))
                .isPresent());
    }
}
