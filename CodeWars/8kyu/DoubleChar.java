public class Solution {
    public static String doubleChar(String s) {
        var doubled = "";
        for (Object c : s.toCharArray()) {
            doubled = doubled + c + c;
        }
        return doubled;
    }
}