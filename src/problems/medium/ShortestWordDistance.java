package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class ShortestWordDistance {
    /***
     * #244. Shortest Word Distance II
     * https://leetcode.com/problems/shortest-word-distance-ii/
     *
     */

    //<word, its indexes>
    private HashMap<String, ArrayList<Integer>> map;

    public ShortestWordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for (int i = 0; i< wordsDict.length; i++){
            String word = wordsDict[i];
            map.computeIfAbsent(word, value -> new ArrayList<Integer>()).add(i); //<<---- Add a vlaue to a new list in the map !!!
        }
    }

    public int shortest(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        ArrayList<Integer> indexWord1 = map.get(word1);
        ArrayList<Integer> indexWord2 = map.get(word2);
        int pointer1 =0;
        int pointer2 =0;

        while (pointer1<indexWord1.size() && pointer2<indexWord2.size()){

            int index1 = indexWord1.get(pointer1);
            int index2 = indexWord2.get(pointer2);

            minDistance = Math.min(minDistance, Math.abs(index1-index2));

            if(index1<index2){ //<<<-------- make pointers closer to each other ??
                pointer1++;
            }else{
                pointer2++;
            }
        }

        return minDistance;
    }
}

/**
 * Note:
 * map.computeIfAbsent(word, value -> new ArrayList<Integer>()).add(i); //<<---- Add a vlaue to a new list in the map !!!
 */
