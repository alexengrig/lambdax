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

package io.github.alexengrig.lambdax.function;

import org.junit.Assert;
import org.junit.Test;

public class TerFunctionTest {
    @Test
    public void checkAndThen() {
        TerFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        int actual = sum.andThen(i -> i * 2).apply(1, 2, 3);
        Assert.assertEquals(12, actual);
    }
}