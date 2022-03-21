public class Repeater {
    public static String repeat(String string, long n) {
        String tmp = "";
        for (int i = 0; i < n; i++) {
            tmp += string;
        }
        return tmp;
    }
}