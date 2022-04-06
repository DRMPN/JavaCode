import java.util.*;

class Diamond {
    public static String print(int n) {

        if (n < 0 || n % 2 == 0)
            return null;

        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= n; i += 2) {
            str.append(" ".repeat((n - i) / 2)).append("*".repeat(i)).append("\n");
        }

        for (int i = n - 2; i > 0; i -= 2) {
            str.append(" ".repeat((n - i) / 2)).append("*".repeat(i)).append("\n");
        }

        return str.toString();
    }
}