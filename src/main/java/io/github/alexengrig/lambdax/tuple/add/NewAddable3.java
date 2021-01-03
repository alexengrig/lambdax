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

public interface NewAddable3<T0, T1, T2> extends NewAddable2<T0, T1> {
    @Override
    <R0> NewAddable3<R0, T0, T1> addAt0(R0 value0);

    @Override
    <R1> NewAddable3<T0, R1, T1> addAt1(R1 value1);

    @Override
    <R2> NewAddable3<T0, T1, R2> addAt2(R2 value2);

    <R3> NewAddable addAt3(R3 value3);
}
