package problems.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * https://leetcode.com/problems/word-ladder/ #127 HARD
 * Graph, BFS
 *
 * Find transformation sequence from word beginWord to word endWord using
 * a dictionary wordList is a sequence of words
 */
public class WordLadder
{
    /***
     * НЕ нужно делать библиотеку из имеющихся слов. Вместо этого метод getNeighbours находит все возможные варианты
     * перестановок-соседей для текущего слова. Если слово-перестановка есть в списке имеющихся - добавляем в очередь
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> notVisited = new HashSet<>(wordList);  // <--- NOT visited

        Queue<String> queue =  new LinkedList<>();
        queue.offer(beginWord);

        int levels = 0;
        while(!queue.isEmpty()){
            levels++;
            int levelSize = queue.size();
            for (int i = 0; i< levelSize; i++){
                String currentWord = queue.poll();

                if(currentWord.equals(endWord)){
                    return levels;
                }
                notVisited.remove(currentWord);
                List<String> neighbours = getNeighbours(currentWord);
                for(String neighbour: neighbours){
                    if(notVisited.contains(neighbour)){
                        queue.offer(neighbour);
                    }
                }
            }

        }

        return 0;
    }
    public List<String> getNeighbours(String currentWord){
        List<String> result = new ArrayList<>();
        char[] word = currentWord.toCharArray();  // <---
        for(int i = 0; i< word.length; i++){
            char tmp = word[i];
            for (char c = 'a'; c<= 'z'; c++){ // <---
                word[i] = c;
                String neighbour = new String(word);
                result.add(neighbour);
            }
            word[i] = tmp;
        }
        return result;
    }
}
