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

}
