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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class ListXTest {
    @Test
    public void checkContains() {
        int value = 1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<List<? extends Number>> containsValue = ListX.contains(value);
        assertTrue(containsValue.test(numbers));
    }

    @Test
    public void checkContainsOptional() {
        double value = 1.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.contains(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkContainsAll() {
        int value = 2;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? extends Number>> containsAllValues = ListX.containsAll(values);
        assertTrue(containsAllValues.test(numbers));
    }

    @Test
    public void checkContainsAllOptional() {
        double value = 2.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.containsAll(values))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkSet() {
        int value = 3;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? super Number>, ? super Number> setFirstValue = ListX.set(0, value);
        assertEquals(value, setFirstValue.apply(numbers));
    }

    @Test
    public void checkSetOptional() {
        double value = 3.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Number actual = Optional.of(numbers)
                .map(ListX.set(0, value))
                .orElseThrow(IllegalStateException::new);
        assertEquals(value, actual);
    }

    @Test
    public void checkGet() {
        int value = 4;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? extends Number>, ? super Number> getFirstValue = ListX.get(0);
        assertEquals(value, getFirstValue.apply(numbers));
    }

    @Test
    public void checkGetOptional() {
        double value = 4.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Number actual = Optional.of(numbers)
                .map(ListX.get(0))
                .orElseThrow(IllegalStateException::new);
        assertEquals(value, actual);
    }

    @Test
    public void checkIndexOf() {
        int value = 5;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? super Number>, Integer> indexOfValue = ListX.indexOf(value);
        assertEquals(Integer.valueOf(0), indexOfValue.apply(numbers));
    }

    @Test
    public void checkIndexOfOptional() {
        double value = 5.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Integer actual = Optional.of(numbers)
                .map(ListX.indexOf(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals(Integer.valueOf(0), actual);
    }

    @Test
    public void checkLastIndexOf() {
        int value = 6;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? super Number>, Integer> lastIndexOfValue = ListX.lastIndexOf(value);
        assertEquals(Integer.valueOf(0), lastIndexOfValue.apply(numbers));
    }

    @Test
    public void checkLastIndexOfOptional() {
        double value = 6.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Integer actual = Optional.of(numbers)
                .map(ListX.lastIndexOf(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals(Integer.valueOf(0), actual);
    }

    @Test
    public void checkAdd() {
        int value = 7;
        List<Number> numbers = new ArrayList<>();
        Predicate<List<? super Number>> addValue = ListX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkAddOptional() {
        double value = 7.1;
        List<Number> numbers = new ArrayList<>();
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.add(value))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkAddWithIndex() {
        int value = 8;
        List<Number> numbers = new ArrayList<>();
        Consumer<List<? super Number>> addValueToStart = ListX.add(0, value);
        addValueToStart.accept(numbers);
        assertEquals(value, numbers.get(0));
    }

    @Test
    public void checkAddWithIndexOptional() {
        double value = 8.1;
        List<Number> numbers = new ArrayList<>();
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.add(0, value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkAddAll() {
        int value = 9;
        List<Number> numbers = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? super Number>> addAllValues = ListX.addAll(values);
        assertTrue(addAllValues.test(numbers));
    }

    @Test
    public void checkAddAllOptional() {
        double value = 9.1;
        List<Number> numbers = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.addAll(values))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkAddAllWithIndex() {
        int value = 10;
        List<Number> numbers = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? super Number>> addAllValuesToStart = ListX.addAll(0, values);
        assertTrue(addAllValuesToStart.test(numbers));
    }

    @Test
    public void checkAddAllWithIndexOptional() {
        double value = 10.1;
        List<Number> numbers = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.addAll(0, values))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 11;
        List<Number> numbers = new ArrayList<>();
        Consumer<List<? super Number>> onlyAddValue = ListX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyAddOptional() {
        double value = 11.1;
        List<Number> numbers = new ArrayList<>();
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.onlyAdd(value)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.contains(value));
    }

    @Test
    public void checkOnlyAddAll() {
        int value = 12;
        List<Number> numbers = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<List<? super Number>> onlyAddAllValues = ListX.onlyAddAll(values);
        onlyAddAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyAddAllOptional() {
        double value = 12.1;
        List<Number> numbers = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.onlyAddAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkOnlyAddAllWithIndex() {
        int value = 13;
        List<Number> numbers = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<List<? super Number>> onlyAddAllValuesToStart = ListX.onlyAddAll(0, values);
        onlyAddAllValuesToStart.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyAddAllWithIndexOptional() {
        double value = 13.1;
        List<Number> numbers = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.onlyAddAll(0, values)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkRemove() {
        int value = 14;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<List<? super Number>> removeValue = ListX.remove(value);
        assertTrue(removeValue.test(numbers));
    }

    @Test
    public void checkRemoveOptional() {
        double value = 14.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.remove(value))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkAllRemove() {
        int value = 15;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? super Number>> removeAllValues = ListX.removeAll(values);
        assertTrue(removeAllValues.test(numbers));
    }

    @Test
    public void checkAllRemoveOptional() {
        double value = 15.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.removeAll(values))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.containsAll(values));
    }

    @Test
    public void checkOnlyRemove() {
        int value = 16;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Consumer<List<? super Number>> onlyRemoveValue = ListX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveOptional() {
        double value = 16.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.onlyRemove(value)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.contains(value));
    }

    @Test
    public void checkOnlyAllRemove() {
        int value = 17;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<List<? super Number>> onlyRemoveAllValues = ListX.onlyRemoveAll(values);
        onlyRemoveAllValues.accept(numbers);
        assertFalse(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyAllRemoveOptional() {
        double value = 17.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.onlyRemoveAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertFalse(actual.containsAll(values));
    }

    @Test
    public void checkRetainAll() {
        int value = 18;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? super Number>> retainAllValues = ListX.retainAll(values);
        assertFalse(retainAllValues.test(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void checkRetainAllOptional() {
        double value = 18.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.retainAll(values))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkOnlyRetainAll() {
        int value = 19;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<List<? super Number>> retainAllValues = ListX.onlyRetainAll(values);
        retainAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkOnlyRetainAllOptional() {
        double value = 19.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.onlyRetainAll(values)))
                .orElseThrow(IllegalStateException::new);
        assertTrue(actual.containsAll(values));
    }

    @Test
    public void checkReplaceAll() {
        int value = 20;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Consumer<List<Number>> replaceAllWithInc = ListX.replaceAll(i -> i.intValue() + 1);
        replaceAllWithInc.accept(numbers);
        assertEquals(value + 1, numbers.get(0));
    }

    @Test
    public void checkReplaceAllOptional() {
        double value = 20.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.replaceAll(i -> i.doubleValue() + 1)))
                .orElseThrow(IllegalStateException::new);
        assertEquals(value + 1, actual.get(0));
    }

    @Test
    public void checkSort() {
        int value = 21;
        int zero = 0;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        numbers.add(zero);
        Consumer<List<? extends Number>> sort = ListX.sort(Comparator.comparingInt(Number::intValue));
        sort.accept(numbers);
        assertArrayEquals(new Integer[]{zero, value}, numbers.toArray());
    }

    @Test
    public void checkSortOptional() {
        double value = 21.1;
        int zero = 0;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        numbers.add(zero);
        List<Number> actual = Optional.of(numbers)
                .map(OptionalX.peek(ListX.sort(Comparator.comparingInt(Number::intValue))))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Number[]{zero, value}, actual.toArray());
    }

    @Test
    public void checkToArray() {
        int value = 22;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? extends Number>, ? extends Number[]> toIntegerArray = ListX.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayOptional() {
        double value = 22.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Number[] actual = Optional.of(numbers)
                .map(ListX.toArray(new Double[0]))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual);
    }

    @Test
    public void checkToArrayWithGenerator() {
        int value = 23;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? extends Number>, ? extends Number[]> toIntegerArray = ListX.toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayWithGeneratorOptional() {
        double value = 23.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Number[] actual = Optional.of(numbers)
                .map(ListX.toArray(Double[]::new))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual);
    }

    @Test
    public void checkSubList() {
        int value = 24;
        int zero = 0;
        List<Number> numbers = new ArrayList<>();
        numbers.add(zero);
        numbers.add(value);
        Function<List<Number>, List<Number>> subList = ListX.subList(1, 2);
        assertArrayEquals(new Integer[]{value}, subList.apply(numbers).toArray());
    }

    @Test
    public void checkSubListOptional() {
        double value = 24.1;
        int zero = 0;
        List<Number> numbers = new ArrayList<>();
        numbers.add(zero);
        numbers.add(value);
        List<Number> actual = Optional.of(numbers)
                .map(ListX.subList(1, 2))
                .orElseThrow(IllegalStateException::new);
        assertArrayEquals(new Double[]{value}, actual.toArray());
    }

    @Test
    public void checkEquals() {
        int value = 25;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? extends Number>> equalsToValues = ListX.equalsTo(values);
        assertTrue(equalsToValues.test(numbers));
    }

    @Test
    public void checkEqualsOptional() {
        double value = 25.1;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Double> values = new ArrayList<>();
        values.add(value);
        List<Number> actual = Optional.of(numbers)
                .filter(ListX.equalsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertEquals(actual, numbers);
    }
}
