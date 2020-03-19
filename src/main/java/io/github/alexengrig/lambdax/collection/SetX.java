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
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * <p>This utility class contains useful lambdas for {@link java.util.Set}.</p>
 *
 * @author Grig Alex
 * @version 0.3.0
 * @see java.util.Collection
 * @see java.util.Set
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 * @see java.util.function.IntFunction
 * @see java.util.function.Predicate
 * @since 0.1.0
 */
public final class SetX {
    private SetX() {
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#contains(Object)}:
     * item -&gt; set -&gt; set.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Set#contains(Object)}
     * @param <E>  a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> contains(E item) {
        return s -> s.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#containsAll(Collection)}:
     * all -&gt; set -&gt; set.containsAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#containsAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#containsAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> containsAll(Collection<? extends E> all) {
        return s -> s.containsAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#contains(Object)} negative:
     * item -&gt; set -&gt; !set.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Set#contains(Object)}
     * @param <E>  a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Set<E>> notContains(E item) {
        return s -> !s.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#containsAll(Collection)} negative:
     * all -&gt; set -&gt; !set.containsAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#containsAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#containsAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Set<E>> notContainsAll(Collection<? extends E> all) {
        return s -> !s.containsAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#add(Object)}:
     * item -&gt; set -&gt; set.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Set#add(Object)}
     * @param <E>  a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#add(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> add(E item) {
        return s -> s.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#addAll(Collection)}:
     * all -&gt; set -&gt; set.addAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#addAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#addAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> addAll(Collection<? extends E> all) {
        return s -> s.addAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#add(Object)}:
     * item -&gt; set -&gt; set.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Set#add(Object)}
     * @param <E>  a type of elements in a set
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Set#add(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Set<E>> onlyAdd(E item) {
        return s -> s.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#addAll(Collection)}:
     * all -&gt; set -&gt; set.addAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#addAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Set#addAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Set<E>> onlyAddAll(Collection<? extends E> all) {
        return s -> s.addAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#remove(Object)}:
     * item -&gt; set -&gt; set.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Set#remove(Object)}
     * @param <E>  a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#remove(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> remove(E item) {
        return s -> s.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#removeAll(Collection)}:
     * all -&gt; set -&gt; set.removeAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#removeAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#removeAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> removeAll(Collection<? extends E> all) {
        return s -> s.removeAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#remove(Object)}:
     * item -&gt; set -&gt; set.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Set#remove(Object)}
     * @param <E>  a type of elements in a set
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Set#remove(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Set<E>> onlyRemove(E item) {
        return s -> s.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#removeAll(Collection)}:
     * all -&gt; set -&gt; set.removeAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#removeAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Set#removeAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Set<E>> onlyRemoveAll(Collection<? extends E> all) {
        return s -> s.removeAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#retainAll(Collection)}:
     * all -&gt; set -&gt; set.retainAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#retainAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#retainAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> retainAll(Collection<? extends E> all) {
        return s -> s.retainAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#retainAll(Collection)}:
     * all -&gt; set -&gt; set.retainAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Set#retainAll(Collection)}
     * @param <E> a type of elements in a set
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Set#retainAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Set<E>> onlyRetainAll(Collection<? extends E> all) {
        return s -> s.retainAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#toArray(Object[])}}:
     * array -&gt; set -&gt; set.toArray(array).</p>
     *
     * @param array an array of {@link E} objects that is passed as the argument to {@link java.util.Set#toArray(Object[])}
     * @param <E>   a type of elements in a set
     * @return a {@link java.util.function.Function}
     * @see java.util.Set#toArray(Object[])
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<Set<E>, E[]> toArray(E[] array) {
        return c -> c.toArray(array);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#toArray(Object[])}}:
     * arrayGenerator -&gt; set -&gt; set.toArray(arrayGenerator.apply(0).</p>
     *
     * @param generator a {@link java.util.function.IntFunction} of array generator (array constructor)
     *                  the result of which is passed as the argument to {@link java.util.Set#toArray(Object[])}
     * @param <E>       a type of elements in a set
     * @return a {@link java.util.function.Function}
     * @see java.util.Set#toArray(Object[])
     * @see java.util.function.IntFunction
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<Set<E>, E[]> toArray(IntFunction<? extends E[]> generator) {
        return c -> c.toArray(generator.apply(0));
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#equals(Object)}:
     * other -&gt; set -&gt; set.equals(other).</p>
     *
     * @param other an {@link java.lang.Object} that is passed as the argument to {@link java.util.Set#equals(Object)})}
     * @param <E>   a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Set<E>> equalsTo(Object other) {
        return c -> c.equals(other);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Set#equals(Object)} negative:
     * other -&gt; set -&gt; !set.equals(other).</p>
     *
     * @param other an {@link java.lang.Object} that is passed as the argument to {@link java.util.Set#equals(Object)})}
     * @param <E>   a type of elements in a set
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Set#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Set<E>> notEqualsTo(Object other) {
        return c -> !c.equals(other);
    }
}
