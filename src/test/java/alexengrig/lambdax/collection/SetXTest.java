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

import java.util.HashSet;
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
    public void checkAdd() {
        int value = 3;
        Set<Number> numbers = new HashSet<>();
        Predicate<Set<? super Number>> addValue = SetX.add(value);
        assertTrue(addValue.test(numbers));
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
    public void checkOnlyAdd() {
        int value = 5;
        Set<Number> numbers = new HashSet<>();
        Consumer<Set<? super Number>> onlyAddValue = SetX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
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
    public void checkRemove() {
        int value = 7;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Predicate<Set<? super Number>> removeValue = SetX.remove(value);
        assertTrue(removeValue.test(numbers));
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
    public void checkOnlyRemove() {
        int value = 9;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Consumer<Set<? super Number>> onlyRemoveValue = SetX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
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
    public void checkRetainAll() {
        int value = 11;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? super Number>> retainAllValues = SetX.retainAll(values);
        assertFalse(retainAllValues.test(numbers));
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
    public void checkToArray() {
        int value = 13;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Function<Set<? extends Number>, ? extends Number[]> toIntegerArray = SetX.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
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
    public void checkEquals() {
        int value = 15;
        Set<Number> numbers = new HashSet<>();
        numbers.add(value);
        Set<Integer> values = new HashSet<>();
        values.add(value);
        Predicate<Set<? extends Number>> equalsToValues = SetX.equalsTo(values);
        assertTrue(equalsToValues.test(numbers));
    }
}