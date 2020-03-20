/*
 * Copyright 2019 Alexengrig Dev.
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

package io.github.alexengrig.lambdax;

import io.github.alexengrig.lambdax.collection.DequeX;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public class OptionalXTest {
    @Test
    public void checkOfValue() {
        Object o = new Object();
        assertTrue(OptionalX.of(o).isPresent());
        o = null;
        //noinspection ConstantConditions
        assertFalse(OptionalX.of(o).isPresent());
    }

    @Test
    public void checkOfSupplier() {
        final Supplier<Object> o = Object::new;
        assertTrue(OptionalX.of(o).isPresent());
    }

    @Test
    public void checkPeek() {
        final Object expect = new Object();
        final ArrayList<Object> list = new ArrayList<>();
        final Object actual = OptionalX.peek(list::add).apply(expect);
        assertEquals(expect, actual);
        assertTrue(list.contains(expect));
    }

    @Test
    public void checkOfAndPeek() {
        int value = 1;
        Number actual = OptionalX.of(ArrayDeque<Number>::new)
                .map(OptionalX.peek(DequeX.onlyAdd(value)))
                .map(Deque::getFirst)
                .orElseThrow(IllegalStateException::new);
        assertEquals(value, actual);
    }
}