public class Kata {
    public static int[] digitize(long n) {
      
      var tmp = "";
      for (char c : Long.toString(n).toCharArray()) {
        tmp = c + tmp;
      }
      
      int[] nums = new int[tmp.length()];

      for (int i = 0; i < tmp.length(); i++) {
          nums[i] = tmp.charAt(i) - '0';
      }
      
      return nums;
    }
}