package alexengrig.lambdax;

import alexengrig.lambdax.collection.MapX;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ChainXTest {
    @Test
    public void checkWorkWithMap() {
        HashMap<Number, String> map = new HashMap<>();
        int key = 3;
        String value = "three";
        String actual = ChainX.of(map)
                .peek(MapX.onlyPut(1, "one"))
                .peek(MapX.onlyPut(2, "two"))
                .peek(MapX.onlyPut(key, value))
                .peek(MapX.onlyPut(4, "four"))
                .peek(MapX.onlyRemove(1))
                .map(MapX.get(key))
                .orElseThrow();
        assertEquals(value, actual);
    }
}