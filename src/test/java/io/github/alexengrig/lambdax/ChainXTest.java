package io.github.alexengrig.lambdax;

import io.github.alexengrig.lambdax.function.OptionalResultFunction;
import io.github.alexengrig.lambdax.function.PredicateX;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    private final OptionalResultFunction<String, String> failOptionalFunction = t -> {
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
        chain = chain.flatMap((String s) -> ChainX.of(s + "1"));
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
        chain = chain.flatMap((String s) -> Optional.of(s + "1"));
        assertFalse(chain.isNull());
        chain = chain.filter(String::isEmpty);
        assertTrue(chain.isNull());
        chain = chain.flatMap(failOptionalFunction);
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
        assertNotNull(ChainX.of("").orElseThrow((Supplier<AssertionError>) AssertionError::new));
        ChainX.empty().orElseThrow((Supplier<NoSuchElementException>) NoSuchElementException::new);
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