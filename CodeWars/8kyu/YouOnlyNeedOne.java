public class Solution {

    public static boolean check(Object[] a, Object x) {
        for (Object o : a) {
            if (o.equals(x)) {
                return true;
            }
        }
        return false;
    }

}