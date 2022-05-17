package problems.medium;

import java.util.HashMap;

public class PermutationInString {
    /***
     * #567. Permutation in String
     * https://leetcode.com/problems/permutation-in-string/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/N0o9QnPLKNv
     */

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s1.length(); i++){
            Character c = s1.charAt(i);
            Integer currI = map.getOrDefault(c, 0);
            map.put(c, currI + 1);
        }

        int leftPointer = 0;
        int rightPointer = 0;
        while(rightPointer<s2.length()){
            Character r = s2.charAt(rightPointer);
            if(map.containsKey(r)){//we found a char, remove it from the map
                int rInt = map.get(r);
                if(rInt == 1){
                    map.remove(r);
                }else{
                    map.put(r, rInt-1);
                }
                rightPointer++;
                if(map.size()==0)
                    return true; //map is empty - all chars are found
            }else{//the sequence is broken. Add left char back
                Character l = s2.charAt(leftPointer);
                Integer currI = map.getOrDefault(l, 0);
                map.put(l, currI + 1);

                leftPointer++;
            }
        }

        return false;
    }
}

/***
 * DOES NOT WORK for input: "adc" "dcda"
 *}else{
 * while(leftPointer<rightPointer){ <<<--------wrong!!1
 *        Character l = s2.charAt(leftPointer);
 *        Integer currI = map.getOrDefault(l, 0);
 *        map.put(l, currI + 1);
 *       leftPointer++;
 *    }
 *
 *leftPointer++;
 * }
 *rightPointer++;
Мы не должны делать reset: смещать leftPointer на уровень rightPointer и добавлть все убранные буквы от leftPointer до rightPointer
 Нужно добавлять левые буквы по одной, тк возможно новое начало интервала будет в середине существующего
 */