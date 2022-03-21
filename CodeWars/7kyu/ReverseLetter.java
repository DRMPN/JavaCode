public class Kata {
    public static String reverseLetter(final String str) {
        return new StringBuilder(str).reverse().toString().replaceAll("[^a-zA-Z]+", "");
    }
}