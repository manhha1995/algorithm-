public class DynamicProgramming {

    public int minCostClimbingStairs(int[] cost) {
        int min = 0;
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int takeOneStep = dp[i - 1] + cost[i - 1];
            int takeTwoSteps = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(takeOneStep, takeTwoSteps);
            if (i == n) {
                min = Math.min(takeOneStep, takeTwoSteps);
            }
        }
        return min;
    }

    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
