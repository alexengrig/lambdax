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

public class EmptyTuple implements Tuple {
    public static final EmptyTuple INSTANCE = new EmptyTuple();

    protected static final int SIZE = 0;

    protected EmptyTuple() {
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    public <X> X getValue(int index) {
        throw new IndexOutOfBoundsException("Empty tuple has no values");
    }
}
