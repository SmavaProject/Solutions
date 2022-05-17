package problems.medium;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NetworkDelayTime {
    /***
     * #743. Network Delay Time
     * https://leetcode.com/problems/network-delay-time/
     *
     * Creating Set<Integer> visited does not work here, because we NEED to visit some nodes Several times(!)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        if(n-1>times.length)return -1;

        int[] maxTimes = new int[n+1];
        Arrays.fill(maxTimes, Integer.MAX_VALUE);

        Map<Integer, ArrayList<Pair<Integer, Integer>>> adjacencyList = new HashMap<>();
        for(int[] time: times){
            ArrayList<Pair<Integer, Integer>> list = adjacencyList.getOrDefault(Integer.valueOf(time[0]), new ArrayList<>());
            list.add(new Pair(time[1], time[2]));
            adjacencyList.put(Integer.valueOf(time[0]), list);
        }


        Queue<int[]> q = new LinkedList<>();
        ArrayList<Pair<Integer, Integer>> firstN = adjacencyList.getOrDefault(Integer.valueOf(k), new ArrayList<>());
        for(Pair<Integer,Integer> p: firstN){
            q.add(new int[]{k, p.fst, p.snd});
            maxTimes[k]=0;
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            maxTimes[node[1]]=Math.min(maxTimes[node[1]], node[2]);
            if(adjacencyList.containsKey(Integer.valueOf(node[1]))){
                ArrayList<Pair<Integer, Integer>> neighbours = adjacencyList.get(Integer.valueOf(node[1]));
                for(Pair<Integer,Integer> neign: neighbours){
                    if(maxTimes[neign.fst]>neign.snd +node[2]){ //<<<---- use instead of Set<Integer> visited
                        q.add(new int[]{node[1], neign.fst, neign.snd +node[2]});
                    }
                }

            }
        }
        int t = Integer.MIN_VALUE;
        for (int i = 1; i< maxTimes.length; i++){
            t = Math.max(t, maxTimes[i]);
        }

        return t==Integer.MAX_VALUE ? -1: t;
    }
}
