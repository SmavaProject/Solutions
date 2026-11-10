package problems2.medium;

public class LongestPalindromicSubstring {

    //https://leetcode.com/problems/longest-palindromic-substring/

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int longest = 0;
        String l = "";

        for (int i = 0; i< s.length()-1; i++){
            for (int j = 0; j< s.length(); j++){
                if(isPal(i, j, s)){
                    if(j-i >= longest){
                        longest = j-i;
                        l = s.substring(i, j+1);
                    }
                }
            }
        }
        return l;
    }

    public boolean isPal(int i, int j, String s){

        while(i<j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
