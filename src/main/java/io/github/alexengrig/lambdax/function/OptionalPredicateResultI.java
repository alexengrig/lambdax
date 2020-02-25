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

import java.util.function.Predicate;

/**
 * TODO: Add JavaDoc
 */
public interface OptionalPredicateResultI<T> {
    /**
     * TODO: Add JavaDoc
     */
    Predicate<T> orElse(Predicate<T> checker);

    /**
     * TODO: Add JavaDoc
     */
    default Predicate<T> orElse(boolean check) {
        return orElse(t -> check);
    }

    /**
     * TODO: Add JavaDoc
     */
    default Predicate<T> orTruth() {
        return orElse(PredicateX.truth());
    }

    /**
     * TODO: Add JavaDoc
     */
    default Predicate<T> orLie() {
        return orElse(PredicateX.lie());
    }
}
