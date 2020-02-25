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

import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link java.util.Queue}.
 *
 * @author Grig Alex
 * @version 0.2.1
 * @see java.util.Queue
 * @see java.util.function.Consumer
 * @see java.util.function.Predicate
 * @since 0.1.0
 */
public final class QueueX {
    private QueueX() {
    }

    /**
     * <p>Returns the carrying of {@link java.util.Queue#add(Object)}:
     * item -&gt; queue -&gt; queue.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Queue#add(Object)}
     * @param <E>  a type of elements in a queue
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Queue#add(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Queue<E>> add(E item) {
        return q -> q.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Queue#add(Object)}:
     * item -&gt; queue -&gt; queue.add(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Queue#add(Object)}
     * @param <E>  a type of elements in a queue
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Queue#add(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Queue<E>> onlyAdd(E item) {
        return q -> q.add(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Queue#offer(Object)}:
     * item -&gt; queue -&gt; queue.offer(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Queue#offer(Object)}
     * @param <E>  a type of elements in a queue
     * @return a {@link java.util.function.Predicate}
     * @see java.util.Queue#offer(Object)
     * @see java.util.function.Predicate
     * @since 0.1.0
     */
    public static <E> Predicate<Queue<E>> offer(E item) {
        return q -> q.offer(item);
    }

    /**
     * <p>Returns the carrying of {@link java.util.Queue#offer(Object)}:
     * item -&gt; queue -&gt; queue.offer(item).</p>
     *
     * @param item an element of {@link E} that is passed as the argument to {@link java.util.Queue#offer(Object)}
     * @param <E>  a type of elements in a queue
     * @return a {@link java.util.function.Consumer}
     * @see java.util.Queue#offer(Object)
     * @see java.util.function.Consumer
     * @since 0.1.0
     */
    public static <E> Consumer<Queue<E>> onlyOffer(E item) {
        return q -> q.offer(item);
    }
}
