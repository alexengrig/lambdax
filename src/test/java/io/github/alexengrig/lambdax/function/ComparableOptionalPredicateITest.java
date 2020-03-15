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

import static org.junit.Assert.assertFalse;

public class ComparableOptionalPredicateITest {
    protected final ComparableOptionalPredicateI<Pack, Item> predicate = new ComparableOptionalPredicateI<Pack, Item>() {
        @Override
        public <V> OptionalPredicateI<Pack, V> map(Function<Item, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V extends Comparable<V>> ComparableOptionalPredicateI<Pack, V> map(ComparableResultFunction<Item, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public OptionalPredicateResultI<Pack> check(Predicate<Item> checker) {
            return otherChecker -> otherChecker;
        }
    };

    @Test
    public void checkLess() {
        assertFalse(predicate
                .less(new Item(null))
                .orLie()
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkGreater() {
        assertFalse(predicate
                .greater(new Item(null))
                .orLie()
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkLessOrEqual() {
        assertFalse(predicate
                .lessOrEqual(new Item(null))
                .orLie()
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkGreaterOrEqual() {
        assertFalse(predicate
                .greaterOrEqual(new Item(null))
                .orLie()
                .test(new Pack(new Item(null))));
    }
}