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

import io.github.alexengrig.lambdax.OptionalX;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Optional;
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
    public void checkAddOptional() {
        double value = 1.1;
        Queue<Number> numbers = new ArrayDeque<>();
        Queue<Number> actual = Optional.of(numbers)
                .filter(QueueX.add(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
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
    public void checkOnlyAddOptional() {
        double value = 2.1;
        Queue<Number> numbers = new ArrayDeque<>();
        Queue<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(QueueX.onlyAdd(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOffer() {
        int value = 3;
        Queue<Number> numbers = new ArrayDeque<>();
        Predicate<Queue<? super Number>> offerValue = QueueX.offer(value);
        assertTrue(offerValue.test(numbers));
    }

    @Test
    public void checkOfferOptional() {
        double value = 3.1;
        Queue<Number> numbers = new ArrayDeque<>();
        Queue<Number> actual = Optional.of(numbers)
                .filter(QueueX.offer(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyOffer() {
        int value = 4;
        Queue<Number> numbers = new ArrayDeque<>();
        Consumer<Queue<? super Number>> onlyOfferValue = QueueX.onlyOffer(value);
        onlyOfferValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyOfferOptional() {
        double value = 4.1;
        Queue<Number> numbers = new ArrayDeque<>();
        Queue<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(QueueX.onlyOffer(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }
}