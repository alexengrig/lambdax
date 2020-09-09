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

import io.github.alexengrig.lambdax.tuple.set.Settable1;

import java.util.Iterator;

public class Couple<T0, T1> extends Monuple<T0>
        implements Valuable1<T0, T1>, Settable1 {
    protected static final int SIZE = 2;

    protected final T1 value1;

    public Couple(T0 value0, T1 value1) {
        super(value0);
        this.value1 = value1;
    }

    public static <T> Couple<T, T> ofIterable(Iterable<? extends T> collection) {
        Iterator<? extends T> iterator = collection.iterator();
        T value0 = iterator.next();
        T value1 = iterator.next();
        return new Couple<>(value0, value1);
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    protected Object[] asArray() {
        return new Object[]{value0, value1};
    }

    @Override
    public <R0> Couple<R0, T1> setAt0(R0 value0) {
        return new Couple<>(value0, value1);
    }

    @Override
    public Monuple<T1> removeAt0() {
        return new Monuple<>(value1);
    }

    @Override
    public T1 valueAt1() {
        return value1;
    }

    @Override
    public <R1> Couple<T0, R1> setAt1(R1 value1) {
        return new Couple<>(value0, value1);
    }

    public Monuple<T0> removeAt1() {
        return new Monuple<>(value0);
    }

}
