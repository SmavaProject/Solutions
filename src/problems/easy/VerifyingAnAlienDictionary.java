package problems.easy;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    /**
     * Решение заключается в том, что нам нужно сравнить только каждую пару слов.
     * Если они сортированы, то и все слова сортированы. Не нужно сравнитьвать все слова со всеми
     * Также не нужно сравнивать все слово. Достаточно сравнить первую отличающуюся букву.
     * Дальше порядок уже не важен
     *
     * #953. Verifying an Alien Dictionary - EASY
     * https://leetcode.com/problems/verifying-an-alien-dictionary/
     */
    public boolean isAlienSorted(String[] words, String order) {
        //Порядковый номер каждой буквы в словаре, чтобы за O(1) получать информацию
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (Integer i = 0; i< order.length(); i++){
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 1; i< words.length; i++){
            String curr = words[i-1];
            String next = words[i];
            int index = 0;
            while(index< curr.length() && index<next.length() && curr.charAt(index)==next.charAt(index)){
                index++;
            }
            if(curr.length()==index){
                continue;
            }
            if(next.length()==index){
                return false;
            }
            Integer currNum = orderMap.get(curr.charAt(index)); //порядковый номер буквы в словаре
            Integer nextNum = orderMap.get(next.charAt(index));
            if(currNum>nextNum){
                return false;
            }
        }
        return true;
    }
}
