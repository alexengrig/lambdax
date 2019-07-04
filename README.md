<a href="https://github.com/alexengrig/lambdax"><img src="https://repository-images.githubusercontent.com/195124600/d08bbd00-9e4d-11e9-9fdb-c6e7eb1a898a" title="LambdaX" alt="LambdaX logo"></a>

# *Lambda*X
The *Lambda***X** library contains utility classes for writing code in the chaining style and useful lambdas.

## Examples
Write code in the chaining style:
```java
Map<Number, CharSequence> map = new HashMapint one = 1;
int key = 2;
String value = "two";
String actual = ChainX.of(map)
         .peek(MapX.onlyPut(one, "one"))  // map.put(one, "one")
         .filter(MapX.containsByKey(one)) // map.containsByKey(one)
         .peek(MapX.onlyRemove(one))      // map.remove(one)
         .peek(MapX.onlyPut(key, value))  // map.put(key, value)
         .map(MapX.get(key))              // map.get(key)
         .map(String.class::cast)
         .orElseThrow();                  // "two"
```


Use lambda to get value from `java.lang.Map` by key:
```java
String value = Optional.of(map)
        .map(m -> m.get(key))
        .orElse(null);

// with LambdaX

String value = Optional.of(map)
        .map(MapX.get(key)) 
        .orElse(null);
```

###### Coming soon...
