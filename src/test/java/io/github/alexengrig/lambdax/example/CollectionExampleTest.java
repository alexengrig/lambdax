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

package io.github.alexengrig.lambdax.example;

import io.github.alexengrig.lambdax.collection.CollectionX;
import io.github.alexengrig.lambdax.collection.MapX;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Abbreviations:
 * <pre>
 *     PS - Plain Style
 *     CS - Chaining Style
 *     LX - LambdaX
 * </pre>
 */
public class CollectionExampleTest {
    private Holder<Map<Integer, String>> mapHolder;
    private Holder<Collection<Integer>> collectionHolder;

    @Before
    public void before() {
        HashMap<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        mapHolder = new Holder<>(numbers);
        collectionHolder = new Holder<>(new ArrayList<>());
    }

    @Test
    public void checkMapGettingInPS() {
        int value = 1;
        Map<Integer, String> map = mapHolder.get();
        String actual = map.get(value);
        assertEquals("one", actual);
    }

    @Test
    public void checkMapGettingInCS() {
        int value = 1;
        String actual = Optional.of(mapHolder)
                .map(Holder::get)
                .map(m -> m.get(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals("one", actual);
    }

    @Test
    public void checkMapGettingInLX() {
        int value = 1;
        String actual = Optional.of(mapHolder)
                .map(Holder::get)
                .map(MapX.get(value))
                .orElseThrow(IllegalStateException::new);
        assertEquals("one", actual);
    }

    @Test
    public void checkInsertItemInPS() {
        int value = 2;
        Collection<Integer> collection = collectionHolder.get();
        if (!collection.contains(value)) {
            collection.add(value);
        }
        assertTrue(collectionHolder.get().contains(value));
    }

    @Test
    public void checkInsertItemInCS() {
        int value = 2;
        Optional.of(collectionHolder)
                .map(Holder::get)
                .filter(collection -> !collection.contains(value))
                .ifPresent(collection -> collection.add(value));
        assertTrue(collectionHolder.get().contains(value));
    }

    @Test
    public void checkInsertItemInLX() {
        int value = 2;
        Optional.of(collectionHolder)
                .map(Holder::get)
                .filter(CollectionX.contains(value).negate())
                .ifPresent(CollectionX.onlyAdd(value));
        assertTrue(collectionHolder.get().contains(value));
    }
}
