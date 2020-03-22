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

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Chainer.
 *
 * @author Grig Alex
 * @version 0.5.0
 * @since 0.5.0
 */
public class ChainX<T> implements Supplier<T> {
    protected static final ChainX<?> EMPTY = new ChainX<>();

    protected final T value;

    protected ChainX() {
        this.value = null;
    }

    protected ChainX(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static <T> ChainX<T> empty() {
        return (ChainX<T>) EMPTY;
    }

    public static <T> ChainX<T> of(T value) {
        return new ChainX<>(value);
    }

    public static <T> ChainX<T> of(Supplier<? extends T> producer) {
        return new ChainX<>(producer.get());
    }

    @SuppressWarnings({"unchecked", "OptionalUsedAsFieldOrParameterType"})
    public static <T> ChainX<T> ofOptional(Optional<? extends T> optional) {
        return (ChainX<T>) optional.map(ChainX::new).orElseGet(ChainX::empty);
    }

    public boolean isNull() {
        return value == null;
    }

    public boolean nonNull() {
        return value != null;
    }

    public ChainX<T> filter(Predicate<? super T> predicate) {
        if (isNull() || predicate.test(value)) {
            return this;
        }
        return empty();
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
    public <R> ChainX<R> flatMapOptional(Function<? super T, ? extends Optional<? extends R>> mapper) {
        if (nonNull()) {
            final Optional<R> optional = (Optional<R>) mapper.apply(value);
            return optional.map(ChainX::of).orElseGet(ChainX::empty);
        }
        return empty();
    }

    public ChainX<T> mutate(Consumer<? super T> mutator) {
        if (nonNull()) {
            mutator.accept(value);
        }
        return this;
    }

    public Optional<T> optional() {
        return nonNull() ? Optional.of(value) : Optional.empty();
    }

    public Stream<T> stream() {
        return nonNull() ? Stream.of(value) : Stream.empty();
    }

    @SuppressWarnings("unchecked")
    public ChainX<T> or(Supplier<? extends ChainX<? extends T>> producer) {
        if (isNull()) {
            return (ChainX<T>) producer.get();
        }
        return this;
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
    public T get() {
        return value;
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
