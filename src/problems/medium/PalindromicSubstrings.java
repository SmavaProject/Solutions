package problems.medium;

public class PalindromicSubstrings {
    /****
     * #647. Palindromic Substrings
     * https://leetcode.com/problems/palindromic-substrings/
     * Solution:
     * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/xV73LEk5rx9
     */

    public int countSubstrings(String s) {
        int[][] substrings = new int[s.length()][s.length()];
        int result = 0;
        //substring из любой одной буквы - это палиндром
        for (int i = 0; i< s.length(); i++){
            substrings[i][i] = 1;
            result++;
        }

        //substring из двух букв
        for (int i = 0; i< s.length()-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){ //<----
                substrings[i][i+1] = 1; //<----
                result++;
            }
        }

        /**
         * Двигаем start к началу а end к концу
         * Если буквы от start и end равны и подинтервал == 1 (например [start,1,1,1,end] )
         * То этот иннервал тоже палиндромж
         */
        for (int start = s.length()-1; start>=0; start--){
            for (int end = start+1; end<s.length(); end++){
                if(s.charAt(start)==s.charAt(end) && substrings[start+1][end-1]==1){ //
                    substrings[start][end] = 1;
                    result++;
                }
            }
        }
        return result;

    }
}
}
