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

import java.util.Optional;
import java.util.function.Supplier;

public class LazyChainX<T> {
    protected static final LazyChainX<?> EMPTY = new LazyChainX<>();

    protected final Supplier<? extends T> producer;

    protected transient volatile T value;

    protected LazyChainX() {
        this.producer = () -> null;
    }

    protected LazyChainX(T value) {
        this.producer = () -> value;
    }

    protected LazyChainX(Supplier<? extends T> producer) {
        this.producer = producer;
    }

    @SuppressWarnings("unchecked")
    public static <T> LazyChainX<T> empty() {
        return (LazyChainX<T>) EMPTY;
    }

    public static <T> LazyChainX<T> of(T value) {
        return new LazyChainX<>(value);
    }

    public static <T> LazyChainX<T> of(Supplier<? extends T> producer) {
        return new LazyChainX<>(producer);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <T> LazyChainX<T> of(Optional<? extends T> optional) {
        return new LazyChainX<>(() -> optional.orElse(null));
    }

//    Check

    public final boolean isNull() {
        return value() == null;
    }

    public final boolean nonNull() {
        return value() != null;
    }

//    Value

    public T value() {
        T target = value;
        if (target == null) {
            synchronized (this) {
                target = value;
                if (target == null) {
                    target = producer.get();
                    value = target;
                }
            }
        }
        return target;
    }
}
