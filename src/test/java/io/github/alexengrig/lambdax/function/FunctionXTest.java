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

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FunctionXTest {
    private final Function<String, String> concat1 = s -> s + ".1.";
    private final Function<String, String> concat2 = s -> s + ".2.";
    private final Function<String, String> concat3 = s -> s + ".3.";
    private final Function<String, String> concat4 = s -> s + ".4.";
    private final Function<String, String> concat5 = s -> s + ".5.";
    private final Function<String, String> concat6 = s -> s + ".6.";
    private final Function<String, String> concat7 = s -> s + ".7.";
    private final Function<String, String> concat8 = s -> s + ".8.";
    private final Function<String, String> concat9 = s -> s + ".9.";
    private final Function<String, String> concat10 = s -> s + ".10.";
    private final Function<String, String> concat11 = s -> s + ".11.";
    private final Function<String, String> concat12 = s -> s + ".12.";
    private final Function<String, String> concat13 = s -> s + ".13.";
    private final Function<String, String> concat14 = s -> s + ".14.";
    private final Function<String, String> concat15 = s -> s + ".15.";
    private final Function<String, String> concat16 = s -> s + ".16.";

    @Test
    public void checkNullSafe() {
        Function<Object, String> nullSafetyFunction =
                FunctionX.nullSafe(t -> "GitHub");
        assertNull(nullSafetyFunction.apply(null));
    }

    @Test
    public void checkNullSafeNullable() {
        String value = "GitHub";
        Function<Object, String> nullSafetyFunction =
                FunctionX.nullSafe(t -> value);
        assertEquals(value, nullSafetyFunction.apply("GitLab"));
    }

    @Test
    public void checkPipe2() {
        final String expected = ".1..2.";
        final Function<String, String> concatFrom1To2 = FunctionX.pipe(
                concat1, concat2);
        final String actual = concatFrom1To2.apply("");
        assertEquals("Concat from 1 to 2", expected, actual);
    }

    @Test
    public void checkPipe3() {
        final String expected = ".1..2..3.";
        final Function<String, String> concatFrom1To3 = FunctionX.pipe(
                concat1, concat2, concat3);
        final String actual = concatFrom1To3.apply("");
        assertEquals("Concat from 1 to 3", expected, actual);
    }

    @Test
    public void checkPipe4() {
        final String expected = ".1..2..3..4.";
        final Function<String, String> concatFrom1To4 = FunctionX.pipe(
                concat1, concat2, concat3, concat4);
        final String actual = concatFrom1To4.apply("");
        assertEquals("Concat from 1 to 4", expected, actual);
    }

    @Test
    public void checkPipe5() {
        final String expected = ".1..2..3..4..5.";
        final Function<String, String> concatFrom1To5 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5);
        final String actual = concatFrom1To5.apply("");
        assertEquals("Concat from 1 to 5", expected, actual);
    }

    @Test
    public void checkPipe6() {
        final String expected = ".1..2..3..4..5..6.";
        final Function<String, String> concatFrom1To6 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6);
        final String actual = concatFrom1To6.apply("");
        assertEquals("Concat from 1 to 6", expected, actual);
    }

    @Test
    public void checkPipe7() {
        final String expected = ".1..2..3..4..5..6..7.";
        final Function<String, String> concatFrom1To7 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7);
        final String actual = concatFrom1To7.apply("");
        assertEquals("Concat from 1 to 7", expected, actual);
    }

    @Test
    public void checkPipe8() {
        final String expected = ".1..2..3..4..5..6..7..8.";
        final Function<String, String> concatFrom1To8 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8);
        final String actual = concatFrom1To8.apply("");
        assertEquals("Concat from 1 to 8", expected, actual);
    }

    @Test
    public void checkPipe9() {
        final String expected = ".1..2..3..4..5..6..7..8..9.";
        final Function<String, String> concatFrom1To9 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9);
        final String actual = concatFrom1To9.apply("");
        assertEquals("Concat from 1 to 9", expected, actual);
    }

    @Test
    public void checkPipe10() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10.";
        final Function<String, String> concatFrom1To10 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10);
        final String actual = concatFrom1To10.apply("");
        assertEquals("Concat from 1 to 10", expected, actual);
    }

    @Test
    public void checkPipe11() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10..11.";
        final Function<String, String> concatFrom1To11 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11);
        final String actual = concatFrom1To11.apply("");
        assertEquals("Concat from 1 to 11", expected, actual);
    }

    @Test
    public void checkPipe12() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10..11..12.";
        final Function<String, String> concatFrom1To12 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12);
        final String actual = concatFrom1To12.apply("");
        assertEquals("Concat from 1 to 12", expected, actual);
    }

    @Test
    public void checkPipe13() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10..11..12..13.";
        final Function<String, String> concatFrom1To13 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13);
        final String actual = concatFrom1To13.apply("");
        assertEquals("Concat from 1 to 13", expected, actual);
    }

    @Test
    public void checkPipe14() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10..11..12..13..14.";
        final Function<String, String> concatFrom1To14 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13, concat14);
        final String actual = concatFrom1To14.apply("");
        assertEquals("Concat from 1 to 14", expected, actual);
    }

    @Test
    public void checkPipe15() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10..11..12..13..14..15.";
        final Function<String, String> concatFrom1To15 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13, concat14, concat15);
        final String actual = concatFrom1To15.apply("");
        assertEquals("Concat from 1 to 15", expected, actual);
    }

    @Test
    public void checkPipe16() {
        final String expected = ".1..2..3..4..5..6..7..8..9..10..11..12..13..14..15..16.";
        final Function<String, String> concatFrom1To16 = FunctionX.pipe(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13, concat14, concat15, concat16);
        final String actual = concatFrom1To16.apply("");
        assertEquals("Concat from 1 to 16", expected, actual);
    }

    @Test
    public void checkCompose2() {
        final String expected = ".2..1.";
        final Function<String, String> concatFrom2To1 = FunctionX.compose(
                concat1, concat2);
        final String actual = concatFrom2To1.apply("");
        assertEquals("Concat from 2 to 1", expected, actual);
    }

    @Test
    public void checkCompose3() {
        final String expected = ".3..2..1.";
        final Function<String, String> concatFrom3To1 = FunctionX.compose(
                concat1, concat2, concat3);
        final String actual = concatFrom3To1.apply("");
        assertEquals("Concat from 3 to 1", expected, actual);
    }

    @Test
    public void checkCompose4() {
        final String expected = ".4..3..2..1.";
        final Function<String, String> concatFrom4To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4);
        final String actual = concatFrom4To1.apply("");
        assertEquals("Concat from 4 to 1", expected, actual);
    }

    @Test
    public void checkCompose5() {
        final String expected = ".5..4..3..2..1.";
        final Function<String, String> concatFrom5To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5);
        final String actual = concatFrom5To1.apply("");
        assertEquals("Concat from 5 to 1", expected, actual);
    }

    @Test
    public void checkCompose6() {
        final String expected = ".6..5..4..3..2..1.";
        final Function<String, String> concatFrom6To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6);
        final String actual = concatFrom6To1.apply("");
        assertEquals("Concat from 6 to 1", expected, actual);
    }

    @Test
    public void checkCompose7() {
        final String expected = ".7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom7To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7);
        final String actual = concatFrom7To1.apply("");
        assertEquals("Concat from 7 to 1", expected, actual);
    }

    @Test
    public void checkCompose8() {
        final String expected = ".8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom8To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8);
        final String actual = concatFrom8To1.apply("");
        assertEquals("Concat from 8 to 1", expected, actual);
    }

    @Test
    public void checkCompose9() {
        final String expected = ".9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom9To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9);
        final String actual = concatFrom9To1.apply("");
        assertEquals("Concat from 9 to 1", expected, actual);
    }

    @Test
    public void checkCompose10() {
        final String expected = ".10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom10To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10);
        final String actual = concatFrom10To1.apply("");
        assertEquals("Concat from 10 to 1", expected, actual);
    }

    @Test
    public void checkCompose11() {
        final String expected = ".11..10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom11To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11);
        final String actual = concatFrom11To1.apply("");
        assertEquals("Concat from 11 to 1", expected, actual);
    }

    @Test
    public void checkCompose12() {
        final String expected = ".12..11..10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom12To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12);
        final String actual = concatFrom12To1.apply("");
        assertEquals("Concat from 12 to 1", expected, actual);
    }

    @Test
    public void checkCompose13() {
        final String expected = ".13..12..11..10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom13To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13);
        final String actual = concatFrom13To1.apply("");
        assertEquals("Concat from 13 to 1", expected, actual);
    }

    @Test
    public void checkCompose14() {
        final String expected = ".14..13..12..11..10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom14To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13, concat14);
        final String actual = concatFrom14To1.apply("");
        assertEquals("Concat from 14 to 1", expected, actual);
    }

    @Test
    public void checkCompose15() {
        final String expected = ".15..14..13..12..11..10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom15To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13, concat14, concat15);
        final String actual = concatFrom15To1.apply("");
        assertEquals("Concat from 15 to 1", expected, actual);
    }

    @Test
    public void checkCompose16() {
        final String expected = ".16..15..14..13..12..11..10..9..8..7..6..5..4..3..2..1.";
        final Function<String, String> concatFrom16To1 = FunctionX.compose(
                concat1, concat2, concat3, concat4,
                concat5, concat6, concat7, concat8,
                concat9, concat10, concat11, concat12,
                concat13, concat14, concat15, concat16);
        final String actual = concatFrom16To1.apply("");
        assertEquals("Concat from 16 to 1", expected, actual);
    }
}
