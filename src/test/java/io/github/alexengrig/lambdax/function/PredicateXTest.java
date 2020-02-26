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
import io.github.alexengrig.lambdax.entity.Holder;
import io.github.alexengrig.lambdax.entity.Item;
import io.github.alexengrig.lambdax.entity.Pack;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PredicateXTest {
    @Test
    public void checkTruth() {
        assertTrue(PredicateX.truth().test(null));
    }

    @Test
    public void checkLie() {
        assertFalse(PredicateX.lie().test(null));
    }

    @Test
    public void checkNegate() {
        assertFalse(PredicateX.not(PredicateX.truth()).test(null));
    }

    @Test
    public void checkFrom() {
        assertTrue(PredicateX.from(Box::isEmpty).test(new Box(null)));
    }

    @Test
    public void checkChecker() {
        String value = "Coca-Cola";
        Holder<Box> boxHolder = new Holder<>(new Box(new Pack(new Item(value))));
        Predicate<Holder<Box>> isEmptyItemName = PredicateX.of(Holder<Box>::get)
                .map(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .check(String::isEmpty);
        assertFalse(isEmptyItemName.test(boxHolder));
    }

    @Test
    public void checkCheckerNullable() {
        Holder<Box> boxHolder = new Holder<>(null);
        Predicate<Holder<Box>> isEmptyItemName = PredicateX.ofNullable(Holder<Box>::get)
                .map(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .check(Objects::isNull)
                .orLie();
        assertFalse(isEmptyItemName.test(boxHolder));
    }

    @Test
    public void checkCheckerChaining() {
        String value = "Coca-Cola";
        Holder<Box> boxHolder = new Holder<>(new Box(new Pack(new Item(value))));
        List<Holder<Box>> list = Stream.of(boxHolder)
                .filter(PredicateX.of(Holder<Box>::get)
                        .map(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .check(String::isEmpty))
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkCheckerNullableChaining() {
        Holder<Box> boxHolder = new Holder<>(null);
        List<Holder<Box>> list = Stream.of(boxHolder)
                .filter(PredicateX.ofNullable(Holder<Box>::get)
                        .map(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .check(String::isEmpty)
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkIsNull() {
        String value = "Monster Energy";
        Pack pack = new Pack(new Item(value));
        Predicate<Pack> isNullItemName = PredicateX.of(Pack::getItem).map(Item::getName).isNull();
        assertFalse(isNullItemName.test(pack));
    }

    @Test
    public void checkIsNullNullable() {
        Pack pack = new Pack(null);
        Predicate<Pack> isNullItemName = PredicateX.ofNullable(Pack::getItem).map(Item::getName).isNull();
        assertTrue(isNullItemName.test(pack));
    }

    @Test
    public void checkIsNullChaining() {
        String value = "Monster Energy";
        Pack pack = new Pack(new Item(value));
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.of(Pack::getItem).map(Item::getName).isNull())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkIsNullNullableChaining() {
        Pack pack = new Pack(null);
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.ofNullable(Pack::getItem).map(Item::getName).isNull())
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkNonNull() {
        String value = "Red Bull";
        Pack pack = new Pack(new Item(value));
        Predicate<Pack> nonNullItemName = PredicateX.of(Pack::getItem).map(Item::getName).nonNull();
        assertTrue(nonNullItemName.test(pack));
    }

    @Test
    public void checkNonNullNullable() {
        Pack pack = new Pack(null);
        Predicate<Pack> nonNullItemName = PredicateX.ofNullable(Pack::getItem).map(Item::getName).nonNull();
        assertFalse(nonNullItemName.test(pack));
    }

    @Test
    public void checkNonNullChaining() {
        String value = "Red Bull";
        Pack pack = new Pack(new Item(value));
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.of(Pack::getItem).map(Item::getName).nonNull())
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkNonNullNullableChaining() {
        Pack pack = new Pack(null);
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.ofNullable(Pack::getItem).map(Item::getName).nonNull())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkEqual() {
        String value = "Coca-Cola";
        Pack pack = new Pack(new Item(value));
        Predicate<Pack> equalsCocaCola = PredicateX.of(Pack::getItem).map(Item::getName).equal(value);
        assertTrue(equalsCocaCola.test(pack));
    }

    @Test
    public void checkEqualNullable() {
        String value = "Coca-Cola";
        Pack pack = new Pack(null);
        Predicate<Pack> equalsCocaCola = PredicateX.ofNullable(Pack::getItem).map(Item::getName).equal(value).orLie();
        assertFalse(equalsCocaCola.test(pack));
    }

    @Test
    public void checkEqualChaining() {
        String value = "Coca-Cola";
        Pack pack = new Pack(new Item(value));
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.ofNullable(Pack::getItem).map(Item::getName).equal(value).orTruth())
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkEqualNullableChaining() {
        String value = "Coca-Cola";
        Pack pack = new Pack(null);
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.ofNullable(Pack::getItem).map(Item::getName).equal(value).orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLessWithComparator() {
        String value = "Pepsi";
        Box box = new Box(new Pack(new Item(value)));
        Pack pack = new Pack(new Item("Coca-Cola"));
        Predicate<Box> lessPepsi = PredicateX.of(Box::getPack)
                .less(pack, Comparator.comparing(p -> p.getItem().getName()));
        assertFalse(lessPepsi.test(box));
    }

    @Test
    public void checkLessNullableWithComparator() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Coca-Cola"));
        Predicate<Box> lessPepsi = PredicateX.ofNullable(Box::getPack)
                .less(pack, Comparator.comparing(p -> p.getItem().getName()))
                .orLie();
        assertFalse(lessPepsi.test(box));
    }

    @Test
    public void checkLessWithComparatorChaining() {
        String value = "Pepsi";
        Box box = new Box(new Pack(new Item(value)));
        Pack pack = new Pack(new Item("Coca-Cola"));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.of(Box::getPack).less(pack, Comparator.comparing(p -> p.getItem().getName())))
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLessNullableWithComparatorChaining() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Coca-Cola"));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.ofNullable(Box::getPack)
                        .less(pack, Comparator.comparing(p -> p.getItem().getName()))
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLess() {
        String value = "Coca-Cola";
        Box box = new Box(new Pack(new Item(value)));
        Predicate<Box> lessPepsi = PredicateX.of(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .less("Pepsi");
        assertTrue(lessPepsi.test(box));
    }

    @Test
    public void checkLessNullable() {
        Box box = new Box(null);
        Predicate<Box> lessPepsi = PredicateX.ofNullable(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .less("Pepsi")
                .orLie();
        assertFalse(lessPepsi.test(box));
    }

    @Test
    public void checkLessChaining() {
        String value = "Coca-Cola";
        Box box = new Box(new Pack(new Item(value)));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.of(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .less("Pepsi"))
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkLessNullableChaining() {
        Box box = new Box(null);
        List<Box> list = Stream.of(box)
                .filter(PredicateX.ofNullable(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .less("Pepsi")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreaterWithComparator() {
        String value = "Dr Pepper";
        Box box = new Box(new Pack(new Item(value)));
        Pack pack = new Pack(new Item("Schweppes"));
        Predicate<Box> greaterCocaCola = PredicateX.of(Box::getPack)
                .greater(pack, Comparator.comparing(p -> p.getItem().getName()));
        assertFalse(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterNullableWithComparator() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Schweppes"));
        Predicate<Box> greaterCocaCola = PredicateX.ofNullable(Box::getPack)
                .greater(pack, Comparator.comparing(p -> p.getItem().getName()))
                .orLie();
        assertFalse(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterWithComparatorChaining() {
        String value = "Dr Pepper";
        Box box = new Box(new Pack(new Item(value)));
        Pack pack = new Pack(new Item("Schweppes"));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.of(Box::getPack).greater(pack, Comparator.comparing(p -> p.getItem().getName())))
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreaterNullableWithComparatorChaining() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Schweppes"));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.ofNullable(Box::getPack)
                        .greater(pack, Comparator.comparing(p -> p.getItem().getName()))
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreater() {
        String value = "Schweppes";
        Box box = new Box(new Pack(new Item(value)));
        Predicate<Box> greaterCocaCola = PredicateX.of(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greater("Dr Pepper");
        assertTrue(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterNullable() {
        Box box = new Box(null);
        Predicate<Box> greaterCocaCola = PredicateX.ofNullable(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greater("Dr Pepper")
                .orLie();
        assertFalse(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterChaining() {
        String value = "Schweppes";
        Box box = new Box(new Pack(new Item(value)));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.of(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .greater("Dr Pepper"))
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkGreaterNullableChaining() {
        Box box = new Box(null);
        List<Box> list = Stream.of(box)
                .filter(PredicateX.ofNullable(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .greater("Dr Pepper")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLessOrEqual() {
        Box box = new Box(new Pack(new Item("Fanta")));
        Predicate<Box> lessOrEqual = PredicateX.of(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .lessOrEqual("Mirinda");
        assertTrue(lessOrEqual.test(box));
    }

    @Test
    public void checkLessOrEqualNullable() {
        Box box = new Box(null);
        Predicate<Box> lessOrEqual = PredicateX.ofNullable(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .lessOrEqual("Mirinda")
                .orLie();
        assertFalse(lessOrEqual.test(box));
    }

    @Test
    public void checkLessOrEqualNotNullable() {
        String name = "Mirinda";
        Box box = new Box(new Pack(new Item(name)));
        Predicate<Box> lessOrEqual = PredicateX.ofNullable(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .lessOrEqual(name)
                .orLie();
        assertTrue(lessOrEqual.test(box));
    }

    @Test
    public void checkLessOrEqualChaining() {
        String value = "Fanta";
        Box box = new Box(new Pack(new Item(value)));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.of(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .lessOrEqual("Mirinda"))
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkLessOrEqualNullableChaining() {
        Box box = new Box(null);
        List<Box> list = Stream.of(box)
                .filter(PredicateX.ofNullable(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .lessOrEqual("Mirinda")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreaterOrEqual() {
        String value = "Sprite";
        Box box = new Box(new Pack(new Item(value)));
        Predicate<Box> greaterCocaCola = PredicateX.of(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greaterOrEqual("7 Up");
        assertTrue(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterOrEqualNullable() {
        Box box = new Box(null);
        Predicate<Box> greaterCocaCola = PredicateX.ofNullable(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greaterOrEqual("7 Up")
                .orLie();
        assertFalse(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterOrEqualNotNullable() {
        String name = "7 Up";
        Box box = new Box(new Pack(new Item(name)));
        Predicate<Box> greaterCocaCola = PredicateX.ofNullable(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greaterOrEqual(name)
                .orLie();
        assertTrue(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterOrEqualChaining() {
        String value = "Sprite";
        Box box = new Box(new Pack(new Item(value)));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.of(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .greaterOrEqual("7 Up"))
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkGreaterOrEqualNullableChaining() {
        Box box = new Box(null);
        List<Box> list = Stream.of(box)
                .filter(PredicateX.ofNullable(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .greaterOrEqual("7 Up")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkMapNullable() {
        assertTrue(PredicateX.ofNullable(Pack::getItem)
                .map(Item::getPart)
                .isNull()
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkMapToNullable() {
        assertTrue(PredicateX.of(Holder<Box>::get)
                .mapToNullable(Box::getPack)
                .isNull()
                .test(new Holder<>(new Box(null))));
    }

    @Test
    public void checkMapToNullableWithComparable() {
        assertTrue(PredicateX.of(Box::getPack)
                .mapToNullable(Pack::getItem)
                .isNull()
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrElseBoolean() {
        assertTrue(PredicateX.ofNullable(Box::getPack)
                .check(Objects::nonNull)
                .orElse(false)
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrElseBooleanNullable() {
        assertTrue(PredicateX.ofNullable(Box::getPack)
                .check(Objects::nonNull)
                .orElse(true)
                .test(new Box(null)));
    }

    @Test
    public void checkOrElse() {
        assertTrue(PredicateX.ofNullable(Box::getPack)
                .check(Objects::nonNull)
                .orElse(t -> false)
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrElseNullable() {
        assertTrue(PredicateX.ofNullable(Box::getPack)
                .check(Objects::nonNull)
                .orElse(t -> true)
                .test(new Box(null)));
    }

    @Test
    public void checkOrLie() {
        assertTrue(PredicateX.ofNullable(Box::getPack)
                .check(Objects::nonNull)
                .orLie()
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrLieNullable() {
        assertFalse(PredicateX.ofNullable(Box::getPack)
                .check(Objects::isNull)
                .orLie()
                .test(new Box(null)));
    }
}
