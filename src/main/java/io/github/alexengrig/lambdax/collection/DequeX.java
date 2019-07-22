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

import java.util.Deque;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * <p>This utility class contains useful lambdas for {@link java.util.Deque}.</p>
 *
 * @author Grig Alex
 * @version 0.1.2
 * @see java.util.Deque
 * @see java.util.function.Consumer
 * @see java.util.function.Predicate
 * @since 0.1.0
 */
public final class DequeX {
    private DequeX() {
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#contains(Object)}:
     * item -&gt; deque -&gt; deque.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#contains(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> contains(E item) {
        return d -> d.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#contains(Object)} negative:
     * item -&gt; deque -&gt; !deque.contains(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#contains(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#contains(Object)
     * @see java.util.function.Predicate
     * @since 0.1.2
     */
    public static <E> Predicate<Deque<? super E>> notContains(E item) {
        return d -> !d.contains(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#add(Object)}:
     * item -&gt; deque -&gt; deque.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#add(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#add(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> add(E item) {
        return d -> d.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#add(Object)}:
     * item -&gt; deque -&gt; deque.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#add(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#add(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyAdd(E item) {
        return d -> d.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#addFirst(Object)}:
     * item -&gt; deque -&gt; deque.addFirst(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#addFirst(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#addFirst(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> addFirst(E item) {
        return d -> d.addFirst(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#addLast(Object)}:
     * item -&gt; deque -&gt; deque.addLast(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#addLast(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#addLast(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> addLast(E item) {
        return d -> d.addLast(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#offer(Object)}:
     * item -&gt; deque -&gt; deque.offer(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#offer(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#offer(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> offer(E item) {
        return d -> d.offer(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#offer(Object)}:
     * item -&gt; deque -&gt; deque.offer(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#offer(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#offer(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyOffer(E item) {
        return d -> d.offer(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#offerFirst(Object)}:
     * item -&gt; deque -&gt; deque.offerFirst(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#offerFirst(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#offerFirst(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> offerFirst(E item) {
        return d -> d.offerFirst(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#offerFirst(Object)}:
     * item -&gt; deque -&gt; deque.offerFirst(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#offerFirst(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#offerFirst(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyOfferFirst(E item) {
        return d -> d.offerFirst(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#offerLast(Object)}:
     * item -&gt; deque -&gt; deque.offerLast(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#offerLast(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#offerLast(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> offerLast(E item) {
        return d -> d.offerLast(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#offerLast(Object)}:
     * item -&gt; deque -&gt; deque.offerLast(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#offerLast(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#offerLast(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyOfferLast(E item) {
        return d -> d.offerLast(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#push(Object)}:
     * item -&gt; deque -&gt; deque.push(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#push(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#push(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> push(E item) {
        return d -> d.push(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#remove(Object)}:
     * item -&gt; deque -&gt; deque.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#remove(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#remove(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> remove(E item) {
        return d -> d.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#remove(Object)}:
     * item -&gt; deque -&gt; deque.remove(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#remove(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#remove(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyRemove(E item) {
        return d -> d.remove(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#removeFirstOccurrence(Object)}:
     * item -&gt; deque -&gt; deque.removeFirstOccurrence(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#removeFirstOccurrence(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#removeFirstOccurrence(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> removeFirstOccurrence(E item) {
        return d -> d.removeFirstOccurrence(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#removeFirstOccurrence(Object)}:
     * item -&gt; deque -&gt; deque.removeFirstOccurrence(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#removeFirstOccurrence(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#removeFirstOccurrence(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyRemoveFirstOccurrence(E item) {
        return d -> d.removeFirstOccurrence(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#removeLastOccurrence(Object)}:
     * item -&gt; deque -&gt; deque.removeLastOccurrence(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#removeLastOccurrence(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Deque#removeLastOccurrence(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Deque<? super E>> removeLastOccurrence(E item) {
        return d -> d.removeLastOccurrence(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Deque#removeLastOccurrence(Object)}:
     * item -&gt; deque -&gt; deque.removeLastOccurrence(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Deque#removeLastOccurrence(Object)}
     * @param <E>  a type of elements in a deque
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Deque#removeLastOccurrence(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Deque<? super E>> onlyRemoveLastOccurrence(E item) {
        return d -> d.removeLastOccurrence(item);
    }
}
