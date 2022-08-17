package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    /**
     * #787. Cheapest Flights Within K Stops
     * https://leetcode.com/problems/cheapest-flights-within-k-stops/
     * Modified BFS, added minPricesMap to keep track of min possible price to reach node (kind of Dijkstra alg)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //graph <sourse, [destination,price]>
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int[] flight: flights){
            ArrayList<int[]> neighbours = map.getOrDefault(flight[0], new ArrayList<int[]>());
            neighbours.add(new int[]{flight[1], flight[2]});
            map.put(flight[0], neighbours);
        }

        int minPrice = Integer.MAX_VALUE;
        int currPrice = 0;
        int numOfStops = 0;
        //<stop, min price to reach this stop
        HashMap<Integer, Integer> minPricesMap = new HashMap<>(); //track the min price to the stop
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        while(!q.isEmpty() && numOfStops<=k+1){
            numOfStops++;
            int numOfNeigh = q.size();
            for(int i = 0; i< numOfNeigh; i++){
                int[] stop = q.poll();
                currPrice=stop[1];
                if(stop[0] == dst){
                    minPrice = Math.min(minPrice, currPrice);
                }
                if(!map.containsKey(stop[0])) continue;

                ArrayList<int[]> neigh = map.get(stop[0]);
                for(int j = 0; j< neigh.size(); j++){
                    int[] currNeigh = neigh.get(j);
                    int updatedPrice = currNeigh[1]+ stop[1];
                    if(minPricesMap.containsKey(currNeigh[0])){
                        int currNeighMinPrice =  minPricesMap.get(currNeigh[0]);
                        if( currNeighMinPrice > updatedPrice){//only put the stop back into queue again if a new total price is less than previous
                            currNeighMinPrice = updatedPrice;
                            minPricesMap.put(currNeigh[0], currNeighMinPrice);
                            q.offer(new int[]{currNeigh[0], currNeighMinPrice});
                        }

                    }else{
                        minPricesMap.put(currNeigh[0], updatedPrice);
                        q.offer(new int[]{currNeigh[0], updatedPrice});
                    }
                }
            }

        }
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }
}
