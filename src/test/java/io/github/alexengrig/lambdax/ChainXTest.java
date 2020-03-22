package io.github.alexengrig.lambdax;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChainXTest {
    @Test
    public void checkOfObject() {
        final ChainX<String> chain = ChainX.of("");
        assertTrue("Chain is present from value", chain.nonNull());
    }

    @Test
    public void checkOfSupplier() {
        final ChainX<String> chain = ChainX.of(() -> "");
        assertTrue("Chain is present from supplier", chain.nonNull());
    }
}