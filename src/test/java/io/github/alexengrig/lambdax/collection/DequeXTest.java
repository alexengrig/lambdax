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

package io.github.alexengrig.lambdax.collection;

import io.github.alexengrig.lambdax.OptionalX;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class DequeXTest {
    @Test
    public void checkContains() {
        int value = 1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<Number>> containsValue = DequeX.contains(value);
        assertTrue(containsValue.test(numbers));
    }

    @Test
    public void checkContainsOptional() {
        double value = 1.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.contains(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkAdd() {
        int value = 2;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<Number>> addValue = DequeX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkAddOptional() {
        double value = 2.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.add(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 3;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> onlyAddValue = DequeX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyAddOptional() {
        double value = 3.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyAdd(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkAddFirst() {
        int value = 4;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> addValueToStart = DequeX.addFirst(value);
        addValueToStart.accept(numbers);
        assertEquals(value, numbers.getFirst());
    }

    @Test
    public void checkAddFirstOptional() {
        double value = 4.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.addFirst(value)))
                .orElseThrow(IllegalStateException::new);
        assertEquals(actual.getFirst(), value);
    }

    @Test
    public void checkAddLast() {
        int value = 5;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> addValueToEnd = DequeX.addLast(value);
        addValueToEnd.accept(numbers);
        assertEquals(value, numbers.getLast());
    }

    @Test
    public void checkAddLastOptional() {
        double value = 5.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.addLast(value)))
                .orElseThrow(IllegalStateException::new);
        assertEquals(actual.getLast(), value);
    }

    @Test
    public void checkOffer() {
        int value = 6;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<Number>> offerValue = DequeX.offer(value);
        assertTrue(offerValue.test(numbers));
    }

    @Test
    public void checkOfferOptional() {
        double value = 6.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.offer(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyOffer() {
        int value = 7;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> onlyOfferValue = DequeX.onlyOffer(value);
        onlyOfferValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyOfferOptional() {
        double value = 7.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyOffer(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOfferFirst() {
        int value = 8;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<Number>> offerValueToStart = DequeX.offerFirst(value);
        assertTrue(offerValueToStart.test(numbers));
    }

    @Test
    public void checkOfferFirstOptional() {
        double value = 8.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.offerFirst(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyOfferFirst() {
        int value = 9;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> onlyOfferValueToStart = DequeX.onlyOfferFirst(value);
        onlyOfferValueToStart.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyOfferFirstOptional() {
        double value = 9.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyOfferFirst(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOfferLast() {
        int value = 10;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<Number>> offerValueToEnd = DequeX.offerLast(value);
        assertTrue(offerValueToEnd.test(numbers));
    }

    @Test
    public void checkOfferLastOptional() {
        double value = 10.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.offerLast(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyOfferLast() {
        int value = 11;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> onlyOfferValueToEnd = DequeX.onlyOfferLast(value);
        onlyOfferValueToEnd.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyOfferLastOptional() {
        double value = 11.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyOfferLast(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkPush() {
        int value = 12;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<Number>> pushValue = DequeX.push(value);
        pushValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkPushOptional() {
        double value = 12.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.push(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkRemove() {
        int value = 13;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<Number>> removeValue = DequeX.remove(value);
        assertTrue(removeValue.test(numbers));
    }

    @Test
    public void checkRemoveOptional() {
        double value = 13.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.remove(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkOnlyRemove() {
        int value = 14;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Consumer<Deque<Number>> onlyRemoveValue = DequeX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveOptional() {
        double value = 14.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyRemove(value)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkRemoveFirstOccurrence() {
        int value = 15;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<Number>> removeFirstOccurrenceValue = DequeX.removeFirstOccurrence(value);
        assertTrue(removeFirstOccurrenceValue.test(numbers));
    }

    @Test
    public void checkRemoveFirstOccurrenceOptional() {
        double value = 15.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.removeFirstOccurrence(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkOnlyRemoveFirstOccurrence() {
        int value = 16;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Consumer<Deque<Number>> onlyRemoveFirstOccurrenceValue = DequeX.onlyRemoveFirstOccurrence(value);
        onlyRemoveFirstOccurrenceValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveFirstOccurrenceOptional() {
        double value = 16.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyRemoveFirstOccurrence(value)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkRemoveLastOccurrence() {
        int value = 17;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<Number>> removeLastOccurrenceValue = DequeX.removeLastOccurrence(value);
        assertTrue(removeLastOccurrenceValue.test(numbers));
    }

    @Test
    public void checkRemoveLastOccurrenceOptional() {
        double value = 17.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.removeLastOccurrence(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkOnlyRemoveLastOccurrence() {
        int value = 18;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Consumer<Deque<Number>> onlyRemoveLastOccurrenceValue = DequeX.onlyRemoveLastOccurrence(value);
        onlyRemoveLastOccurrenceValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveLastOccurrenceOptional() {
        double value = 18.1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Deque<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(DequeX.onlyRemoveLastOccurrence(value)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkNotContains() {
        int value = 18;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<Number>> containsValue = DequeX.notContains(value);
        assertFalse(containsValue.test(numbers));
    }

    @Test
    public void checkNotContainsOptional() {
        double value = 18.1;
        Deque<Number> numbers = new ArrayDeque<>();
        Deque<Number> actual = Optional.of(numbers)
                .filter(DequeX.notContains(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }
}