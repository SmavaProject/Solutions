package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {
    /***
     * #811. Subdomain Visit Count
     * https://leetcode.com/problems/subdomain-visit-count/
     *
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: cpdomains){
            String[] numDomain = s.split(" ");
            String domains = numDomain[1];
            int index = 0;
            while(index<domains.length()){
                char c = domains.charAt(index);
                if(c=='.' || index == 0){ // index == 0 <-- to include parent domain
                    String domain = index==0 ? domains.substring(index, domains.length()) : domains.substring(index +1, domains.length());
                    Integer num = map.getOrDefault(domain, 0);
                    map.put(domain, num + Integer.valueOf(numDomain[0]));
                }
                index++;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String s: map.keySet()){
            result.add(map.get(s) + " " + s);
        }
        return result;
    }
}
