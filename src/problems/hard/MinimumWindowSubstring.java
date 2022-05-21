package problems.hard;

import java.util.HashMap;

public class MinimumWindowSubstring {
    /***
     * #76. Minimum Window Substring
     * https://leetcode.com/problems/minimum-window-substring/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/xoyL4q6ApNE
     */


    /***
     * Основные идеи и ошибки:
     * В HashMap<Character, Integer> chars могут быть и отрицательные значения (если найденное окно содержит несколько лишних значений Character
     * Мы НЕ удаляем Character из chars если его значение стало 0. Вместо этого, мы используем переменную matched чтобы оценить нашли ли мы все Character
     */
    public String minWindow(String s, String t) {
        //Char, its number of occurencies in t. While using, it can be 0 (if we found all occurrences, can also be negative if we found several
        HashMap<Character, Integer> chars = new HashMap<>();
        for(int i = 0; i< t.length(); i++){
            Character c = t.charAt(i);
            Integer currCInt = chars.getOrDefault(c, 0);
            chars.put(c, currCInt+1);
        }
        int leftPointer = 0;
        StringBuilder sb = new StringBuilder();
        String minWord = null;
        int matched = 0;

        for(int rightPointer = 0; rightPointer< s.length(); rightPointer++){
            Character rightChar = s.charAt(rightPointer);
            //expand the window
            sb.append(rightChar);
            if(chars.containsKey(rightChar)){ //update number of chars in the map and minWord (if relevant)
                chars.put(rightChar, chars.get(rightChar)-1);
                if(chars.get(rightChar)>=0){ //<----------- (!!!)
                    matched++; // update matched chars ONLY if we DONT have redundant chars
                }

                //check wether we found all matched chars
                while(matched == t.length()){
                    if(minWord == null){
                        minWord = sb.toString();
                    }else{
                        minWord = minWord.length()<sb.length() ?minWord : sb.toString();
                    }
                    //remove first chars
                    Character leftChar = s.charAt(leftPointer);
                    sb.deleteCharAt(0);
                    if(chars.containsKey(leftChar)){//update the map if leftChar is in there. Ony decrease 'matched' if leftChar is not redundant (chars.get(leftChar) can be negative !!!)
                        if(chars.get(leftChar)==0){ //<----------- (!!!)
                            matched--;
                        }
                        chars.put(leftChar, chars.get(leftChar) + 1);
                    }
                    leftPointer++;
                }


            }

        }


        return minWord == null ? "" : minWord;
    }
}
