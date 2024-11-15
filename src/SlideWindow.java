public class SlideWindow {
    public int minimumSubArray(int[] arr, int n, int k) {
        if (n <= k) {
            return -1;
        }
        int minSum = 0;

        for (int i = 0; i < k; i++) {
            minSum += arr[i];
        }

        int window_sum = minSum;

        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i-k];
            minSum = Math.min(window_sum, minSum);
        }

        return minSum;
    }
}
