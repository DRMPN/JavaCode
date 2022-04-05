public class Solution {

    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            var val = target - numbers[i];
            for (int n = i; n < numbers.length; n++) {
                if (val == numbers[n]) {
                    return new int[] { i, n };
                }
            }
        }

        return null;
    }
}