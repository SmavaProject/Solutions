package problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SmallestCommonRegion {
    /***
     * #1257. Smallest Common Region
     * https://leetcode.com/problems/smallest-common-region/
     */
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        /*
         * 1) Построить HashMap <child, parent>
         * 2) По цепочке найти всех Parents региона1
         * 3) Найти Parents региона2 проверяя их на наличие в HashSet<String> region1Parents. Первый найденный и есть общий
         */
        //<child, parent>
        HashMap<String, String> map = new HashMap<>();
        for (List<String> r: regions){
            String parent = r.get(0);
            for(int i = 1; i< r.size(); i++){
                map.put(r.get(i), parent);
            }
        }

        HashSet<String> region1Parents = new HashSet<>();
        region1Parents.add(region1); //<<<--- every region is a parent of itself
        String reg1Parent = map.get(region1);
        while(reg1Parent!=null){
            region1Parents.add(reg1Parent);
            reg1Parent = map.get(reg1Parent);
        }

        String reg2Parent = region2; //<<<--- every region is a parent of itself
        while(!region1Parents.contains(reg2Parent)){
            reg2Parent = map.get(reg2Parent);
        }
        return reg2Parent;
    }

}
