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

import io.github.alexengrig.lambdax.entity.Ref;
import io.github.alexengrig.lambdax.exception.ExpectedException;
import io.github.alexengrig.lambdax.exception.UnexpectedException;
import io.github.alexengrig.lambdax.function.PredicateX;
import io.github.alexengrig.lambdax.function.ThrowableFunction;
import org.junit.Assert;
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
    private final Consumer<String[]> failConsumer = t -> fail("Fail consumer");
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
    private final ThrowableFunction<String, String, AssertionError> failThrowableFunction = t -> {
        fail("Fail throwable function");
        return t;
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
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilter() {
        assertTrue(ChainX.of("string").tryFilter(String::isEmpty).isNull());
        assertTrue(ChainX.of("").tryFilter(v -> v.substring(-1).isEmpty()).nonNull());
        assertTrue(ChainX.<String>empty().tryFilter(v -> {
            fail();
            return true;
        }).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterWithCatcher() {
        final Ref<IndexOutOfBoundsException> refIndexOutOfBoundsException = new Ref<>();
        assertTrue(ChainX.of("string")
                .tryFilter(String::isEmpty, refIndexOutOfBoundsException::set).isNull());
        assertNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.of("")
                .tryFilter(v -> v.substring(-1).isEmpty(), refIndexOutOfBoundsException::set).nonNull());
        assertNotNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.<String>empty().tryFilter(v -> {
            fail();
            return true;
        }, e -> fail()).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterOrEmpty() {
        assertTrue(ChainX.of("string").tryFilterOrEmpty(String::isEmpty).isNull());
        assertTrue(ChainX.of("").tryFilterOrEmpty(v -> v.substring(-1).isEmpty()).isNull());
        assertTrue(ChainX.<String>empty().tryFilterOrEmpty(v -> {
            fail();
            return true;
        }).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterOrEmptyWithCatcher() {
        final Ref<IndexOutOfBoundsException> refIndexOutOfBoundsException = new Ref<>();
        assertTrue(ChainX.of("string")
                .tryFilterOrEmpty(String::isEmpty, refIndexOutOfBoundsException::set).isNull());
        assertNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.of("")
                .tryFilterOrEmpty(v -> v.substring(-1).isEmpty(), refIndexOutOfBoundsException::set).isNull());
        assertNotNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.<String>empty().tryFilterOrEmpty(v -> {
            fail();
            return true;
        }, e -> fail()).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterOrElse() {
        assertTrue(ChainX.of("string").tryFilterOrElse(String::isEmpty, false).isNull());
        assertTrue(ChainX.of("").tryFilterOrElse(v -> v.substring(-1).isEmpty(), false).isNull());
        assertTrue(ChainX.of("").tryFilterOrElse(v -> v.substring(-1).isEmpty(), true).nonNull());
        assertTrue(ChainX.<String>empty().tryFilterOrElse(v -> {
            fail();
            return true;
        }, false).isNull());
        assertTrue(ChainX.<String>empty().tryFilterOrElse(v -> {
            fail();
            return true;
        }, true).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterOrElseWithCatcher() {
        final Ref<IndexOutOfBoundsException> refIndexOutOfBoundsException = new Ref<>();
        assertTrue(ChainX.of("string")
                .tryFilterOrElse(String::isEmpty, false, refIndexOutOfBoundsException::set)
                .isNull());
        assertNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.of("")
                .tryFilterOrElse(v -> v.substring(-1).isEmpty(), false, refIndexOutOfBoundsException::set)
                .isNull());
        assertNotNull(refIndexOutOfBoundsException.get());
        refIndexOutOfBoundsException.nullify();
        assertNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.of("")
                .tryFilterOrElse(v -> v.substring(-1).isEmpty(), true, refIndexOutOfBoundsException::set)
                .nonNull());
        assertNotNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.<String>empty().tryFilterOrElse(v -> {
            fail();
            return true;
        }, false, e -> fail()).isNull());
        assertTrue(ChainX.<String>empty().tryFilterOrElse(v -> {
            fail();
            return true;
        }, true, e -> fail()).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterOrGet() {
        assertTrue(ChainX.of("string").tryFilterOrGet(String::isEmpty, () -> false).isNull());
        assertTrue(ChainX.of("").tryFilterOrGet(v -> v.substring(-1).isEmpty(), () -> false).isNull());
        assertTrue(ChainX.of("").tryFilterOrGet(v -> v.substring(-1).isEmpty(), () -> true).nonNull());
        assertTrue(ChainX.<String>empty().tryFilterOrGet(v -> {
            fail();
            return true;
        }, () -> false).isNull());
        assertTrue(ChainX.<String>empty().tryFilterOrGet(v -> {
            fail();
            return true;
        }, () -> true).isNull());
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void checkTryFilterOrGetWithCatcher() {
        final Ref<IndexOutOfBoundsException> refIndexOutOfBoundsException = new Ref<>();
        assertTrue(ChainX.of("string")
                .tryFilterOrGet(String::isEmpty, () -> false, refIndexOutOfBoundsException::set)
                .isNull());
        assertNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.of("")
                .tryFilterOrGet(v -> v.substring(-1).isEmpty(), () -> false, refIndexOutOfBoundsException::set)
                .isNull());
        assertNotNull(refIndexOutOfBoundsException.get());
        refIndexOutOfBoundsException.nullify();
        assertNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.of("")
                .tryFilterOrGet(v -> v.substring(-1).isEmpty(), () -> true, refIndexOutOfBoundsException::set)
                .nonNull());
        assertNotNull(refIndexOutOfBoundsException.get());
        assertTrue(ChainX.<String>empty().tryFilterOrGet(v -> {
            fail();
            return true;
        }, () -> false, e -> fail()).isNull());
        assertTrue(ChainX.<String>empty().tryFilterOrGet(v -> {
            fail();
            return true;
        }, () -> true, e -> fail()).isNull());
    }

    @Test
    public void checkTryMutate() {
        assertTrue(ChainX.of("").tryMutate(t -> fail()).nonNull());
        assertTrue(ChainX.<String>empty().tryMutate(t -> fail()).isNull());
    }

    @Test
    public void checkTryMutateWithCatcher() {
        final Ref<AssertionError> refAssertionError = new Ref<>();
        assertTrue(ChainX.of("").tryMutate(t -> fail(), refAssertionError::set).nonNull());
        assertNotNull(refAssertionError.get());
        assertTrue(ChainX.<String>empty().tryMutate(t -> fail(), e -> fail()).isNull());
    }

    @Test
    public void checkTryMapOrEmpty() {
        assertTrue(ChainX.of("").tryMapOrEmpty(failThrowableFunction).isNull());
        assertTrue(ChainX.of("").tryMapOrEmpty(s -> {
            throw new UnexpectedException();
        }).isNull());
        assertTrue(ChainX.<String>empty().tryMapOrEmpty(failThrowableFunction).isNull());
    }

    @Test
    public void checkTryMapOrEmptyWithCatcher() {
        final Ref<AssertionError> refAssertionError = new Ref<>(null);
        assertTrue(ChainX.of("").tryMapOrEmpty(failThrowableFunction, refAssertionError::set).isNull());
        assertNotNull(refAssertionError.get());
        assertTrue(ChainX.<String>empty().tryMapOrEmpty(failThrowableFunction, e -> fail()).isNull());
        final Ref<ExpectedException> refExpectedException = new Ref<>(null);
        assertTrue(ChainX.of("").tryMapOrEmpty(s -> {
            throw new ExpectedException();
        }, refExpectedException::set).isNull());
        assertNotNull(refExpectedException.get());
    }

    @Test
    public void checkTryMapOrElse() {
        final String expected = "expected";
        assertEquals(expected, ChainX.of("").tryMapOrElse(failThrowableFunction, expected).get());
        assertEquals(expected, ChainX.of("").tryMapOrElse(s -> {
            throw new ExpectedException();
        }, expected).get());
        assertTrue(ChainX.<String>empty().tryMapOrElse(failThrowableFunction, expected).isNull());
    }

    @Test
    public void checkTryMapOrElseWithCatcher() {
        final String expected = "expected";
        final Ref<AssertionError> refAssertionError = new Ref<>();
        assertEquals(expected, ChainX.of("")
                .tryMapOrElse(failThrowableFunction, expected, refAssertionError::set).get());
        assertNotNull(refAssertionError.get());
        final Ref<ExpectedException> refExpectedException = new Ref<>();
        assertEquals(expected, ChainX.of("").tryMapOrElse(s -> {
            throw new ExpectedException();
        }, expected, refExpectedException::set).get());
        assertNotNull(refExpectedException.get());
        assertTrue(ChainX.<String>empty().tryMapOrElse(failThrowableFunction, expected, e -> fail()).isNull());
    }

    @Test
    public void checkTryMapOrGet() {
        final String expected = "expected";
        assertEquals(expected, ChainX.of("").tryMapOrGet(failThrowableFunction, () -> expected).get());
        assertEquals(expected, ChainX.of("").tryMapOrGet(s -> {
            throw new ExpectedException();
        }, () -> expected).get());
        assertTrue(ChainX.<String>empty().tryMapOrGet(failThrowableFunction, () -> {
            fail();
            return "unexpected";
        }).isNull());
    }

    @Test
    public void checkTryMapOrGetWithCatcher() {
        final String expected = "expected";
        final Ref<AssertionError> refAssertionError = new Ref<>();
        assertEquals(expected, ChainX.of("")
                .tryMapOrGet(failThrowableFunction, () -> expected, refAssertionError::set).get());
        assertNotNull(refAssertionError.get());
        final Ref<ExpectedException> refExpectedException = new Ref<>();
        assertEquals(expected, ChainX.of("").tryMapOrGet(s -> {
            throw new ExpectedException();
        }, () -> expected, refExpectedException::set).get());
        assertNotNull(refExpectedException.get());
        assertTrue(ChainX.<String>empty().tryMapOrGet(failThrowableFunction, () -> {
            fail();
            return "unexpected";
        }, e -> fail()).isNull());
    }

    @Test
    public void checkTryMapOrCatch() {
        final String expected = "expected";
        assertEquals(expected, ChainX.of("").tryMapOrCatch(failThrowableFunction, t -> expected).get());
        assertEquals(expected, ChainX.of("").tryMapOrCatch(s -> {
            throw new ExpectedException();
        }, t -> expected).get());
        assertTrue(ChainX.<String>empty().tryMapOrCatch(failThrowableFunction, t -> {
            fail();
            return "unexpected";
        }).isNull());
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

    @Test(expected = ExpectedException.class)
    public void checkOrElseThrowObject() {
        assertNotNull(ChainX.of("").orElseThrow(new AssertionError()));
        ChainX.empty().orElseThrow(new ExpectedException());
    }

    @Test(expected = ExpectedException.class)
    public void checkOrElseThrowSupplier() {
        assertNotNull(ChainX.of("").orElseThrowGet(AssertionError::new));
        ChainX.empty().orElseThrowGet(ExpectedException::new);
    }

    @Test(expected = ExpectedException.class)
    public void checkIfNull() {
        ChainX.of("").ifNull(Assert::fail);
        ChainX.empty().ifNull(() -> {
            throw new ExpectedException();
        });
    }

    @Test(expected = ExpectedException.class)
    public void checkIfNonNull() {
        ChainX.empty().ifNonNull(o -> fail());
        ChainX.of("").ifNonNull(o -> {
            throw new ExpectedException();
        });
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