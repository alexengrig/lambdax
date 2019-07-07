/*
 * Copyright 2019 LambdaX contributors
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

package io.github.alexengrig.lambdax.collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class QueueXTest {
    @Test
    public void checkAdd() {
        int value = 1;
        Queue<Number> numbers = new ArrayDeque<>();
        Predicate<Queue<? super Number>> addValue = QueueX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 2;
        Queue<Number> numbers = new ArrayDeque<>();
        Consumer<Queue<? super Number>> onlyAddValue = QueueX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOffer() {
        int value = 3;
        Queue<Number> numbers = new ArrayDeque<>();
        Predicate<Queue<? super Number>> offerValue = QueueX.offer(value);
        assertTrue(offerValue.test(numbers));
    }

    @Test
    public void checkOnlyOffer() {
        int value = 4;
        Queue<Number> numbers = new ArrayDeque<>();
        Consumer<Queue<? super Number>> onlyOfferValue = QueueX.onlyOffer(value);
        onlyOfferValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }
}