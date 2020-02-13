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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.function.Function;
import org.junit.Test;

public class FunctionXTest {
  @Test
  public void checkNullSafe() {
    Function<Object, String> nullSafetyFunction =
        FunctionX.nullSafe(t -> "GitHub");
    assertNull(nullSafetyFunction.apply(null));
  }

  @Test
  public void checkNullSafeNullable() {
    String value = "GitHub";
    Function<Object, String> nullSafetyFunction =
        FunctionX.nullSafe(t -> value);
    assertEquals(value, nullSafetyFunction.apply("GitLab"));
  }
}
