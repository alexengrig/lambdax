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

package io.github.alexengrig.lambdax.example;

import io.github.alexengrig.lambdax.ChainX;
import io.github.alexengrig.lambdax.function.ThrowableFunction;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.Assert.*;

public class ChainExampleTest {
    @Test
    public void example() {
        final String string = "This is STRING!!1";
        final Object[] holder = new Object[1];
        final ChainX<Integer> chain = ChainX.of(string)
                .map(String::length)
                .filter(length -> length > 0)
                .mutate(length -> holder[0] = length);
        assertEquals(string.length(), holder[0]);
        assertTrue(chain.nonNull());
        assertNotNull(chain.get());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void tryMap() {
        final ThrowableFunction<String, String, IndexOutOfBoundsException> mapper = s -> s.substring(-1);
        final IndexOutOfBoundsException[] holder = new IndexOutOfBoundsException[1];
        final Consumer<IndexOutOfBoundsException> catcher = e -> holder[0] = e;
        final String expected = "expected";
        assertEquals(expected, ChainX.of("string").tryMapOrElse(mapper, expected, catcher).get());
        assertNotNull(holder[0]);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void tryMapOrNull() {
        final ThrowableFunction<String, String, IndexOutOfBoundsException> mapper = s -> s.substring(-1);
        assertTrue(ChainX.of("string").tryMapOrEmpty(mapper).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void tryMapOrDefault() {
        final ThrowableFunction<String, String, IndexOutOfBoundsException> mapper = s -> s.substring(-1);
        final String expected = "expected";
        assertEquals(expected, ChainX.of("string").tryMapOrElse(mapper, expected).get());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void tryMapOrCatch() {
        final ThrowableFunction<String, String, IndexOutOfBoundsException> mapper = s -> s.substring(-1);
        final String expected = "expected";
        final Function<IndexOutOfBoundsException, String> catcher = e -> expected;
        assertEquals(expected, ChainX.of("string").tryMapOrCatch(mapper, catcher).get());
    }
}
