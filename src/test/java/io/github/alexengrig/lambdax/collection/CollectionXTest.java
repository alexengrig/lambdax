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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class CollectionXTest {
    @Test
    public void checkContains() {
        int value = 1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<Collection<Number>> containsValue = CollectionX.contains(value);
        assertTrue(containsValue.test(numbers));
    }

    @Test
    public void checkContainsOptional() {
        double value = 1.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.contains(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numbers, actual);
    }

    @Test
    public void checkContainsAll() {
        int value = 2;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> containsAllValues = CollectionX.containsAll(values);
        assertTrue(containsAllValues.test(numbers));
    }

    @Test
    public void checkContainsAllOptional() {
        double value = 2.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.containsAll(values))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numbers, actual);
    }

    @Test
    public void checkAdd() {
        int value = 3;
        Collection<Number> numbers = new ArrayList<>();
        Predicate<Collection<Number>> addValue = CollectionX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkAddOptional() {
        double value = 3.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.add(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkAddAll() {
        int value = 4;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> addAllValues = CollectionX.addAll(values);
        assertTrue(addAllValues.test(numbers));
    }

    @Test
    public void checkAddAllOptional() {
        double value = 4.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.addAll(values))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 5;
        Collection<Number> numbers = new ArrayList<>();
        Consumer<Collection<Number>> onlyAddValue = CollectionX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyAddOptional() {
        double value = 5.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(CollectionX.onlyAdd(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyAddAll() {
        int value = 6;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<Collection<Number>> onlyAddAllValues = CollectionX.onlyAddAll(values);
        onlyAddAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyAddAllOptional() {
        double value = 6.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(CollectionX.onlyAddAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkRemove() {
        int value = 7;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<Collection<Number>> removeValue = CollectionX.remove(value);
        assertTrue(removeValue.test(numbers));
    }

    @Test
    public void checkRemoveOptional() {
        double value = 7.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.remove(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkRemoveAll() {
        int value = 8;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> removeAllValues = CollectionX.removeAll(values);
        assertTrue(removeAllValues.test(numbers));
    }

    @Test
    public void checkRemoveAllOptional() {
        double value = 8.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.removeAll(values))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.containsAll(values));
    }

    @Test
    public void checkOnlyRemove() {
        int value = 9;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Consumer<Collection<Number>> onlyRemoveValue = CollectionX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveOptional() {
        double value = 9.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(CollectionX.onlyRemove(value)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkOnlyRemoveAll() {
        int value = 10;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<Collection<Number>> onlyRemoveAllValues = CollectionX.onlyRemoveAll(values);
        onlyRemoveAllValues.accept(numbers);
        assertFalse(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyRemoveAllOptional() {
        double value = 10.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(CollectionX.onlyRemoveAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.containsAll(values));
    }

    @Test
    public void checkRetainAll() {
        int value = 11;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> retainAllValues = CollectionX.retainAll(values);
        assertFalse(retainAllValues.test(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void checkRetainAllOptional() {
        double value = 11.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.retainAll(values))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkOnlyRetainAll() {
        int value = 12;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<Collection<Number>> onlyRetainAllValues = CollectionX.onlyRetainAll(values);
        onlyRetainAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyRetainAllOptional() {
        double value = 12.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(CollectionX.onlyRetainAll(values)))
                .orElseThrow(NullPointerException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkToArray() {
        int value = 13;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<Collection<Number>, Number[]> toIntegerArray = CollectionX.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayOptional() {
        double value = 13.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Number[] actual = Optional.of(numbers)
                .map(CollectionX.toArray(new Double[0]))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual);
    }

    @Test
    public void checkToArrayWithGenerator() {
        int value = 14;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<Collection<Number>, Number[]> toIntegerArray = CollectionX.toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayWithGeneratorOptional() {
        double value = 14.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Number[] actual = Optional.of(numbers)
                .map(CollectionX.toArray(Double[]::new))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual);
    }

    @Test
    public void checkEquals() {
        int value = 15;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> equalsToValues = CollectionX.equalsTo(values);
        assertTrue(equalsToValues.test(numbers));
    }

    @Test
    public void checkEqualsOptional() {
        double value = 15.1;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.equalsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertEquals(values, actual);
    }

    @Test
    public void checkNotContains() {
        int value = 16;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<Collection<Number>> notContainsValue = CollectionX.notContains(value);
        assertFalse(notContainsValue.test(numbers));
    }

    @Test
    public void checkNotContainsOptional() {
        double value = 16.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.notContains(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numbers, actual);
    }

    @Test
    public void checkNotContainsAll() {
        int value = 17;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> notContainsAllValues = CollectionX.notContainsAll(values);
        assertFalse(notContainsAllValues.test(numbers));
    }

    @Test
    public void checkNotContainsAllOptional() {
        double value = 17.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.notContainsAll(values))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numbers, actual);
    }

    @Test
    public void checkNotEquals() {
        int value = 18;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<Number>> notEqualsToValues = CollectionX.notEqualsTo(values);
        assertFalse(notEqualsToValues.test(numbers));
    }

    @Test
    public void checkNotEqualsOptional() {
        double value = 18.1;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Double> values = new ArrayList<>();
        values.add(value);
        Collection<Number> actual = Optional.of(numbers)
                .filter(CollectionX.notEqualsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertNotEquals(values, actual);
    }
}