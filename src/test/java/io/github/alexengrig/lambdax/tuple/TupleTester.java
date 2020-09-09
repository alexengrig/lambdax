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
            String actual = tuple.valueAt(i++);
            assertSame(expected, actual);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void should_throw_IndexOutOfBounds_on_valueByIndex() {
        Tuple tuple = getTuple(getValues());
        tuple.valueAt(tuple.size());
    }

    @Test
    public <T extends String> void should_return_value0() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable0) {
            @SuppressWarnings("unchecked")
            Valuable0<T> valuable0 = (Valuable0<T>) tuple;
            assertSame(values.get(0), valuable0.valueAt0());
        }
    }

    @Test
    public <T extends String> void should_return_value1() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable1) {
            @SuppressWarnings("unchecked")
            Valuable1<T, T> valuable1 = (Valuable1<T, T>) tuple;
            assertSame(values.get(1), valuable1.valueAt1());
        }
    }

    @Test
    public <T extends String> void should_return_value2() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable2) {
            @SuppressWarnings("unchecked")
            Valuable2<T, T, T> valuable2 = (Valuable2<T, T, T>) tuple;
            assertSame(values.get(2), valuable2.valueAt2());
        }
    }

    @Test
    public <T extends String> void should_return_value3() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable3) {
            @SuppressWarnings("unchecked")
            Valuable3<T, T, T, T> valuable3 = (Valuable3<T, T, T, T>) tuple;
            assertSame(values.get(3), valuable3.valueAt3());
        }
    }

    @Test
    public <T extends String> void should_return_value4() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable4) {
            @SuppressWarnings("unchecked")
            Valuable4<T, T, T, T, T> valuable4 = (Valuable4<T, T, T, T, T>) tuple;
            assertSame(values.get(4), valuable4.valueAt4());
        }
    }

    @Test
    public <T extends String> void should_return_value5() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable5) {
            @SuppressWarnings("unchecked")
            Valuable5<T, T, T, T, T, T> valuable5 = (Valuable5<T, T, T, T, T, T>) tuple;
            assertSame(values.get(5), valuable5.valueAt5());
        }
    }

    @Test
    public <T extends String> void should_return_value6() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable6) {
            @SuppressWarnings("unchecked")
            Valuable6<T, T, T, T, T, T, T> valuable6 = (Valuable6<T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(6), valuable6.valueAt6());
        }
    }

    @Test
    public <T extends String> void should_return_value7() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable7) {
            @SuppressWarnings("unchecked")
            Valuable7<T, T, T, T, T, T, T, T> valuable7 = (Valuable7<T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(7), valuable7.valueAt7());
        }
    }

    @Test
    public <T extends String> void should_return_value8() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable8) {
            @SuppressWarnings("unchecked")
            Valuable8<T, T, T, T, T, T, T, T, T> valuable8 = (Valuable8<T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(8), valuable8.valueAt8());
        }
    }

    @Test
    public <T extends String> void should_return_value9() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable9) {
            @SuppressWarnings("unchecked")
            Valuable9<T, T, T, T, T, T, T, T, T, T> valuable9 = (Valuable9<T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(9), valuable9.valueAt9());
        }
    }

    @Test
    public <T extends String> void should_return_value10() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable10) {
            @SuppressWarnings("unchecked")
            Valuable10<T, T, T, T, T, T, T, T, T, T, T> valuable10 =
                    (Valuable10<T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(10), valuable10.valueAt10());
        }
    }

    @Test
    public <T extends String> void should_return_value11() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable11) {
            @SuppressWarnings("unchecked")
            Valuable11<T, T, T, T, T, T, T, T, T, T, T, T> valuable11 =
                    (Valuable11<T, T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(11), valuable11.valueAt11());
        }
    }

    @Test
    public <T extends String> void should_return_value12() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable12) {
            @SuppressWarnings("unchecked")
            Valuable12<T, T, T, T, T, T, T, T, T, T, T, T, T> valuable12 =
                    (Valuable12<T, T, T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(12), valuable12.valueAt12());
        }
    }

    @Test
    public <T extends String> void should_return_value13() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable13) {
            @SuppressWarnings("unchecked")
            Valuable13<T, T, T, T, T, T, T, T, T, T, T, T, T, T> valuable13 =
                    (Valuable13<T, T, T, T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(13), valuable13.valueAt13());
        }
    }

    @Test
    public <T extends String> void should_return_value14() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable14) {
            @SuppressWarnings("unchecked")
            Valuable14<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T> valuable14 =
                    (Valuable14<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(14), valuable14.valueAt14());
        }
    }

    @Test
    public <T extends String> void should_return_value15() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable15) {
            @SuppressWarnings("unchecked")
            Valuable15<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T> valuable15 =
                    (Valuable15<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(15), valuable15.valueAt15());
        }
    }

    @Test
    public <T extends String> void should_return_value16() {
        List<String> values = getValues();
        Tuple tuple = getTuple(values);
        if (tuple instanceof Valuable16) {
            @SuppressWarnings("unchecked")
            Valuable16<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T> valuable16 =
                    (Valuable16<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>) tuple;
            assertSame(values.get(16), valuable16.valueAt16());
        }
    }
}
