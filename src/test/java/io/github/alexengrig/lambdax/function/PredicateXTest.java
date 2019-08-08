/*
 * Copyright 2019 LambdaX contributors
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

import io.github.alexengrig.lambdax.example.Box;
import io.github.alexengrig.lambdax.example.Item;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class PredicateXTest {
    @Test
    public void checkPredicate() {
        Box box = new Box(new Item("Coca-Cola"));
        Predicate<Box> equalsCocaCola = PredicateX.of(Box::getItem).map(Item::getName).check("Coca-Cola"::equals);
        assertTrue(equalsCocaCola.test(box));
    }

    @Test
    public void checkComparablePredicate() {
        Box box = new Box(new Item("Coca-Cola"));
        Predicate<Box> equalsCocaCola = PredicateX.ofComparable(Box::getItem).map(Item::getName).less("Pepsi");
        assertTrue(equalsCocaCola.test(box));
    }
}