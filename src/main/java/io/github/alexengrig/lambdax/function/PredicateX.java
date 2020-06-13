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

package io.github.alexengrig.lambdax.function;

import io.github.alexengrig.lambdax.PredicateChainX;
import io.github.alexengrig.lambdax.SafePredicateChainX;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * {@link java.util.function.Predicate} extension.
 *
 * @author Grig Alex
 * @version 0.6.0
 * @see java.util.function.Predicate
 * @since 0.2.0
 */
@FunctionalInterface
public interface PredicateX<T> extends Predicate<T> {
    /**
     * Returns a predicate extension.
     * <p>
     * Usage example:
     * <pre>{@code
     * // impossible: String::isEmpty.or("empty"::equals).test("string");
     *
     * PredicateX.of(String::isEmpty).or("empty"::equals).test("string");
     * }</pre>
     *
     * @param predicate the predicate to extension
     * @param <T>       the type of the input to {@code predicate}
     * @return the predicate extension
     * @throws NullPointerException if {@code predicate} is {@code null}
     * @since 0.6.0
     */
    static <T> PredicateX<T> of(Predicate<? super T> predicate) {
        return Objects.requireNonNull(predicate, "The predicate must not be null")::test;
    }

    static <T, R> PredicateChainX<T, R> chain(Function<T, R> mapper) {
        return PredicateChainX.of(mapper);
    }

    static <T, R> SafePredicateChainX<T, R> chainSafe(Function<T, R> mapper) {
        return SafePredicateChainX.of(mapper);
    }

    /**
     * Returns the predicate extension:
     * <pre>{@code
     * t -> true
     * }</pre>
     *
     * @param <T> the type of the input to the predicate
     * @return the predicate extension that always returns {@code true}
     * @since 0.2.0
     */
    static <T> PredicateX<T> truth() {
        return t -> true;
    }

    /**
     * Returns the predicate extension:
     * <pre>{@code
     * t -> false
     * }</pre>
     *
     * @param <T> the type of the input to the predicate
     * @return the predicate extension that always returns {@code false}
     * @since 0.2.0
     */
    static <T> PredicateX<T> lie() {
        return t -> false;
    }

    /**
     * <p>Returns the {@link java.util.function.Predicate} that is the negation of
     * the supplied predicate.</p> <p>Like in JDK 11.</p>
     *
     * @param <T>       a type of the input to the predicate
     * @param predicate a supplied predicate to negate
     * @return The {@link java.util.function.Predicate} that negates the results
     * of the supplied predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#negate
     * @since 0.2.0
     */
    static <T> PredicateX<T> not(Predicate<? super T> predicate) {
        return of(predicate.negate());
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * AND of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code false},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ANDed with the {@code second}
     * @param second a predicate that will be logically-ANDed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * AND of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#and(java.util.function.Predicate)
     * @since 0.3.0
     */
    static <T> PredicateX<T> and(Predicate<? super T> first, Predicate<? super T> second) {
        return t -> first.test(t) && second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical AND of predicates.
     * When evaluating the composed predicate,
     * if any predicate is {@code false},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ANDed with the {@code second}
     * @param second a predicate that will be logically-ANDed with the {@code first}
     * @param others predicates that will be logically-ANDed with previous result
     *               starting from the result of the {@code first} and the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * AND of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#and(java.util.function.Predicate)
     * @see #and(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    static <T> PredicateX<T> and(Predicate<? super T> first, Predicate<? super T> second,
                                 Predicate<? super T>... others) {
        PredicateX<T> predicate = and(first, second);
        for (Predicate<? super T> other : others) {
            predicate = and(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * OR of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code true},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ORed with the {@code second}
     * @param second a predicate that will be logically-ORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * OR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#or(java.util.function.Predicate)
     * @since 0.3.0
     */
    static <T> PredicateX<T> or(Predicate<? super T> first, Predicate<? super T> second) {
        return t -> first.test(t) || second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical OR of predicates.
     * When evaluating the composed predicate,
     * if any predicate is {@code true},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-ORed with the {@code second}
     * @param second a predicate that will be logically-ORed with the {@code first}
     * @param others predicates that will be logically-ORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * OR of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see java.util.function.Predicate#or(java.util.function.Predicate)
     * @see #or(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    static <T> PredicateX<T> or(Predicate<? super T> first, Predicate<? super T> second,
                                Predicate<? super T>... others) {
        PredicateX<T> predicate = or(first, second);
        for (Predicate<? super T> other : others) {
            predicate = or(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * XOR of first predicate and second predicate.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XORed with the {@code second}
     * @param second a predicate that will be logically-XORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * XOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    static <T> PredicateX<T> xor(Predicate<? super T> first, Predicate<? super T> second) {
        return t -> first.test(t) ^ second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical XOR of predicates.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XORed with the {@code second}
     * @param second a predicate that will be logically-XORed with the {@code first}
     * @param others predicates that will be logically-XORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * XOR of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see #xor(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    static <T> PredicateX<T> xor(Predicate<? super T> first, Predicate<? super T> second,
                                 Predicate<? super T>... others) {
        PredicateX<T> predicate = xor(first, second);
        for (Predicate<? super T> other : others) {
            predicate = xor(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * NAND of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code false},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NANDed with the {@code second}
     * @param second a predicate that will be logically-NANDed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * NAND of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    static <T> PredicateX<T> nand(Predicate<? super T> first, Predicate<? super T> second) {
        return t -> !(first.test(t) && second.test(t));
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical NAND of predicates.
     * if any predicate is {@code false},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NANDed with the {@code second}
     * @param second a predicate that will be logically-NANDed with the {@code first}
     * @param others predicates that will be logically-NANDed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * NAND of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see #nand(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    static <T> PredicateX<T> nand(Predicate<? super T> first, Predicate<? super T> second,
                                  Predicate<? super T>... others) {
        PredicateX<T> predicate = nand(first, second);
        for (Predicate<? super T> other : others) {
            predicate = nand(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * NOR of first predicate and second predicate.
     * When evaluating the composed predicate,
     * if first predicate is {@code true},
     * then second predicate is not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NORed with the {@code second}
     * @param second a predicate that will be logically-NORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * NOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    static <T> PredicateX<T> nor(Predicate<? super T> first, Predicate<? super T> second) {
        return t -> !(first.test(t) || second.test(t));
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical NOR of predicates.
     * When evaluating the composed predicate,
     * if any predicate is {@code true},
     * then those following predicates are not evaluated.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-NORed with the {@code second}
     * @param second a predicate that will be logically-NORed with the {@code first}
     * @param others predicates that will be logically-NORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * NOR of the {@code first} predicate, the {@code second} predicate and the {@code others} predicates
     * @see java.util.function.Predicate
     * @see #nor(java.util.function.Predicate, java.util.function.Predicate)
     * @since 0.3.0
     */
    @SafeVarargs
    static <T> PredicateX<T> nor(Predicate<? super T> first, Predicate<? super T> second,
                                 Predicate<? super T>... others) {
        PredicateX<T> predicate = nor(first, second);
        for (Predicate<? super T> other : others) {
            predicate = nor(predicate, other);
        }
        return predicate;
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical
     * XNOR of first predicate and second predicate.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XNORed with the {@code second}
     * @param second a predicate that will be logically-XNORed with the {@code first}
     * @return a composed predicate that represents the short-circuiting logical
     * XNOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    static <T> PredicateX<T> xnor(Predicate<? super T> first, Predicate<? super T> second) {
        return t -> first.test(t) == second.test(t);
    }

    /**
     * Returns a composed predicate that represents a short-circuiting logical XNOR of predicates.
     *
     * @param <T>    the type of arguments to the predicate
     * @param first  a predicate that will be logically-XNORed with the {@code second}
     * @param second a predicate that will be logically-XNORed with the {@code first}
     * @param others predicates that will be logically-XNORed with previous result
     *               starting from the result of the {@code first} and the {@code second}
     * @return a composed predicate that represents the short-circuiting logical
     * XNOR of the {@code first} predicate and the {@code second} predicate
     * @see java.util.function.Predicate
     * @since 0.3.0
     */
    @SafeVarargs
    static <T> PredicateX<T> xnor(Predicate<? super T> first, Predicate<? super T> second,
                                  Predicate<? super T>... others) {
        PredicateX<T> predicate = xnor(first, second);
        for (Predicate<? super T> other : others) {
            predicate = xnor(predicate, other);
        }
        return predicate;
    }

    default PredicateX<T> xor(Predicate<? super T> other) {
        return t -> test(t) ^ other.test(t);
    }

    default PredicateX<T> nand(Predicate<? super T> other) {
        return t -> !(test(t) && other.test(t));
    }

    default PredicateX<T> nor(Predicate<? super T> other) {
        return t -> !(test(t) || other.test(t));
    }

    default PredicateX<T> xnor(Predicate<? super T> other) {
        return t -> test(t) == other.test(t);
    }
}
