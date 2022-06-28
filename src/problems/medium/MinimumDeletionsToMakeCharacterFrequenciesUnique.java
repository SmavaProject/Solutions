package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    /***
     * 1647. Minimum Deletions to Make Character Frequencies Unique
     * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
     */
    public int minDeletions(String s) {
        //<char, its frequency >
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        //мы посчитали как часто каждая буква встречается и теперь нас интеесует только сама частота, не важны буквы
        ArrayList<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies, Collections.reverseOrder()); //<---- !!

        if(frequencies.size()<2) return 0;
        int result = 0;

        //будем складывать в стэк все frequencies таким образом, чтобы они были уникальны и в убывающем порядке
        //мы не можем по возрастанию складывать, тк в случае повторов мы можем только отнимать
        Stack<Integer> monoDecreasingStack = new Stack<>();
        int index = 0;
        monoDecreasingStack.push(frequencies.get(index));
        index++;
        while(index < frequencies.size()){
            int freq = frequencies.get(index);
            while(freq>=monoDecreasingStack.peek() && freq>=1){
                freq--;
                result++;
            }
            if(freq>0){ //элементы 0 нас не интересуют
                monoDecreasingStack.push(freq);
            }
            index++;
        }
        return result;
    }
}

