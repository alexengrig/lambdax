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

import org.junit.Assert;

import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class PredicateTester {
    protected final String className;

    protected PredicateTester(String className) {
        this.className = className;
    }

    protected <T> void assertTrueByMethod(String method, Predicate<? super T> predicate, T subject) {
        String message = String.format("The %s#%s must return true", className, method);
        Assert.assertTrue(message, predicate.test(subject));
    }

    protected <T> void assertFalseByMethod(String method, Predicate<? super T> predicate, T subject) {
        String message = String.format("The %s#%s must return false", className, method);
        Assert.assertFalse(message, predicate.test(subject));
    }

    protected <T> Predicate<T> failPredicateByMethod(String method) {
        return t -> {
            Assert.fail(String.format("This predicate should not be called for the %s#%s", className, method));
            return false;
        };
    }

    protected <T> Supplier<Boolean> failSupplierByMethod(String method) {
        return () -> {
            Assert.fail(String.format("This supplier should not be called for the %s#%s", className, method));
            return false;
        };
    }
}
