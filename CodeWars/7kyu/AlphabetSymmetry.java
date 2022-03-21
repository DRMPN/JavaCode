import java.util.*;

public class Solution{
    public static int[] solve(String[] arr){
        int[] tmp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int pos = 0;
            for (char ch : arr[i].toLowerCase().toCharArray()) {
                if ((int) ch % 97 == pos) {
                    count++;
                }
                pos++;
            }
            tmp[i] = count;
        }
      
        return tmp;
    }
}