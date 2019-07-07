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

package alexengrig.lambdax.collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class DequeXTest {
    @Test
    public void checkContains() {
        int value = 1;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<? super Number>> containsValue = DequeX.contains(value);
        assertTrue(containsValue.test(numbers));
    }

    @Test
    public void checkAdd() {
        int value = 2;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<? super Number>> addValue = DequeX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 3;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> onlyAddValue = DequeX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkAddFirst() {
        int value = 4;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> addValueToStart = DequeX.addFirst(value);
        addValueToStart.accept(numbers);
        assertEquals(value, numbers.getFirst());
    }

    @Test
    public void checkAddLast() {
        int value = 5;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> addValueToEnd = DequeX.addLast(value);
        addValueToEnd.accept(numbers);
        assertEquals(value, numbers.getLast());
    }

    @Test
    public void checkOffer() {
        int value = 6;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<? super Number>> offerValue = DequeX.offer(value);
        assertTrue(offerValue.test(numbers));
    }

    @Test
    public void checkOnlyOffer() {
        int value = 7;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> onlyOfferValue = DequeX.onlyOffer(value);
        onlyOfferValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOfferFirst() {
        int value = 8;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<? super Number>> offerValueToStart = DequeX.offerFirst(value);
        assertTrue(offerValueToStart.test(numbers));
    }

    @Test
    public void checkOnlyOfferFirst() {
        int value = 9;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> onlyOfferValueToStart = DequeX.onlyOfferFirst(value);
        onlyOfferValueToStart.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOfferLast() {
        int value = 10;
        Deque<Number> numbers = new ArrayDeque<>();
        Predicate<Deque<? super Number>> offerValueToEnd = DequeX.offerLast(value);
        assertTrue(offerValueToEnd.test(numbers));
    }

    @Test
    public void checkOnlyOfferLast() {
        int value = 11;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> onlyOfferValueToEnd = DequeX.onlyOfferLast(value);
        onlyOfferValueToEnd.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkPush() {
        int value = 12;
        Deque<Number> numbers = new ArrayDeque<>();
        Consumer<Deque<? super Number>> pushValue = DequeX.push(value);
        pushValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkRemove() {
        int value = 13;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<? super Number>> removeValue = DequeX.remove(value);
        assertTrue(removeValue.test(numbers));
    }

    @Test
    public void checkOnlyRemove() {
        int value = 14;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Consumer<Deque<? super Number>> onlyRemoveValue = DequeX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkRemoveFirstOccurrence() {
        int value = 15;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<? super Number>> removeFirstOccurrenceValue = DequeX.removeFirstOccurrence(value);
        assertTrue(removeFirstOccurrenceValue.test(numbers));
    }

    @Test
    public void checkOnlyRemoveFirstOccurrence() {
        int value = 16;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Consumer<Deque<? super Number>> onlyRemoveFirstOccurrenceValue = DequeX.onlyRemoveFirstOccurrence(value);
        onlyRemoveFirstOccurrenceValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkRemoveLastOccurrence() {
        int value = 17;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Predicate<Deque<? super Integer>> removeLastOccurrenceValue = DequeX.removeLastOccurrence(value);
        assertTrue(removeLastOccurrenceValue.test(numbers));
    }

    @Test
    public void checkOnlyRemoveLastOccurrence() {
        int value = 18;
        Deque<Number> numbers = new ArrayDeque<>();
        numbers.add(value);
        Consumer<Deque<? super Integer>> onlyRemoveLastOccurrenceValue = DequeX.onlyRemoveLastOccurrence(value);
        onlyRemoveLastOccurrenceValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }
}