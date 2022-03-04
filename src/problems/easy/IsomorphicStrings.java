package problems.easy;

import java.util.HashMap;

public class IsomorphicStrings {
    /***
     * #205. Isomorphic Strings
     * https://leetcode.com/problems/isomorphic-strings/
     *
     */

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        /*
        Обязательно нужны 2 HashMap чтобы сопоставить S->T и T->S
        Иначе можно пропустить случаи как:
        [bada],[baxa]
         */
        HashMap<Character, Character> mappingST = new HashMap<>(); //<-----
        HashMap<Character, Character> mappingTS = new HashMap<>(); //<-----
        for (int i = 0; i< s.length(); i++){
            Character currS = s.charAt(i);
            Character currT = t.charAt(i);
            if(mappingST.containsKey(currS)){
                if(mappingST.get(currS)!=currT){
                    return false;
                }
            }else if(mappingTS.containsKey(currT)){
                if(mappingTS.get(currT)!=currS){
                    return false;
                }
            }else{
                mappingST.put(currS, currT);
                mappingTS.put(currT, currS);
            }

        }
        return true;
    }

}
