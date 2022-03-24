import java.util.*;

public class CountDig {

    public static int nbDig(int n, int d) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (char c : String.valueOf(i * i).toCharArray()) {
                if (c - '0' == d) {
                    count++;
                }
            }
        }
        return count;
    }
}