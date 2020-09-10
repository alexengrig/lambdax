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

public interface Removable5<T0, T1, T2, T3, T4, T5> extends Removable4<T0, T1, T2, T3, T4> {
    @Override
    Removable4<T1, T2, T3, T4, T5> removeAt0();

    @Override
    Removable4<T0, T2, T3, T4, T5> removeAt1();

    @Override
    Removable4<T0, T1, T3, T4, T5> removeAt2();

    @Override
    Removable4<T0, T1, T2, T4, T5> removeAt3();

    @Override
    Removable4<T0, T1, T2, T3, T5> removeAt4();

    Removable4<T0, T1, T2, T3, T4> removeAt5();
}
