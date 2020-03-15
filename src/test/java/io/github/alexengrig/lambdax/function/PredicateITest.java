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

import io.github.alexengrig.lambdax.entity.Box;
import io.github.alexengrig.lambdax.entity.Pack;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class PredicateITest {
    protected final PredicateI<Box, Pack> predicate = new PredicateI<Box, Pack>() {
        @Override
        public <V> PredicateI<Box, V> map(Function<Pack, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V extends Comparable<V>> ComparablePredicateI<Box, V> map(ComparableResultFunction<Pack, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V> OptionalPredicateI<Box, V> mapToNullable(Function<Pack, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public <V extends Comparable<V>> ComparableOptionalPredicateI<Box, V> mapToNullable(ComparableResultFunction<Pack, V> mapper) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Predicate<Box> check(Predicate<Pack> checker) {
            return t -> true;
        }
    };

    @Test
    public void checkIsNull() {
        assertTrue(predicate.isNull().test(null));
    }

    @Test
    public void checkNonNull() {
        assertTrue(predicate.nonNull().test(null));
    }

    @Test
    public void checkEqual() {
        assertTrue(predicate.equal(new Pack(null)).test(null));
    }

    @Test
    public void checkLess() {
        assertTrue(predicate.less(null, null).test(null));
    }

    @Test
    public void checkGreater() {
        assertTrue(predicate.greater(null, null).test(null));
    }

    @Test
    public void checkLessOrEqual() {
        assertTrue(predicate.lessOrEqual(null, null).test(null));
    }

    @Test
    public void checkGreaterOrEqual() {
        assertTrue(predicate.greaterOrEqual(null, null).test(null));
    }
}