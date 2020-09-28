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

package io.github.alexengrig.lambdax.tuple.set;

public interface Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>
        extends Settable14<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> {
    @Override
    <R0> Settable15<R0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt0(R0 value0);

    @Override
    <R1> Settable15<T0, R1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt1(R1 value1);

    @Override
    <R2> Settable15<T0, T1, R2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt2(R2 value2);

    @Override
    <R3> Settable15<T0, T1, T2, R3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt3(R3 value3);

    @Override
    <R4> Settable15<T0, T1, T2, T3, R4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt4(R4 value4);

    @Override
    <R5> Settable15<T0, T1, T2, T3, T4, R5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt5(R5 value5);

    @Override
    <R6> Settable15<T0, T1, T2, T3, T4, T5, R6, T7, T8, T9, T10, T11, T12, T13, T14, T15> setAt6(R6 value6);

    @Override
    <R7> Settable15<T0, T1, T2, T3, T4, T5, T6, R7, T8, T9, T10, T11, T12, T13, T14, T15> setAt7(R7 value7);

    @Override
    <R8> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, R8, T9, T10, T11, T12, T13, T14, T15> setAt8(R8 value8);

    @Override
    <R9> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, R9, T10, T11, T12, T13, T14, T15> setAt9(R9 value9);

    @Override
    <R10> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R10, T11, T12, T13, T14, T15> setAt10(R10 value10);

    @Override
    <R11> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R11, T12, T13, T14, T15> setAt11(R11 value11);

    @Override
    <R12> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R12, T13, T14, T15> setAt12(R12 value12);

    @Override
    <R13> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R13, T14, T15> setAt13(R13 value13);

    @Override
    <R14> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R14, T15> setAt14(R14 value14);

    <R15> Settable15<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R15> setAt15(R15 value15);
}