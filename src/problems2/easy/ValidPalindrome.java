package problems2.easy;

public class ValidPalindrome {

    //https://leetcode.com/problems/valid-palindrome/description/

    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();

        String noSpace = lower.replaceAll("[^a-zA-Z0-9]", "");

        StringBuilder sb = new StringBuilder();
        for (int i = noSpace.length() -1; i>=0;  i --){
            sb.append(noSpace.charAt(i));

        }
        String result = sb.toString();

        return result.equals(noSpace);
    }

    // #2

    public boolean isPalindrome2(String s) {

        String lower = s.toLowerCase();

        String noSpace = lower.replaceAll("[^a-zA-Z0-9]", "");

        return recutsion(0, noSpace.length()-1, noSpace);

    }

    public boolean recutsion(int start, int end, String s){
        if (start > end) return true;
        if(s.charAt(start) != s.charAt(end)) return false;

        return recutsion(start + 1, end -1, s);

    }

}
