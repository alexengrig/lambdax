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

package io.github.alexengrig.lambdax.tuple.remove;

public interface Removable12<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>
        extends Removable11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> {
    @Override
    Removable11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> removeAt0();

    @Override
    Removable11<T0, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> removeAt1();

    @Override
    Removable11<T0, T1, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> removeAt2();

    @Override
    Removable11<T0, T1, T2, T4, T5, T6, T7, T8, T9, T10, T11, T12> removeAt3();

    @Override
    Removable11<T0, T1, T2, T3, T5, T6, T7, T8, T9, T10, T11, T12> removeAt4();

    @Override
    Removable11<T0, T1, T2, T3, T4, T6, T7, T8, T9, T10, T11, T12> removeAt5();

    @Override
    Removable11<T0, T1, T2, T3, T4, T5, T7, T8, T9, T10, T11, T12> removeAt6();

    @Override
    Removable11<T0, T1, T2, T3, T4, T5, T6, T8, T9, T10, T11, T12> removeAt7();

    @Override
    Removable11<T0, T1, T2, T3, T4, T5, T6, T7, T9, T10, T11, T12> removeAt8();

    @Override
    Removable11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T10, T11, T12> removeAt9();

    @Override
    Removable11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T11, T12> removeAt10();

    @Override
    Removable11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T12> removeAt11();

    Removable11<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> removeAt12();
}