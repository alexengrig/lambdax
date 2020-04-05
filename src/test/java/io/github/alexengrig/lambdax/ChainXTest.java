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

package io.github.alexengrig.lambdax;

import io.github.alexengrig.lambdax.function.PredicateX;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class ChainXTest {
    private final Predicate<String> failPredicate = t -> {
        fail("Fail predicate");
        return false;
    };
    private final Consumer<String[]> failConsumer = t -> {
        fail("Fail consumer");
    };
    private final Function<String, String> failFunction = t -> {
        fail("Fail function");
        return t;
    };
    private final Function<String, ChainX<String>> failChainFunction = t -> {
        fail("Fail chain function");
        return ChainX.empty();
    };
    private final Function<String, Optional<String>> failOptionalFunction = t -> {
        fail("Fail optional function");
        return Optional.empty();
    };

    @Test
    public void checkEmpty() {
        final ChainX<String> chain = ChainX.empty();
        assertTrue("Value is null", chain.isNull());
    }

    @Test
    public void checkOfObject() {
        final ChainX<String> chain = ChainX.of("");
        assertTrue("Value is not null", chain.nonNull());
    }

    @Test
    public void checkOfSupplier() {
        final ChainX<String> chain = ChainX.of(() -> "");
        assertTrue("Value is not null", chain.nonNull());
    }

    @Test
    public void checkOfOptional() {
        final ChainX<String> chain = ChainX.of(Optional.empty());
        assertTrue("Value is null", chain.isNull());
    }

    @Test
    public void checkFilter() {
        ChainX<String> chain = ChainX.of("");
        assertFalse(chain.isNull());
        chain = chain.filter(String::isEmpty);
        assertFalse(chain.isNull());
        chain = chain.filter(PredicateX.not(String::isEmpty));
        assertTrue(chain.isNull());
        chain = chain.filter(failPredicate);
        assertTrue(chain.isNull());
    }

    @Test
    public void checkMap() {
        ChainX<String> chain = ChainX.of("");
        assertFalse(chain.isNull());
        chain = chain.map(s -> s + "1");
        assertFalse(chain.isNull());
        chain = chain.filter(String::isEmpty);
        assertTrue(chain.isNull());
        chain = chain.map(failFunction);
        assertTrue(chain.isNull());
    }

    @Test
    public void checkFlatMap() {
        ChainX<String> chain = ChainX.of("");
        assertFalse(chain.isNull());
        chain = chain.flatMap(s -> ChainX.of(s + "1"));
        assertFalse(chain.isNull());
        chain = chain.filter(String::isEmpty);
        assertTrue(chain.isNull());
        chain = chain.flatMap(failChainFunction);
        assertTrue(chain.isNull());
    }

    @Test
    public void checkFlatMapOptional() {
        ChainX<String> chain = ChainX.of("");
        assertFalse(chain.isNull());
        chain = chain.flatMapOptional(s -> Optional.of(s + "1"));
        assertFalse(chain.isNull());
        chain = chain.filter(String::isEmpty);
        assertTrue(chain.isNull());
        chain = chain.flatMapOptional(failOptionalFunction);
        assertTrue(chain.isNull());
    }

    @Test
    public void checkMutate() {
        ChainX<String[]> chain = ChainX.of(new String[]{""});
        assertFalse(chain.isNull());
        chain = chain.mutate(arr -> arr[0] = arr[0] + "1");
        assertFalse(chain.isNull());
        chain = chain.filter(arr -> arr[0].isEmpty());
        assertTrue(chain.isNull());
        chain = chain.mutate(failConsumer);
        assertTrue(chain.isNull());
    }

    @Test
    public void checkOptional() {
        assertTrue(ChainX.of("").optional().isPresent());
        assertFalse(ChainX.empty().optional().isPresent());
    }

    @Test
    public void checkStream() {
        assertEquals(1, ChainX.of("").stream().count());
        assertEquals(0, ChainX.empty().stream().count());
    }

    @Test
    public void checkOrObject() {
        assertFalse(ChainX.of("").or(ChainX.empty()).isNull());
        assertFalse(ChainX.empty().or(ChainX.of("")).isNull());
    }

    @Test
    public void checkOrSupplier() {
        assertFalse(ChainX.of("").or(ChainX::empty).isNull());
        assertFalse(ChainX.empty().or(() -> ChainX.of("")).isNull());
    }

    @Test
    public void checkOrElse() {
        assertNotNull(ChainX.of("").orElse(null));
        assertNotNull(ChainX.empty().orElse(""));
    }

    @Test
    public void checkOrElseGet() {
        assertNotNull(ChainX.of("").orElseGet(() -> null));
        assertNotNull(ChainX.empty().orElseGet(() -> ""));
    }

    @Test(expected = NoSuchElementException.class)
    public void checkOrElseThrow() {
        assertNotNull(ChainX.of("").orElseThrow());
        ChainX.empty().orElseThrow();
    }

    @Test(expected = NoSuchElementException.class)
    public void checkOrElseThrowObject() {
        assertNotNull(ChainX.of("").orElseThrow(new AssertionError()));
        ChainX.empty().orElseThrow(new NoSuchElementException());
    }

    @Test(expected = NoSuchElementException.class)
    public void checkOrElseThrowSupplier() {
        assertNotNull(ChainX.of("").orElseThrowGet(AssertionError::new));
        ChainX.empty().orElseThrowGet(NoSuchElementException::new);
    }

    @Test
    public void checkGet() {
        assertNotNull(ChainX.of("").get());
        assertNull(ChainX.empty().get());
    }

    @Test
    public void checkEquals() {
        assertEquals(ChainX.empty(), ChainX.empty());
        assertNotEquals(ChainX.empty(), null);
        assertNotEquals(ChainX.empty(), new Object());
        assertEquals(ChainX.of(""), ChainX.of(""));
        assertNotEquals(ChainX.of("1"), ChainX.of("2"));
    }

    @Test
    public void checkHashCode() {
        assertEquals("".hashCode(), ChainX.of("").hashCode());
        assertEquals(0, ChainX.empty().hashCode());
    }

    @Test
    public void checkToString() {
        assertEquals("ChainX[1]", ChainX.of(1).toString());
        assertEquals("ChainX.empty", ChainX.empty().toString());
    }
}