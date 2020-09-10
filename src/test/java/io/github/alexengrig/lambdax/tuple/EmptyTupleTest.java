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

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EmptyTupleTest extends TupleTester {
    @Override
    protected int getSize() {
        return EmptyTuple.SIZE;
    }

    @Override
    protected Tuple getTuple(Collection<String> collection) {
        return EmptyTuple.INSTANCE;
    }

    @Override
    public void should_work_correctly_equals() {
        Tuple tuple = getTupleWithValues();
        Tuple other = getTupleWithOtherValues();
        assertEquals(tuple, tuple);
        assertEquals(tuple, other);
        assertNotEquals(tuple, null);
    }

    @Override
    public void should_work_correctly_hashCode() {
        Tuple tuple = getTupleWithValues();
        Tuple other = getTupleWithOtherValues();
        assertEquals(tuple.hashCode(), tuple.hashCode());
        assertEquals(tuple.hashCode(), other.hashCode());
    }
}