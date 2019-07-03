package alexengrig.lambdax.collection;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MapX {
    private MapX() {
    }

    public static <K, V> Predicate<Map<? extends K, ? extends V>> containsByKey(final K key) {
        return map -> map.containsKey(key);
    }

    public static <K, V> Predicate<Map<? extends K, ? extends V>> containsByValue(final V value) {
        return map -> map.containsValue(value);
    }

    public static <K, V> Predicate<Map<? super K, ? super V>> equalsTo(final Object other) {
        return map -> map.equals(other);
    }

    public static <K, V> Consumer<Map<? super K, ? super V>> onlyPut(final K key, final V value) {
        return map -> map.put(key, value);
    }

    public static <K, V> Consumer<Map<? extends K, ? extends V>> onlyRemove(final K key) {
        return map -> map.remove(key);
    }

    public static <K, V> Consumer<Map<? super K, ? super V>> putAll(final Map<? extends K, ? extends V> all) {
        return map -> map.putAll(all);
    }

    public static <K, V> Consumer<Map<? extends K, ? extends V>> forEach(final BiConsumer<? super K, ? super V> cons) {
        return map -> map.forEach(cons);
    }

    public static <K, V> Function<Map<? extends K, ? extends V>, V> remove(final K key) {
        return map -> map.remove(key);
    }

    public static <K, V> Function<Map<? super K, ? extends V>, V> get(final K key) {
        return map -> map.get(key);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Function<Map<? super K, ? super V>, V> put(final K key, final V value) {
        return map -> (V) map.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Function<Map<? super K, ? super V>, V> getOrDefault(final K key, final V value) {
        return map -> (V) map.getOrDefault(key, value);
    }
}
