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
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * This utility class contains useful lambdas for {@link List}
 *
 * @author Grig Alex
 * @see Collection
 * @see List
 * @see Comparator
 * @see Consumer
 * @see Function
 * @see Predicate
 * @see IntFunction
 * @see UnaryOperator
 * @since 0.1.0
 */
public final class ListX {
    private ListX() {
    }

    public static <E> Predicate<List<? extends E>> contains(E item) {
        return l -> l.contains(item);
    }

    public static <E> Predicate<List<? extends E>> containsAll(Collection<? extends E> all) {
        return l -> l.containsAll(all);
    }

    @SuppressWarnings("unchecked")
    public static <E> Function<List<? super E>, ? super E> set(int i, E item) {
        return l -> (E) l.set(i, item);
    }

    public static <E> Function<List<? extends E>, ? super E> get(int i) {
        return l -> l.get(i);
    }

    public static <E> Function<List<? super E>, Integer> indexOf(E item) {
        return l -> l.indexOf(item);
    }

    public static <E> Function<List<? super E>, Integer> lastIndexOf(E item) {
        return l -> l.lastIndexOf(item);
    }

    public static <E> Predicate<List<? super E>> add(E item) {
        return l -> l.add(item);
    }

    public static <E> Consumer<List<? super E>> add(int i, E item) {
        return l -> l.add(i, item);
    }

    public static <E> Predicate<List<? super E>> addAll(Collection<? extends E> all) {
        return l -> l.addAll(all);
    }

    public static <E> Predicate<List<? super E>> addAll(int i, Collection<? extends E> all) {
        return l -> l.addAll(i, all);
    }

    public static <E> Consumer<List<? super E>> onlyAdd(E item) {
        return l -> l.add(item);
    }

    public static <E> Consumer<List<? super E>> onlyAddAll(Collection<? extends E> all) {
        return l -> l.addAll(all);
    }

    public static <E> Consumer<List<? super E>> onlyAddAll(int i, Collection<? extends E> all) {
        return l -> l.addAll(i, all);
    }

    public static <E> Predicate<List<? super E>> remove(E item) {
        return l -> l.remove(item);
    }

    public static <E> Predicate<List<? super E>> removeAll(Collection<? extends E> all) {
        return l -> l.removeAll(all);
    }

    public static <E> Consumer<List<? super E>> onlyRemove(E item) {
        return l -> l.remove(item);
    }

    public static <E> Consumer<List<? super E>> onlyRemoveAll(Collection<? extends E> all) {
        return l -> l.removeAll(all);
    }

    public static <E> Predicate<List<? super E>> retainAll(Collection<? extends E> all) {
        return l -> l.retainAll(all);
    }

    public static <E> Consumer<List<? super E>> onlyRetainAll(Collection<? extends E> all) {
        return l -> l.retainAll(all);
    }

    public static <E> Consumer<List<E>> replaceAll(UnaryOperator<E> operator) {
        return l -> l.replaceAll(operator);
    }

    public static <E> Consumer<List<? extends E>> sort(Comparator<? super E> comparator) {
        return l -> l.sort(comparator);
    }

    public static <E> Function<List<? extends E>, E[]> toArray(E[] array) {
        return c -> c.toArray(array);
    }

    public static <E> Function<List<? extends E>, E[]> toArray(IntFunction<? extends E[]> generator) {
        return c -> c.toArray(generator.apply(0));
    }

    public static <E> Function<List<? extends E>, List<? extends E>> subList(int from, int to) {
        return l -> l.subList(from, to);
    }

    public static <E> Predicate<List<? extends E>> equalsTo(Object other) {
        return l -> l.equals(other);
    }
}
