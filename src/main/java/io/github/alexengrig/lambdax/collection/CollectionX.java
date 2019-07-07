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

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link Collection}
 *
 * @author Grig Alex
 * @see Collection
 * @see Consumer
 * @see Function
 * @see IntFunction
 * @see Predicate
 * @since 0.1.0
 */
public final class CollectionX {
    private CollectionX() {
    }

    public static <E> Predicate<Collection<? extends E>> contains(E item) {
        return c -> c.contains(item);
    }

    public static <E> Predicate<Collection<? extends E>> containsAll(Collection<? extends E> all) {
        return c -> c.containsAll(all);
    }

    public static <E> Predicate<Collection<? super E>> add(E item) {
        return c -> c.add(item);
    }

    public static <E> Predicate<Collection<? super E>> addAll(Collection<? extends E> all) {
        return c -> c.addAll(all);
    }

    public static <E> Consumer<Collection<? super E>> onlyAdd(E item) {
        return c -> c.add(item);
    }

    public static <E> Consumer<Collection<? super E>> onlyAddAll(Collection<? extends E> all) {
        return c -> c.addAll(all);
    }

    public static <E> Predicate<Collection<? super E>> remove(E item) {
        return c -> c.remove(item);
    }

    public static <E> Predicate<Collection<? super E>> removeAll(Collection<? extends E> all) {
        return c -> c.removeAll(all);
    }

    public static <E> Consumer<Collection<? super E>> onlyRemove(E item) {
        return c -> c.remove(item);
    }

    public static <E> Consumer<Collection<? super E>> onlyRemoveAll(Collection<? extends E> all) {
        return c -> c.removeAll(all);
    }

    public static <E> Predicate<Collection<? super E>> retainAll(Collection<? extends E> all) {
        return c -> c.retainAll(all);
    }

    public static <E> Consumer<Collection<? super E>> onlyRetainAll(Collection<? extends E> all) {
        return c -> c.retainAll(all);
    }

    public static <E> Function<Collection<? extends E>, E[]> toArray(E[] array) {
        return c -> c.toArray(array);
    }

    public static <E> Function<Collection<? extends E>, E[]> toArray(IntFunction<? extends E[]> generator) {
        return c -> c.toArray(generator.apply(0));
    }

    public static <E> Predicate<Collection<? extends E>> equalsTo(Object other) {
        return c -> c.equals(other);
    }
}
