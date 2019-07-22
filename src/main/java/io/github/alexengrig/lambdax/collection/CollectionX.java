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
 * <p>This utility class contains useful lambdas for {@link java.util.Collection}.</p>
 *
 * @author Grig Alex
 * @version 0.1.2
 * @see java.util.Collection
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 * @see java.util.function.IntFunction
 * @see java.util.function.Predicate
 * @since 0.1.0
 */
public final class CollectionX {
    private CollectionX() {
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#contains(Object)}:
     * item -&gt; collection -&gt; collection.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Collection#contains(Object)}
     * @param <E>  a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? extends E>> contains(E item) {
        return c -> c.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#containsAll(Collection)}:
     * all -&gt; collection -&gt; collection.containsAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#containsAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#containsAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? extends E>> containsAll(Collection<? extends E> all) {
        return c -> c.containsAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#contains(Object)} negative:
     * item -&gt; collection -&gt; !collection.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Collection#contains(Object)}
     * @param <E>  a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Collection<? extends E>> notContains(E item) {
        return c -> !c.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#containsAll(Collection)} negative:
     * all -&gt; collection -&gt; !collection.containsAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#containsAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#containsAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Collection<? extends E>> notContainsAll(Collection<? extends E> all) {
        return c -> !c.containsAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#add(Object)}:
     * item -&gt; collection -&gt; collection.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Collection#add(Object)}
     * @param <E>  a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#add(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? super E>> add(E item) {
        return c -> c.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#addAll(Collection)}:
     * all -&gt; collection -&gt; collection.addAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#addAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#addAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? super E>> addAll(Collection<? extends E> all) {
        return c -> c.addAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#add(Object)}:
     * item -&gt; collection -&gt; collection.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Collection#add(Object)}
     * @param <E>  a type of elements in a collection
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Collection#add(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Collection<? super E>> onlyAdd(E item) {
        return c -> c.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#addAll(Collection)}:
     * all -&gt; collection -&gt; collection.addAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#addAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Collection#addAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Collection<? super E>> onlyAddAll(Collection<? extends E> all) {
        return c -> c.addAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#remove(Object)}:
     * item -&gt; collection -&gt; collection.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Collection#remove(Object)}
     * @param <E>  a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#remove(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? super E>> remove(E item) {
        return c -> c.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#removeAll(Collection)}:
     * all -&gt; collection -&gt; collection.removeAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#removeAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#removeAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? super E>> removeAll(Collection<? extends E> all) {
        return c -> c.removeAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#remove(Object)}:
     * item -&gt; collection -&gt; collection.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Collection#remove(Object)}
     * @param <E>  a type of elements in a collection
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Collection#remove(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Collection<? super E>> onlyRemove(E item) {
        return c -> c.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#removeAll(Collection)}:
     * all -&gt; collection -&gt; collection.removeAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#removeAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Collection#removeAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Collection<? super E>> onlyRemoveAll(Collection<? extends E> all) {
        return c -> c.removeAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#retainAll(Collection)}:
     * all -&gt; collection -&gt; collection.retainAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#retainAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#retainAll(Collection)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? super E>> retainAll(Collection<? extends E> all) {
        return c -> c.retainAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#retainAll(Collection)}:
     * all -&gt; collection -&gt; collection.retainAll(all).</p>
     *
     * @param all a {@link java.util.Collection} that is passed as the argument to {@link java.util.Collection#retainAll(Collection)}
     * @param <E> a type of elements in a collection
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Collection#retainAll(Collection)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Collection<? super E>> onlyRetainAll(Collection<? extends E> all) {
        return c -> c.retainAll(all);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#toArray(Object[])}}:
     * array -&gt; collection -&gt; collection.toArray(array).</p>
     *
     * @param array an array of {@link E} objects that is passed as the argument to {@link java.util.Collection#toArray(Object[])}
     * @param <E>   a type of elements in a collection
     * @return a {@link java.util.function.Function}
     * @see java.util.Collection#toArray(Object[])
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<Collection<? extends E>, E[]> toArray(E[] array) {
        return c -> c.toArray(array);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#toArray(Object[])}}:
     * arrayGenerator -&gt; collection -&gt; collection.toArray(arrayGenerator.apply(0).</p>
     *
     * @param generator a {@link java.util.function.IntFunction} of array generator (array constructor)
     *                  the result of which is passed as the argument to {@link java.util.Collection#toArray(Object[])}
     * @param <E>       a type of elements in a collection
     * @return a {@link java.util.function.Function}
     * @see java.util.Collection#toArray(Object[])
     * @see java.util.function.IntFunction
     * @see java.util.function.Function
     * @since 0.1.0
     */
    public static <E> Function<Collection<? extends E>, E[]> toArray(IntFunction<? extends E[]> generator) {
        return c -> c.toArray(generator.apply(0));
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#equals(Object)}:
     * other -&gt; collection -&gt; collection.equals(other).</p>
     *
     * @param other an {@link java.lang.Object} that is passed as the argument to {@link java.util.Collection#equals(Object)})}
     * @param <E>   a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Collection<? extends E>> equalsTo(Object other) {
        return c -> c.equals(other);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Collection#equals(Object)} negative:
     * other -&gt; collection -&gt; !collection.equals(other).</p>
     *
     * @param other an {@link java.lang.Object} that is passed as the argument to {@link java.util.Collection#equals(Object)})}
     * @param <E>   a type of elements in a collection
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Collection#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Collection<? extends E>> notEqualsTo(Object other) {
        return c -> !c.equals(other);
    }
}
