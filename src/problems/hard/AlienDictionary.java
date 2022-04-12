package problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    /**
     * # 269. Alien Dictionary - HARD
     * Graph, topological sort
     * https://leetcode.com/problems/alien-dictionary/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/R8AJWOMxw2q
     */
 /*
    * 1) Создать HashMap<Character, ArrayList<Caracter>> со списком всех Char которые предшествуют этой. Это наш граф
    * 1.1) Добавить все буквы из всех имеющихся слов в HashMa. Это важно сделать в начале чтобы не пропустить никакую букву
    как например в этом кейсе - ["ab","adc"]. "c" может быть пропущена после сравнения "ab" и "ad"
    * 2) Если ArrayList<Caracter> пустой, это значит что этому Character никто не предшествует (0 indegree)
    * 3) Пройтись по всем 0 indegree и добавить их в "словарь"
    * 4) Важно! сравнивать слова достаточно попарно, и только первую отличабщуюся букву
    * см. 953. Verifying an Alien Dictionary
    */
    public String alienOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> orderMap = new HashMap<>();
        //add all chars to the orderMap
        for (int i = 0; i< words.length; i++){
            String curr = words[i];
            for(int j = 0; j<curr.length(); j++){
                char c = curr.charAt(j);
                orderMap.put(c, new ArrayList<Character>());
            }
        }
        //initialize the graph
        for (int i = 1; i< words.length; i++){
            String curr = words[i-1];
            String next = words[i];
            int index = 0;
            while(index<curr.length() && index<next.length() && curr.charAt(index)==next.charAt(index)){
                index++;
            }
            if(curr.length()!=index&&next.length()==index){//to cover test case: ["abc","ab"]
                return "";
            }
            if(curr.length()==index||next.length()==index){
                continue;
            }
            Character currChar = curr.charAt(index);
            Character nextChar = next.charAt(index);
            ArrayList<Character> beforeArray = orderMap.get(nextChar);
            if(!beforeArray.contains(currChar)){
                beforeArray.add(currChar);
                orderMap.put(nextChar, beforeArray);
            }
        }

        StringBuilder order = new StringBuilder();

        Queue<Character> queue = new LinkedList<Character>();
        //add all 0 indegree chars to the queue
        for(Character c: orderMap.keySet()){
            ArrayList<Character> beforeArray = orderMap.get(c);
            if(beforeArray.size()==0){
                queue.add(c);
            }
        }

        // collect all chars to the "order"
        while(!queue.isEmpty()){
            Character curr = queue.poll();
            order.append(curr);
            for(Character c: orderMap.keySet()){
                ArrayList<Character> beforeArray = orderMap.get(c);
                if(beforeArray.contains(curr)){
                    beforeArray.remove(curr);
                    if(beforeArray.size()==0){
                        queue.add(c);
                    }
                }
            }
        }


        return order.length() == orderMap.size() ? order.toString() : "";
    }
}
