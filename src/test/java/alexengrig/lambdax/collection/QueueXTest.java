package alexengrig.lambdax.collection;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class QueueXTest {
    @Test
    public void checkAdd() {
        int value = 1;
        Queue<Number> numbers = new ArrayDeque<>();
        Predicate<Queue<? super Number>> addValue = QueueX.add(value);
        assertTrue(addValue.test(numbers));
    }

    @Test
    public void checkOnlyAdd() {
        int value = 2;
        Queue<Number> numbers = new ArrayDeque<>();
        Consumer<Queue<? super Number>> onlyAddValue = QueueX.onlyAdd(value);
        onlyAddValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }

    @Test
    public void checkOffer() {
        int value = 3;
        Queue<Number> numbers = new ArrayDeque<>();
        Predicate<Queue<? super Number>> offerValue = QueueX.offer(value);
        assertTrue(offerValue.test(numbers));
    }

    @Test
    public void checkOnlyOffer() {
        int value = 4;
        Queue<Number> numbers = new ArrayDeque<>();
        Consumer<Queue<? super Number>> onlyOfferValue = QueueX.onlyOffer(value);
        onlyOfferValue.accept(numbers);
        assertTrue(numbers.contains(value));
    }
}