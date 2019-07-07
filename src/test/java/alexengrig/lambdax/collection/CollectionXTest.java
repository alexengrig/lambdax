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

import java.util.ArrayList;
import java.util.Collection;
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
        Predicate<Collection<? extends Number>> containsValue = CollectionX.contains(value);
        assertTrue(containsValue.test(numbers));
    }

    @Test
    public void checkContainsAll() {
        int value = 2;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<? extends Number>> containsAllValues = CollectionX.containsAll(values);
        assertTrue(containsAllValues.test(numbers));
    }

    @Test
    public void checkAdd() {
        int value = 3;
        Collection<Number> numbers = new ArrayList<>();
        Predicate<Collection<? super Number>> addValue = CollectionX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkAddAll() {
        int value = 4;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<? super Number>> addAllValues = CollectionX.addAll(values);
        assertTrue(addAllValues.test(numbers));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 5;
        Collection<Number> numbers = new ArrayList<>();
        Consumer<Collection<? super Number>> onlyAddValue = CollectionX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOnlyAddAll() {
        int value = 6;
        Collection<Number> numbers = new ArrayList<>();
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<Collection<? super Number>> onlyAddAllValues = CollectionX.onlyAddAll(values);
        onlyAddAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkRemove() {
        int value = 7;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Predicate<Collection<? super Integer>> removeValue = CollectionX.remove(value);
        assertTrue(removeValue.test(numbers));
    }

    @Test
    public void checkRemoveAll() {
        int value = 8;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<? super Number>> removeAllValues = CollectionX.removeAll(values);
        assertTrue(removeAllValues.test(numbers));
    }

    @Test
    public void checkOnlyRemove() {
        int value = 9;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Consumer<Collection<? super Integer>> onlyRemoveValue = CollectionX.onlyRemove(value);
        onlyRemoveValue.accept(numbers);
        assertFalse(numbers.contains(value));
    }

    @Test
    public void checkOnlyRemoveAll() {
        int value = 10;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<Collection<? super Number>> onlyRemoveAllValues = CollectionX.onlyRemoveAll(values);
        onlyRemoveAllValues.accept(numbers);
        assertFalse(numbers.containsAll(values));
    }

    @Test
    public void checkRetainAll() {
        int value = 11;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<? super Number>> retainAllValues = CollectionX.retainAll(values);
        assertFalse(retainAllValues.test(numbers));
    }

    @Test
    public void checkOnlyRetainAll() {
        int value = 12;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Consumer<Collection<? super Number>> onlyRetainAllValues = CollectionX.onlyRetainAll(values);
        onlyRetainAllValues.accept(numbers);
        assertTrue(numbers.containsAll(values));
    }

    @Test
    public void checkToArray() {
        int value = 13;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<Collection<? extends Number>, ? extends Number[]> toIntegerArray = CollectionX.toArray(new Integer[0]);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkToArrayWithGenerator() {
        int value = 14;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Function<Collection<? extends Number>, ? extends Number[]> toIntegerArray = CollectionX.toArray(Integer[]::new);
        assertArrayEquals(new Integer[]{value}, toIntegerArray.apply(numbers));
    }

    @Test
    public void checkEquals() {
        int value = 15;
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(value);
        Collection<Integer> values = new ArrayList<>();
        values.add(value);
        Predicate<Collection<? extends Number>> equalsToValues = CollectionX.equalsTo(values);
        assertTrue(equalsToValues.test(numbers));
    }
}