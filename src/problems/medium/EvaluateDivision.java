package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {
    /***
     * #399. Evaluate Division
     * https://leetcode.com/problems/evaluate-division/
     * Graph
     */

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];


        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(int i = 0; i<equations.size(); i++){
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);

            HashMap<String, Double> aMap = map.getOrDefault(a, new HashMap<String, Double>());
            aMap.put(b, values[i]);
            map.put(a, aMap);

            HashMap<String, Double> bMap = map.getOrDefault(b, new HashMap<String, Double>());
            bMap.put(a, 1 / values[i]);
            map.put(b, bMap);
        }

        for(int i = 0; i<queries.size(); i++){
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);

            if(!map.containsKey(a)){
                result[i] = -1.00000;
            }else if(a.equals(b)){
                result[i] = 1.00000;
            }else{
                HashMap<String, Double> aMap = map.get(a);
                if(aMap.containsKey(b)){
                    result[i] = aMap.get(b);
                }else{
                    if(findPath(aMap, map, a, b)){
                        result[i] = aMap.get(b);
                    }else{
                        result[i] = -1.00000;
                    }

                }
            }
        }

        return result;
    }

    //aMap does not contain b, we have already checked it. But we may find a longer path to b
    public boolean findPath(HashMap<String, Double> aMap, HashMap<String, HashMap<String, Double>> map, String a, String b){

        for(String key: aMap.keySet()){
            HashSet<String> visited = new HashSet<>();
            visited.add(a);

            double aValue = aMap.get(key);
            double updKeyVal = 1;

            while(map.containsKey(key) && !visited.contains(key)){
                visited.add(key);
                aValue = aValue * updKeyVal;
                HashMap<String, Double> keyMap = map.get(key);
                ArrayList<String> keyMapKeys = new ArrayList<>(keyMap.keySet());
                int index = 0;

                if(keyMap.containsKey(b)){
                    aValue = aValue * keyMap.get(b);
                    aMap.put(b, aValue);
                    map.put(a, aMap);

                    //add reverse value as well
                    HashMap<String, Double> bMap = map.getOrDefault(b, new HashMap<String, Double>());
                    bMap.put(a, 1 / aValue);
                    map.put(b, bMap);
                    return true;
                }else{
                    //update key
                    while(index<keyMapKeys.size() && visited.contains(key)){
                        key = keyMapKeys.get(index);
                        updKeyVal = keyMap.get(key);
                        index++;
                    }

                }
            }
        }
        return false;
    }
}