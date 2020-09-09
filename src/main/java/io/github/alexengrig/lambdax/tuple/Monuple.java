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

public class Monuple<T0> extends EmptyTuple implements Valuable0<T0> {
    protected static final int SIZE = 1;

    protected final T0 value0;

    protected transient volatile Object[] array;

    public Monuple(T0 value0) {
        this.value0 = value0;
    }

    public Monuple(Collection<? extends T0> collection) {
        this(collection.iterator().next());
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public <X> X value(int index) {
        requireLegalIndex(index);
        @SuppressWarnings("unchecked")
        X target = (X) toArray()[index];
        return target;
    }

    protected void requireLegalIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(String.format("The index must be from 0 to %d (exclusive)", size()));
        }
    }

    protected Object[] toArray() {
        Object[] target = array;
        if (target == null) {
            synchronized (this) {
                target = array;
                if (target == null) {
                    target = asArray();
                    array = target;
                }
            }
        }
        return target;
    }

    protected Object[] asArray() {
        return new Object[]{value0};
    }

    @Override
    public T0 value0() {
        return value0;
    }

    public <R0> Monuple<R0> setAt0(R0 value0) {
        return new Monuple<>(value0);
    }

    public EmptyTuple removeAt0() {
        return EmptyTuple.INSTANCE;
    }
}
