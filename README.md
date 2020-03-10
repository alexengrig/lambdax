[![LambdaX logo](logo/lambdax-preview.png "LambdaX")](https://alexengrig.github.io/lambdax)

# *Lambda*X 0.2.0 [![Maven Central](https://img.shields.io/maven-central/v/io.github.alexengrig/lambdax.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.alexengrig%22%20AND%20a:%22lambdax%22)[![Javadocs](https://www.javadoc.io/badge/io.github.alexengrig/lambdax.svg)](https://www.javadoc.io/doc/io.github.alexengrig/lambdax)[![License Apache-2.0](https://img.shields.io/github/license/alexengrig/lambdax?style=flat&&color=informational)](LICENSE)
[![Build Status](https://travis-ci.com/alexengrig/lambdax.svg?branch=master)](https://travis-ci.com/alexengrig/lambdax)[![codecov](https://codecov.io/gh/alexengrig/lambdax/branch/master/graph/badge.svg)](https://codecov.io/gh/alexengrig/lambdax)[![Coverage Status](https://coveralls.io/repos/github/alexengrig/lambdax/badge.svg)](https://coveralls.io/github/alexengrig/lambdax)[![Codacy Badge](https://api.codacy.com/project/badge/Grade/138c91a8899645ae9e62f13e56bf9465)](https://app.codacy.com/app/alexengrig/lambdax?utm_source=github.com&utm_medium=referral&utm_content=alexengrig/lambdax&utm_campaign=Badge_Grade_Dashboard)[![BCH compliance](https://bettercodehub.com/edge/badge/alexengrig/lambdax?branch=master)](https://bettercodehub.com/)[![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/alexengrig/lambdax.svg)](https://github.com/alexengrig/lambdax/releases)

This library contains utility classes with useful lambdas.

## Features

*Lambda***X** uses concepts of [functional programming](https://en.wikipedia.org/wiki/Functional_programming):

*   [Pure functions](https://en.wikipedia.org/wiki/Pure_function).
*   [Higher-order functions](https://en.wikipedia.org/wiki/Higher-order_function).
*   [Currying functions](https://en.wikipedia.org/wiki/Currying).

*Lambda***X** provides the following:

*   Writing code in [declarative](https://en.wikipedia.org/wiki/Declarative_programming) style.
*   Writing code in [chaining](https://github.com/twitter/commons/blob/master/src/java/com/twitter/common/styleguide.md#chained-method-calls) style.

## Examples

Get the value from `Map` and print it on the console:

```java
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    Holder<Map<Integer, String>> holder = new Holder<>(map);
// Plain Java
    Map<Integer, String> map = holder.get();
    String actual = map.get(key);
    System.out.println(actual);
// Chaining Style
    Optional.of(holder)
            .map(Holder::get)
            .map(m -> m.get(key))
            .ifPresent(System.out::println);
// LambdaX
    String actual = Optional.of(holder)
             .map(Holder::get)
             .map(MapX.get(key))
             .ifPresent(System.out::println);
```

Insert the value into `Collection` if it does not contain it:

```java
    Collection<Integer> numbers = new ArrayList<>();
    Holder<Collection<Integer>> holder = new Holder<>(numbers);
    int value = 1;
// Plain Java
    Collection<Integer> target = holder.get();
    if (!target.contains(value)) {
        target.add(value);
    }
// Chaining Style  
    Optional.of(holder)
            .map(Holder::get)
            .filter(collection -> !collection.contains(value))
            .ifPresent(collection -> collection.add(value));
// LambdaX
    Optional.of(holder)
            .map(Holder::get)
            .filter(CollectionX.notContains(value))
            .ifPresent(CollectionX.onlyAdd(value));
```

## Installation

Releases are available in [Maven Central](https://repo1.maven.org/maven2/io/github/alexengrig/lambdax/).

List of version [changes](CHANGES.md).

### Maven

Add this snippet to the pom.xml `dependencies` section:

```xml
<dependency>
  <groupId>io.github.alexengrig</groupId>
  <artifactId>lambdax</artifactId>
  <version>0.2.0</version>
</dependency>
```

### Gradle

Add this snippet to the build.gradle `dependencies` section:

```groovy
implementation 'io.github.alexengrig:lambdax:0.2.0'
```

### Others

Other snippets are available in [The Central Repository](https://search.maven.org/artifact/io.github.alexengrig/lambdax/0.2.0/jar).

## License

This project is [licensed](LICENSE) under [Apache License, version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
