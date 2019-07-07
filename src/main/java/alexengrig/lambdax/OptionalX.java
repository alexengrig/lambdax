package alexengrig.lambdax;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * This utility class contains useful lambdas for {@link Optional}
 *
 * @author Grig Alex
 * @see Optional
 * @see Consumer
 * @see UnaryOperator
 * @since 0.1.0
 */
public final class OptionalX {
    private OptionalX() {
    }

    public static <T> Optional<T> of(Supplier<? extends T> generator) {
        return Optional.ofNullable(generator.get());
    }

    public static <T> Function<T, T> peek(Consumer<? super T> action) {
        return t -> {
            action.accept(t);
            return t;
        };
    }
}