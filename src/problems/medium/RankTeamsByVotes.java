package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RankTeamsByVotes {
    /***
     * #1366. Rank Teams by Votes
     * https://leetcode.com/problems/rank-teams-by-votes/
     */
    public String rankTeams(String[] votes) {


        HashMap<Character, int[]> map = new HashMap<>();

        for(int wordIndex = 0; wordIndex< votes.length; wordIndex++){
            for(int i = 0; i< votes[0].length(); i++){//go by chars
                String word = votes[wordIndex];
                Character c = word.charAt(i);
                int[] val = map.getOrDefault(c, new int[word.length()]);
                val[i]++;
                map.put(c, val);
            }
        }

        /*
         *    A -> [5, 0, 0]
         *    B -> [0, 2, 3]
         *    C -> [0, 3, 2]
         */

        //сортируем characters исходя из их соличества в массиве
        List<Character> list = new ArrayList(map.keySet());
        Collections.sort(list, (c1, c2) -> {
            for(int i = 0; i< votes[0].length(); i++){
                if(map.get(c1)[i]>map.get(c2)[i]) return -1;
                if(map.get(c1)[i]<map.get(c2)[i]) return 1;
            }
            return c1.compareTo(c2); //если всегда было одно и то же количество то сортируем по алфавиту
        });

        StringBuilder sb = new StringBuilder();
        for(Character c: list){
            sb.append(c);
        }

        return sb.toString();
    }
}
