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

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <p>This utility class contains useful lambdas
 * for {@link java.util.function.Function}.</p>
 *
 * @author Grig Alex
 * @version 0.4.0
 * @see java.util.function.Function
 * @see java.util.function.BiFunction
 * @since 0.3.0
 */
public final class FunctionX {
    /**
     * <p>The private constructor.</p>
     *
     * @since 0.3.0
     */
    private FunctionX() {
    }

    /**
     * <p>Returns the {@link java.util.function.Function} that is if the input
     * value is null then returns null, otherwise returns the result of the input
     * function.</p>
     *
     * @param <T>      the type of the input to the function
     * @param <R>      the type of the result of the function
     * @param function the function to apply the input value
     * @return The {@link java.util.function.Function} with the null safety input
     * value
     * @see java.util.function.Function
     * @see java.util.function.Function#apply(Object)
     * @since 0.3.0
     */
    public static <T, R> Function<T, R> nullSafe(Function<? super T, ? extends R> function) {
        return t -> t == null ? null : function.apply(t);
    }

    /**
     * Returns a curried function that passes the value to the function as the first input
     * and expects a value for the second input of the function:
     * <pre>
     *
     * (function, t) -&gt; u -&gt; function.apply(t, u)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param t        a value for the first input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code t} to the {@code function} as the first input
     * and expects a value for the second input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, R> Function<U, R> left(
            BiFunction<? super T, ? super U, ? extends R> function,
            T t) {
        return (U u) -> function.apply(t, u);
    }

    /**
     * Returns a curried function that passes the value to the function as the second input
     * and expects a value for the first input of the function:
     * <pre>
     *
     * (function, u) -&gt; t -&gt; function.apply(t, u)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param u        a value for the second input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code u} to the {@code function} as the second input
     * and expects a value for the first input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, R> Function<T, R> right(
            BiFunction<? super T, ? super U, ? extends R> function,
            U u) {
        return (T t) -> function.apply(t, u);
    }

    /**
     * Returns a curried function that passes the value to the function as the first input
     * and expects two values for the second input and the third input of the function:
     * <pre>
     *
     * (function, t) -&gt; (u, s) -&gt; function.apply(t, u, s)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param t        a value for the first input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <S>      the type of the third input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code t} to the {@code function} as the first input
     * and expects two values for the second input and the third input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, S, R> BiFunction<U, S, R> left(
            TerFunction<? super T, ? super U, ? super S, ? extends R> function,
            T t) {
        return (U u, S s) -> function.apply(t, u, s);
    }

    /**
     * Returns a curried function that passes the value to the function as the third input
     * and expects two values for the first input and the second input of the function:
     * <pre>
     *
     * (function, s) -&gt; (t, u) -&gt; function.apply(t, u, s)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param s        a value for the third input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <S>      the type of the third input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code s} to the {@code function} as the third input
     * and expects two values for the first input and the second input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, S, R> BiFunction<T, U, R> right(
            TerFunction<? super T, ? super U, ? super S, ? extends R> function,
            S s) {
        return (T t, U u) -> function.apply(t, u, s);
    }

    /**
     * Returns a curried function that passes the values to the function as the first input and the second input
     * and expects a value for the third input of the function:
     * <pre>
     *
     * (function, t, u) -&gt; s -&gt; function.apply(t, u, s)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param t        a value for the first input of the {@code function}
     * @param u        a value for the second input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <S>      the type of the third input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code t} and the {@code u} to the {@code function} as the first input and the second input
     * and expects a value for the third input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, S, R> Function<S, R> left(
            TerFunction<? super T, ? super U, ? super S, ? extends R> function,
            T t,
            U u) {
        return (S s) -> function.apply(t, u, s);
    }

    /**
     * Returns a curried function that passes the values to the function as the second input and the third input
     * and expects a value for the third input of the function:
     * <pre>
     *
     * (function, u, s) -&gt; t -&gt; function.apply(t, u, s)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param u        a value for the second input of the {@code function}
     * @param s        a value for the third input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <S>      the type of the third input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code u} and the {@code s} to the {@code function} as the second input and the third input
     * and expects a value for the first input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, S, R> Function<T, R> right(
            TerFunction<? super T, ? super U, ? super S, ? extends R> function,
            U u,
            S s) {
        return (T t) -> function.apply(t, u, s);
    }

    /**
     * Returns a curried function that passes the value to the function as the second input
     * and expects two values for the first input and the third input of the function:
     * <pre>
     *
     * (function, u) -&gt; (t, s) -&gt; function.apply(t, u, s)
     * </pre>
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param function a function for currying
     * @param u        a value for the second input of the {@code function}
     * @param <T>      the type of the first input to the {@code function}
     * @param <U>      the type of the second input to the {@code function}
     * @param <S>      the type of the third input to the {@code function}
     * @param <R>      the type of output of the {@code function}
     * @return a curried function
     * that passes the {@code u} to the {@code function} as the second input
     * and expects two values for the first input and the third input of the {@code function}
     * @see java.util.function.Function
     * @since 0.4.0
     */
    public static <T, U, S, R> BiFunction<T, S, R> center(
            TerFunction<? super T, ? super U, ? super S, ? extends R> function,
            U u) {
        return (T t, S s) -> function.apply(t, u, s);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ar  a 2nd function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ar} function
     * @param <R> the type of output of the {@code ar} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends R> ar) {
        return ((Function<T, A>) ta)
                .andThen(ar);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param br  a 3rd function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code br} function
     * @param <R> the type of output of the {@code br} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends R> br) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(br);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cr  a 4th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cr} function
     * @param <R> the type of output of the {@code cr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends R> cr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param dr  a 5th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code dr} function
     * @param <R> the type of output of the {@code dr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends R> dr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(dr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param er  a 6th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code er} function
     * @param <R> the type of output of the {@code er} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends R> er) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(er);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fr  a 7th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fr} function
     * @param <R> the type of output of the {@code fr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends R> fr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gr  an 8th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gr} function
     * @param <R> the type of output of the {@code gr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends R> gr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hr  a 9th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hr} function
     * @param <R> the type of output of the {@code hr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends R> hr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ir  a 10th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ir} function
     * @param <R> the type of output of the {@code ir} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends R> ir) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ir);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ij  a 10th function
     * @param jr  an 11th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jr} function
     * @param <R> the type of output of the {@code jr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends J> ij,
            Function<? super J, ? extends R> jr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ij)
                .andThen(jr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ij  a 10th function
     * @param jk  an 11th function
     * @param kr  a 12th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kr} function
     * @param <R> the type of output of the {@code kr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends J> ij,
            Function<? super J, ? extends K> jk, Function<? super K, ? extends R> kr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ij)
                .andThen(jk).andThen(kr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ij  a 10th function
     * @param jk  an 11th function
     * @param kl  a 12th function
     * @param lr  a 13th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lr} function
     * @param <R> the type of output of the {@code lr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends J> ij,
            Function<? super J, ? extends K> jk, Function<? super K, ? extends L> kl,
            Function<? super L, ? extends R> lr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ij)
                .andThen(jk).andThen(kl).andThen(lr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ij  a 10th function
     * @param jk  an 11th function
     * @param kl  a 12th function
     * @param lm  a 13th function
     * @param mr  a 14th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lm} function
     * @param <M> the type of the input to the {@code mr} function
     * @param <R> the type of output of the {@code mr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, M, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends J> ij,
            Function<? super J, ? extends K> jk, Function<? super K, ? extends L> kl,
            Function<? super L, ? extends M> lm, Function<? super M, ? extends R> mr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ij)
                .andThen(jk).andThen(kl).andThen(lm)
                .andThen(mr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ij  a 10th function
     * @param jk  an 11th function
     * @param kl  a 12th function
     * @param lm  a 13th function
     * @param mn  a 14th function
     * @param nr  a 15th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lm} function
     * @param <M> the type of the input to the {@code mn} function
     * @param <N> the type of the input to the {@code nr} function
     * @param <R> the type of output of the {@code nr} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, M, N, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends J> ij,
            Function<? super J, ? extends K> jk, Function<? super K, ? extends L> kl,
            Function<? super L, ? extends M> lm, Function<? super M, ? extends N> mn,
            Function<? super N, ? extends R> nr) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ij)
                .andThen(jk).andThen(kl).andThen(lm)
                .andThen(mn).andThen(nr);
    }

    /**
     * Returns a composed from left to right function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param ta  a 1st function
     * @param ab  a 2nd function
     * @param bc  a 3rd function
     * @param cd  a 4th function
     * @param de  a 5th function
     * @param ef  a 6th function
     * @param fg  a 7th function
     * @param gh  an 8th function
     * @param hi  a 9th function
     * @param ij  a 10th function
     * @param jk  an 11th function
     * @param kl  a 12th function
     * @param lm  a 13th function
     * @param mn  a 14th function
     * @param no  a 15th function
     * @param or  a 16th function
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lm} function
     * @param <M> the type of the input to the {@code mn} function
     * @param <N> the type of the input to the {@code no} function
     * @param <O> the type of the input to the {@code or} function
     * @param <R> the type of output of the {@code or} function, and of the composed function
     * @return a composed from left to right function that applies all the passed functions
     * @see java.util.function.Function#andThen(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, R> Function<T, R> pipe(
            Function<? super T, ? extends A> ta, Function<? super A, ? extends B> ab,
            Function<? super B, ? extends C> bc, Function<? super C, ? extends D> cd,
            Function<? super D, ? extends E> de, Function<? super E, ? extends F> ef,
            Function<? super F, ? extends G> fg, Function<? super G, ? extends H> gh,
            Function<? super H, ? extends I> hi, Function<? super I, ? extends J> ij,
            Function<? super J, ? extends K> jk, Function<? super K, ? extends L> kl,
            Function<? super L, ? extends M> lm, Function<? super M, ? extends N> mn,
            Function<? super N, ? extends O> no, Function<? super O, ? extends R> or) {
        return ((Function<T, A>) ta)
                .andThen(ab).andThen(bc).andThen(cd)
                .andThen(de).andThen(ef).andThen(fg)
                .andThen(gh).andThen(hi).andThen(ij)
                .andThen(jk).andThen(kl).andThen(lm)
                .andThen(mn).andThen(no).andThen(or);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ar} function
     * @param <R> the type of output of the {@code ar} function, and of the composed function
     * @param ar  a 1st function
     * @param ta  a 2nd function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, R> Function<T, R> compose(
            Function<? super A, ? extends R> ar, Function<? super T, ? extends A> ta) {
        return ((Function<A, R>) ar)
                .compose(ta);
    }


    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code br} function
     * @param <R> the type of output of the {@code br} function, and of the composed function
     * @param br  a 1st function
     * @param ab  a 2nd function
     * @param ta  a 3rd function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, R> Function<T, R> compose(
            Function<? super B, ? extends R> br, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<B, R>) br)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cr} function
     * @param <R> the type of output of the {@code cr} function, and of the composed function
     * @param cr  a 1st function
     * @param bc  a 2nd function
     * @param ab  a 3rd function
     * @param ta  a 4th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, R> Function<T, R> compose(
            Function<? super C, ? extends R> cr, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<C, R>) cr)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code dr} function
     * @param <R> the type of output of the {@code dr} function, and of the composed function
     * @param dr  a 1st function
     * @param cd  a 2nd function
     * @param bc  a 3rd function
     * @param ab  a 4th function
     * @param ta  a 5th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, R> Function<T, R> compose(
            Function<? super D, ? extends R> dr, Function<? super C, ? extends D> cd,
            Function<? super B, ? extends C> bc, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<D, R>) dr)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code er} function
     * @param <R> the type of output of the {@code er} function, and of the composed function
     * @param er  a 1st function
     * @param de  a 2nd function
     * @param cd  a 3rd function
     * @param bc  a 4th function
     * @param ab  a 5th function
     * @param ta  a 6th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, R> Function<T, R> compose(
            Function<? super E, ? extends R> er, Function<? super D, ? extends E> de,
            Function<? super C, ? extends D> cd, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<E, R>) er)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fr} function
     * @param <R> the type of output of the {@code fr} function, and of the composed function
     * @param fr  a 1st function
     * @param ef  a 2nd function
     * @param de  a 3rd function
     * @param cd  a 4th function
     * @param bc  a 5th function
     * @param ab  a 6th function
     * @param ta  a 7th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, R> Function<T, R> compose(
            Function<? super F, ? extends R> fr, Function<? super E, ? extends F> ef,
            Function<? super D, ? extends E> de, Function<? super C, ? extends D> cd,
            Function<? super B, ? extends C> bc, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<F, R>) fr)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gr} function
     * @param <R> the type of output of the {@code gr} function, and of the composed function
     * @param gr  a 1st function
     * @param fg  a 2nd function
     * @param ef  a 3rd function
     * @param de  a 4th function
     * @param cd  a 5th function
     * @param bc  a 6th function
     * @param ab  a 7th function
     * @param ta  an 8th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, R> Function<T, R> compose(
            Function<? super G, ? extends R> gr, Function<? super F, ? extends G> fg,
            Function<? super E, ? extends F> ef, Function<? super D, ? extends E> de,
            Function<? super C, ? extends D> cd, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<G, R>) gr)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hr} function
     * @param <R> the type of output of the {@code hr} function, and of the composed function
     * @param hr  a 1st function
     * @param gh  a 2nd function
     * @param fg  a 3rd function
     * @param ef  a 4th function
     * @param de  a 5th function
     * @param cd  a 6th function
     * @param bc  a 7th function
     * @param ab  an 8th function
     * @param ta  a 9th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, R> Function<T, R> compose(
            Function<? super H, ? extends R> hr, Function<? super G, ? extends H> gh,
            Function<? super F, ? extends G> fg, Function<? super E, ? extends F> ef,
            Function<? super D, ? extends E> de, Function<? super C, ? extends D> cd,
            Function<? super B, ? extends C> bc, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<H, R>) hr)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ir} function
     * @param <R> the type of output of the {@code ir} function, and of the composed function
     * @param ir  a 1st function
     * @param hi  a 2nd function
     * @param gh  a 3rd function
     * @param fg  a 4th function
     * @param ef  a 5th function
     * @param de  a 6th function
     * @param cd  a 7th function
     * @param bc  an 8th function
     * @param ab  a 9th function
     * @param ta  a 10th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, R> Function<T, R> compose(
            Function<? super I, ? extends R> ir, Function<? super H, ? extends I> hi,
            Function<? super G, ? extends H> gh, Function<? super F, ? extends G> fg,
            Function<? super E, ? extends F> ef, Function<? super D, ? extends E> de,
            Function<? super C, ? extends D> cd, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<I, R>) ir)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jr} function
     * @param <R> the type of output of the {@code jr} function, and of the composed function
     * @param jr  a 1st function
     * @param ij  a 2nd function
     * @param hi  a 3rd function
     * @param gh  a 4th function
     * @param fg  a 5th function
     * @param ef  a 6th function
     * @param de  a 7th function
     * @param cd  an 8th function
     * @param bc  a 9th function
     * @param ab  a 10th function
     * @param ta  an 11th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, R> Function<T, R> compose(
            Function<? super J, ? extends R> jr, Function<? super I, ? extends J> ij,
            Function<? super H, ? extends I> hi, Function<? super G, ? extends H> gh,
            Function<? super F, ? extends G> fg, Function<? super E, ? extends F> ef,
            Function<? super D, ? extends E> de, Function<? super C, ? extends D> cd,
            Function<? super B, ? extends C> bc, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<J, R>) jr)
                .compose(ij)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kr} function
     * @param <R> the type of output of the {@code kr} function, and of the composed function
     * @param kr  a 1st function
     * @param jk  a 2nd function
     * @param ij  a 3rd function
     * @param hi  a 4th function
     * @param gh  a 5th function
     * @param fg  a 6th function
     * @param ef  a 7th function
     * @param de  an 8th function
     * @param cd  a 9th function
     * @param bc  a 10th function
     * @param ab  an 11th function
     * @param ta  a 12th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, R> Function<T, R> compose(
            Function<? super K, ? extends R> kr, Function<? super J, ? extends K> jk,
            Function<? super I, ? extends J> ij, Function<? super H, ? extends I> hi,
            Function<? super G, ? extends H> gh, Function<? super F, ? extends G> fg,
            Function<? super E, ? extends F> ef, Function<? super D, ? extends E> de,
            Function<? super C, ? extends D> cd, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<K, R>) kr)
                .compose(jk)
                .compose(ij)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lr} function
     * @param <R> the type of output of the {@code lr} function, and of the composed function
     * @param lr  a 1st function
     * @param kl  a 2nd function
     * @param jk  a 3rd function
     * @param ij  a 4th function
     * @param hi  a 5th function
     * @param gh  a 6th function
     * @param fg  a 7th function
     * @param ef  an 8th function
     * @param de  a 9th function
     * @param cd  a 10th function
     * @param bc  an 11th function
     * @param ab  a 12th function
     * @param ta  a 13th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, R> Function<T, R> compose(
            Function<? super L, ? extends R> lr, Function<? super K, ? extends L> kl,
            Function<? super J, ? extends K> jk, Function<? super I, ? extends J> ij,
            Function<? super H, ? extends I> hi, Function<? super G, ? extends H> gh,
            Function<? super F, ? extends G> fg, Function<? super E, ? extends F> ef,
            Function<? super D, ? extends E> de, Function<? super C, ? extends D> cd,
            Function<? super B, ? extends C> bc, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<L, R>) lr)
                .compose(kl)
                .compose(jk)
                .compose(ij)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lm} function
     * @param <M> the type of the input to the {@code mr} function
     * @param <R> the type of output of the {@code mr} function, and of the composed function
     * @param mr  a 1st function
     * @param lm  a 2nd function
     * @param kl  a 3rd function
     * @param jk  a 4th function
     * @param ij  a 5th function
     * @param hi  a 6th function
     * @param gh  a 7th function
     * @param fg  an 8th function
     * @param ef  a 9th function
     * @param de  a 10th function
     * @param cd  an 11th function
     * @param bc  a 12th function
     * @param ab  a 13th function
     * @param ta  a 14th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, M, R> Function<T, R> compose(
            Function<? super M, ? extends R> mr, Function<? super L, ? extends M> lm,
            Function<? super K, ? extends L> kl, Function<? super J, ? extends K> jk,
            Function<? super I, ? extends J> ij, Function<? super H, ? extends I> hi,
            Function<? super G, ? extends H> gh, Function<? super F, ? extends G> fg,
            Function<? super E, ? extends F> ef, Function<? super D, ? extends E> de,
            Function<? super C, ? extends D> cd, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<M, R>) mr)
                .compose(lm)
                .compose(kl)
                .compose(jk)
                .compose(ij)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lm} function
     * @param <M> the type of the input to the {@code mn} function
     * @param <N> the type of the input to the {@code nr} function
     * @param <R> the type of output of the {@code nr} function, and of the composed function
     * @param nr  a 1st function
     * @param mn  a 2nd function
     * @param lm  a 3rd function
     * @param kl  a 4th function
     * @param jk  a 5th function
     * @param ij  a 6th function
     * @param hi  a 7th function
     * @param gh  an 8th function
     * @param fg  a 9th function
     * @param ef  a 10th function
     * @param de  an 11th function
     * @param cd  a 12th function
     * @param bc  a 13th function
     * @param ab  a 14th function
     * @param ta  a 15th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, M, N, R> Function<T, R> compose(
            Function<? super N, ? extends R> nr, Function<? super M, ? extends N> mn,
            Function<? super L, ? extends M> lm, Function<? super K, ? extends L> kl,
            Function<? super J, ? extends K> jk, Function<? super I, ? extends J> ij,
            Function<? super H, ? extends I> hi, Function<? super G, ? extends H> gh,
            Function<? super F, ? extends G> fg, Function<? super E, ? extends F> ef,
            Function<? super D, ? extends E> de, Function<? super C, ? extends D> cd,
            Function<? super B, ? extends C> bc, Function<? super A, ? extends B> ab,
            Function<? super T, ? extends A> ta) {
        return ((Function<N, R>) nr)
                .compose(mn)
                .compose(lm)
                .compose(kl)
                .compose(jk)
                .compose(ij)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }

    /**
     * Returns a composed from right to left function that applies all the passed functions.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <T> the type of the input to the {@code ta} function
     * @param <A> the type of the input to the {@code ab} function
     * @param <B> the type of the input to the {@code bc} function
     * @param <C> the type of the input to the {@code cd} function
     * @param <D> the type of the input to the {@code de} function
     * @param <E> the type of the input to the {@code ef} function
     * @param <F> the type of the input to the {@code fg} function
     * @param <G> the type of the input to the {@code gh} function
     * @param <H> the type of the input to the {@code hi} function
     * @param <I> the type of the input to the {@code ij} function
     * @param <J> the type of the input to the {@code jk} function
     * @param <K> the type of the input to the {@code kl} function
     * @param <L> the type of the input to the {@code lm} function
     * @param <M> the type of the input to the {@code mn} function
     * @param <N> the type of the input to the {@code no} function
     * @param <O> the type of the input to the {@code or} function
     * @param <R> the type of output of the {@code or} function, and of the composed function
     * @param or  a 1st function
     * @param no  a 2nd function
     * @param mn  a 3rd function
     * @param lm  a 4th function
     * @param kl  a 5th function
     * @param jk  a 6th function
     * @param ij  a 7th function
     * @param hi  an 8th function
     * @param gh  a 9th function
     * @param fg  a 10th function
     * @param ef  an 11th function
     * @param de  a 12th function
     * @param cd  a 13th function
     * @param bc  a 14th function
     * @param ab  a 15th function
     * @param ta  a 16th function
     * @return a composed from right to left function that applies all the passed functions
     * @see java.util.function.Function#compose(java.util.function.Function)
     * @since 0.4.0
     */
    @SuppressWarnings("unchecked")
    public static <T, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, R> Function<T, R> compose(
            Function<? super O, ? extends R> or, Function<? super N, ? extends O> no,
            Function<? super M, ? extends N> mn, Function<? super L, ? extends M> lm,
            Function<? super K, ? extends L> kl, Function<? super J, ? extends K> jk,
            Function<? super I, ? extends J> ij, Function<? super H, ? extends I> hi,
            Function<? super G, ? extends H> gh, Function<? super F, ? extends G> fg,
            Function<? super E, ? extends F> ef, Function<? super D, ? extends E> de,
            Function<? super C, ? extends D> cd, Function<? super B, ? extends C> bc,
            Function<? super A, ? extends B> ab, Function<? super T, ? extends A> ta) {
        return ((Function<O, R>) or)
                .compose(no)
                .compose(mn)
                .compose(lm)
                .compose(kl)
                .compose(jk)
                .compose(ij)
                .compose(hi)
                .compose(gh)
                .compose(fg)
                .compose(ef)
                .compose(de)
                .compose(cd)
                .compose(bc)
                .compose(ab)
                .compose(ta);
    }
}
