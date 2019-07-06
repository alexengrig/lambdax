package alexengrig.lambdax.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
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
        Predicate<Map<? extends Number, ? extends CharSequence>> containsKey = MapX.containsKey(key);
        assertTrue(containsKey.test(numberWords));
    }

    @Test
    public void checkContainsValue() {
        int key = 2;
        String value = "two";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Predicate<Map<? extends Number, ? extends CharSequence>> containsValue = MapX.containsValue(value);
        assertTrue(containsValue.test(numberWords));
    }

    @Test
    public void checkGet() {
        int key = 3;
        String value = "three";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Function<Map<? super Number, ?>, ? super CharSequence> getByKey = MapX.get(key);
        assertEquals(value, getByKey.apply(numberWords));
    }

    @Test
    public void checkPut() {
        int key = 4;
        String value = "four";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Function<Map<? super Number, ? super CharSequence>, ? extends CharSequence> putKeyAndValue = MapX.put(key, value);
        assertEquals(value, putKeyAndValue.apply(numberWords));
    }

    @Test
    public void checkPutAll() {
        int key = 5;
        String value = "five";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Map<Integer, String> other = new HashMap<>();
        other.put(key, value);
        Consumer<Map<? super Number, ? super CharSequence>> putAllValues = MapX.putAll(other);
        putAllValues.accept(numberWords);
        assertTrue(numberWords.containsKey(key));
    }

    @Test
    public void checkOnlyPut() {
        int key = 6;
        String value = "six";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        Consumer<Map<? super Number, ? super CharSequence>> onlyPutKeyAndValue = MapX.onlyPut(key, value);
        onlyPutKeyAndValue.accept(numberWords);
        assertTrue(numberWords.containsKey(key));
    }

    @Test
    public void checkRemove() {
        int key = 7;
        String value = "seven";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Function<Map<? extends Number, ? extends CharSequence>, ? extends CharSequence> removeByKey = MapX.remove(key);
        assertEquals(value, removeByKey.apply(numberWords));
    }

    @Test
    public void checkOnlyRemove() {
        int key = 8;
        String value = "eight";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Consumer<Map<? extends Number, ? extends CharSequence>> onlyRemoveByKey = MapX.onlyRemove(key);
        onlyRemoveByKey.accept(numberWords);
        assertFalse(numberWords.containsKey(key));
    }

    @Test
    public void checkEquals() {
        int key = 9;
        String value = "nine";
        Map<Number, CharSequence> numberWords = new HashMap<>();
        numberWords.put(key, value);
        Map<Integer, String> other = new HashMap<>();
        other.put(key, value);
        Predicate<Map<? super Number, ? super CharSequence>> equalsToOther = MapX.equalsTo(other);
        assertTrue(equalsToOther.test(numberWords));
    }
}