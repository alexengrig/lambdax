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

package io.github.alexengrig.lambdax.lang;

import java.nio.charset.Charset;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This utility class contains useful lambdas for {@link java.lang.String}.
 *
 * @author Grig Alex
 * @version 0.5.0
 * @see java.lang.String
 * @since 0.5.0
 */
public final class StringX {
    private StringX() {
    }

    /**
     * Returns the carrying {@link java.lang.String#replaceFirst(String, String)} function:
     *
     * <pre>
     * s -&gt; s.replaceFirst(regex, replacement)
     * </pre>
     *
     * @param regex       the first argument of {@link java.lang.String#replaceFirst(String, String)}
     * @param replacement the second argument of {@link java.lang.String#replaceFirst(String, String)}
     * @return the carrying {@link java.lang.String#replaceFirst(String, String)} function
     * @see java.lang.String#replaceFirst(String, String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> replaceFirst(String regex, String replacement) {
        return s -> s.replaceFirst(regex, replacement);
    }

    /**
     * Returns the carrying {@link java.lang.String#replaceAll(String, String)} function:
     *
     * <pre>
     * s -&gt; s.replaceAll(regex, replacement)
     * </pre>
     *
     * @param regex       the first argument of {@link java.lang.String#replaceAll(String, String)}
     * @param replacement the second argument of {@link java.lang.String#replaceAll(String, String)}
     * @return the carrying {@link java.lang.String#replaceAll(String, String)} function
     * @see java.lang.String#replaceAll(String, String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> replaceAll(String regex, String replacement) {
        return s -> s.replaceAll(regex, replacement);
    }

    /**
     * Returns the carrying {@link java.lang.String#replace(CharSequence, CharSequence)} function:
     *
     * <pre>
     * s -&gt; s.replace(target, replacement)
     * </pre>
     *
     * @param target      the first argument of {@link java.lang.String#replace(CharSequence, CharSequence)}
     * @param replacement the second argument of {@link java.lang.String#replace(CharSequence, CharSequence)}
     * @return the carrying {@link java.lang.String#replace(CharSequence, CharSequence)} function
     * @see java.lang.String#replace(CharSequence, CharSequence)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> replace(CharSequence target, CharSequence replacement) {
        return s -> s.replace(target, replacement);
    }

    /**
     * Returns the carrying {@link java.lang.String#substring(int)} function:
     *
     * <pre>
     * s -&gt; s.substring(beginIndex)
     * </pre>
     *
     * @param beginIndex the argument of {@link java.lang.String#substring(int)}
     * @return the carrying {@link java.lang.String#substring(int)} function
     * @see java.lang.String#substring(int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> substring(int beginIndex) {
        return s -> s.substring(beginIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#substring(int, int)} function:
     *
     * <pre>
     * s -&gt; s.substring(beginIndex, endIndex)
     * </pre>
     *
     * @param beginIndex the first argument of {@link java.lang.String#substring(int, int)}
     * @param endIndex   the second argument of {@link java.lang.String#substring(int, int)}
     * @return the carrying {@link java.lang.String#substring(int, int)} function
     * @see java.lang.String#substring(int, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> substring(int beginIndex, int endIndex) {
        return s -> s.substring(beginIndex, endIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#concat(String)} function:
     *
     * <pre>
     * s -&gt; s.concat(str)
     * </pre>
     *
     * @param str the argument of {@link java.lang.String#concat(String)}
     * @return the carrying {@link java.lang.String#concat(String)} function
     * @see java.lang.String#concat(String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> concat(String str) {
        return s -> s.concat(str);
    }

    /**
     * Returns the carrying {@link java.lang.String#replace(char, char)} function:
     *
     * <pre>
     * s -&gt; s.replace(oldChar, newChar)
     * </pre>
     *
     * @param oldChar the first argument of {@link java.lang.String#replace(char, char)}
     * @param newChar the second argument of {@link java.lang.String#replace(char, char)}
     * @return the carrying {@link java.lang.String#replace(char, char)} function
     * @see java.lang.String#replace(char, char)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String> replace(char oldChar, char newChar) {
        return s -> s.replace(oldChar, newChar);
    }

    /**
     * Returns the carrying {@link java.lang.String#split(String)} function:
     *
     * <pre>
     * s -&gt; s.split(regex)
     * </pre>
     *
     * @param regex the argument of {@link java.lang.String#split(String)}
     * @return the carrying {@link java.lang.String#split(String)} function
     * @see java.lang.String#split(String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String[]> split(String regex) {
        return s -> s.split(regex);
    }

    /**
     * Returns the carrying {@link java.lang.String#split(String, int)} function:
     *
     * <pre>
     * s -&gt; s.split(regex, limit)
     * </pre>
     *
     * @param regex the first argument of {@link java.lang.String#split(String, int)}
     * @param limit the second argument of {@link java.lang.String#split(String, int)}
     * @return the carrying {@link java.lang.String#split(String, int)} function
     * @see java.lang.String#split(String, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, String[]> split(String regex, int limit) {
        return s -> s.split(regex, limit);
    }

    /**
     * Returns the carrying {@link java.lang.String#subSequence(int, int)} function:
     *
     * <pre>
     * s -&gt; s.subSequence(beginIndex, endIndex)
     * </pre>
     *
     * @param beginIndex the first argument of {@link java.lang.String#subSequence(int, int)}
     * @param endIndex   the second argument of {@link java.lang.String#subSequence(int, int)}
     * @return the carrying {@link java.lang.String#subSequence(int, int)} function
     * @see java.lang.String#subSequence(int, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, CharSequence> subSequence(int beginIndex, int endIndex) {
        return s -> s.subSequence(beginIndex, endIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#charAt(int)} function:
     *
     * <pre>
     * s -&gt; s.charAt(index)
     * </pre>
     *
     * @param index the argument of {@link java.lang.String#charAt(int)}
     * @return the carrying {@link java.lang.String#charAt(int)} function
     * @see java.lang.String#charAt(int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Character> charAt(int index) {
        return s -> s.charAt(index);
    }

    /**
     * Returns the carrying {@link java.lang.String#indexOf(int)} function:
     *
     * <pre>
     * s -&gt; s.indexOf(ch)
     * </pre>
     *
     * @param ch the argument of {@link java.lang.String#indexOf(int)}
     * @return the carrying {@link java.lang.String#indexOf(int)} function
     * @see java.lang.String#indexOf(int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> indexOf(int ch) {
        return s -> s.indexOf(ch);
    }

    /**
     * Returns the carrying {@link java.lang.String#indexOf(int, int)} function:
     *
     * <pre>
     * s -&gt; s.indexOf(ch, fromIndex)
     * </pre>
     *
     * @param ch        the first argument of {@link java.lang.String#indexOf(int, int)}
     * @param fromIndex the second argument of {@link java.lang.String#indexOf(int, int)}
     * @return the carrying {@link java.lang.String#indexOf(int, int)} function
     * @see java.lang.String#indexOf(int, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> indexOf(int ch, int fromIndex) {
        return s -> s.indexOf(ch, fromIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#lastIndexOf(int)} function:
     *
     * <pre>
     * s -&gt; s.lastIndexOf(ch)
     * </pre>
     *
     * @param ch the argument of {@link java.lang.String#lastIndexOf(int)}
     * @return the carrying {@link java.lang.String#lastIndexOf(int)} function
     * @see java.lang.String#lastIndexOf(int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> lastIndexOf(int ch) {
        return s -> s.lastIndexOf(ch);
    }

    /**
     * Returns the carrying {@link java.lang.String#lastIndexOf(int, int)} function:
     *
     * <pre>
     * s -&gt; s.lastIndexOf(ch, fromIndex)
     * </pre>
     *
     * @param ch        the first argument of {@link java.lang.String#lastIndexOf(int, int)}
     * @param fromIndex the second argument of {@link java.lang.String#lastIndexOf(int, int)}
     * @return the carrying {@link java.lang.String#lastIndexOf(int, int)} function
     * @see java.lang.String#lastIndexOf(int, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> lastIndexOf(int ch, int fromIndex) {
        return s -> s.lastIndexOf(ch, fromIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#indexOf(String)} function:
     *
     * <pre>
     * s -&gt; s.indexOf(str)
     * </pre>
     *
     * @param str the argument of {@link java.lang.String#indexOf(String)}
     * @return the carrying {@link java.lang.String#indexOf(String)} function
     * @see java.lang.String#indexOf(String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> indexOf(String str) {
        return s -> s.indexOf(str);
    }

    /**
     * Returns the carrying {@link java.lang.String#indexOf(String, int)} function:
     *
     * <pre>
     * s -&gt; s.indexOf(str, fromIndex)
     * </pre>
     *
     * @param str       the first argument of {@link java.lang.String#indexOf(String, int)}
     * @param fromIndex the second argument of {@link java.lang.String#indexOf(String, int)}
     * @return the carrying {@link java.lang.String#indexOf(String, int)} function
     * @see java.lang.String#indexOf(String, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> indexOf(String str, int fromIndex) {
        return s -> s.indexOf(str, fromIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#lastIndexOf(String)} function:
     *
     * <pre>
     * s -&gt; s.lastIndexOf(str)
     * </pre>
     *
     * @param str the argument of {@link java.lang.String#lastIndexOf(String)}
     * @return the carrying {@link java.lang.String#lastIndexOf(String)} function
     * @see java.lang.String#lastIndexOf(String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> lastIndexOf(String str) {
        return s -> s.lastIndexOf(str);
    }

    /**
     * Returns the carrying {@link java.lang.String#lastIndexOf(String, int)} function:
     *
     * <pre>
     * s -&gt; s.lastIndexOf(str, fromIndex)
     * </pre>
     *
     * @param str       the first argument of {@link java.lang.String#lastIndexOf(String, int)}
     * @param fromIndex the second argument of {@link java.lang.String#lastIndexOf(String, int)}
     * @return the carrying {@link java.lang.String#lastIndexOf(String, int)} function
     * @see java.lang.String#lastIndexOf(String, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> lastIndexOf(String str, int fromIndex) {
        return s -> s.lastIndexOf(str, fromIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#codePointAt(int)} function:
     *
     * <pre>
     * s -&gt; s.codePointAt(index)
     * </pre>
     *
     * @param index the argument of {@link java.lang.String#codePointAt(int)}
     * @return the carrying {@link java.lang.String#codePointAt(int)} function
     * @see java.lang.String#codePointAt(int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> codePointAt(int index) {
        return s -> s.codePointAt(index);
    }

    /**
     * Returns the carrying {@link java.lang.String#codePointBefore(int)} function:
     *
     * <pre>
     * s -&gt; s.codePointBefore(index)
     * </pre>
     *
     * @param index the argument of {@link java.lang.String#codePointBefore(int)}
     * @return the carrying {@link java.lang.String#codePointBefore(int)} function
     * @see java.lang.String#codePointBefore(int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> codePointBefore(int index) {
        return s -> s.codePointBefore(index);
    }

    /**
     * Returns the carrying {@link java.lang.String#codePointCount(int, int)} function:
     *
     * <pre>
     * s -&gt; s.codePointCount(beginIndex, endIndex)
     * </pre>
     *
     * @param beginIndex the first argument of {@link java.lang.String#codePointCount(int, int)}
     * @param endIndex   the second argument of {@link java.lang.String#codePointCount(int, int)}
     * @return the carrying {@link java.lang.String#codePointCount(int, int)} function
     * @see java.lang.String#codePointCount(int, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> codePointCount(int beginIndex, int endIndex) {
        return s -> s.codePointCount(beginIndex, endIndex);
    }

    /**
     * Returns the carrying {@link java.lang.String#offsetByCodePoints(int, int)} function:
     *
     * <pre>
     * s -&gt; s.offsetByCodePoints(index, codePointOffset)
     * </pre>
     *
     * @param index           the first argument of {@link java.lang.String#offsetByCodePoints(int, int)}
     * @param codePointOffset the second argument of {@link java.lang.String#offsetByCodePoints(int, int)}
     * @return the carrying {@link java.lang.String#offsetByCodePoints(int, int)} function
     * @see java.lang.String#offsetByCodePoints(int, int)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> offsetByCodePoints(int index, int codePointOffset) {
        return s -> s.offsetByCodePoints(index, codePointOffset);
    }

    /**
     * Returns the carrying {@link java.lang.String#compareTo(String)} function:
     *
     * <pre>
     * s -&gt; s.compareTo(other)
     * </pre>
     *
     * @param other the argument of {@link java.lang.String#compareTo(String)}
     * @return the carrying {@link java.lang.String#compareTo(String)} function
     * @see java.lang.String#compareTo(String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> compareTo(String other) {
        return s -> s.compareTo(other);
    }

    /**
     * Returns the carrying {@link java.lang.String#compareToIgnoreCase(String)} function:
     *
     * <pre>
     * s -&gt; s.compareToIgnoreCase(other)
     * </pre>
     *
     * @param other the argument of {@link java.lang.String#compareToIgnoreCase(String)}
     * @return the carrying {@link java.lang.String#compareToIgnoreCase(String)} function
     * @see java.lang.String#compareToIgnoreCase(String)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, Integer> compareToIgnoreCase(String other) {
        return s -> s.compareToIgnoreCase(other);
    }

    /**
     * Returns the carrying {@link java.lang.String#getBytes(Charset)} function:
     *
     * <pre>
     * s -&gt; s.getBytes(charset)
     * </pre>
     *
     * @param charset the argument of {@link java.lang.String#getBytes(Charset)}
     * @return the carrying {@link java.lang.String#getBytes(Charset)} function
     * @see java.lang.String#getBytes(Charset)
     * @see java.util.function.Function
     * @since 0.5.0
     */
    public static Function<String, byte[]> getBytes(Charset charset) {
        return s -> s.getBytes(charset);
    }

    /**
     * Returns the carrying {@link java.lang.String#startsWith(String)} predicate:
     *
     * <pre>
     * s -&gt; s.startsWith(prefix)
     * </pre>
     *
     * @param prefix the argument of {@link java.lang.String#startsWith(String)}
     * @return the carrying {@link java.lang.String#startsWith(String)} predicate
     * @see java.lang.String#startsWith(String)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> startsWith(String prefix) {
        return s -> s.startsWith(prefix);
    }

    /**
     * Returns the carrying {@link java.lang.String#startsWith(String, int)} predicate:
     *
     * <pre>
     * s -&gt; s.startsWith(prefix, offset)
     * </pre>
     *
     * @param prefix the first argument of {@link java.lang.String#startsWith(String, int)}
     * @param offset the second argument of {@link java.lang.String#startsWith(String, int)}
     * @return the carrying {@link java.lang.String#startsWith(String, int)} predicate
     * @see java.lang.String#startsWith(String, int)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> startsWith(String prefix, int offset) {
        return s -> s.startsWith(prefix, offset);
    }

    /**
     * Returns the carrying {@link java.lang.String#endsWith(String)} predicate:
     *
     * <pre>
     * s -&gt; s.endsWith(suffix)
     * </pre>
     *
     * @param suffix the argument of {@link java.lang.String#endsWith(String)}
     * @return the carrying {@link java.lang.String#endsWith(String)} predicate
     * @see java.lang.String#endsWith(String)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> endsWith(String suffix) {
        return s -> s.endsWith(suffix);
    }

    /**
     * Returns the carrying {@link java.lang.String#contains(CharSequence)} predicate:
     *
     * <pre>
     * s -&gt; s.contains(cs)
     * </pre>
     *
     * @param cs the argument of {@link java.lang.String#contains(CharSequence)}
     * @return the carrying {@link java.lang.String#contains(CharSequence)} predicate
     * @see java.lang.String#contains(CharSequence)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> contains(CharSequence cs) {
        return s -> s.contains(cs);
    }

    /**
     * Returns the carrying {@link java.lang.String#matches(String)} predicate:
     *
     * <pre>
     * s -&gt; s.matches(regex)
     * </pre>
     *
     * @param regex the argument of {@link java.lang.String#matches(String)}
     * @return the carrying {@link java.lang.String#matches(String)} predicate
     * @see java.lang.String#matches(String)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> matches(String regex) {
        return s -> s.matches(regex);
    }

    /**
     * Returns the carrying {@link java.lang.String#contentEquals(StringBuffer)} predicate:
     *
     * <pre>
     * s -&gt; s.contentEquals(sb)
     * </pre>
     *
     * @param sb the argument of {@link java.lang.String#contentEquals(StringBuffer)}
     * @return the carrying {@link java.lang.String#contentEquals(StringBuffer)} predicate
     * @see java.lang.String#contentEquals(StringBuffer)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> contentEqualsTo(StringBuffer sb) {
        return s -> s.contentEquals(sb);
    }

    /**
     * Returns the carrying {@link java.lang.String#contentEquals(CharSequence)} predicate:
     *
     * <pre>
     * s -&gt; s.contentEquals(cs)
     * </pre>
     *
     * @param cs the argument of {@link java.lang.String#contentEquals(CharSequence)}
     * @return the carrying {@link java.lang.String#contentEquals(CharSequence)} predicate
     * @see java.lang.String#contentEquals(CharSequence)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> contentEqualsTo(CharSequence cs) {
        return s -> s.contentEquals(cs);
    }

    /**
     * Returns the carrying {@link java.lang.String#equalsIgnoreCase(String)} predicate:
     *
     * <pre>
     * s -&gt; s.equalsIgnoreCase(other)
     * </pre>
     *
     * @param other the argument of {@link java.lang.String#equalsIgnoreCase(String)}
     * @return the carrying {@link java.lang.String#equalsIgnoreCase(String)} predicate
     * @see java.lang.String#equalsIgnoreCase(String)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> equalsIgnoreCaseTo(String other) {
        return s -> s.equalsIgnoreCase(other);
    }

    /**
     * Returns the carrying {@link java.lang.String#equals(Object)} predicate:
     *
     * <pre>
     * s -&gt; s.equals(other)
     * </pre>
     *
     * @param other the argument of {@link java.lang.String#equals(Object)}
     * @return the carrying {@link java.lang.String#equals(Object)} predicate
     * @see java.lang.String#equals(Object)
     * @see java.util.function.Predicate
     * @since 0.5.0
     */
    public static Predicate<String> equalsTo(Object other) {
        return s -> s.equals(other);
    }
}
