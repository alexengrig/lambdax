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

public interface Addable7<T0, T1, T2, T3, T4, T5, T6, T7>
        extends Addable6<T0, T1, T2, T3, T4, T5, T6> {
    @Override
    default <R> Addable8<R, T0, T1, T2, T3, T4, T5, T6, T7> add(R value) {
        return addAt0(value);
    }

    @Override
    <R0> Addable8<R0, T0, T1, T2, T3, T4, T5, T6, T7> addAt0(R0 value0);

    @Override
    <R1> Addable8<T0, R1, T1, T2, T3, T4, T5, T6, T7> addAt1(R1 value1);

    @Override
    <R2> Addable8<T0, T1, R2, T2, T3, T4, T5, T6, T7> addAt2(R2 value2);

    @Override
    <R3> Addable8<T0, T1, T2, R3, T3, T4, T5, T6, T7> addAt3(R3 value3);

    @Override
    <R4> Addable8<T0, T1, T2, T3, R4, T4, T5, T6, T7> addAt4(R4 value4);

    @Override
    <R5> Addable8<T0, T1, T2, T3, T4, R5, T5, T6, T7> addAt5(R5 value5);

    @Override
    <R6> Addable8<T0, T1, T2, T3, T4, T5, R6, T6, T7> addAt6(R6 value6);

    <R7> Addable8<T0, T1, T2, T3, T4, T5, T6, R7, T7> addAt7(R7 value7);
}