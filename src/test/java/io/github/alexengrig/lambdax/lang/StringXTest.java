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
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
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

    @SuppressWarnings("SameParameterValue")
    private <T, R, V extends String> void doCheckEqualsFunctionResult(
            Function<? super T, ? super R> expected, T first,
            Function<? super T, ? extends Function<? super V, ? super R>> actual, V value) {
        assertEquals(expected.apply(first), actual.apply(first).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, R, V extends String> void doCheckEqualsFunctionResult(
            BiFunction<? super T, ? super U, ? super R> expected, T first, U second,
            BiFunction<? super T, ? super U, ? extends Function<? super V, ? super R>> actual, V value) {
        assertEquals(expected.apply(first, second), actual.apply(first, second).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, R, V extends String> void doCheckEqualsLeftFunctionResult(
            BiFunction<? super T, ? super U, ? super R> expected, T first, U second,
            Function<? super T, ? extends Function<? super U, Function<V, R>>> actual, V value) {
        assertEquals(expected.apply(first, second), actual.apply(first).apply(second).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, R, V extends String> void doCheckEqualsRightFunctionResult(
            BiFunction<? super T, ? super U, ? super R> expected, T first, U second,
            Function<? super U, ? extends Function<? super T, Function<V, R>>> actual, V value) {
        assertEquals(expected.apply(first, second), actual.apply(second).apply(first).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, R, V extends String> void doCheckEqualsFunctionArrayResult(
            Function<? super T, ? extends R[]> expected, T first,
            Function<? super T, ? extends Function<? super V, ? extends R[]>> actual, V value) {
        assertArrayEquals(expected.apply(first), actual.apply(first).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, R, V extends String> void doCheckEqualsFunctionArrayResult(
            BiFunction<? super T, ? super U, ? extends R[]> expected, T first, U second,
            BiFunction<? super T, ? super U, ? extends Function<? super V, ? extends R[]>> actual, V value) {
        assertArrayEquals(expected.apply(first, second), actual.apply(first, second).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, R, V extends String> void doCheckEqualsLeftFunctionArrayResult(
            BiFunction<? super T, ? super U, ? extends R[]> expected, T first, U second,
            Function<? super T, ? extends Function<? super U, ? extends Function<? super V, ? extends R[]>>> actual,
            V value) {
        assertArrayEquals(expected.apply(first, second), actual.apply(first).apply(second).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, R, V extends String> void doCheckEqualsRightFunctionArrayResult(
            BiFunction<? super T, ? super U, ? extends R[]> expected, T first, U second,
            Function<? super U, ? extends Function<? super T, ? extends Function<? super V, ? extends R[]>>> actual,
            V value) {
        assertArrayEquals(expected.apply(first, second), actual.apply(second).apply(first).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, V extends String> void doCheckEqualsFunctionByteArrayResult(
            Function<? super T, ? extends byte[]> expected, T first,
            Function<? super T, ? extends Function<? super V, ? extends byte[]>> actual, V value) {
        assertArrayEquals(expected.apply(first), actual.apply(first).apply(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, V extends String> void doCheckEqualsPredicateResult(
            Predicate<? super T> expected, T first,
            Function<? super T, ? extends Predicate<? super V>> actual, V value) {
        assertEquals(expected.test(first), actual.apply(first).test(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, V extends String> void doCheckEqualsPredicateResult(
            BiPredicate<? super T, ? super U> expected, T first, U second,
            BiFunction<? super T, ? super U, ? extends Predicate<? super V>> actual, V value) {
        assertEquals(expected.test(first, second), actual.apply(first, second).test(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, V extends String> void doCheckEqualsLeftPredicateResult(
            BiPredicate<? super T, ? super U> expected, T first, U second,
            Function<? super T, ? extends Function<? super U, ? extends Predicate<? super V>>> actual, V value) {
        assertEquals(expected.test(first, second), actual.apply(first).apply(second).test(value));
    }

    @SuppressWarnings("SameParameterValue")
    private <T, U, V extends String> void doCheckEqualsRightPredicateResult(
            BiPredicate<? super T, ? super U> expected, T first, U second,
            Function<? super U, ? extends Function<? super T, ? extends Predicate<? super V>>> actual, V value) {
        assertEquals(expected.test(first, second), actual.apply(second).apply(first).test(value));
    }

    @Test
    public void checkReplaceFirst() {
        doCheckEqualsFunctionResult(STRING::replaceFirst, REGEX, REPLACEMENT, StringX::replaceFirst, STRING);
    }

    @Test
    public void checkLeftReplaceFirst() {
        doCheckEqualsLeftFunctionResult(STRING::replaceFirst, REGEX, REPLACEMENT, StringX::leftReplaceFirst, STRING);
    }

    @Test
    public void checkRightReplaceFirst() {
        doCheckEqualsLeftFunctionResult(STRING::replaceFirst, REGEX, REPLACEMENT, StringX::rightReplaceFirst, STRING);
    }

    @Test
    public void checkReplaceAll() {
        doCheckEqualsFunctionResult(STRING::replaceAll, REGEX, REPLACEMENT, StringX::replaceAll, STRING);
    }

    @Test
    public void checkLeftReplaceAll() {
        doCheckEqualsLeftFunctionResult(STRING::replaceAll, REGEX, REPLACEMENT, StringX::leftReplaceAll, STRING);
    }

    @Test
    public void checkRightReplaceAll() {
        doCheckEqualsRightFunctionResult(STRING::replaceAll, REGEX, REPLACEMENT, StringX::rightReplaceAll, STRING);
    }

    @Test
    public void checkReplaceWithChar() {
        doCheckEqualsFunctionResult(STRING::replace, S, C, StringX::replace, STRING);
    }

    @Test
    public void checkLeftReplaceWithChar() {
        doCheckEqualsLeftFunctionResult(STRING::replace, S, C, StringX::leftReplace, STRING);
    }

    @Test
    public void checkRightReplaceWithChar() {
        doCheckEqualsRightFunctionResult(STRING::replace, S, C, StringX::rightReplace, STRING);
    }

    @Test
    public void checkReplaceWithCharSequence() {
        doCheckEqualsFunctionResult(STRING::replace, STR, REPLACEMENT, StringX::replace, STRING);
    }

    @Test
    public void checkLeftReplaceWithCharSequence() {
        doCheckEqualsLeftFunctionResult(STRING::replace, STR, REPLACEMENT, StringX::leftReplace, STRING);
    }

    @Test
    public void checkRightReplaceWithCharSequence() {
        doCheckEqualsRightFunctionResult(STRING::replace, STR, REPLACEMENT, StringX::rightReplace, STRING);
    }

    @Test
    public void checkSubstring() {
        doCheckEqualsFunctionResult(STRING::substring, ONE, StringX::substring, STRING);
    }

    @Test
    public void checkSubstringWithEnd() {
        doCheckEqualsFunctionResult(STRING::substring, ONE, THREE, StringX::substring, STRING);
    }

    @Test
    public void checkLeftSubstringWithEnd() {
        doCheckEqualsLeftFunctionResult(STRING::substring, ONE, THREE, StringX::leftSubstring, STRING);
    }

    @Test
    public void checkRightSubstringWithEnd() {
        doCheckEqualsRightFunctionResult(STRING::substring, ONE, THREE, StringX::rightSubstring, STRING);
    }

    @Test
    public void checkConcat() {
        doCheckEqualsFunctionResult(STRING::concat, STR, StringX::concat, STRING);
    }

    @Test
    public void checkSplit() {
        doCheckEqualsFunctionArrayResult(STRING::split, REGEX, StringX::split, STRING);
    }

    @Test
    public void checkSplitWithLimit() {
        doCheckEqualsFunctionArrayResult(STRING::split, REGEX, ONE, StringX::split, STRING);
    }

    @Test
    public void checkLeftSplitWithLimit() {
        doCheckEqualsLeftFunctionArrayResult(STRING::split, REGEX, ONE, StringX::leftSplit, STRING);
    }

    @Test
    public void checkRightSplitWithLimit() {
        doCheckEqualsRightFunctionArrayResult(STRING::split, REGEX, ONE, StringX::rightSplit, STRING);
    }

    @Test
    public void checkSubSequence() {
        doCheckEqualsFunctionResult(STRING::subSequence, ONE, THREE, StringX::subSequence, STRING);
    }

    @Test
    public void checkLeftSubSequence() {
        doCheckEqualsLeftFunctionResult(STRING::subSequence, ONE, THREE, StringX::leftSubSequence, STRING);
    }

    @Test
    public void checkRightSubSequence() {
        doCheckEqualsRightFunctionResult(STRING::subSequence, ONE, THREE, StringX::rightSubSequence, STRING);
    }

    @Test
    public void checkCharAt() {
        doCheckEqualsFunctionResult(STRING::charAt, ONE, StringX::charAt, STRING);
    }

    @Test
    public void checkCharIndexOf() {
        doCheckEqualsFunctionResult(STRING::indexOf, S, StringX::indexOf, STRING);
    }

    @Test
    public void checkCharIndexOfWithIndex() {
        doCheckEqualsFunctionResult(STRING::indexOf, S, ONE, StringX::indexOf, STRING);
    }

    @Test
    public void checkLeftCharIndexOfWithIndex() {
        doCheckEqualsLeftFunctionResult(STRING::indexOf, S, ONE, StringX::leftIndexOf, STRING);
    }

    @Test
    public void checkRightCharIndexOfWithIndex() {
        doCheckEqualsRightFunctionResult(STRING::indexOf, (int) S, ONE, StringX::rightIndexOfChar, STRING);
    }

    @Test
    public void checkCharLastIndexOf() {
        doCheckEqualsFunctionResult(STRING::lastIndexOf, S, StringX::lastIndexOf, STRING);
    }

    @Test
    public void checkCharLastIndexOfWithIndex() {
        doCheckEqualsFunctionResult(STRING::lastIndexOf, S, ONE, StringX::lastIndexOf, STRING);
    }

    @Test
    public void checkLeftCharLastIndexOfWithIndex() {
        doCheckEqualsLeftFunctionResult(STRING::lastIndexOf, S, ONE, StringX::leftLastIndexOf, STRING);
    }

    @Test
    public void checkRightCharLastIndexOfWithIndex() {
        doCheckEqualsRightFunctionResult(STRING::lastIndexOf, (int) S, ONE, StringX::rightLastIndexOfChar, STRING);
    }

    @Test
    public void checkStringIndexOf() {
        doCheckEqualsFunctionResult(STRING::indexOf, STR, StringX::indexOf, STRING);
    }

    @Test
    public void checkStringIndexOfWithIndex() {
        doCheckEqualsFunctionResult(STRING::indexOf, STR, ONE, StringX::indexOf, STRING);
    }

    @Test
    public void checkLeftStringIndexOfWithIndex() {
        doCheckEqualsLeftFunctionResult(STRING::indexOf, STR, ONE, StringX::leftIndexOf, STRING);
    }

    @Test
    public void checkRightStringIndexOfWithIndex() {
        doCheckEqualsRightFunctionResult(STRING::indexOf, STR, ONE, StringX::rightIndexOfString, STRING);
    }

    @Test
    public void checkStringLastIndexOf() {
        doCheckEqualsFunctionResult(STRING::lastIndexOf, STR, StringX::lastIndexOf, STRING);
    }

    @Test
    public void checkStringLastIndexOfWithIndex() {
        doCheckEqualsFunctionResult(STRING::lastIndexOf, STR, ONE, StringX::lastIndexOf, STRING);
    }

    @Test
    public void checkLeftStringLastIndexOfWithIndex() {
        doCheckEqualsLeftFunctionResult(STRING::lastIndexOf, STR, ONE, StringX::leftLastIndexOf, STRING);
    }

    @Test
    public void checkRightStringLastIndexOfWithIndex() {
        doCheckEqualsRightFunctionResult(STRING::lastIndexOf, STR, ONE, StringX::rightLastIndexOfString, STRING);
    }

    @Test
    public void checkCodePointAt() {
        doCheckEqualsFunctionResult(STRING::codePointAt, ONE, StringX::codePointAt, STRING);
    }

    @Test
    public void checkCodePointBefore() {
        doCheckEqualsFunctionResult(STRING::codePointBefore, ONE, StringX::codePointBefore, STRING);
    }

    @Test
    public void checkCodePointCount() {
        doCheckEqualsFunctionResult(STRING::codePointCount, ONE, THREE, StringX::codePointCount, STRING);
    }

    @Test
    public void checkLeftCodePointCount() {
        doCheckEqualsLeftFunctionResult(STRING::codePointCount, ONE, THREE, StringX::leftCodePointCount, STRING);
    }

    @Test
    public void checkRightCodePointCount() {
        doCheckEqualsRightFunctionResult(STRING::codePointCount, ONE, THREE, StringX::rightCodePointCount, STRING);
    }

    @Test
    public void checkOffsetByCodePoints() {
        doCheckEqualsFunctionResult(STRING::offsetByCodePoints, ONE, THREE, StringX::offsetByCodePoints, STRING);
    }

    @Test
    public void checkLeftOffsetByCodePoints() {
        doCheckEqualsLeftFunctionResult(STRING::offsetByCodePoints, ONE, THREE, StringX::leftOffsetByCodePoints, STRING);
    }

    @Test
    public void checkRightOffsetByCodePoints() {
        doCheckEqualsRightFunctionResult(STRING::offsetByCodePoints, ONE, THREE, StringX::rightOffsetByCodePoints, STRING);
    }

    @Test
    public void checkCompareTo() {
        doCheckEqualsFunctionResult(STRING::compareTo, STR, StringX::compareTo, STRING);
    }

    @Test
    public void checkCompareToIgnoreCase() {
        doCheckEqualsFunctionResult(STRING::compareToIgnoreCase, STR, StringX::compareToIgnoreCase, STRING);
    }

    @Test
    public void checkGetBytes() {
        doCheckEqualsFunctionByteArrayResult(STRING::getBytes, CHARSET, StringX::getBytes, STRING);
    }

    @Test
    public void checkStartsWith() {
        doCheckEqualsPredicateResult(STRING::startsWith, STR, StringX::startsWith, STRING);
    }

    @Test
    public void checkStartsWithIndex() {
        doCheckEqualsPredicateResult(STRING::startsWith, STR, ONE, StringX::startsWith, STRING);
    }

    @Test
    public void checkLeftStartsWithIndex() {
        doCheckEqualsLeftPredicateResult(STRING::startsWith, STR, ONE, StringX::leftStartsWith, STRING);
    }

    @Test
    public void checkRightStartsWithIndex() {
        doCheckEqualsRightPredicateResult(STRING::startsWith, STR, ONE, StringX::rightStartsWith, STRING);
    }

    @Test
    public void checkEndsWith() {
        doCheckEqualsPredicateResult(STRING::endsWith, STR, StringX::endsWith, STRING);
    }

    @Test
    public void checkContains() {
        doCheckEqualsPredicateResult(STRING::contains, STR, StringX::contains, STRING);
    }

    @Test
    public void checkMatches() {
        doCheckEqualsPredicateResult(STRING::matches, REGEX, StringX::matches, STRING);
    }

    @Test
    public void checkContentEqualsToWithStringBuffer() {
        doCheckEqualsPredicateResult(STRING::contentEquals, SB, StringX::contentEqualsTo, STRING);
    }

    @Test
    public void checkContentEqualsToWithCharSequence() {
        doCheckEqualsPredicateResult(STRING::contentEquals, STR, StringX::contentEqualsTo, STRING);
    }

    @Test
    public void checkEqualsIgnoreCaseTo() {
        doCheckEqualsPredicateResult(STRING::equalsIgnoreCase, STR, StringX::equalsIgnoreCaseTo, STRING);
    }

    @Test
    public void checkEqualsTo() {
        doCheckEqualsPredicateResult(STRING::equals, STR, StringX::equalsTo, STRING);
    }
}