package alexengrig.lambdax.collection;

import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link Set}
 *
 * @author Grig Alex
 * @see Set
 * @see Collection
 * @see Consumer
 * @see Function
 * @see IntFunction
 * @see Predicate
 * @since 0.1.0
 */
public final class SetX {
    private SetX() {
    }

    public static <E> Predicate<Set<? extends E>> contains(E item) {
        return s -> s.contains(item);
    }

    public static <E> Predicate<Set<? extends E>> containsAll(Collection<? extends E> all) {
        return s -> s.containsAll(all);
    }

    public static <E> Predicate<Set<? super E>> add(E item) {
        return s -> s.add(item);
    }

    public static <E> Predicate<Set<? super E>> addAll(Collection<? extends E> all) {
        return s -> s.addAll(all);
    }

    public static <E> Consumer<Set<? super E>> onlyAdd(E item) {
        return s -> s.add(item);
    }

    public static <E> Consumer<Set<? super E>> onlyAddAll(Collection<? extends E> all) {
        return s -> s.addAll(all);
    }

    public static <E> Predicate<Set<? super E>> remove(E item) {
        return s -> s.remove(item);
    }

    public static <E> Predicate<Set<? super E>> removeAll(Collection<? extends E> all) {
        return s -> s.removeAll(all);
    }

    public static <E> Consumer<Set<? super E>> onlyRemove(E item) {
        return s -> s.remove(item);
    }

    public static <E> Consumer<Set<? super E>> onlyRemoveAll(Collection<? extends E> all) {
        return s -> s.removeAll(all);
    }

    public static <E> Predicate<Set<? super E>> retainAll(Collection<? extends E> all) {
        return s -> s.retainAll(all);
    }

    public static <E> Consumer<Set<? super E>> onlyRetainAll(Collection<? extends E> all) {
        return s -> s.retainAll(all);
    }

    public static <E> Function<Set<? extends E>, E[]> toArray(E[] array) {
        return c -> c.toArray(array);
    }

    public static <E> Function<Set<? extends E>, E[]> toArray(IntFunction<? extends E[]> generator) {
        return c -> c.toArray(generator.apply(0));
    }

    public static <E> Predicate<Set<? extends E>> equalsTo(Object other) {
        return c -> c.equals(other);
    }
}
