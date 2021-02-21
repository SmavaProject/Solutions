package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * https://leetcode.com/problems/reconstruct-itinerary/  #332 MEDIUM
 * Не проходит тест кейс, странное описание условий
 */
public class ReconstructItinerary
{
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        result.add("JFK");
        if(tickets.size()==0){
            return result;
        }

        //1. add all tickets to the map
        Map<String, List<String>> routes = new HashMap<>();
        for(List<String> curr: tickets){
            String from = curr.get(0);
            List<String> to = routes.getOrDefault(from, new ArrayList<>());
            to.add(curr.get(1));
            routes.put(from, to);
        }


        String from = "JFK";
        String to = "tmp";
        while(routes.size()>0){
            List<String> fromTo = routes.get(from);
            if(fromTo == null){
                return result;
            }
            for (String s: fromTo){
                if(to.compareTo(s)>0){
                    to = s;
                }
            }
            result.add(to);
            fromTo.remove(to);
            if(fromTo.size()>0){
                routes.put(from, fromTo);
            }else{
                routes.remove(from);
            }
            from = to;
            to = "tmp";
        }


        return result;
    }
}
