import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayLeetCode {
    public static boolean findSubarrays(int[] nums) {

        if (nums.length <= 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }

        return false;
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int totalCandies = candies[n - 1];
        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }
        return totalCandies;
    }

    int maxNonIntersectingElems(int[] arr){
        int maxIntersectincount = 0;
        int intersectingcount = 0;
        int prevSum = -1;
        int count = 1;
        Map<Integer, Integer> countSum = new HashMap<>();

        for(int i=0; i<arr.length-1; i++){
            if (checkOverNumber(arr[i], arr[i+1])) {
                continue;
            }
            int sum = arr[i] + arr[i+1];
           
            if(sum != prevSum || count == 2) {
                intersectingcount = getCount(sum, countSum);
                maxIntersectincount = Math.max(maxIntersectincount, intersectingcount);
                count = 1;
            }else{
                if(sum == prevSum){
                    count = 2;
                }
            }
            prevSum = sum;
        }

        return maxIntersectincount;
    }

    private boolean checkOverNumber(int a, int b) {
        if (b > 0 && a > Integer.MAX_VALUE - b) return true; 
        if (b < 0 && a < Integer.MIN_VALUE - b) return true;
        return false;
    }

    private int getCount(int sum, Map<Integer, Integer> countSum) {
        int val = countSum.get(sum) == null ? countSum.getOrDefault(sum, 1): countSum.get(sum)+1;
        countSum.put(sum, val);
        return val;
    }

    public int maxDistance(int[] X, int[] Y) {
        if (X.length == 0 || Y.length == 0 || X.length <2 || X.length != Y.length) {
            return 0;
        }
        int n = X.length;
        int max = 0;
       for (int i = 0; i < n; i++) {
            int current = X[i];
            for (int j = i + 1; j < n; j++) {
                if (X[j] == current) {
                    max = Math.max(max, Math.abs(Y[j] - Y[i]));
                }
            }
       }

       return max;
    }

    public static void main(String[] args) {
        int A[] = {1,5,2,4,3,3};

        ArrayLeetCode arrayLeetCode = new ArrayLeetCode();
        System.out.println(arrayLeetCode.maxNonIntersectingElems(A));
    }
}
