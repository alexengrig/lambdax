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
import static org.junit.Assert.assertSame;

public class MonupleTest extends TupleTester {
    @Override
    protected int getSize() {
        return Monuple.SIZE;
    }

    @Override
    protected Tuple getTuple(Collection<String> collection) {
        return Monuple.ofIterable(collection);
    }

    @Test
    public void should_set_value0() {
        Monuple<Integer> oldMonuple = new Monuple<>(0);
        Monuple<String> monuple = oldMonuple.setAt0("0");
        assertEquals("0", monuple.value0());
    }

    @Test
    public void should_remove_value0() {
        Monuple<Integer> monuple = new Monuple<>(0);
        EmptyTuple emptyTuple = monuple.removeAt0();
        assertSame(EmptyTuple.INSTANCE, emptyTuple);
    }
}