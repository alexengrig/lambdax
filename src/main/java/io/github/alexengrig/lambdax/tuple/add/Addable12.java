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

package io.github.alexengrig.lambdax.tuple.add;

public interface Addable12<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>
        extends Addable11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> {
    @Override
    default <R> Addable13<R, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> add(R value) {
        return addAt0(value);
    }

    @Override
    <R0> Addable13<R0, T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> addAt0(R0 value0);

    @Override
    <R1> Addable13<T0, R1, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> addAt1(R1 value1);

    @Override
    <R2> Addable13<T0, T1, R2, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> addAt2(R2 value2);

    @Override
    <R3> Addable13<T0, T1, T2, R3, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> addAt3(R3 value3);

    @Override
    <R4> Addable13<T0, T1, T2, T3, R4, T4, T5, T6, T7, T8, T9, T10, T11, T12> addAt4(R4 value4);

    @Override
    <R5> Addable13<T0, T1, T2, T3, T4, R5, T5, T6, T7, T8, T9, T10, T11, T12> addAt5(R5 value5);

    @Override
    <R6> Addable13<T0, T1, T2, T3, T4, T5, R6, T6, T7, T8, T9, T10, T11, T12> addAt6(R6 value6);

    @Override
    <R7> Addable13<T0, T1, T2, T3, T4, T5, T6, R7, T7, T8, T9, T10, T11, T12> addAt7(R7 value7);

    @Override
    <R8> Addable13<T0, T1, T2, T3, T4, T5, T6, T7, R8, T8, T9, T10, T11, T12> addAt8(R8 value8);

    @Override
    <R9> Addable13<T0, T1, T2, T3, T4, T5, T6, T7, T8, R9, T9, T10, T11, T12> addAt9(R9 value9);

    @Override
    <R10> Addable13<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R10, T10, T11, T12> addAt10(R10 value10);

    @Override
    <R11> Addable13<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R11, T11, T12> addAt11(R11 value11);

    <R12> Addable13<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R12, T12> addAt12(R12 value12);
}