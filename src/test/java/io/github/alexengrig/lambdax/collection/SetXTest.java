/*
 * Copyright 2019 Alexengrig Dev.
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class SetXTest {
    @Test
    public void checkContains() {
        int value = 1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Predicate<Set<? extends Number>> containsValue = SetX.contains(value);
        assertTrue(containsValue.test(numbers));
    }

    @Test
    public void checkContainsOptional() {
        double value = 1.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.contains(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkContainsAll() {
        int value = 2;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? extends Number>> containsAllValues = SetX.containsAll(values);
        assertTrue(containsAllValues.test(numbers));
    }

    @Test
    public void checkContainsAllOptional() {
        double value = 2.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.containsAll(values))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkAdd() {
        int value = 3;
        Set<Number> numbers = new HashSet<>();
        Predicate<Set<? super Number>> addValue = SetX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkAddOptional() {
        double value = 3.1;
        Set<Number> numbers = new HashSet<>();
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.add(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkAddAll() {
        int value = 4;
        Set<Number> numbers = new HashSet<>();
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? super Number>> addAllValues = SetX.addAll(values);
        assertTrue(addAllValues.test(numbers));
    }

    @Test
    public void checkAddAllOptional() {
        double value = 4.1;
        Set<Number> numbers = new HashSet<>();
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.addAll(values))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 5;
        Set<Number> numbers = new HashSet<>();
        Consumer<Set<? super Number>> onlyAddValue = SetX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyAddOptional() {
        double value = 5.1;
        Set<Number> numbers = new HashSet<>();
        Set<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(SetX.onlyAdd(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyAddAll() {
        int value = 6;
        Set<Number> numbers = new HashSet<>();
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Consumer<Set<? super Number>> onlyAddAllValues = SetX.onlyAddAll(values);
        onlyAddAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyAddAllOptional() {
        double value = 6.1;
        Set<Number> numbers = new HashSet<>();
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(SetX.onlyAddAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkRemove() {
        int value = 7;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Predicate<Set<? super Number>> removeValue = SetX.remove(value);
        assertTrue(removeValue.test(numbers));
    }

    @Test
    public void checkRemoveOptional() {
        double value = 7.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.remove(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkRemoveAll() {
        int value = 8;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? super Number>> removeAllValues = SetX.removeAll(values);
        assertTrue(removeAllValues.test(numbers));
    }

    @Test
    public void checkRemoveAllOptional() {
        double value = 8.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.removeAll(values))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.containsAll(values));
    }

    @Test
    public void checkOnlyRemove() {
        int value = 9;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Consumer<Set<? super Number>> onlyRemoveValue = SetX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveOptional() {
        double value = 9.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(SetX.onlyRemove(value)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkOnlyRemoveAll() {
        int value = 10;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Consumer<Set<? super Number>> removeAllValues = SetX.onlyRemoveAll(values);
        removeAllValues.accept(numbers);
        assertFalse(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyRemoveAllOptional() {
        double value = 10.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(SetX.onlyRemoveAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.containsAll(values));
    }

    @Test
    public void checkRetainAll() {
        int value = 11;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? super Number>> retainAllValues = SetX.retainAll(values);
        assertFalse(retainAllValues.test(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void checkRetainAllOptional() {
        double value = 11.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.retainAll(values))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkOnlyRetainAll() {
        int value = 12;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Consumer<Set<? super Number>> onlyRetainAllValues = SetX.onlyRetainAll(values);
        onlyRetainAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyRetainAllOptional() {
        double value = 12.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(SetX.onlyRetainAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkToArray() {
        int value = 13;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Function<Set<? extends Number>, ? extends Number[]> toIntegerArray = SetX.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayOptional() {
        double value = 13.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Number[] actual = Optional.of(numbers)
                .map(SetX.toArray(new Double[0]))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual);
    }

    @Test
    public void checkToArrayWithGenerator() {
        int value = 14;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Function<Set<? extends Number>, ? extends Number[]> toIntegerArray = SetX.toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayWithGeneratorOptional() {
        double value = 14.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Number[] actual = Optional.of(numbers)
                .map(SetX.toArray(Double[]::new))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual);
    }

    @Test
    public void checkEquals() {
        int value = 15;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? extends Number>> equalsToValues = SetX.equalsTo(values);
        assertTrue(equalsToValues.test(numbers));
    }

    @Test
    public void checkEqualsOptional() {
        double value = 15.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.equalsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertEquals(values, actual);
    }

    @Test
    public void checkNotContains() {
        int value = 16;
        Set<Number> numbers = new HashSet<>();
        Predicate<Set<? extends Number>> notContainsValue = SetX.notContains(value);
        assertTrue(notContainsValue.test(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void checkNotContainsOptional() {
        double value = 16.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.notContains(value))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkNotContainsAll() {
        int value = 17;
        Set<Number> numbers = new HashSet<>();
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? extends Number>> notContainsAllValues = SetX.notContainsAll(values);
        assertTrue(notContainsAllValues.test(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void checkNotContainsAllOptional() {
        double value = 17.1;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.notContainsAll(values))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkNotEquals() {
        int value = 18;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? extends Number>> notEqualsToValues = SetX.notEqualsTo(values);
        assertFalse(notEqualsToValues.test(numbers));
    }

    @Test
    public void checkNotEqualsOptional() {
        double value = 18.1;
        Set<Number> numbers = new HashSet<>();
        Set<Double> values = new HashSet<>();
        values.add(value);
        Set<Number> actual = Optional.of(numbers)
                .filter(SetX.notEqualsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertNotEquals(actual, values);
    }
}