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

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class CoupleTest extends TupleTester {
    @Override
    protected int getSize() {
        return Couple.SIZE;
    }

    @Override
    protected Tuple getTuple(Collection<String> collection) {
        return Couple.of(collection);
    }

    @Test
    public void should_set_value0() {
        Couple<Integer, String> oldCouple = new Couple<>(0, "1");
        Couple<String, String> couple = oldCouple.setAt0("0");
        assertEquals("0", couple.value0());
        assertEquals("1", couple.value1());
    }

    @Test
    public void should_set_value1() {
        Couple<String, Integer> oldCouple = new Couple<>("0", 1);
        Couple<String, String> couple = oldCouple.setAt1("1");
        assertEquals("0", couple.value0());
        assertEquals("1", couple.value1());
    }

    @Test
    public void should_remove_value0() {
        Couple<Integer, String> couple = new Couple<>(0, "1");
        Monuple<String> monuple = couple.removeAt0();
        assertEquals("1", monuple.value0());
    }

    @Test
    public void should_remove_value1() {
        Couple<String, Integer> couple = new Couple<>("0", 1);
        Monuple<String> monuple = couple.removeAt1();
        assertEquals("0", monuple.value0());
    }


}