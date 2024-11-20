import java.util.HashSet;

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

    public static int maxSubArray(int[] arr, int k) {
        int n = arr.length;
        if (n <= k ) {
            return 0;
        }

        int maxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int window_sum = 0;

        for (int i = 0; i < k; i++) {
            window_sum += arr[i];
            set.add(arr[i]);
        }
        if (set.size() == k) {
            maxSum = window_sum;
        }


        for (int i = k; i < arr.length; i++) {
            set.remove(arr[i-k]);
            window_sum -= arr[i-k] ;

            window_sum += arr[i];
            set.add(arr[i]);

            if (set.size() == k) {
                maxSum = Math.max(maxSum, window_sum);
            }

            set.add(arr[i -k + 1]);
        }

        return maxSum; 
    }

    public static int minimizeArrayValue(int[] nums) {
        int result = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur >= prev) {
                prev = cur;
            } else {
                int d = prev - cur;
                int k = (d + i - 1) / i;
                prev = cur + k;
            }
            result = Math.max(result, prev);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3,7,1,6};
        System.out.println(minimizeArrayValue(a));
    }
}
