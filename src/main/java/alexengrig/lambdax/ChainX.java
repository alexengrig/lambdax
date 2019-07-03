package alexengrig.lambdax;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class ChainX<T> {
    private static final ChainX<?> EMPTY = new ChainX<>();

    private final T value;

    private ChainX() {
        this.value = null;
    }

    public ChainX(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> ChainX<T> empty() {
        @SuppressWarnings("unchecked")
        ChainX<T> empty = (ChainX<T>) EMPTY;
        return empty;
    }

    public static <T> ChainX<T> of(T value) {
        return new ChainX<>(value);
    }

    public static <T> ChainX<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        } else {
            return value;
        }
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public void ifPresent(Consumer<? super T> action) {
        if (isPresent()) {
            action.accept(value);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
        if (value != null) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }

    public ChainX<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (isEmpty()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

    public ChainX<T> peek(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        if (isEmpty()) {
            return empty();
        } else {
            action.accept(value);
            return this;
        }
    }

    public <U> ChainX<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (isEmpty()) {
            return empty();
        } else {
            return ChainX.ofNullable(mapper.apply(value));
        }
    }

    public <U> ChainX<U> flatMap(Function<? super T, ? extends ChainX<? extends U>> mapper) {
        Objects.requireNonNull(mapper);
        if (isEmpty()) {
            return empty();
        } else {
            @SuppressWarnings("unchecked")
            ChainX<U> target = (ChainX<U>) mapper.apply(value);
            return Objects.requireNonNull(target);
        }
    }

    public ChainX<T> or(Supplier<? extends ChainX<? extends T>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) {
            return this;
        } else {
            @SuppressWarnings("unchecked")
            ChainX<T> target = (ChainX<T>) supplier.get();
            return Objects.requireNonNull(target);
        }
    }

    public Stream<T> stream() {
        if (isEmpty()) {
            return Stream.empty();
        } else {
            return Stream.of(value);
        }
    }

    public T orElse(T other) {
        return isPresent() ? value : other;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        return isPresent() ? value : supplier.get();
    }

    public T orElseThrow() {
        if (isEmpty()) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) throws X {
        if (isPresent()) {
            return value;
        } else {
            throw supplier.get();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChainX)) {
            return false;
        }
        ChainX<?> other = (ChainX<?>) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return isPresent()
                ? String.format("ChainX[%s]", value)
                : "ChainX.empty";
    }
}
