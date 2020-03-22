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

import io.github.alexengrig.lambdax.function.OptionalResultFunction;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A value container which may manipulate its value.
 * <p>All methods, except {@link #mutate(Consumer)}, are pure functions.
 *
 * @param <T> the type of value
 * @author Grig Alex
 * @version 0.4.0
 * @see java.util.Optional
 * @see java.util.stream.Stream
 * @since 0.4.0
 */
public class ChainX<T> {
    /**
     * Common instance for {@code empty()}.
     *
     * @see io.github.alexengrig.lambdax.ChainX#empty()
     * @since 0.4.0
     */
    protected static final ChainX<?> EMPTY = new ChainX<>();

    /**
     * Stored value.
     *
     * @since 0.4.0
     */
    protected final T value;

    /**
     * Constructs an empty instance.
     *
     * @since 0.4.0
     */
    protected ChainX() {
        this.value = null;
    }

    /**
     * Constructs an instance with the stored value.
     *
     * @param value the value to store
     * @since 0.4.0
     */
    protected ChainX(T value) {
        this.value = value;
    }

    /**
     * Returns an empty {@code ChainX} instance with value is {@code null}.
     *
     * @param <T> the type of value
     * @return An empty {@code ChainX}
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T> ChainX<T> empty() {
        return (ChainX<T>) EMPTY;
    }

    /**
     * Returns an {@code ChainX} storing the given nullable value.
     *
     * @param value the nullable value to store
     * @param <T>   the type of the {@code value}
     * @return A {@code ChainX} with the {@code value}
     * @since 0.4.0
     */
    public static <T> ChainX<T> of(T value) {
        return new ChainX<>(value);
    }

    /**
     * Returns an {@code ChainX} storing the nullable obtained value from the value producer.
     *
     * @param producer the producer of the nullable value to store
     * @param <T>      the type of the nullable obtained value from the {@code producer}
     * @return A {@code ChainX} with the nullable obtained value from {@code producer}
     * @since 0.4.0
     */
    public static <T> ChainX<T> of(Supplier<? extends T> producer) {
        return new ChainX<>(producer.get());
    }


    /**
     * Returns an {@code ChainX} storing the nullable obtained value from the {@code Optional}.
     *
     * @param optional the {@code Optional} of the nullable value to store
     * @param <T>      the type of the nullable obtained value from the {@code optional}
     * @return A {@code ChainX} with the nullable obtained value from {@code optional}
     * @since 0.4.0
     */
    @SuppressWarnings({"unchecked", "OptionalUsedAsFieldOrParameterType"})
    public static <T> ChainX<T> of(Optional<? extends T> optional) {
        return (ChainX<T>) optional.map(ChainX::new).orElseGet(ChainX::empty);
    }

    /**
     * Returns the stored value.
     *
     * @return The stored value
     * @since 0.4.0
     */
    public T get() {
        return value;
    }

    /**
     * If a value is {@code null}, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if a value is {@code null}, otherwise {@code false}
     * @since 0.4.0
     */
    public boolean isNull() {
        return value == null;
    }

    /**
     * If a value is not {@code null}, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if a value is not {@code null}, otherwise {@code false}
     * @since 0.4.0
     */
    public boolean nonNull() {
        return value != null;
    }

    public ChainX<T> filter(Predicate<? super T> predicate) {
        if (isNull() || predicate.test(value)) {
            return this;
        }
        return empty();
    }

    public ChainX<T> mutate(Consumer<? super T> mutator) {
        if (nonNull()) {
            mutator.accept(value);
        }
        return this;
    }

    public <R> ChainX<R> map(Function<? super T, ? extends R> mapper) {
        if (nonNull()) {
            return of(mapper.apply(value));
        }
        return empty();
    }

    @SuppressWarnings("unchecked")
    public <R> ChainX<R> flatMap(Function<? super T, ? extends ChainX<? extends R>> mapper) {
        if (nonNull()) {
            return (ChainX<R>) mapper.apply(value);
        }
        return empty();
    }

    @SuppressWarnings("unchecked")
    public <R> ChainX<R> flatMap(OptionalResultFunction<? super T, ? extends R> mapper) {
        if (nonNull()) {
            final Optional<R> optional = (Optional<R>) mapper.apply(value);
            return optional.map(ChainX::of).orElseGet(ChainX::empty);
        }
        return empty();
    }

    @SuppressWarnings("unchecked")
    public ChainX<T> or(ChainX<? extends T> chain) {
        if (isNull()) {
            return (ChainX<T>) chain;
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    public ChainX<T> or(Supplier<? extends ChainX<? extends T>> producer) {
        if (isNull()) {
            return (ChainX<T>) producer.get();
        }
        return this;
    }

    public Stream<T> stream() {
        return nonNull() ? Stream.of(value) : Stream.empty();
    }

    public Optional<T> optional() {
        return nonNull() ? Optional.of(value) : Optional.empty();
    }

    public T orElse(T other) {
        return nonNull() ? value : other;
    }

    public T orElseGet(Supplier<? extends T> producer) {
        return nonNull() ? value : producer.get();
    }

    public T orElseThrow() {
        if (nonNull()) {
            return value;
        }
        throw new NoSuchElementException("No value present");
    }

    public <X extends Throwable> T orElseThrow(X throwable) throws X {
        if (nonNull()) {
            return value;
        }
        throw throwable;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> producer) throws X {
        if (nonNull()) {
            return value;
        }
        throw producer.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChainX<?> other = (ChainX<?>) o;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        return nonNull() ? "ChainX[" + value + "]" : "ChainX.empty";
    }
}
