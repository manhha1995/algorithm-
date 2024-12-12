import java.util.HashSet;

public class Greedy {
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

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;    // Track total surplus of gas
         int currentSurplus = 0;  // Track current tank level
         int startStation = 0;    // Potential starting station
         
         for (int i = 0; i < gas.length; i++) {
             totalSurplus += gas[i] - cost[i];
             currentSurplus += gas[i] - cost[i];
             
             // If we can't reach the next station
             if (currentSurplus < 0) {
                 // Start from next station
                 startStation = i + 1;
                 // Reset current tank
                 currentSurplus = 0;
             }
         }
         
         // If total surplus is negative, no solution exists
         return totalSurplus >= 0 ? startStation : -1;
     }

     public String predictPartyVictory(String senate) {
        if (senate.isEmpty() || senate.isBlank()) {return "";}
        int n = senate.length();
        int r = 0, d = 0;
        boolean[] banned = new boolean[n];
        while (true) {
            for (int i = 0; i < n; i++) {
                if (banned[i]) {continue;}
                if (senate.charAt(i) == 'R') {
                    if (d == 0) {
                        r++;
                    } else {
                        d--;
                        banned[i] = true;
                    }
                } else {
                    if (r == 0) {
                        d++;
                    } else {
                        r--;
                        banned[i] = true;
                    }
                }
            }


            for (int i = 0; i < n; i++) {
                while (!banned[i]) {
                    if (senate.charAt(i) == 'R') {
                        if (d == 0) {
                            return "Radiant";
                        }
                        d--;
                    } else {
                        if  (senate.charAt(i) == 'D') {
                                if (r == 0) {
                                    return "Dire";
                            }
                                r--;    
                            } else {
                                return "Radiant";
                        }
                    }
                }
            }
        }
    }

    public int solution(String s) {
        int n = s.length();
        int[] players = new int[n -1];
        int[] arrows = new int[n -1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n -1; i++) {
            if (s.charAt(i) == 'A') {
                players[i] = arrowKey(i, n, s.charAt(i));
                arrows[i] = arrowKey(i, n, s.charAt(i));
            } else if (s.charAt(i) == 'B') {
                players[i] = arrowKey(i, n, s.charAt(i));
                arrows[i] = arrowKey(i, n, s.charAt(i));
            } else if (s.charAt(i) == 'L' || s.charAt(i) == 'R' || s.charAt(i) == 'U' || s.charAt(i) == 'D') {
                players[i] = arrowKey(i, n, s.charAt(i));
                arrows[i] = arrowKey(i, n, s.charAt(i));
                set.add(i);
            } else {
                throw new IllegalArgumentException("not valid direction" + s.charAt(i));
            }

        }

        return set.size();
    }

    public int arrowKey(int x, int y, char c) {
        switch (c) {
            case 'L': return (x-1)*y;
            case 'R': return (x+1)*y;
            case 'U': return x*(y+1);
            case 'D': return x*(y-1);
            default:
                throw new IllegalArgumentException("not valid direction" + c);
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int start, end, value = intervals[0][1];
        int count = 0;
        for (int i = 0; i < n -2; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            System.out.println(value);
            if (start < value) {
                value = Math.min(value, end);
                count ++;
            } else {
                value = end;
            }
        }
        return count;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int numsCoins = 0; 
        for (int i = n -1; i >= 0; i--) {
            if (coins[i] <= amount) {
                amount -= coins[i];
                numsCoins++;
            }
        }

        return numsCoins;
    }

    public static void main(String[] args) {
       int[] coins = new int[] {2};
                Greedy greedy = new Greedy();   
        System.out.println(greedy.coinChange(coins, 3));
    }
}
