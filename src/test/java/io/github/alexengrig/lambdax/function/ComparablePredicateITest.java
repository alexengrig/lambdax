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

import io.github.alexengrig.lambdax.entity.Item;
import io.github.alexengrig.lambdax.entity.Pack;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class ComparablePredicateITest {
    protected final ComparablePredicateI<Pack, Item> predicate = new ComparablePredicateI<Pack, Item>() {
        @Override
        public <V> PredicateI<Pack, V> map(Function<Item, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V extends Comparable<V>> ComparablePredicateI<Pack, V> map(ComparableResultFunction<Item, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V> OptionalPredicateI<Pack, V> mapToNullable(Function<Item, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V extends Comparable<V>> ComparableOptionalPredicateI<Pack, V> mapToNullable(ComparableResultFunction<Item, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Predicate<Pack> check(Predicate<Item> checker) {
            return t -> true;
        }
    };

    @Test
    public void checkLess() {
        assertTrue(predicate
                .less(new Item(null))
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkGreater() {
        assertTrue(predicate
                .greater(new Item(null))
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkLessOrEqual() {
        assertTrue(predicate
                .lessOrEqual(new Item(null))
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkGreaterOrEqual() {
        assertTrue(predicate
                .greaterOrEqual(new Item(null))
                .test(new Pack(new Item(null))));
    }
}