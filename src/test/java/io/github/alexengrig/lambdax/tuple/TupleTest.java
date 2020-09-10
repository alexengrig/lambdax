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

package io.github.alexengrig.lambdax.tuple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TupleTest {
    @Test
    public void should_create_monuple() {
        Monuple<String> monuple = Tuple.of("0");
        assertEquals("0", monuple.valueAt0());
    }

    @Test
    public void should_create_couple() {
        Couple<String, String> couple = Tuple.of("0", "1");
        assertEquals("0", couple.valueAt0());
        assertEquals("1", couple.valueAt1());
    }

    @Test
    public void should_create_triple() {
        Triple<String, String, String> triple = Tuple.of("0", "1", "2");
        assertEquals("0", triple.valueAt0());
        assertEquals("1", triple.valueAt1());
        assertEquals("2", triple.valueAt2());
    }
}