package alexengrig.lambdax.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapXTest {
    private Map<Number, CharSequence> map = new HashMap<>();
    private Integer key = 1;
    private String value = "Value from map";

    @Before
    public void fillMap() {
        map.put(key, value);
    }

    @Test
    public void checkContainsByKey() {
        Predicate<Map<? extends Number, ? extends CharSequence>> containsByKey = MapX.containsByKey(key);
        assertTrue(containsByKey.test(map));
    }

    @Test
    public void checkContainsByValue() {
        Predicate<Map<? extends Number, ? extends CharSequence>> containsByValue = MapX.containsByValue(value);
        assertTrue(containsByValue.test(map));
    }

    @Test
    public void checkGet() {
        Function<Map<? super Number, ? extends CharSequence>, CharSequence> getByKey = MapX.get(key);
        assertEquals(value, getByKey.apply(map));
    }

    @Test
    public void checkPut() {
        Function<Map<? super Number, ? super CharSequence>, CharSequence> putKeyWithValue = MapX.put(key, value);
        assertEquals(value, putKeyWithValue.apply(map));
    }

    @Test
    public void checkRemove() {
        int keyForRemove = 13;
        String valueForRemove = "Value for remove";
        map.put(keyForRemove, valueForRemove);
        Function<Map<? extends Number, ?>, Object> removeByKey = MapX.remove(keyForRemove);
        assertEquals(valueForRemove, removeByKey.apply(map));
    }

    @Test
    public void checkPutAll() {
        Map<Integer, String> newMap = new HashMap<>();
        int keyForNewMap = 69;
        String valueForNewMap = "Value for new map";
        newMap.put(keyForNewMap, valueForNewMap);
        Consumer<Map<? super Integer, ? super String>> putAll = MapX.putAll(newMap);
        putAll.accept(map);
        assertTrue(map.containsKey(keyForNewMap));
        assertTrue(map.containsValue(valueForNewMap));
    }

    @Test
    public void checkEqualsTo() {
        Map<Number, CharSequence> other = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Predicate<Map<? super Number, ? super CharSequence>> equalsTo = MapX.equalsTo(other);
        assertTrue(equalsTo.test(map));
    }

    @Test
    public void checkGetOrDefault() {
        String defaultValue = "Default value";
        Function<Map<? super Number, ? super CharSequence>, CharSequence> getOrDefault = MapX.getOrDefault(100, defaultValue);
        assertEquals(defaultValue, getOrDefault.apply(map));
    }
}