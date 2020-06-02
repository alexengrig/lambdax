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

import static io.github.alexengrig.lambdax.function.PredicateX.*;
import static org.junit.Assert.*;

public class PredicateXTest {
    private final Predicate<Object> failPredicate = t -> {
        fail("Fail predicate");
        return false;
    };

    @Test
    public void checkXorOperation() {
        assertTrue(truth().xor(lie()).test(null));
    }

    @Test
    public void checkNandOperation() {
        assertTrue(truth().nand(lie()).test(null));
    }

    @Test
    public void checkNorOperation() {
        assertFalse(truth().nor(lie()).test(null));
    }

    @Test
    public void checkXnorOperation() {
        assertFalse(truth().xnor(lie()).test(null));
    }

    @Test
    public void checkTruth() {
        assertTrue(truth().test(null));
    }

    @Test
    public void checkLie() {
        assertFalse(lie().test(null));
    }

    @Test
    public void checkNegate() {
        assertFalse(not(truth()).test(null));
        assertTrue(not(lie()).test(null));
    }

    @Test
    public void checkAnd() {
        assertFalse(and(lie(), lie()).test(null));
        assertFalse(and(lie(), truth()).test(null));
        assertFalse(and(truth(), lie()).test(null));
        assertTrue(and(truth(), truth()).test(null));
    }

    @Test
    public void checkAndWithVarargs() {
        assertFalse(and(lie(), lie(), lie()).test(null));
        assertFalse(and(lie(), lie(), truth()).test(null));
        assertFalse(and(lie(), truth(), lie()).test(null));
        assertFalse(and(lie(), truth(), truth()).test(null));
        assertFalse(and(truth(), lie(), lie()).test(null));
        assertFalse(and(truth(), lie(), truth()).test(null));
        assertFalse(and(truth(), truth(), lie()).test(null));
        assertTrue(and(truth(), truth(), truth()).test(null));
    }

    @Test
    public void checkLazyAnd() {
        assertFalse(and(lie(), failPredicate).test(null));
        assertFalse(and(truth(), lie(), failPredicate).test(null));
    }

    @Test
    public void checkOr() {
        assertFalse(or(lie(), lie()).test(null));
        assertTrue(or(lie(), truth()).test(null));
        assertTrue(or(truth(), lie()).test(null));
        assertTrue(or(truth(), truth()).test(null));
    }

    @Test
    public void checkOrWithVarargs() {
        assertFalse(or(lie(), lie(), lie()).test(null));
        assertTrue(or(lie(), lie(), truth()).test(null));
        assertTrue(or(lie(), truth(), lie()).test(null));
        assertTrue(or(lie(), truth(), truth()).test(null));
        assertTrue(or(truth(), lie(), lie()).test(null));
        assertTrue(or(truth(), lie(), truth()).test(null));
        assertTrue(or(truth(), truth(), lie()).test(null));
        assertTrue(or(truth(), truth(), truth()).test(null));
    }

    @Test
    public void checkLazyOr() {
        assertTrue(or(truth(), failPredicate).test(null));
        assertTrue(or(lie(), truth(), failPredicate).test(null));
    }

    @Test
    public void checkXor() {
        assertFalse(xor(lie(), lie()).test(null));
        assertTrue(xor(lie(), truth()).test(null));
        assertTrue(xor(truth(), lie()).test(null));
        assertFalse(xor(truth(), truth()).test(null));
    }

    @Test
    public void checkXorWithVarargs() {
        assertFalse(xor(lie(), lie(), lie()).test(null));
        assertTrue(xor(lie(), lie(), truth()).test(null));
        assertTrue(xor(lie(), truth(), lie()).test(null));
        assertFalse(xor(lie(), truth(), truth()).test(null));
        assertTrue(xor(truth(), lie(), lie()).test(null));
        assertFalse(xor(truth(), lie(), truth()).test(null));
        assertFalse(xor(truth(), truth(), lie()).test(null));
        assertTrue(xor(truth(), truth(), truth()).test(null));
    }

    @Test
    public void checkNand() {
        assertTrue(nand(lie(), lie()).test(null));
        assertTrue(nand(lie(), truth()).test(null));
        assertTrue(nand(truth(), lie()).test(null));
        assertFalse(nand(truth(), truth()).test(null));
    }

    @Test
    public void checkNandWithVarargs() {
        assertTrue(nand(lie(), lie(), lie()).test(null));
        assertFalse(nand(lie(), lie(), truth()).test(null));
        assertTrue(nand(lie(), truth(), lie()).test(null));
        assertFalse(nand(lie(), truth(), truth()).test(null));
        assertTrue(nand(truth(), lie(), lie()).test(null));
        assertFalse(nand(truth(), lie(), truth()).test(null));
        assertTrue(nand(truth(), truth(), lie()).test(null));
        assertTrue(nand(truth(), truth(), truth()).test(null));
    }

    @Test
    public void checkLazyNand() {
        assertTrue(nand(lie(), failPredicate).test(null));
        assertTrue(nand(truth(), truth(), failPredicate).test(null));
    }

    @Test
    public void checkNor() {
        assertTrue(nor(lie(), lie()).test(null));
        assertFalse(nor(lie(), truth()).test(null));
        assertFalse(nor(truth(), lie()).test(null));
        assertFalse(nor(truth(), truth()).test(null));
    }

    @Test
    public void checkNorWithVarargs() {
        assertFalse(nor(lie(), lie(), lie()).test(null));
        assertFalse(nor(lie(), lie(), truth()).test(null));
        assertTrue(nor(lie(), truth(), lie()).test(null));
        assertFalse(nor(lie(), truth(), truth()).test(null));
        assertTrue(nor(truth(), lie(), lie()).test(null));
        assertFalse(nor(truth(), lie(), truth()).test(null));
        assertTrue(nor(truth(), truth(), lie()).test(null));
        assertFalse(nor(truth(), truth(), truth()).test(null));
    }

    @Test
    public void checkLazyNor() {
        assertFalse(nor(truth(), failPredicate).test(null));
        assertFalse(nor(lie(), lie(), failPredicate).test(null));
    }

    @Test
    public void checkXnor() {
        assertTrue(xnor(lie(), lie()).test(null));
        assertFalse(xnor(lie(), truth()).test(null));
        assertFalse(xnor(truth(), lie()).test(null));
        assertTrue(xnor(truth(), truth()).test(null));
    }

    @Test
    public void checkXnorWithVarargs() {
        assertFalse(xnor(lie(), lie(), lie()).test(null));
        assertTrue(xnor(lie(), lie(), truth()).test(null));
        assertTrue(xnor(lie(), truth(), lie()).test(null));
        assertFalse(xnor(lie(), truth(), truth()).test(null));
        assertTrue(xnor(truth(), lie(), lie()).test(null));
        assertFalse(xnor(truth(), lie(), truth()).test(null));
        assertFalse(xnor(truth(), truth(), lie()).test(null));
        assertTrue(xnor(truth(), truth(), truth()).test(null));
    }

    @Test
    public void checkFrom() {
        assertTrue(PredicateX.of(Box::isEmpty).test(new Box(null)));
    }

    @Test
    public void checkChecker() {
        String value = "Coca-Cola";
        Holder<Box> boxHolder = new Holder<>(new Box(new Pack(new Item(value))));
        Predicate<Holder<Box>> isEmptyItemName = PredicateX.chain(Holder<Box>::get)
                .map(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .check(String::isEmpty);
        assertFalse(isEmptyItemName.test(boxHolder));
    }

    @Test
    public void checkCheckerNullable() {
        Holder<Box> boxHolder = new Holder<>(null);
        Predicate<Holder<Box>> isEmptyItemName = PredicateX.chainSafe(Holder<Box>::get)
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
                .filter(PredicateX.chain(Holder<Box>::get)
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
                .filter(PredicateX.chainSafe(Holder<Box>::get)
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
        Predicate<Pack> isNullItemName = PredicateX.chain(Pack::getItem).map(Item::getName).isNull();
        assertFalse(isNullItemName.test(pack));
    }

    @Test
    public void checkIsNullNullable() {
        Pack pack = new Pack(null);
        Predicate<Pack> isNullItemName = PredicateX.chainSafe(Pack::getItem).map(Item::getName).isNull();
        assertTrue(isNullItemName.test(pack));
    }

    @Test
    public void checkIsNullChaining() {
        String value = "Monster Energy";
        Pack pack = new Pack(new Item(value));
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.chain(Pack::getItem).map(Item::getName).isNull())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkIsNullNullableChaining() {
        Pack pack = new Pack(null);
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.chainSafe(Pack::getItem).map(Item::getName).isNull())
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkNonNull() {
        String value = "Red Bull";
        Pack pack = new Pack(new Item(value));
        Predicate<Pack> nonNullItemName = PredicateX.chain(Pack::getItem).map(Item::getName).nonNull();
        assertTrue(nonNullItemName.test(pack));
    }

    @Test
    public void checkNonNullNullable() {
        Holder<Box> holder = new Holder<>(new Box(null));
        Predicate<Holder<Box>> nonNullItemName = PredicateX.chainSafe(Holder<Box>::get).nonNull();
        assertTrue(nonNullItemName.test(holder));
    }

    @Test
    public void checkNonNullNullableComparable() {
        Pack pack = new Pack(null);
        Predicate<Pack> nonNullItemName = PredicateX.chainSafe(Pack::getItem).map(Item::getName).nonNull();
        assertFalse(nonNullItemName.test(pack));
    }

    @Test
    public void checkNonNullChaining() {
        String value = "Red Bull";
        Pack pack = new Pack(new Item(value));
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.chain(Pack::getItem).map(Item::getName).nonNull())
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkNonNullNullableChaining() {
        Pack pack = new Pack(null);
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.chainSafe(Pack::getItem).map(Item::getName).nonNull())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkEqual() {
        String value = "Coca-Cola";
        Pack pack = new Pack(new Item(value));
        Predicate<Pack> equalsCocaCola = PredicateX.chain(Pack::getItem).map(Item::getName).equal(value);
        assertTrue(equalsCocaCola.test(pack));
    }

    @Test
    public void checkEqualNullable() {
        Holder<Box> holder = new Holder<>(new Box(null));
        Predicate<Holder<Box>> equal = PredicateX.chainSafe(Holder<Box>::get)
                .equal(new Box(null))
                .orTruth();
        assertFalse(equal.test(holder));
    }

    @Test
    public void checkEqualNullableComparable() {
        String value = "Coca-Cola";
        Pack pack = new Pack(null);
        Predicate<Pack> equalsCocaCola = PredicateX.chainSafe(Pack::getItem).map(Item::getName).equal(value).orLie();
        assertFalse(equalsCocaCola.test(pack));
    }

    @Test
    public void checkEqualChaining() {
        String value = "Coca-Cola";
        Pack pack = new Pack(new Item(value));
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.chainSafe(Pack::getItem).map(Item::getName).equal(value).orTruth())
                .collect(Collectors.toList());
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkEqualNullableChaining() {
        String value = "Coca-Cola";
        Pack pack = new Pack(null);
        List<Pack> list = Stream.of(pack)
                .filter(PredicateX.chainSafe(Pack::getItem).map(Item::getName).equal(value).orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLessWithComparator() {
        String value = "Pepsi";
        Box box = new Box(new Pack(new Item(value)));
        Pack pack = new Pack(new Item("Coca-Cola"));
        Predicate<Box> lessPepsi = PredicateX.chain(Box::getPack)
                .less(pack, Comparator.comparing(p -> p.getItem().getName()));
        assertFalse(lessPepsi.test(box));
    }

    @Test
    public void checkLessNullableWithComparator() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Coca-Cola"));
        Predicate<Box> lessPepsi = PredicateX.chainSafe(Box::getPack)
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
                .filter(PredicateX.chain(Box::getPack).less(pack, Comparator.comparing(p -> p.getItem().getName())))
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLessNullableWithComparatorChaining() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Coca-Cola"));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.chainSafe(Box::getPack)
                        .less(pack, Comparator.comparing(p -> p.getItem().getName()))
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLess() {
        String value = "Coca-Cola";
        Box box = new Box(new Pack(new Item(value)));
        Predicate<Box> lessPepsi = PredicateX.chain(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .less("Pepsi");
        assertTrue(lessPepsi.test(box));
    }

    @Test
    public void checkLessNullable() {
        Box box = new Box(null);
        Predicate<Box> lessPepsi = PredicateX.chainSafe(Box::getPack)
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
                .filter(PredicateX.chain(Box::getPack)
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
                .filter(PredicateX.chainSafe(Box::getPack)
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
        Predicate<Box> greaterCocaCola = PredicateX.chain(Box::getPack)
                .greater(pack, Comparator.comparing(p -> p.getItem().getName()));
        assertFalse(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterNullableWithComparator() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Schweppes"));
        Predicate<Box> greaterCocaCola = PredicateX.chainSafe(Box::getPack)
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
                .filter(PredicateX.chain(Box::getPack).greater(pack, Comparator.comparing(p -> p.getItem().getName())))
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreaterNullableWithComparatorChaining() {
        Box box = new Box(null);
        Pack pack = new Pack(new Item("Schweppes"));
        List<Box> list = Stream.of(box)
                .filter(PredicateX.chainSafe(Box::getPack)
                        .greater(pack, Comparator.comparing(p -> p.getItem().getName()))
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreater() {
        String value = "Schweppes";
        Box box = new Box(new Pack(new Item(value)));
        Predicate<Box> greaterCocaCola = PredicateX.chain(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greater("Dr Pepper");
        assertTrue(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterNullable() {
        Box box = new Box(null);
        Predicate<Box> greaterCocaCola = PredicateX.chainSafe(Box::getPack)
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
                .filter(PredicateX.chain(Box::getPack)
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
                .filter(PredicateX.chainSafe(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .greater("Dr Pepper")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkLessOrEqual() {
        Holder<Box> holder = new Holder<>(new Box(null));
        Predicate<Holder<Box>> lessOrEqual = PredicateX.chain(Holder<Box>::get)
                .lessOrEqual(new Box(null), (o1, o2) -> 0);
        assertTrue(lessOrEqual.test(holder));
    }

    @Test
    public void checkLessOrEqualComparable() {
        Box box = new Box(new Pack(new Item("Fanta")));
        Predicate<Box> lessOrEqual = PredicateX.chain(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .lessOrEqual("Mirinda");
        assertTrue(lessOrEqual.test(box));
    }

    @Test
    public void checkLessOrEqualNullable() {
        Box box = new Box(new Pack(null));
        Predicate<Box> lessOrEqual = PredicateX.chainSafe(Box::getPack)
                .lessOrEqual(new Pack(null), (o1, o2) -> 0)
                .orLie();
        assertTrue(lessOrEqual.test(box));
    }

    @Test
    public void checkLessOrEqualNullableComparable() {
        Box box = new Box(null);
        Predicate<Box> lessOrEqual = PredicateX.chainSafe(Box::getPack)
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
        Predicate<Box> lessOrEqual = PredicateX.chainSafe(Box::getPack)
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
                .filter(PredicateX.chain(Box::getPack)
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
                .filter(PredicateX.chainSafe(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .lessOrEqual("Mirinda")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkGreaterOrEqual() {
        Holder<Box> holder = new Holder<>(new Box(null));
        Predicate<Holder<Box>> greaterCocaCola = PredicateX.chain(Holder<Box>::get)
                .greaterOrEqual(new Box(null), (o1, o2) -> 0);
        assertTrue(greaterCocaCola.test(holder));
    }

    @Test
    public void checkGreaterOrEqualComparable() {
        String value = "Sprite";
        Box box = new Box(new Pack(new Item(value)));
        Predicate<Box> greaterCocaCola = PredicateX.chain(Box::getPack)
                .map(Pack::getItem)
                .map(Item::getName)
                .greaterOrEqual("7 Up");
        assertTrue(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterOrEqualNullable() {
        Box box = new Box(new Pack(null));
        Predicate<Box> greaterCocaCola = PredicateX.chainSafe(Box::getPack)
                .greaterOrEqual(new Pack(null), (o1, o2) -> 0)
                .orLie();
        assertTrue(greaterCocaCola.test(box));
    }

    @Test
    public void checkGreaterOrEqualNullableComparable() {
        Box box = new Box(null);
        Predicate<Box> greaterCocaCola = PredicateX.chainSafe(Box::getPack)
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
        Predicate<Box> greaterCocaCola = PredicateX.chainSafe(Box::getPack)
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
                .filter(PredicateX.chain(Box::getPack)
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
                .filter(PredicateX.chainSafe(Box::getPack)
                        .map(Pack::getItem)
                        .map(Item::getName)
                        .greaterOrEqual("7 Up")
                        .orLie())
                .collect(Collectors.toList());
        assertTrue(list.isEmpty());
    }

    @Test
    public void checkMapNullable() {
        assertTrue(PredicateX.chainSafe(Pack::getItem)
                .map(Item::getPart)
                .isNull()
                .test(new Pack(new Item(null))));
    }

    @Test
    public void checkMapToNullable() {
        assertTrue(PredicateX.chain(Holder<Box>::get)
                .mapToNullable(Box::getPack)
                .isNull()
                .test(new Holder<>(new Box(null))));
    }

    @Test
    public void checkMapToNullableWithComparable() {
        assertTrue(PredicateX.chain(Box::getPack)
                .mapToNullable(Pack::getItem)
                .isNull()
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrElseBoolean() {
        assertTrue(PredicateX.chainSafe(Box::getPack)
                .check(Objects::nonNull)
                .orElse(false)
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrElseBooleanNullable() {
        assertTrue(PredicateX.chainSafe(Box::getPack)
                .check(Objects::nonNull)
                .orElse(true)
                .test(new Box(null)));
    }

    @Test
    public void checkOrElse() {
        assertTrue(PredicateX.chainSafe(Box::getPack)
                .check(Objects::nonNull)
                .orElse(t -> false)
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrElseNullable() {
        assertTrue(PredicateX.chainSafe(Box::getPack)
                .check(Objects::nonNull)
                .orElse(t -> true)
                .test(new Box(null)));
    }

    @Test
    public void checkOrLie() {
        assertTrue(PredicateX.chainSafe(Box::getPack)
                .check(Objects::nonNull)
                .orLie()
                .test(new Box(new Pack(null))));
    }

    @Test
    public void checkOrLieNullable() {
        assertFalse(PredicateX.chainSafe(Box::getPack)
                .check(Objects::isNull)
                .orLie()
                .test(new Box(null)));
    }
}
