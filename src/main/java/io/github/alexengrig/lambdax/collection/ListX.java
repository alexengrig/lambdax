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


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * <p>This utility class contains useful lambdas for {@link java.util.List}.</p>
 *
 * @author Grig Alex
 * @version 0.3.0
 * @see java.util.Collection
 * @see java.util.List
 * @see java.util.Comparator
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 * @see java.util.function.IntFunction
 * @see java.util.function.UnaryOperator
 * @since 0.1.0
 */
public final class ListX {
    private ListX() {
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#contains(Object)}:
     * item -&gt; list -&gt; list.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#contains(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> contains(E item) {
        return l -> l.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#containsAll(Collection)}:
     * all -&gt; list -&gt; list.containsAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#containsAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#containsAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> containsAll(Collection<? extends E> all) {
        return l -> l.containsAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#contains(Object)} negative:
     * item -&gt; list -&gt; !list.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#contains(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<List<E>> notContains(E item) {
        return l -> !l.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#containsAll(Collection)} negative:
     * all -&gt; list -&gt; !list.containsAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#containsAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#containsAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<List<E>> notContainsAll(Collection<? extends E> all) {
        return l -> !l.containsAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#set(int, Object)}:
     * (i, item) -&gt; list -&gt; list.set(i, item).</p>
     *
     * @param i    an index that is passed as the first argument to {@link java.util.List#set(int, Object)}
     * @param item an element of {@link E} that is passed as the second argument to {@link java.util.List#set(int, Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#set(int, Object)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, E> set(int i, E item) {
        return l -> l.set(i, item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#get(int)}:
     * i -&gt; list -&gt; list.get(i).</p>
     *
     * @param i   an index that is passed as the argument to {@link java.util.List#get(int)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#get(int)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, E> get(int i) {
        return l -> l.get(i);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#indexOf(Object)}:
     * item -&gt; list -&gt; list.indexOf(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#indexOf(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#indexOf(Object)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, Integer> indexOf(E item) {
        return l -> l.indexOf(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#lastIndexOf(Object)}:
     * item -&gt; list -&gt; list.lastIndexOf(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#lastIndexOf(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#lastIndexOf(Object)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, Integer> lastIndexOf(E item) {
        return l -> l.lastIndexOf(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#add(Object)}:
     * item -&gt; list -&gt; list.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#add(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#add(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> add(E item) {
        return l -> l.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#add(int, Object)}:
     * (i, item) -&gt; list -&gt; list.add(i, item).</p>
     *
     * @param i    an index that is passed as the first argument to {@link java.util.List#add(int, Object)}
     * @param item an element of {@link E} that is passed as the second argument to {@link java.util.List#add(int, Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#add(int, Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> add(int i, E item) {
        return l -> l.add(i, item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#addAll(Collection)}:
     * all -&gt; list -&gt; list.addAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#addAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#addAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> addAll(Collection<? extends E> all) {
        return l -> l.addAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#addAll(int, Collection)}:
     * (i, all) -&gt; list -&gt; list.addAll(i, all).</p>
     *
     * @param i   an index that is passed as the first argument to {@link java.util.List#addAll(int, Collection)}
     * @param all a {@link java.util.Collection} that is passed as the second argument to {@link java.util.List#addAll(int, Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#addAll(int, Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> addAll(int i, Collection<? extends E> all) {
        return l -> l.addAll(i, all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#add(Object)}:
     * item -&gt; list -&gt; list.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#add(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#add(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> onlyAdd(E item) {
        return l -> l.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#addAll(Collection)}:
     * all -&gt; list -&gt; list.addAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#addAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#addAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> onlyAddAll(Collection<? extends E> all) {
        return l -> l.addAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#addAll(int, Collection)}:
     * (i, all) -&gt; list -&gt; list.addAll(i, all).</p>
     *
     * @param i   an index that is passed as the first argument to {@link java.util.List#addAll(int, Collection)}
     * @param all a {@link java.util.Collection} that is passed as the second argument to {@link java.util.List#addAll(int, Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#addAll(int, Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> onlyAddAll(int i, Collection<? extends E> all) {
        return l -> l.addAll(i, all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#remove(Object)}:
     * item -&gt; list -&gt; list.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#remove(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#remove(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> remove(E item) {
        return l -> l.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#removeAll(Collection)}:
     * all -&gt; list -&gt; list.removeAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#removeAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#removeAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> removeAll(Collection<? extends E> all) {
        return l -> l.removeAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#remove(Object)}:
     * item -&gt; list -&gt; list.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.List#remove(Object)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#remove(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> onlyRemove(E item) {
        return l -> l.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#removeAll(Collection)}:
     * all -&gt; list -&gt; list.removeAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#removeAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#removeAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> onlyRemoveAll(Collection<? extends E> all) {
        return l -> l.removeAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#retainAll(Collection)}:
     * all -&gt; list -&gt; list.retainAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#retainAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#retainAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> retainAll(Collection<? extends E> all) {
        return l -> l.retainAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#retainAll(Collection)}:
     * all -&gt; list -&gt; list.retainAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.List#retainAll(Collection)}
     * @param <E> a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#retainAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> onlyRetainAll(Collection<? extends E> all) {
        return l -> l.retainAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#replaceAll(UnaryOperator)}:
     * operator -&gt; list -&gt; list.replaceAll(operator).</p>
     *
     * @param operator an {@link java.util.function.UnaryOperator} that is passed as the argument to {@link java.util.List#replaceAll(UnaryOperator)}
     * @param <E>      a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#replaceAll(UnaryOperator)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> replaceAll(UnaryOperator<E> operator) {
        return l -> l.replaceAll(operator);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#sort(Comparator)}:
     * comparator -&gt; list -&gt; list.sort(comparator).</p>
     *
     * @param comparator a {@link java.util.Comparator} that is passed as the argument to {@link java.util.List#sort(Comparator)}
     * @param <E>        a type of elements in a list
     * @return a {@link java.util.function.Consumer}
     * @see java.util.List#sort(Comparator)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<List<E>> sort(Comparator<? super E> comparator) {
        return l -> l.sort(comparator);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#toArray(Object[])}}:
     * array -&gt; list -&gt; list.toArray(array).</p>
     *
     * @param array an array of {@link E} objects that is passed as the argument to {@link java.util.List#toArray(Object[])}
     * @param <E>   a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#toArray(Object[])
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, E[]> toArray(E[] array) {
        return c -> c.toArray(array);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#toArray(Object[])}}:
     * arrayGenerator -&gt; list -&gt; list.toArray(arrayGenerator.apply(0).</p>
     *
     * @param generator a {@link java.util.function.IntFunction} of array generator (array constructor)
     *                  the result of which is passed as the argument to {@link java.util.List#toArray(Object[])}
     * @param <E>       a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#toArray(Object[])
     * @see java.util.function.IntFunction
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, E[]> toArray(IntFunction<? extends E[]> generator) {
        return c -> c.toArray(generator.apply(0));
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#subList(int, int)}:
     * (from, to) -&gt; list -&gt; list.subList(from, to).</p>
     *
     * @param from an index that is passed as the first argument to {@link java.util.List#subList(int, int)}
     * @param to   an index that is passed as the second argument to {@link java.util.List#subList(int, int)}
     * @param <E>  a type of elements in a list
     * @return a {@link java.util.function.Function}
     * @see java.util.List#subList(int, int)
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<List<E>, List<E>> subList(int from, int to) {
        return l -> l.subList(from, to);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#equals(Object)}:
     * other -&gt; list -&gt; list.equals(other).</p>
     *
     * @param other an {@link java.lang.Object} that is passed as the argument to {@link java.util.List#equals(Object)})}
     * @param <E>   a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<List<E>> equalsTo(Object other) {
        return l -> l.equals(other);
    }

    /**
     * <p>Returns the carrying of {@link java.util.List#equals(Object)} negative:
     * other -&gt; list -&gt; !list.equals(other).</p>
     *
     * @param other an {@link java.lang.Object} that is passed as the argument to {@link java.util.List#equals(Object)})}
     * @param <E>   a type of elements in a list
     * @return a {@link java.util.function.Predicate}
     * @see java.util.List#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<List<E>> notEqualsTo(Object other) {
        return l -> !l.equals(other);
    }
}
