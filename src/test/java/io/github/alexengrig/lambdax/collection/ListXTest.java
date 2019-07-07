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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
    public void checkContainsAll() {
        int value = 2;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> other = new ArrayList<>();
        other.add(value);
        Predicate<List<? extends Number>> containsAllOther = ListX.containsAll(other);
        assertTrue(containsAllOther.test(numbers));
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
    public void checkGet() {
        int value = 4;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? extends Number>, ? super Number> getFirstValue = ListX.get(0);
        assertEquals(value, getFirstValue.apply(numbers));
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
    public void checkLastIndexOf() {
        int value = 6;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? super Number>, Integer> lastIndexOfValue = ListX.lastIndexOf(value);
        assertEquals(Integer.valueOf(0), lastIndexOfValue.apply(numbers));
    }

    @Test
    public void checkAdd() {
        int value = 7;
        List<Number> numbers = new ArrayList<>();
        Predicate<List<? super Number>> addValue = ListX.add(value);
        assertTrue(addValue.test(numbers));
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
    public void checkAddAll() {
        int value = 9;
        List<Number> numbers = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? super Number>> addAllValues = ListX.addAll(values);
        assertTrue(addAllValues.test(numbers));
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
    public void checkOnlyAdd() {
        int value = 11;
        List<Number> numbers = new ArrayList<>();
        Consumer<List<? super Number>> onlyAddValue = ListX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
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
    public void checkRemove() {
        int value = 14;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<List<? super Number>> removeValue = ListX.remove(value);
        assertTrue(removeValue.test(numbers));
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
    public void checkOnlyRemove() {
        int value = 16;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Consumer<List<? super Number>> onlyRemoveValue = ListX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
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
    public void checkRetainAll() {
        int value = 18;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        List<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<List<? super Number>> retainAllValues = ListX.retainAll(values);
        assertFalse(retainAllValues.test(numbers));
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
    public void checkReplaceAll() {
        int value = 20;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Consumer<List<Number>> replaceAllWithInc = ListX.replaceAll(i -> i.intValue() + 1);
        replaceAllWithInc.accept(numbers);
        assertEquals(value + 1, numbers.get(0));
    }

    @Test
    public void checkSort() {
        int value = 21;
        int first = 0;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        numbers.add(first);
        Consumer<List<? extends Number>> sort = ListX.sort(Comparator.comparingInt(Number::intValue));
        sort.accept(numbers);
        assertArrayEquals(new Integer[]{first, value}, numbers.toArray());
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
    public void checkToArrayWithGenerator() {
        int value = 23;
        List<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<List<? extends Number>, ? extends Number[]> toIntegerArray = ListX.toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkSubList() {
        int value = 24;
        int first = 0;
        List<Number> numbers = new ArrayList<>();
        numbers.add(first);
        numbers.add(value);
        Function<List<? extends Number>, List<? extends Number>> subList = ListX.subList(1, 2);
        assertArrayEquals(new Integer[]{value}, subList.apply(numbers).toArray());
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
}
