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

import io.github.alexengrig.lambdax.function.ThrowableConsumer;
import io.github.alexengrig.lambdax.function.ThrowableFunction;
import io.github.alexengrig.lambdax.function.ThrowablePredicate;

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
 * <p>All methods,
 * except {@link #mutate(Consumer)},
 * {@link #tryMutate(ThrowableConsumer)} and {@link #tryMutate(ThrowableConsumer, Consumer)},
 * are pure functions.
 *
 * @param <T> the type of value
 * @author Grig Alex
 * @version 0.5.0
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

//    Create

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
     * @throws NullPointerException if {@code producer} is {@code null}
     * @since 0.4.0
     */
    public static <T> ChainX<T> of(Supplier<? extends T> producer) {
        return new ChainX<>(producer.get());
    }

    /**
     * Returns an {@code ChainX} storing the nullable obtained value from the {@link java.util.Optional}.
     *
     * @param optional the {@link java.util.Optional} of the nullable value to store
     * @param <T>      the type of the nullable obtained value from the {@link java.util.Optional}
     * @return A {@code ChainX} with the nullable obtained value from {@link java.util.Optional}
     * @throws NullPointerException if {@code optional} is {@code null}
     * @see java.util.Optional
     * @since 0.4.0
     */
    @SuppressWarnings({"unchecked", "OptionalUsedAsFieldOrParameterType"})
    public static <T> ChainX<T> of(Optional<? extends T> optional) {
        return (ChainX<T>) Objects.requireNonNull(optional, "Passed Optional is null")
                .map(ChainX::new).orElseGet(ChainX::empty);
    }

//    Check

    /**
     * If a value is {@code null}, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if a value is {@code null}, otherwise {@code false}
     * @since 0.4.0
     */
    public final boolean isNull() {
        return value == null;
    }

    /**
     * If a value is not {@code null}, returns {@code true}, otherwise {@code false}.
     *
     * @return {@code true} if a value is not {@code null}, otherwise {@code false}
     * @since 0.4.0
     */
    public final boolean nonNull() {
        return value != null;
    }

//    Flow

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null}
     * @see java.util.function.Predicate
     * @since 0.4.0
     */
    public ChainX<T> filter(Predicate<? super T> predicate) {
        if (isNull() || predicate.test(value)) {
            return this;
        }
        return empty();
    }

    /**
     * Returns this {@code ChainX},
     * if a value is not {@code null}, the given consumer function updates the value.
     *
     * <p>ATTENTION: This method mutates the value.
     *
     * @param mutator the consumer function to accept to a value, if not {@code null}
     * @return this {@code ChainX} storing the updates value
     * @throws NullPointerException if value is not {@code null} and {@code mutator} is {@code null}
     * @see java.util.function.Consumer
     * @since 0.4.0
     */
    public ChainX<T> mutate(Consumer<? super T> mutator) {
        if (nonNull()) {
            mutator.accept(value);
        }
        return this;
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param <R>    the type of the value returned from the mapping function
     * @return a {@code ChainX} storing the result of applying a mapping
     * function to the value of this {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null}
     * @since 0.4.0
     */
    public <R> ChainX<R> map(Function<? super T, ? extends R> mapper) {
        if (nonNull()) {
            return of(mapper.apply(value));
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>This method is similar to {@link #map(Function)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param <R>    the type of value of the {@code ChainX} returned by the mapping function
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX}, if a value is not {@code null}, otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public <R> ChainX<R> flatMap(Function<? super T, ? extends ChainX<? extends R>> mapper) {
        if (nonNull()) {
            return (ChainX<R>) mapper.apply(value);
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@link java.util.Optional}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param <R>    the type of value of the {@link java.util.Optional} returned by the mapping function
     * @return the result of applying a {@link java.util.Optional}-bearing mapping
     * function to the value of this {@code ChainX}, if a value is not {@code null}, otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null}
     * @see java.util.function.Function
     * @see java.util.Optional
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public <R> ChainX<R> flatMapOptional(Function<? super T, ? extends Optional<? extends R>> mapper) {
        if (nonNull()) {
            final Optional<R> optional = (Optional<R>) mapper.apply(value);
            return optional.map(ChainX::of).orElseGet(ChainX::empty);
        }
        return empty();
    }

//    Try

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * returns this {@code ChainX} storing the value.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception,
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    public <X extends Throwable> ChainX<T> tryFilter(ThrowablePredicate<? super T, ? super X> predicate) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable ignore) {
            return this;
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * passes an exception to the given exception consumer and
     * returns this {@code ChainX} storing the value.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param catcher   the consumer to accept to an exception,
     *                  if {@code predicate} throws the exception
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null},
     *                              or {@code cathcer} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <X extends Throwable> ChainX<T> tryFilter(
            ThrowablePredicate<? super T, ? super X> predicate, Consumer<? super X> catcher) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable throwable) {
            catcher.accept((X) throwable);
            return this;
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * otherwise an empty {@code ChainX};
     * an empty {@code ChainX} if {@code predicate} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    public <X extends Throwable> ChainX<T> tryFilterOrEmpty(ThrowablePredicate<? super T, ? super X> predicate) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable ignore) {
            return empty();
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * passes an exception to the given exception consumer and
     * returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param catcher   the consumer to accept to an exception,
     *                  if {@code predicate} throws the exception
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * otherwise an empty {@code ChainX};
     * an empty {@code ChainX} if {@code predicate} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null},
     *                              or {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <X extends Throwable> ChainX<T> tryFilterOrEmpty(
            ThrowablePredicate<? super T, ? super X> predicate, Consumer<? super X> catcher) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable throwable) {
            catcher.accept((X) throwable);
            return empty();
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception and {@code result} is {@code true},
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param result    the answer to the question "return this {@code ChainX} in case of exception?"
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception and
     * {@code result} is {@code true},
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    public <X extends Throwable> ChainX<T> tryFilterOrElse(
            ThrowablePredicate<? super T, ? super X> predicate, boolean result) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable ignore) {
            if (result) {
                return this;
            }
            return empty();
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * passes an exception to given exception consumer,
     * and if {@code result} is {@code true},
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param catcher   the consumer to accept to an exception,
     *                  if {@code predicate} throws the exception
     * @param result    the answer to the question "return this {@code ChainX} in case of exception?"
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception and
     * {@code result} is {@code true},
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null},
     *                              or {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <X extends Throwable> ChainX<T> tryFilterOrElse(
            ThrowablePredicate<? super T, ? super X> predicate, boolean result, Consumer<? super X> catcher) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable throwable) {
            catcher.accept((X) throwable);
            if (result) {
                return this;
            }
            return empty();
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception and
     * a value produced by the supplying function is {@code true},
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param producer  the supplying function that produces
     *                  an answer to the question "return this {@code ChainX} in case of exception?"
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception and
     * a value produced by {@code producer} is {@code true},
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null},
     *                              or {@code predicate} throws an exception and {@code producer} is {@code null}
     * @see java.util.function.Supplier
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    public <X extends Throwable> ChainX<T> tryFilterOrGet(
            ThrowablePredicate<? super T, ? super X> predicate, Supplier<Boolean> producer) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable ignore) {
            if (producer.get()) {
                return this;
            }
            return empty();
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * passes an exception to given exception consumer,
     * and if a value produced by the supplying function is {@code true},
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param producer  the supplying function that produces
     *                  an answer to the question "return this {@code ChainX} in case of exception?"
     * @param catcher   the consumer to accept to an exception,
     *                  if {@code predicate} throws the exception
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception and
     * a value produced by {@code producer} is {@code true},
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null},
     *                              or {@code predicate} throws an exception and,
     *                              {@code producer} is {@code null} or {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see java.util.function.Supplier
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <X extends Throwable> ChainX<T> tryFilterOrGet(
            ThrowablePredicate<? super T, ? super X> predicate, Supplier<Boolean> producer,
            Consumer<? super X> catcher) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable throwable) {
            catcher.accept((X) throwable);
            if (producer.get()) {
                return this;
            }
            return empty();
        }
    }

    /**
     * If the value is not {@code null},
     * and the value matches the given predicate,
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given predicate throws an exception,
     * passes an exception to given exception predicate,
     * and if the returning value is {@code true},
     * returns this {@code ChainX} storing the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * @param predicate the predicate to apply to a value, if not {@code null}
     * @param catcher   the predicate to accept to an exception,
     *                  if {@code predicate} throws the exception and
     *                  produces an answer to the question "return this {@code ChainX} in case of exception?"
     * @param <X>       the type of exception
     * @return this {@code ChainX} storing the value,
     * if the value is not {@code null} and
     * the value matches {@code predicate},
     * or {@code predicate} throws an exception and
     * a value produced by {@code catcher} is {@code true},
     * otherwise an empty {@code ChainX};
     * @throws NullPointerException if value is not {@code null} and {@code predicate} is {@code null},
     *                              or {@code predicate} throws an exception and {@code catcher} is {@code null}
     * @see java.util.function.Predicate
     * @see io.github.alexengrig.lambdax.function.ThrowablePredicate
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <X extends Throwable> ChainX<T> tryFilterOrCatch(
            ThrowablePredicate<? super T, ? super X> predicate, Predicate<? super X> catcher) {
        try {
            if (isNull() || predicate.test(value)) {
                return this;
            }
            return empty();
        } catch (Throwable throwable) {
            if (catcher.test((X) throwable)) {
                return this;
            }
            return empty();
        }
    }

    /**
     * Returns this {@code ChainX},
     * if a value is not {@code null}, the given consumer function updates the value.
     *
     * <p>
     * If the given consumer function throws an exception,
     * ignores the exception.
     *
     * <p>
     * ATTENTION: This method mutates the value.
     *
     * @param mutator the consumer function to accept to a value, if not {@code null}
     * @param <X>     the type of exception
     * @return this {@code ChainX} storing the updates value
     * @throws NullPointerException if value is not {@code null} and {@code mutator} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowableConsumer
     * @since 0.5.0
     */
    public <X extends Throwable> ChainX<T> tryMutate(ThrowableConsumer<? super T, ? super X> mutator) {
        if (nonNull()) {
            try {
                mutator.accept(value);
            } catch (Throwable ignore) {
            }
        }
        return this;
    }

    /**
     * Returns this {@code ChainX},
     * if a value is not {@code null}, the given consumer function updates the value.
     *
     * <p>
     * If the given consumer function throws an exception,
     * passes the exception to the given exception consumer.
     *
     * <p>
     * ATTENTION: This method mutates the value.
     *
     * @param mutator the consumer function to accept to a value, if not {@code null}
     * @param <X>     the type of exception
     * @return this {@code ChainX} storing the updates value
     * @throws NullPointerException if value is not {@code null} and {@code mutator} is {@code null},
     *                              or {@code mutator} throws an exception and {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowableConsumer
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <X extends Throwable> ChainX<T> tryMutate(
            ThrowableConsumer<? super T, ? super X> mutator, Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                mutator.accept(value);
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
            }
        }
        return this;
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * returns an empty {@code ChainX}.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param <R>    the type of the value returned from the mapping function
     * @param <X>    the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    public <R, X extends Throwable> ChainX<R> tryMapOrEmpty(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable ignore) {
                return empty();
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception consumer and
     * returns an empty {@code ChainX}.
     *
     * @param mapper  the mapping function to apply to a value, if not {@code null}
     * @param catcher the consumer to accept to an exception,
     *                if {@code mapper} throws the exception
     * @param <R>     the type of the value returned from the mapping function
     * @param <X>     the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryMapOrEmpty(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper, Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
                return empty();
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * returns a {@code ChainX} storing (as if by {@link #of}) the given value.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param other  the value in case of exception
     * @param <R>    the type of the value returned from the mapping function
     * @param <X>    the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} storing {@code other},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    public <R, X extends Throwable> ChainX<R> tryMapOrElse(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper, R other) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable ignore) {
                return of(other);
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception consumer and
     * returns a {@code ChainX} storing (as if by {@link #of}) the given value.
     *
     * @param mapper  the mapping function to apply to a value, if not {@code null}
     * @param other   the value in case of exception
     * @param catcher the consumer to accept to an exception,
     *                if {@code mapper} throws the exception
     * @param <R>     the type of the value returned from the mapping function
     * @param <X>     the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} storing {@code other},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryMapOrElse(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper, R other, Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
                return of(other);
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * returns a {@code ChainX} storing (as if by {@link #of}) a value produced by the given supplying function.
     *
     * @param mapper   the mapping function to apply to a value, if not {@code null}
     * @param producer the supplying function that produces a value in case of exception
     * @param <R>      the type of the value returned from the mapping function
     * @param <X>      the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} storing a value produced by {@code producer},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and {@code producer} is {@code null}
     * @see java.util.function.Supplier
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    public <R, X extends Throwable> ChainX<R> tryMapOrGet(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper, Supplier<? extends R> producer) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable ignore) {
                return of(producer.get());
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception consumer and
     * returns a {@code ChainX} storing (as if by {@link #of}) a value produced by the given supplying function.
     *
     * @param mapper   the mapping function to apply to a value, if not {@code null}
     * @param producer the supplying function that produces a value in case of exception
     * @param catcher  the consumer to accept to an exception,
     *                 if {@code mapper} throws the exception
     * @param <R>      the type of the value returned from the mapping function
     * @param <X>      the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} storing a value produced by {@code producer},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and,
     *                              {@code producer} is {@code null} or {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see java.util.function.Supplier
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryMapOrGet(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper, Supplier<? extends R> producer,
            Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
                return of(producer.get());
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns a {@code ChainX} storing (as if by {@link #of}) the result of applying
     * the given mapping function to the value, otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception function and
     * returns a {@code ChainX} storing (as if by {@link #of}) the returning value.
     *
     * @param mapper  the mapping function to apply to a value, if not {@code null}
     * @param catcher the function to accept to an exception and
     *                to return a value for {@code ChainX} storing,
     *                if {@code mapper} throws the exception
     * @param <R>     the type of the value returned from the mapping function
     * @param <X>     the type of exception
     * @return a {@code ChainX} storing the result of {@code mapper} to the value of this {@code ChainX},
     * if the value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} storing a value produced by {@code catcher},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and {@code catcher} is {@code null}
     * @see java.util.function.Function
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryMapOrCatch(
            ThrowableFunction<? super T, ? extends R, ? extends X> mapper, Function<? super X, ? extends R> catcher) {
        if (nonNull()) {
            try {
                return of(mapper.apply(value));
            } catch (Throwable throwable) {
                return of(catcher.apply((X) throwable));
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * returns an empty {@code ChainX}.
     *
     * <p>
     * This method is similar to {@link #tryMapOrEmpty(ThrowableFunction)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param <R>    the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>    the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrEmpty(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable ignore) {
                return empty();
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception consumer and
     * returns an empty {@code ChainX}.
     *
     * <p>
     * This method is similar to {@link #tryMapOrEmpty(ThrowableFunction, Consumer)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper  the mapping function to apply to a value, if not {@code null}
     * @param catcher the consumer to accept to an exception,
     *                if {@code mapper} throws the exception
     * @param <R>     the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>     the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX}
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and {@code catcher} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrEmpty(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper,
            Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
                return empty();
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * returns the given {@code ChainX}.
     *
     * <p>
     * This method is similar to {@link #tryMapOrElse(ThrowableFunction, Object)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper the mapping function to apply to a value, if not {@code null}
     * @param other  the resulting {@code ChainX} in case of exception
     * @param <R>    the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>    the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * {@code other}, if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and {@code other} is {@code null}
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrElse(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper, ChainX<R> other) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable ignore) {
                return Objects.requireNonNull(other, "The other ChainX must not be null");
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception consumer and
     * returns the given {@code ChainX}.
     *
     * <p>
     * This method is similar to {@link #tryMapOrElse(ThrowableFunction, Object, Consumer)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper  the mapping function to apply to a value, if not {@code null}
     * @param other   the resulting {@code ChainX} in case of exception
     * @param catcher the consumer to accept to an exception,
     *                if {@code mapper} throws the exception
     * @param <R>     the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>     the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * {@code other}, if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and,
     *                              {@code catcher} is {@code null} or {@code other} is {@code null}
     * @see java.util.function.Consumer
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrElse(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper, ChainX<R> other,
            Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
                return Objects.requireNonNull(other, "The other ChainX must not be null");
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * returns a {@code ChainX} produced by the given supplying function.
     *
     * <p>
     * This method is similar to {@link #tryMapOrGet(ThrowableFunction, Supplier)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper   the mapping function to apply to a value, if not {@code null}
     * @param producer the supplying function that produces a {@code ChainX} in case of exception
     * @param <R>      the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>      the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} produced by {@code producer},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and,
     *                              {@code producer} is {@code null} or {@code producer} result is {@code null}
     * @see java.util.function.Supplier
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrGet(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper,
            Supplier<? extends ChainX<R>> producer) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable ignore) {
                return Objects.requireNonNull(producer.get(), "The resulting ChainX must not be null");
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception consumer and
     * returns a {@code ChainX} produced by the given supplying function.
     *
     * <p>
     * This method is similar to {@link #tryMapOrGet(ThrowableFunction, Supplier, Consumer)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper   the mapping function to apply to a value, if not {@code null}
     * @param producer the supplying function that produces a {@code ChainX} in case of exception
     * @param catcher  the consumer to accept to an exception,
     *                 if {@code mapper} throws the exception
     * @param <R>      the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>      the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} produced by {@code producer},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and, {@code catcher} is {@code null} or
     *                              {@code producer} is {@code null} or {@code producer} result is {@code null}
     * @see java.util.function.Consumer
     * @see java.util.function.Supplier
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrGet(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper,
            Supplier<? extends ChainX<R>> producer, Consumer<? super X> catcher) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable throwable) {
                catcher.accept((X) throwable);
                return Objects.requireNonNull(producer.get(), "The resulting ChainX must not be null");
            }
        }
        return empty();
    }

    /**
     * If a value is not {@code null},
     * returns the result of applying the given {@code ChainX}-bearing mapping function to the value,
     * otherwise returns an empty {@code ChainX}.
     *
     * <p>
     * If the given mapping function throws an exception,
     * passes the exception to the given exception function and
     * returns the returning {@code ChainX}.
     *
     * <p>
     * This method is similar to {@link #tryMapOrCatch(ThrowableFunction, Function)},
     * but the mapping function is one whose result is already a {@code ChainX},
     * and if invoked, {@code flatMap} does not wrap it within an additional {@code ChainX}.
     *
     * @param mapper  the mapping function to apply to a value, if not {@code null}
     * @param catcher the function to accept to an exception and
     *                to return an {@code ChainX},
     *                if {@code mapper} throws the exception
     * @param <R>     the type of value of the {@code ChainX} returned by the mapping function
     * @param <X>     the type of exception
     * @return the result of applying a {@code ChainX}-bearing mapping
     * function to the value of this {@code ChainX},
     * if a value is not {@code null} and {@code mapper} does not throw an exception,
     * otherwise an empty {@code ChainX};
     * a {@code ChainX} produced by {@code catcher},
     * if {@code mapper} throws an exception
     * @throws NullPointerException if value is not {@code null} and {@code mapper} is {@code null},
     *                              or {@code mapper} throws an exception and,
     *                              {@code catcher} is {@code null} or {@code catcher} result is {@code null}
     * @see java.util.function.Function
     * @see io.github.alexengrig.lambdax.function.ThrowableFunction
     * @since 0.5.0
     */
    @SuppressWarnings("unchecked")
    public <R, X extends Throwable> ChainX<R> tryFlatMapOrCatch(
            ThrowableFunction<? super T, ? extends ChainX<? extends R>, ? extends X> mapper,
            Function<? super X, ? extends ChainX<R>> catcher) {
        if (nonNull()) {
            try {
                return (ChainX<R>) mapper.apply(value);
            } catch (Throwable throwable) {
                return Objects.requireNonNull(catcher.apply((X) throwable), "The resulting ChainX must not be null");
            }
        }
        return empty();
    }

//    Or

    /**
     * If a value is not {@code null},
     * returns this {@code ChainX} storing the value,
     * otherwise returns the given {@code ChainX}.
     *
     * @param chain the {@code ChainX} to be returned
     * @return returns this {@code ChainX} storing the value of this {@code ChainX},
     * if a value is not {@code null}, otherwise the given {@code ChainX}
     * @throws NullPointerException if value is {@code null} and {@code chain} is {@code null}
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public ChainX<T> or(ChainX<? extends T> chain) {
        if (isNull()) {
            return (ChainX<T>) Objects.requireNonNull(chain, "Passed ChainX is null");
        }
        return this;
    }

    /**
     * If a value is not {@code null},
     * returns this {@code ChainX} storing the value,
     * otherwise returns a {@code ChainX} produced by the producer function.
     *
     * @param producer the supplying function that produces a {@code ChainX} to be returned
     * @return returns this {@code ChainX} storing the value of this {@code ChainX},
     * if a value is not {@code null}, otherwise a {@code ChainX} produced by the supplying function
     * @throws NullPointerException if value is {@code null} and {@code producer} is {@code null}
     * @see java.util.function.Supplier
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public ChainX<T> or(Supplier<? extends ChainX<? extends T>> producer) {
        if (isNull()) {
            return (ChainX<T>) producer.get();
        }
        return this;
    }

//    Value

    /**
     * If a value is not {@code null},
     * returns a sequential {@link Stream} containing only that value,
     * otherwise returns an empty {@code Stream}.
     *
     * @return the value as a {@code Stream}
     * @see java.util.stream.Stream
     * @since 0.4.0
     */
    public Stream<T> stream() {
        return nonNull() ? Stream.of(value) : Stream.empty();
    }

    /**
     * If a value is not {@code null},
     * returns an {@link java.util.Optional} containing that value,
     * otherwise returns an empty {@link java.util.Optional}.
     *
     * @return the value as an {@link java.util.Optional}
     * @see java.util.Optional
     * @since 0.4.0
     */
    public Optional<T> optional() {
        return nonNull() ? Optional.of(value) : Optional.empty();
    }

    /**
     * Returns the stored value.
     *
     * <p>ATTENTION: The value might be null.
     *
     * @return The stored value
     * @since 0.4.0
     */
    public T get() {
        return value;
    }

//    Or else

    /**
     * Return the value if not {@code null}, otherwise return {@code other}.
     *
     * @param other the value to be returned if the value is {@code null}, may be null
     * @return the value, if not {@code null}, otherwise {@code other}
     * @since 0.4.0
     */
    public T orElse(T other) {
        return nonNull() ? value : other;
    }

    /**
     * Return the value if not {@code null},
     * otherwise invoke {@code other} and return the result of that invocation.
     *
     * @param producer a {@code Supplier} whose result is returned if the value is {@code null}
     * @return the value if not {@code null}, otherwise the result of {@code producer.get()}
     * @throws NullPointerException if value is {@code null} and {@code producer} is {@code null}
     * @see java.util.function.Supplier
     * @since 0.4.0
     */
    public T orElseGet(Supplier<? extends T> producer) {
        return nonNull() ? value : producer.get();
    }

    /**
     * Return the value if not {@code null},
     * otherwise throws NoSuchElementException.
     *
     * @return the non-{@code null} stored value
     * @throws NoSuchElementException if value is {@code null}
     * @see java.util.NoSuchElementException
     * @since 0.4.0
     */
    public T orElseThrow() {
        if (nonNull()) {
            return value;
        }
        throw new NoSuchElementException("Value is null");
    }

    /**
     * Return the value if not {@code null},
     * otherwise throws an exception.
     *
     * @param throwable the exception to be thrown
     * @param <X>       the type of the exception to be thrown
     * @return the non-{@code null} stored value
     * @throws X if value is {@code null}
     * @see java.lang.Throwable
     * @since 0.4.0
     */
    public <X extends Throwable> T orElseThrow(X throwable) throws X {
        if (nonNull()) {
            return value;
        }
        throw throwable;
    }

    /**
     * Return the value if not {@code null},
     * otherwise throws an exception produced by the exception supplying function.
     *
     * @param producer the supplying function that produces an exception to be thrown
     * @param <X>      the type of the exception to be thrown
     * @return the non-{@code null} stored value
     * @throws X                    if value is {@code null}
     * @throws NullPointerException if value is {@code null} and {@code producer} is {@code null}
     * @see java.lang.Throwable
     * @see java.util.function.Supplier
     * @since 0.4.0
     */
    public <X extends Throwable> T orElseThrowGet(Supplier<? extends X> producer) throws X {
        if (nonNull()) {
            return value;
        }
        throw producer.get();
    }

//    If

    /**
     * Invoke the specified runnable if value is {@code null},
     * otherwise do nothing.
     *
     * @param runnable block to be executed if value is {@code null}
     * @throws NullPointerException if value is {@code null} and {@code runnable} is {@code null}
     * @see java.lang.Runnable
     * @since 0.4.0
     */
    public void ifNull(Runnable runnable) {
        if (isNull()) {
            runnable.run();
        }
    }

    /**
     * Invoke the specified consumer with the value if not {@code null},
     * otherwise do nothing.
     *
     * @param consumer block to be executed if value is not {@code null}
     * @throws NullPointerException if value is not {@code null} and {@code consumer} is {@code null}
     * @see java.util.function.Consumer
     * @since 0.4.0
     */
    public void ifNonNull(Consumer<T> consumer) {
        if (nonNull()) {
            consumer.accept(value);
        }
    }

//    Object

    /**
     * Compare by value.
     *
     * @param o the object to compare
     * @since 0.4.0
     */
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

    /**
     * Calculate by value.
     *
     * @since 0.4.0
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    /**
     * Returns a non-empty string representation of this ChainX.
     *
     * @return the string representation of this instance
     * @since 0.4.0
     */
    @Override
    public String toString() {
        return nonNull() ? "ChainX[" + value + "]" : "ChainX.empty";
    }
}
