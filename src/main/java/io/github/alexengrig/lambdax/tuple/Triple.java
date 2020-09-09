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

import java.util.Iterator;

public class Triple<T0, T1, T2> extends Couple<T0, T1> implements Valuable2<T0, T1, T2> {
    protected static final int SIZE = 3;

    protected final T2 value2;

    public Triple(T0 value0, T1 value1, T2 value2) {
        super(value0, value1);
        this.value2 = value2;
    }

    public static <T> Triple<T, T, T> of(Iterable<? extends T> iterable) {
        Iterator<? extends T> iterator = iterable.iterator();
        T value0 = iterator.next();
        T value1 = iterator.next();
        T value2 = iterator.next();
        return new Triple<>(value0, value1, value2);
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    protected Object[] asArray() {
        return new Object[]{value0, value1, value2};
    }

    @Override
    public T2 value2() {
        return value2;
    }
}
