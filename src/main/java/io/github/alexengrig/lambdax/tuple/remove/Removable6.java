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

public interface Removable6<T0, T1, T2, T3, T4, T5, T6> extends Removable5<T0, T1, T2, T3, T4, T5> {
    @Override
    Removable5<T1, T2, T3, T4, T5, T6> removeAt0();

    @Override
    Removable5<T0, T2, T3, T4, T5, T6> removeAt1();

    @Override
    Removable5<T0, T1, T3, T4, T5, T6> removeAt2();

    @Override
    Removable5<T0, T1, T2, T4, T5, T6> removeAt3();

    @Override
    Removable5<T0, T1, T2, T3, T5, T6> removeAt4();

    @Override
    Removable5<T0, T1, T2, T3, T4, T6> removeAt5();

    Removable5<T0, T1, T2, T3, T4, T5> removeAt6();
}
