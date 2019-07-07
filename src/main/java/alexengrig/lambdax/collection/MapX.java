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

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link Map}
 *
 * @author Grig Alex
 * @see Map
 * @see Consumer
 * @see Function
 * @see Predicate
 * @since 0.1.0
 */
public final class MapX {
    private MapX() {
    }

    public static <K, V> Predicate<Map<? extends K, ? extends V>> containsKey(K key) {
        return map -> map.containsKey(key);
    }

    public static <K, V> Predicate<Map<? extends K, ? extends V>> containsValue(V value) {
        return map -> map.containsValue(value);
    }

    public static <K, V> Function<Map<? super K, ? extends V>, ? super V> get(K key) {
        return map -> map.get(key);
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Function<Map<? super K, ? super V>, ? super V> put(K key, V value) {
        return map -> (V) map.put(key, value);
    }

    public static <K, V> Consumer<Map<? super K, ? super V>> putAll(Map<? extends K, ? extends V> all) {
        return map -> map.putAll(all);
    }

    public static <K, V> Consumer<Map<? super K, ? super V>> onlyPut(K key, V value) {
        return map -> map.put(key, value);
    }

    public static <K, V> Function<Map<? extends K, ? extends V>, ? extends V> remove(K key) {
        return map -> map.remove(key);
    }

    public static <K, V> Consumer<Map<? extends K, ? extends V>> onlyRemove(K key) {
        return map -> map.remove(key);
    }

    public static <K, V> Predicate<Map<? super K, ? super V>> equalsTo(Object other) {
        return map -> map.equals(other);
    }
}
