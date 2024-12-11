import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Collections;

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

    public int maxSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> digitMap = new HashMap<>();
    
        // Group numbers by their largest digit
        for (int num : nums) {
            int maxDigit = digitSum(num);
            digitMap.computeIfAbsent(maxDigit, k -> new PriorityQueue<>(Collections.reverseOrder())).add(num);
        }
    
        int maxSum = -1;
    
        // Find maximum sum for each group of numbers
        for (PriorityQueue<Integer> numbers : digitMap.values()) {
            if (numbers.size() >= 2) {
                // Sort in descending order to get largest numbers first
            int first = numbers.poll();
            int second = numbers.poll();
            maxSum = Math.max(maxSum, first + second);
            }
        }
        
        return maxSum;

    }
    public int digitSum(int digit) {
        int maxDigit = 0;
        while (digit > 0) {
            maxDigit = Math.max(maxDigit, digit % 10);
            digit = digit / 10;
        }
        return maxDigit;
    }

    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        int leftover = 0;
        
        // Calculate pairs and leftover numbers
        for (int count : map.values()) {
            pairs += count / 2;      // Number of pairs that can be formed
            leftover += count % 2;   // Numbers that can't form pairs
        }
    
        return new int[]{pairs, leftover};
    }

    public int fillCups(int[] amount) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < amount.length; i++) {
            max = Math.max(max, amount[i]);
            sum += amount[i];
        }
        return Math.max(max, (sum + 1) / 2);
    }

    public static void main(String[] args) {
        int A[] = {2536,1613,3366,162};

        ArrayLeetCode arrayLeetCode = new ArrayLeetCode();
        System.out.println(arrayLeetCode.maxSum(A));
    }
}
