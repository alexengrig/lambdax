package alexengrig.lambdax;

import alexengrig.lambdax.collection.DequeX;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class OptionalXTest {
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