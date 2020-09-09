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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class TupleTester {
    protected abstract Tuple getTuple(Collection<String> collection);

    protected abstract int getSize();

    protected List<String> getValues() {
        int size = getSize();
        ArrayList<String> values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add("value" + i);
        }
        return values;
    }

    protected Tuple getTupleWithValues() {
        return getTuple(getValues());
    }

    @Test
    public void should_return_size() {
        int expected = getSize();
        Tuple tuple = getTupleWithValues();
        int actual = tuple.size();
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_valueByIndex() {
        Collection<String> values = getValues();
        Tuple tuple = getTuple(values);
        int i = 0;
        for (String expected : values) {
            String actual = tuple.getValue(i++);
            assertSame(expected, actual);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_IndexOutOfBounds_on_valueByIndex() {
        Tuple tuple = getTuple(getValues());
        tuple.getValue(tuple.size());
    }

    @Test
    public void should_return_value0() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable0) {
            @SuppressWarnings("unchecked")
            Valuable0<String> valuable0 = (Valuable0<String>) tuple;
            assertSame(values.get(0), valuable0.getValue0());
        }
    }

    @Test
    public void should_return_value1() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable1) {
            @SuppressWarnings("unchecked")
            Valuable1<String, String> valuable1 = (Valuable1<String, String>) tuple;
            assertSame(values.get(1), valuable1.getValue1());
        }
    }
}
