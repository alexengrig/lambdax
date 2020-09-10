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

@SuppressWarnings({"unused", "RedundantSuppression"})
public interface Settable6<T0, T1, T2, T3, T4, T5, T6>
        extends Settable5<T0, T1, T2, T3, T4, T5> {
    @Override
    <R0> Settable6<R0, T1, T2, T3, T4, T5, T6> setAt0(R0 value0);

    @Override
    <R1> Settable6<T0, R1, T2, T3, T4, T5, T6> setAt1(R1 value1);

    @Override
    <R2> Settable6<T0, T1, R2, T3, T4, T5, T6> setAt2(R2 value2);

    @Override
    <R3> Settable6<T0, T1, T2, R3, T4, T5, T6> setAt3(R3 value3);

    @Override
    <R4> Settable6<T0, T1, T2, T3, R4, T5, T6> setAt4(R4 value4);

    @Override
    <R5> Settable6<T0, T1, T2, T3, T4, R5, T6> setAt5(R5 value5);

    <R6> Settable6<T0, T1, T2, T3, T4, T5, R6> setAt6(R6 value6);
}