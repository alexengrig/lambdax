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

import io.github.alexengrig.lambdax.collection.QueueX;
import io.github.alexengrig.lambdax.entity.Holder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class QueueXPredicateXTest {
    protected Holder<Queue<Integer>> holder;

    @Before
    public void before() {
        holder = new Holder<>(new ArrayDeque<>());
    }

    @Test
    public void checkQueueAdd() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.chain(Holder<Queue<Integer>>::get)
                        .check(QueueX.add(1)))
                .isPresent());
    }

    @Test
    public void checkQueueOffer() {
        assertTrue(Optional.of(holder)
                .filter(PredicateX.chain(Holder<Queue<Integer>>::get)
                        .check(QueueX.offer(1)))
                .isPresent());
    }
}
