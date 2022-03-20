package problems.medium;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    /***
     * # 424. Longest Repeating Character Replacement - MEDIUM
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR
     */
    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxLength = 0;
        int currLength = 0;

        /*
        Это частота наиболее повторяющейся Char (в каждом window)
        В каждом window у нас может быть несколько Char. И нам наиболее важно учитывать количество самой часто повторяющейся
        */
        int maximumRepeatingLetter = 0;// <----

        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for(int end = 0; end<s.length(); end++){
            char rightChar = s.charAt(end);
            Integer rightCharFreq = charFrequencyMap.getOrDefault(rightChar, 0)+1;
            charFrequencyMap.put(rightChar,rightCharFreq );
            //для current window частота самой частой Char
            maximumRepeatingLetter = Math.max(maximumRepeatingLetter, rightCharFreq);

            currLength = end-start+1;
            /*
            В каждый момент времени мы можем иметь длинну window не больщую чем
            maximumRepeatingLetter плюс все разрешенные замены k
             */
            //мы вышли за пределы разрешенного количества замен k
            //сужаем window и убираем leftChar
            if(currLength > maximumRepeatingLetter + k){
                char leftChar = s.charAt(start);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) -1);
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}