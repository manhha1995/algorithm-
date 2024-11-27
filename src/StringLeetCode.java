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
}
