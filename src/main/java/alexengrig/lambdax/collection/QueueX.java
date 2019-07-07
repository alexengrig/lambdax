package alexengrig.lambdax.collection;

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
