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

public interface Tuple {
    static <T0> Monuple<T0> of(T0 value0) {
        return new Monuple<>(value0);
    }

    static <T0, T1> Couple<T0, T1> of(T0 value0, T1 value1) {
        return new Couple<>(value0, value1);
    }

    static <T0, T1, T2> Triple<T0, T1, T2> of(T0 value0, T1 value1, T2 value2) {
        return new Triple<>(value0, value1, value2);
    }

    int size();

    <X> X valueAt(int index);
}
