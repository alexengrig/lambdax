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

import io.github.alexengrig.lambdax.entity.Box;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptionalPredicateResultITest {
    protected final OptionalPredicateResultI<Box> predicate = checker -> checker;

    @Test
    public void checkOrElseBoolean() {
        assertTrue(predicate.orElse(true).test(new Box(null)));
    }

    @Test
    public void checkOrTruth() {
        assertTrue(predicate.orTruth().test(new Box(null)));
    }

    @Test
    public void checkOrLie() {
        assertFalse(predicate.orLie().test(new Box(null)));
    }
}