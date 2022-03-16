import java.util.*;

public class Kata {
  public static boolean isAnagram(String test, String original) {
    char[] a = test.toLowerCase().toCharArray();
    char[] b = original.toLowerCase().toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a, b);
  }
}