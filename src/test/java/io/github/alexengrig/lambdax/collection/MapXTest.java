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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class MapXTest {
    @Test
    public void checkContainsKey() {
        int key = 1;
        String value = "one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Predicate<Map<Number, CharSequence>> containsKey = MapX.containsKey(key);
        assertTrue(containsKey.test(numberWords));
    }

    @Test
    public void checkContainsKeyOptional() {
        double key = 1.1;
        String value = "one.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .filter(MapX.containsKey(key))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numberWords, actual);
    }

    @Test
    public void checkContainsValue() {
        int key = 2;
        String value = "two";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Predicate<Map<Number, CharSequence>> containsValue = MapX.containsValue(value);
        assertTrue(containsValue.test(numberWords));
    }

    @Test
    public void checkContainsValueOptional() {
        double key = 2.1;
        String value = "two.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .filter(MapX.containsValue(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numberWords, actual);
    }

    @Test
    public void checkGet() {
        int key = 3;
        String value = "three";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Function<Map<Number, CharSequence>, CharSequence> getByKey = MapX.get(key);
        assertEquals(value, getByKey.apply(numberWords));
    }

    @Test
    public void checkGetOptional() {
        double key = 3.1;
        String value = "three.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        CharSequence actual = Optional.of(numberWords)
                .map(MapX.get(key))
                .orElseThrow(IllegalStateException::new);
        assertEquals(value, actual);
    }

    @Test
    public void checkPut() {
        int key = 4;
        String value = "four";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Function<Map<Number, CharSequence>, CharSequence> putKeyAndValue = MapX.put(key, value);
        assertEquals(value, putKeyAndValue.apply(numberWords));
    }

    @Test(expected = NullPointerException.class)
    public void checkPutOptional() {
        double key = 4.1;
        String value = "four.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        CharSequence actual = Optional.of(numberWords)
                .map(MapX.put(key, value))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkPutAll() {
        int key = 5;
        String value = "five";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Map<Integer, String> values = new HashMap<>();
        values.put(key, value);
        Consumer<Map<Number, CharSequence>> putAllValues = MapX.putAll(values);
        putAllValues.accept(numberWords);
        assertTrue(numberWords.containsKey(key));
    }

    @Test
    public void checkPutAllOptional() {
        double key = 5.1;
        String value = "five.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Map<Double, String> values = new HashMap<>();
        values.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .map(OptionalX.peek(MapX.putAll(values)))
                .filter(MapX.containsKey(key))
                .orElseThrow(IllegalStateException::new);
        assertEquals(values, actual);
    }

    @Test
    public void checkOnlyPut() {
        int key = 6;
        String value = "six";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Consumer<Map<Number, CharSequence>> onlyPutKeyAndValue = MapX.onlyPut(key, value);
        onlyPutKeyAndValue.accept(numberWords);
        assertTrue(numberWords.containsKey(key));
    }

    @Test
    public void checkOnlyPutOptional() {
        double key = 6.1;
        String value = "six.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .map(OptionalX.peek(MapX.onlyPut(key, value)))
                .filter(MapX.containsKey(key))
                .orElseThrow(IllegalStateException::new);
        assertEquals(numberWords, actual);
    }

    @Test
    public void checkRemove() {
        int key = 7;
        String value = "seven";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Function<Map<Number, CharSequence>, CharSequence> removeByKey = MapX.remove(key);
        assertEquals(value, removeByKey.apply(numberWords));
    }

    @Test
    public void checkRemoveOptional() {
        double key = 7.1;
        String value = "seven.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        CharSequence actual = Optional.of(numberWords)
                .map(MapX.remove(key))
                .orElseThrow(IllegalStateException::new);
        assertEquals(value, actual);
    }

    @Test
    public void checkOnlyRemove() {
        int key = 8;
        String value = "eight";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Consumer<Map<Number, CharSequence>> onlyRemoveByKey = MapX.onlyRemove(key);
        onlyRemoveByKey.accept(numberWords);
        assertFalse(numberWords.containsKey(key));
    }

    @Test(expected = NullPointerException.class)
    public void checkOnlyRemoveOptional() {
        double key = 8.1;
        String value = "eight.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .map(OptionalX.peek(MapX.onlyRemove(key)))
                .filter(MapX.containsValue(value))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkEquals() {
        int key = 9;
        String value = "nine";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Integer, String> values = new HashMap<>();
        values.put(key, value);
        Predicate<Map<Number, CharSequence>> equalsToValues = MapX.equalsTo(values);
        assertTrue(equalsToValues.test(numberWords));
    }

    @Test
    public void checkEqualsOptional() {
        double key = 9.1;
        String value = "nine.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Double, String> values = new HashMap<>();
        values.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .filter(MapX.equalsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertEquals(values, actual);
    }

    @Test
    public void checkNotContainsKey() {
        int key = 10;
        String value = "ten";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        numberWords.remove(key);
        Predicate<Map<Number, CharSequence>> notContainsKey = MapX.notContainsKey(key);
        assertTrue(notContainsKey.test(numberWords));
    }

    @Test(expected = NullPointerException.class)
    public void checkNotContainsKeyOptional() {
        double key = 10.1;
        String value = "ten.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .filter(MapX.notContainsKey(key))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkNotContainsValue() {
        int key = 11;
        String value = "eleven";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        numberWords.remove(key);
        Predicate<Map<Number, CharSequence>> notContainsValue = MapX.notContainsValue(value);
        assertTrue(notContainsValue.test(numberWords));
    }

    @Test(expected = NullPointerException.class)
    public void checkNotContainsValueOptional() {
        double key = 11.1;
        String value = "eleven.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .filter(MapX.notContainsValue(value))
                .orElseThrow(NullPointerException::new);
        assertNull(actual);
    }

    @Test
    public void checkNotEquals() {
        int key = 12;
        String value = "twelve";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Integer, String> values = new HashMap<>();
        values.put(key, value);
        Predicate<Map<Number, CharSequence>> notEqualsToValues = MapX.notEqualsTo(values);
        assertFalse(notEqualsToValues.test(numberWords));
    }

    @Test
    public void checkNotEqualsOptional() {
        double key = 12.1;
        String value = "twelve.one";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Map<Double, String> values = new HashMap<>();
        values.put(key, value);
        Map<Number, CharSequence> actual = Optional.of(numberWords)
                .filter(MapX.notEqualsTo(values))
                .orElseThrow(IllegalStateException::new);
        assertNotEquals(values, actual);
    }
}