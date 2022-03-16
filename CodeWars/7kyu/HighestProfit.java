class MinMax {
    public static int[] minMax(int[] arr) {
        int[] res = new int[] { arr[0], arr[0] };
        for (int i = 0; i < arr.length; i++) {
            var tmp = arr[i];
            if (tmp < res[0]) {
                res[0] = tmp;
            } else if (tmp > res[1]) {
                res[1] = tmp;
            }
        }
        return res;
    }
}