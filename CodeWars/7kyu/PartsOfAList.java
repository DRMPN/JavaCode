import java.util.*;

public class Partlist {
    
    public static String[][] partlist(String[] arr) {
        var len = arr.length - 1;
      
        String[][] a = new String[len][1];
        for (int i = 0; i < len; i++){
            var first = String.join(" ", Arrays.copyOfRange(arr, 0, i + 1));
            var second = String.join(" ", Arrays.copyOfRange(arr, i + 1, len + 1));
            //System.out.println(String.join(", ", first, second));
            a[i][0] = String.join(", ", first, second);
        }
        
        //System.out.println(Arrays.deepToString(a));
        return a;
    }
}