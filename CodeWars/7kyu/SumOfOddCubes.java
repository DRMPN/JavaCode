public class FindOddCubes {

    public static int cubeOdd(int arr[]) {
        int sum = 0;
        for (int i : arr) {
            int tmp = (int) Math.pow(i, 3);
            if (tmp % 2 != 0) {
                sum += tmp;
            }
        }
        return sum;
    }
    
}