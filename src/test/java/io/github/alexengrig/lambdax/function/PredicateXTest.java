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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PredicateXTest {
    @Test
    public void checkChecker() {
        String value = "Coca-Cola";
        Box box = new Box(new Item(value));
        Predicate<Box> isEmptyItemName = PredicateX.of(Box::getItem).map(Item::getName).check(String::isEmpty);
        assertFalse(isEmptyItemName.test(box));
    }

    @Test
    public void equal() {
        String value = "Coca-Cola";
        Box box = new Box(new Item(value));
        Predicate<Box> equalsCocaCola = PredicateX.of(Box::getItem).map(Item::getName).equal(value);
        assertTrue(equalsCocaCola.test(box));
    }

    @Test
    public void less() {
        String value = "Coca-Cola";
        Box box = new Box(new Item(value));
        Predicate<Box> lessPepsi = PredicateX.of(Box::getItem).map(Item::getName).less("Pepsi");
        assertTrue(lessPepsi.test(box));
    }

    @Test
    public void greater() {
        String value = "Dr Pepper";
        Box box = new Box(new Item(value));
        Predicate<Box> greaterCocaCola = PredicateX.of(Box::getItem).map(Item::getName).greater("Coca-Cola");
        assertTrue(greaterCocaCola.test(box));
    }
}