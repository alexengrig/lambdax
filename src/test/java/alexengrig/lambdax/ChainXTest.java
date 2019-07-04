package alexengrig.lambdax;

import alexengrig.lambdax.collection.MapX;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ChainXTest {
    @Test
    public void checkWorkWithMap() {
        Map<Number, CharSequence> map = new HashMap<>();
        int one = 1;
        int key = 2;
        String value = "two";
        String actual = ChainX.of(map)
                .peek(MapX.onlyPut(one, "one"))
                .filter(MapX.containsByKey(one))
                .peek(MapX.onlyRemove(one))
                .peek(MapX.onlyPut(key, value))
                .map(MapX.get(key))
                .map(String.class::cast)
                .orElseThrow();
        assertEquals(value, actual);
    }
}