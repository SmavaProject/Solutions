package problems.medium;

public class LongestPalindromicSubstring {
    /***
     * #5. Longest Palindromic Substring - medium
     * Dynamic programming
     * https://leetcode.com/problems/longest-palindromic-substring/
     * Solution:
     * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2yRjwxBY7A
     */

    private int start = -1;
    private int end = -1;
    private int maxLen = 1;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = i == j ? 0 : -1; //каждая буква сама по себе это палиндром длинной в 1 символ

            }
        }

        recursion(s, 0, s.length() - 1, dp);
        return this.maxLen == 1 ? s.substring(0, 1) : s.substring(this.start, this.end + 1);
    }

    private int recursion(String s, int start, int end, int[][] dp) {
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }
        char startC = s.charAt(start);
        char endC = s.charAt(end);

        if (dp[start][end] == -1) {
            if (startC == endC) {

                if (isPalindrome(s, start + 1, end - 1)) {
                    dp[start][end] = end - start + 1;
                    if (dp[start][end] > this.maxLen) {
                        this.start = start;
                        this.end = end;
                        this.maxLen = end - start + 1;
                    }
                    return dp[start][end];
                }
            }
            /*
            Выполняется всегда, а не в else блоке к if(startC == endC)
            Потому что даже если текущие startC == endC, то может быть что string все равно не палиндром (e.g. "abca")
            И нужно исследовать варианты ее substring
             */
            int v1 = recursion(s, start, end - 1, dp);
            int v2 = recursion(s, start + 1, end, dp);
            dp[start][end] = Math.max(v1, v2);

        }
        return dp[start][end];
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start <= end ? false : true;
    }
}
