import java.util.*;

public class Kata {
    public static String reverseWords(final String original) {
        List<String> list = new ArrayList<String>();
        String[] strings = original.split(" ");
      
        if (strings.length == 0) {
            return original;
        }
      
        for (String s : strings) {
            var rev = new StringBuilder(s).reverse().toString();
            list.add(rev);
        }
      
        return String.join(" ", list);
    }
}