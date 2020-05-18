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

import io.github.alexengrig.lambdax.entity.Gun;
import io.github.alexengrig.lambdax.entity.Man;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Predicate;

import static io.github.alexengrig.lambdax.SafePredicateChainX.of;

public class SafePredicateChainXTest extends PredicateTester implements Data {
    public SafePredicateChainXTest() {
        super("SafePredicateChainX");
    }

    @Test
    public void checkIsNull() {
        assertTrueByMethod(
                "isNull",
                of(Man::getGun).isNull(),
                ZOMBIE
        );
    }

    @Test
    public void checkNonNull() {
        assertTrueByMethod(
                "nonNull",
                of(Man::getGun).nonNull(),
                GORDON_FREEMAN
        );
    }

    @Test
    public void checkCheck() {
        String method = "check";
        Predicate<Gun> predicate = gun -> !gun.getName().isEmpty() && gun.getDamage() > 1;
        assertTrueByMethod(
                method,
                of(Man::getGun).check(predicate).orLie(),
                GORDON_FREEMAN
        );
        assertTrueByMethod(
                method,
                of(Man::getGun).map(Gun::getName).check(name -> name.contains("bar")).orLie(),
                GORDON_FREEMAN
        );
    }

    @Test
    public void checkEqual() {
        assertTrueByMethod(
                "equal",
                of(Man::getGun).equal(CROWBAR).orLie(),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkLess() {
        of(Man::getGun).less(SNARK).orLie().test(GORDON_FREEMAN);
    }

    @Test
    public void checkLessWithComparator() {
        assertTrueByMethod(
                "less(Object,Comparator)",
                of(Man::getGun).less(SNARK, Comparator.comparing(Gun::getDamage)).orLie(),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkGreater() {
        of(Man::getGun).greater(SNARK).orLie().test(GORDON_FREEMAN);
    }

    @Test
    public void checkGreaterWithComparator() {
        assertFalseByMethod(
                "greater(Object,Comparator)",
                of(Man::getGun).greater(SNARK, Comparator.comparing(Gun::getDamage)).orTruth(),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkLessOrEqual() {
        of(Man::getGun).lessOrEqual(SNARK).orLie().test(GORDON_FREEMAN);
    }

    @Test
    public void checkLessOrEqualWithComparator() {
        assertTrueByMethod(
                "lessOrEqual(Object,Comparator)",
                of(Man::getGun).lessOrEqual(SNARK, Comparator.comparing(Gun::getDamage)).orLie(),
                GORDON_FREEMAN
        );
    }

    @Test(expected = ClassCastException.class)
    public void checkGreaterOrEqual() {
        of(Man::getGun).greaterOrEqual(SNARK).orLie().test(GORDON_FREEMAN);
    }

    @Test
    public void checkGreaterOrEqualWithComparator() {
        assertFalseByMethod(
                "greaterOrEqual(Object,Comparator)",
                of(Man::getGun).greaterOrEqual(SNARK, Comparator.comparing(Gun::getDamage)).orTruth(),
                GORDON_FREEMAN
        );
    }

    public static class Result extends PredicateTester implements Data {
        public Result() {
            super("SafePredicateChainX.Result");
        }

        @Test
        public void checkOrElseWithPredicate() {
            String method = "orElse(Predicate)";
            assertTrueByMethod(
                    method,
                    of(Man::getGun).map(Gun::getName).equal("no-gun").orElse(m -> m.getGun() == null),
                    ZOMBIE
            );
            assertTrueByMethod(
                    method,
                    of(Man::getGun).map(Gun::getDamage).greater(0).orElse(failByMethod(method)),
                    GORDON_FREEMAN
            );
        }

        @Test
        public void checkOrElseWithBoolean() {
            String method = "orElse(boolean)";
            assertTrueByMethod(
                    method,
                    of(Man::getGun).map(Gun::getName).equal("no-gun").orElse(true),
                    ZOMBIE
            );
            assertTrueByMethod(
                    method,
                    of(Man::getGun).map(Gun::getDamage).greater(0).orElse(false),
                    GORDON_FREEMAN
            );
        }

        @Test
        public void checkOrTruth() {
            String method = "orTruth";
            assertTrueByMethod(
                    method,
                    of(Man::getGun).map(Gun::getName).equal("no-gun").orTruth(),
                    ZOMBIE
            );
            assertFalseByMethod(
                    method,
                    of(Man::getGun).map(Gun::getDamage).less(0).orTruth(),
                    GORDON_FREEMAN
            );
        }

        @Test
        public void checkOrLie() {
            String method = "orLie";
            assertFalseByMethod(
                    method,
                    of(Man::getGun).map(Gun::getName).equal("no-gun").orLie(),
                    ZOMBIE
            );
            assertTrueByMethod(
                    method,
                    of(Man::getGun).map(Gun::getDamage).greater(0).orLie(),
                    GORDON_FREEMAN
            );
        }
    }
}