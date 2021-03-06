[![LambdaX logo](docs/images/header.png "LambdaX")](https://alexengrig.github.io/lambdax)

# *Lambda*X 0.5.0 [![Maven Central](https://img.shields.io/maven-central/v/io.github.alexengrig/lambdax.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.alexengrig%22%20AND%20a:%22lambdax%22)[![Javadocs](https://www.javadoc.io/badge/io.github.alexengrig/lambdax.svg)](https://www.javadoc.io/doc/io.github.alexengrig/lambdax)[![GitHub](https://img.shields.io/github/license/alexengrig/lambdax?style=flat&&color=informational)](LICENSE)
[![Build Status](https://travis-ci.com/alexengrig/lambdax.svg?branch=master)](https://travis-ci.com/alexengrig/lambdax)[![codecov](https://codecov.io/gh/alexengrig/lambdax/branch/master/graph/badge.svg)](https://codecov.io/gh/alexengrig/lambdax)[![Coverage Status](https://coveralls.io/repos/github/alexengrig/lambdax/badge.svg)](https://coveralls.io/github/alexengrig/lambdax)[![Codacy Badge](https://api.codacy.com/project/badge/Grade/138c91a8899645ae9e62f13e56bf9465)](https://app.codacy.com/app/alexengrig/lambdax?utm_source=github.com&utm_medium=referral&utm_content=alexengrig/lambdax&utm_campaign=Badge_Grade_Dashboard)[![BCH compliance](https://bettercodehub.com/edge/badge/alexengrig/lambdax?branch=master)](https://bettercodehub.com/)[![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/alexengrig/lambdax.svg)](https://github.com/alexengrig/lambdax/releases)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Falexengrig%2Flambdax.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Falexengrig%2Flambdax?ref=badge_shield)

## ⚠️ This library is under experimental development - expect the major version ⚠️

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

### Chain

*   Data flow:

```java
    int integer = ChainX.of("some string")
            .map(String::length)
            .filter(length -> length > 0)
            .mutate(length -> holder[0] = length)
            .orElse(-1);
```

### Collection

*   Get the value from `Map` and print it on the console:

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

*   Insert the value into `Collection` if it does not contain it:

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

### Predicate

*   Filter holders by name (not null safe):

```java
List<Holder<Item>> filterByName(List<Holder<Item>> list) {
    return list.stream()
            .filter(PredicateX.of(Holder<Item>::get)
                    .map(Item::getName) // NPE if item is null
                    .equal("Item name"))
            .collect(Collectors.toList());
}
```

and null safe variant:

```java
List<Holder<Item>> filterByExistingName(List<Holder<Item>> list) {
    return list.stream()
            .filter(PredicateX.ofNullable(Holder<Item>::get)
                    .map(Item::getName)
                    .equal("Item name")
                    .orLie()) // return false if item or item name is null
            .collect(Collectors.toList());
}
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
  <version>0.5.0</version>
</dependency>
```

### Gradle

Add this snippet to the build.gradle `dependencies` section:

```groovy
implementation 'io.github.alexengrig:lambdax:0.5.0'
```

### Others

Other snippets are available in [The Central Repository](https://search.maven.org/artifact/io.github.alexengrig/lambdax/0.5.0/jar).

## License

This project is [licensed](LICENSE) under [Apache License, version 2.0](https://www.apache.org/licenses/LICENSE-2.0).

[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Falexengrig%2Flambdax.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Falexengrig%2Flambdax?ref=badge_large)
