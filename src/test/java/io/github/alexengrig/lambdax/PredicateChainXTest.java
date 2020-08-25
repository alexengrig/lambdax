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

package io.github.alexengrig.lambdax;

import io.github.alexengrig.lambdax.entity.Entities;
import io.github.alexengrig.lambdax.entity.Gun;
import io.github.alexengrig.lambdax.entity.Man;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Predicate;

public class PredicateChainXTest extends PredicateTester implements Entities {
    public PredicateChainXTest() {
        super("PredicateChainX");
    }

    @Test
    public void checkIsNull() {
        assertTrueByMethod(
                "isNull",
                PredicateChainX.of(Man::getGun).isNull(),
                ZOMBIE
        );
    }

    @Test
    public void checkNonNull() {
        assertTrueByMethod(
                "nonNull",
                PredicateChainX.of(Man::getGun).nonNull(),
                GORDON_FREEMAN
        );
    }

    @Test
    public void checkCheck() {
        Predicate<Gun> predicate = gun -> !gun.getName().isEmpty() && gun.getDamage() > 1;
        assertTrueByMethod(
                "check",
                PredicateChainX.of(Man::getGun).check(predicate),
                GORDON_FREEMAN
        );
        assertTrueByMethod(
                "check",
                PredicateChainX.of(Man::getGun).map(Gun::getName).check(name -> name.contains("bar")),
                GORDON_FREEMAN
        );
    }

    @Test
    public void checkEqual() {
        assertTrueByMethod(
                "equal",
                PredicateChainX.of(Man::getGun).equalTo(CROWBAR),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkLess() {
        PredicateChainX.of(Man::getGun).less(SNARK).test(GORDON_FREEMAN);
    }

    @Test
    public void checkLessWithComparator() {
        assertTrueByMethod(
                "less",
                PredicateChainX.of(Man::getGun).less(SNARK, Comparator.comparing(Gun::getDamage)),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkGreater() {
        PredicateChainX.of(Man::getGun).greater(SNARK).test(GORDON_FREEMAN);
    }

    @Test
    public void checkGreaterWithComparator() {
        assertFalseByMethod(
                "greater",
                PredicateChainX.of(Man::getGun).greater(SNARK, Comparator.comparing(Gun::getDamage)),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkLessOrEqual() {
        PredicateChainX.of(Man::getGun).lessOrEqual(SNARK).test(GORDON_FREEMAN);
    }

    @Test
    public void checkLessOrEqualWithComparator() {
        assertTrueByMethod(
                "lessOrEqual",
                PredicateChainX.of(Man::getGun).lessOrEqual(SNARK, Comparator.comparing(Gun::getDamage)),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkGreaterOrEqual() {
        PredicateChainX.of(Man::getGun).greaterOrEqual(SNARK).test(GORDON_FREEMAN);
    }

    @Test
    public void checkGreaterOrEqualWithComparator() {
        assertFalseByMethod(
                "greaterOrEqual",
                PredicateChainX.of(Man::getGun).greaterOrEqual(SNARK, Comparator.comparing(Gun::getDamage)),
                GORDON_FREEMAN
        );
    }
}