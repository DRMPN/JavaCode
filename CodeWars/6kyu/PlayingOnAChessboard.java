import java.util.*;

public class Suite2 {

    public static String game(long n) {

        double sum = 0;

        for (long i = 1; i <= n; i++) {
            sum += (i - 1) + 0.5;
        }

        return n % 2 == 0
                ? Arrays.toString(new long[] { (long) sum })
                : Arrays.toString(new long[] { (long) (sum * 2), 2 });
    }
}