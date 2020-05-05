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

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringXTest {
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final char S = 's';
    private static final char C = 'c';
    private static final String STRING = "string";
    private static final String STR = "str";
    private static final String REPLACEMENT = "replacement";
    private static final String REGEX = "\\.";
    private static final StringBuffer SB = new StringBuffer(STR);
    private static final Charset CHARSET = Charset.defaultCharset();

    private <R> void equalResult(Function<? super String, R> expected, Function<? super String, R> actual) {
        assertEquals(expected.apply(STRING), actual.apply(STRING));
    }

    private void equalResult(Predicate<? super String> expected, Predicate<? super String> actual) {
        assertEquals(expected.test(STRING), actual.test(STRING));
    }

    private <R> void equalArrayResult(Function<? super String, R[]> expected, Function<? super String, R[]> actual) {
        assertArrayEquals(expected.apply(STRING), actual.apply(STRING));
    }

    private void equalByteArrayResult(Function<? super String, byte[]> expected, Function<? super String, byte[]> actual) {
        assertArrayEquals(expected.apply(STRING), actual.apply(STRING));
    }

    @Test
    public void checkReplaceFirst() {
        equalResult(StringX.replaceFirst(REGEX, REPLACEMENT), s -> s.replaceFirst(REGEX, REPLACEMENT));
    }

    @Test
    public void checkReplaceAll() {
        equalResult(StringX.replaceAll(REGEX, REPLACEMENT), s -> s.replaceAll(REGEX, REPLACEMENT));
    }

    @Test
    public void checkReplaceWithChar() {
        equalResult(StringX.replace(S, C), s -> s.replace(S, C));
    }

    @Test
    public void checkReplaceWithCharSequence() {
        equalResult(StringX.replace(STR, REPLACEMENT), s -> s.replace(STR, REPLACEMENT));
    }

    @Test
    public void checkSubstring() {
        equalResult(StringX.substring(ONE), s -> s.substring(ONE));
    }

    @Test
    public void checkSubstringWithEnd() {
        equalResult(StringX.substring(ONE, THREE), s -> s.substring(ONE, THREE));
    }

    @Test
    public void checkConcat() {
        equalResult(StringX.concat(STR), s -> s.concat(STR));
    }

    @Test
    public void checkSplit() {
        equalArrayResult(StringX.split(REGEX), s -> s.split(REGEX));
    }

    @Test
    public void checkSplitWithLimit() {
        equalArrayResult(StringX.split(REGEX, ONE), s -> s.split(REGEX, ONE));
    }

    @Test
    public void checkSubSequence() {
        equalResult(StringX.subSequence(ONE, THREE), s -> s.subSequence(ONE, THREE));
    }

    @Test
    public void checkCharAt() {
        equalResult(StringX.charAt(ONE), s -> s.charAt(ONE));
    }

    @Test
    public void checkCharIndexOf() {
        equalResult(StringX.indexOf(S), s -> s.indexOf(S));
    }

    @Test
    public void checkCharIndexOfWithIndex() {
        equalResult(StringX.indexOf(S, ONE), s -> s.indexOf(S, ONE));
    }

    @Test
    public void checkCharLastIndexOf() {
        equalResult(StringX.lastIndexOf(S), s -> s.lastIndexOf(S));
    }

    @Test
    public void checkCharLastIndexOfWithIndex() {
        equalResult(StringX.lastIndexOf(S, ONE), s -> s.lastIndexOf(S, ONE));
    }

    @Test
    public void checkStringIndexOf() {
        equalResult(StringX.indexOf(STR), s -> s.indexOf(STR));
    }

    @Test
    public void checkStringIndexOfWithIndex() {
        equalResult(StringX.indexOf(STR, ONE), s -> s.indexOf(STR, ONE));
    }

    @Test
    public void checkStringLastIndexOf() {
        equalResult(StringX.lastIndexOf(STR), s -> s.lastIndexOf(STR));
    }

    @Test
    public void checkStringLastIndexOfWithIndex() {
        equalResult(StringX.lastIndexOf(STR, ONE), s -> s.lastIndexOf(STR, ONE));
    }

    @Test
    public void checkCodePointAt() {
        equalResult(StringX.codePointAt(ONE), s -> s.codePointAt(ONE));
    }

    @Test
    public void checkCodePointBefore() {
        equalResult(StringX.codePointBefore(ONE), s -> s.codePointBefore(ONE));
    }

    @Test
    public void checkCodePointCount() {
        equalResult(StringX.codePointCount(ONE, THREE), s -> s.codePointCount(ONE, THREE));
    }

    @Test
    public void checkOffsetByCodePoints() {
        equalResult(StringX.offsetByCodePoints(ONE, THREE), s -> s.offsetByCodePoints(ONE, THREE));
    }

    @Test
    public void checkCompareTo() {
        equalResult(StringX.compareTo(STR), s -> s.compareTo(STR));
    }

    @Test
    public void checkCompareToIgnoreCase() {
        equalResult(StringX.compareToIgnoreCase(STR), s -> s.compareToIgnoreCase(STR));
    }

    @Test
    public void checkGetBytes() {
        equalByteArrayResult(StringX.getBytes(CHARSET), s -> s.getBytes(CHARSET));
    }

    @Test
    public void checkStartsWith() {
        equalResult(StringX.startsWith(STR), s -> s.startsWith(STR));
    }

    @Test
    public void checkStartsWithIndex() {
        equalResult(StringX.startsWith(STR, ONE), s -> s.startsWith(STR, ONE));
    }

    @Test
    public void checkEndsWith() {
        equalResult(StringX.endsWith(STR), s -> s.endsWith(STR));
    }

    @Test
    public void checkContains() {
        equalResult(StringX.contains(STR), s -> s.contains(STR));
    }

    @Test
    public void checkMatches() {
        equalResult(StringX.matches(REGEX), s -> s.matches(REGEX));
    }

    @Test
    public void checkContentEqualsToWithStringBuffer() {
        equalResult(StringX.contentEqualsTo(SB), s -> s.contentEquals(SB));
    }

    @Test
    public void checkContentEqualsToWithCharSequence() {
        equalResult(StringX.contentEqualsTo(STR), s -> s.contentEquals(STR));
    }

    @Test
    public void checkEqualsIgnoreCaseTo() {
        equalResult(StringX.equalsIgnoreCaseTo(STR), s -> s.equalsIgnoreCase(STR));
    }

    @Test
    public void checkEqualsTo() {
        equalResult(StringX.equalsTo(STR), s -> s.equals(STR));
    }
}