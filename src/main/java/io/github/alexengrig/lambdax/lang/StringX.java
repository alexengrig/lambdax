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
 * @version 0.999.0
 * @see java.lang.String
 * @since 0.999.0
 */
public final class StringX {
    private StringX() {
    }

    public static Function<String, String> replaceFirst(String regex, String replacement) {
        return s -> s.replaceFirst(regex, replacement);
    }

    public static Function<String, String> replaceAll(String regex, String replacement) {
        return s -> s.replaceAll(regex, replacement);
    }

    public static Function<String, String> replace(CharSequence target, CharSequence replacement) {
        return s -> s.replace(target, replacement);
    }

    public static Function<String, String> substring(int beginIndex) {
        return s -> s.substring(beginIndex);
    }

    public static Function<String, String> substring(int beginIndex, int endIndex) {
        return s -> s.substring(beginIndex, endIndex);
    }

    public static Function<String, String> concat(String str) {
        return s -> s.concat(str);
    }

    public static Function<String, String> replace(char oldChar, char newChar) {
        return s -> s.replace(oldChar, newChar);
    }

    public static Function<String, String[]> split(String regex, int limit) {
        return s -> s.split(regex, limit);
    }

    public static Function<String, String[]> split(String regex) {
        return s -> s.split(regex);
    }

    public static Function<String, CharSequence> subSequence(int beginIndex, int endIndex) {
        return s -> s.subSequence(beginIndex, endIndex);
    }

    public static Function<String, Character> charAt(int index) {
        return s -> s.charAt(index);
    }

    public static Function<String, Integer> indexOf(int ch) {
        return s -> s.indexOf(ch);
    }

    public static Function<String, Integer> indexOf(int ch, int fromIndex) {
        return s -> s.indexOf(ch, fromIndex);
    }

    public static Function<String, Integer> lastIndexOf(int ch) {
        return s -> s.lastIndexOf(ch);
    }

    public static Function<String, Integer> lastIndexOf(int ch, int fromIndex) {
        return s -> s.lastIndexOf(ch, fromIndex);
    }

    public static Function<String, Integer> indexOf(String str) {
        return s -> s.indexOf(str);
    }

    public static Function<String, Integer> indexOf(String str, int fromIndex) {
        return s -> s.indexOf(str, fromIndex);
    }

    public static Function<String, Integer> lastIndexOf(String str) {
        return s -> s.lastIndexOf(str);
    }

    public static Function<String, Integer> lastIndexOf(String str, int fromIndex) {
        return s -> s.lastIndexOf(str, fromIndex);
    }

    public static Function<String, Integer> codePointAt(int index) {
        return s -> s.codePointAt(index);
    }

    public static Function<String, Integer> codePointBefore(int index) {
        return s -> s.codePointBefore(index);
    }

    public static Function<String, Integer> codePointCount(int beginIndex, int endIndex) {
        return s -> s.codePointCount(beginIndex, endIndex);
    }

    public static Function<String, Integer> offsetByCodePoints(int index, int codePointOffset) {
        return s -> s.offsetByCodePoints(index, codePointOffset);
    }

    public static Function<String, Integer> compareTo(String other) {
        return s -> s.compareTo(other);
    }

    public static Function<String, Integer> compareToIgnoreCase(String other) {
        return s -> s.compareToIgnoreCase(other);
    }

    public static Function<String, byte[]> getBytes(Charset charset) {
        return s -> s.getBytes(charset);
    }

    public static Predicate<String> startsWith(String prefix) {
        return s -> s.startsWith(prefix);
    }

    public static Predicate<String> startsWith(String prefix, int offset) {
        return s -> s.startsWith(prefix, offset);
    }

    public static Predicate<String> endsWith(String suffix) {
        return s -> s.endsWith(suffix);
    }

    public static Predicate<String> contains(CharSequence cs) {
        return s -> s.contains(cs);
    }

    public static Predicate<String> matches(String regex) {
        return s -> s.matches(regex);
    }

    public static Predicate<String> contentEquals(StringBuffer sb) {
        return s -> s.contentEquals(sb);
    }

    public static Predicate<String> contentEquals(CharSequence cs) {
        return s -> s.contentEquals(cs);
    }

    public static Predicate<String> equalsIgnoreCaseTo(String other) {
        return s -> s.equalsIgnoreCase(other);
    }

    public static Predicate<String> equalsTo(Object other) {
        return s -> s.equals(other);
    }
}
