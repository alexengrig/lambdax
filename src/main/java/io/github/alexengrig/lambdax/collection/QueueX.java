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

import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link Queue}
 *
 * @author Grig Alex
 * @see Queue
 * @see Consumer
 * @see Predicate
 * @since 0.1.0
 */
public final class QueueX {
    private QueueX() {
    }

    public static <E> Predicate<Queue<? super E>> add(E item) {
        return q -> q.add(item);
    }

    public static <E> Consumer<Queue<? super E>> onlyAdd(E item) {
        return q -> q.add(item);
    }

    public static <E> Predicate<Queue<? super E>> offer(E item) {
        return q -> q.offer(item);
    }

    public static <E> Consumer<Queue<? super E>> onlyOffer(E item) {
        return q -> q.offer(item);
    }
}
