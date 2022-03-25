import java.util.*;
import java.util.stream.IntStream;

public class Minimum {

    public static int minValue(int[] values) {
        String s = String.join("", IntStream.of(values)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .toArray(String[]::new));
        return Integer.valueOf(s);
    }

}