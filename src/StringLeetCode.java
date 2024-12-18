import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
public class StringLeetCode {
    public static String largestPalindromic(String num) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            while (count[i] > 1) {
                sb.append(i);
                count[i] -= 2;
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        for (int i = 9; i >= 0; i--) {
            if (count[i] == 1) {
                sb.append(i);
                break;
            }
        }
        for (int i = sb.length() - 2; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }

       public String revere(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                sb.append(words[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            sb.append(word.reverse());
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public String removeDuplicate(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
          if (!sb.isEmpty() && c == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = 0; i < n; i++) {
           if (c < spaces.length && i == spaces[c]) {
              sb.append(" ");
              c++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

     public String firstPalindrome(String[] words) {
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            sb = new StringBuilder(words[i]);
            if (sb.reverse().toString().equals(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int i : asteroids) {
                if (mass < i) {
                   return false;
                } else {
                   mass += i;
                }
        } 

       return true;
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty() || str1.length() < str2.length()) {
            return false;
        }

        char[] c = str1.toCharArray();
        int start = 0;
        for (int i = 0; i < c.length  && start < str2.length(); i++) {
            if (c[i] == str2.charAt(start) || (c[i] + 1) == str2.charAt(start)&& str1.charAt(i) != 'z' || str2.charAt(start) == 'a' && str1.charAt(i) == 'z') {
                start++;
            }
        }
        return start == str2.length();
    }

    public int longestPalindrome(String s) {
       Set<String> set = new HashSet<>();
       int n = s.length();
       int count = 0; 
       for (int i = 0; i < n; i++) {
           String c = String.valueOf(s.charAt(i));
           if (set.contains(c)) {
               set.remove(c);
               count += 2;
           } else {
               set.add(c);
           }
       }
       return set.isEmpty() ? count : count + 1;
    }

    public int arrayPairSum(int[] nums) {
       // Sort the array first
        Arrays.sort(nums);
        
        // Initialize sum
        int sum = 0;
        
        // Take every element at even indices
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
            
    }

    public static void main(String[] args) {
        String str1 = "p";
        String str2 = "a";
        StringLeetCode stringLeetCode = new StringLeetCode();
        System.out.println(stringLeetCode.canMakeSubsequence(str1, str2));
    }
    
}
