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

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link java.util.Map}.
 *
 * @author Grig Alex
 * @version 0.1.1
 * @see java.util.Map
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @since 0.1.0
 */
public final class MapX {
    private MapX() {
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#containsKey(Object)} negative:
     * key -&gt; map -&gt; !map.containsKey(key).</p>
     *
     * @param key a key of {@link K} that is passed as the argument to {@link java.util.Map#containsKey(Object)}
     * @param <K> a type of keys in a map
     * @param <V> a type of values in a map
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Map#containsKey(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <K, V> Predicate<Map<? extends K, ? extends V>> containsKey(K key) {
        return map -> map.containsKey(key);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#containsKey(Object)}:
     * key -&gt; map -&gt; map.containsKey(key).</p>
     *
     * @param key a key of {@link K} that is passed as the argument to {@link java.util.Map#containsKey(Object)}
     * @param <K> a type of keys in a map
     * @param <V> a type of values in a map
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Map#containsKey(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <K, V> Predicate<Map<? extends K, ? extends V>> notContainsKey(K key) {
        return map -> !map.containsKey(key);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#containsValue(Object)}:
     * value -&gt; map -&gt; map.containsValue(value).</p>
     *
     * @param value a value of {@link V} that is passed as the argument to {@link java.util.Map#containsValue(Object)}
     * @param <K>   a type of keys in a map
     * @param <V>   a type of values in a map
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Map#containsValue(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <K, V> Predicate<Map<? extends K, ? extends V>> containsValue(V value) {
        return map -> map.containsValue(value);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#containsValue(Object)} negative:
     * value -&gt; map -&gt; !map.containsValue(value).</p>
     *
     * @param value a value of {@link V} that is passed as the argument to {@link java.util.Map#containsValue(Object)}
     * @param <K>   a type of keys in a map
     * @param <V>   a type of values in a map
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Map#containsValue(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <K, V> Predicate<Map<? extends K, ? extends V>> notConntainsValue(V value) {
        return map -> !map.containsValue(value);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#get(Object)}:
     * key -&gt; map -&gt; map.get(key).</p>
     *
     * @param key a key of {@link K} that is passed as the argument to {@link java.util.Map#get(Object)}
     * @param <K> a type of keys in a map
     * @param <V> a type of values in a map
     * @return a {@link java.util.function.Function}
     * @see java.util.Map#get(Object)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <K, V> Function<Map<? extends K, ? extends V>, V> get(K key) {
        return map -> map.get(key);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#put(Object, Object)}:
     * (key, value) -&gt; map -&gt; map.put(key, value).</p>
     *
     * @param key   a key of {@link K} that is passed as the first argument to {@link java.util.Map#put(Object, Object)}
     * @param value a value of {@link V} that is passed as the second argument to {@link java.util.Map#put(Object, Object)}
     * @param <K>   a type of keys in a map
     * @param <V>   a type of values in a map
     * @return a {@link java.util.function.Function}
     * @see java.util.Map#put(Object, Object)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    @SuppressWarnings("unchecked")
    public static <K, V> Function<Map<? super K, ? super V>, V> put(K key, V value) {
        return map -> (V) map.put(key, value);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#putAll(Map)}:
     * all -&gt; map -&gt; map.putAll(all).</p>
     *
     * @param all a {@link java.util.Map} that is passed as the argument to {@link java.util.Map#putAll(Map)}
     * @param <K> a type of keys in a map
     * @param <V> a type of values in a map
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Map#putAll(Map)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <K, V> Consumer<Map<? super K, ? super V>> putAll(Map<? extends K, ? extends V> all) {
        return map -> map.putAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#put(Object, Object)}:
     * (key, value) -&gt; map -&gt; map.put(key, value).</p>
     *
     * @param key   a key of {@link K} that is passed as the first argument to {@link java.util.Map#put(Object, Object)}
     * @param value a value of {@link V} that is passed as the second argument to {@link java.util.Map#put(Object, Object)}
     * @param <K>   a type of keys in a map
     * @param <V>   a type of values in a map
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Map#put(Object, Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <K, V> Consumer<Map<? super K, ? super V>> onlyPut(K key, V value) {
        return map -> map.put(key, value);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#remove(Object)}:
     * key -&gt; map -&gt; map.remove(key).</p>
     *
     * @param key a key of {@link K} that is passed as the argument to {@link java.util.Map#remove(Object)}
     * @param <K> a type of keys in a map
     * @param <V> a type of values in a map
     * @return a {@link java.util.function.Function}
     * @see java.util.Map#remove(Object)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <K, V> Function<Map<? extends K, ? extends V>, V> remove(K key) {
        return map -> map.remove(key);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#remove(Object)}:
     * key -&gt; map -&gt; map.remove(key).</p>
     *
     * @param key a key of {@link K} that is passed as the argument to {@link java.util.Map#remove(Object)}
     * @param <K> a type of keys in a map
     * @param <V> a type of values in a map
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Map#remove(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <K, V> Consumer<Map<? extends K, ? extends V>> onlyRemove(K key) {
        return map -> map.remove(key);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#equals(Object)}:
     * other -&gt; map -&gt; map.equals(other).</p>
     *
     * @param other a {@link java.lang.Object} that is passed as the argument to {@link java.util.Map#equals(Object)}
     * @param <K>   a type of keys in a map
     * @param <V>   a type of values in a map
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Map#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <K, V> Predicate<Map<? super K, ? super V>> equalsTo(Object other) {
        return map -> map.equals(other);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Map#equals(Object)} negative:
     * other -&gt; map -&gt; !map.equals(other).</p>
     *
     * @param other a {@link java.lang.Object} that is passed as the argument to {@link java.util.Map#equals(Object)}
     * @param <K>   a type of keys in a map
     * @param <V>   a type of values in a map
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Map#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <K, V> Predicate<Map<? super K, ? super V>> notEqualsTo(Object other) {
        return map -> !map.equals(other);
    }
}
