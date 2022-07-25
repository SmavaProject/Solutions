package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class AllPathsFromSourceLeadToDestination {
    /***
     * #1059. All Paths from Source Lead to Destination
     * https://leetcode.com/problems/all-paths-from-source-lead-to-destination/
     */
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        //Step 1: create a graph from the edges
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            ArrayList<Integer> incomming = graph.getOrDefault(edge[0], new ArrayList<Integer>());
            incomming.add(edge[1]);
            graph.put(edge[0], incomming);
        }

        if(source == destination && graph.size() == 0) return true;

        //Step 2: go through all pathes in the graph.
        //If you find any path which ends not at "destination" then return false
        Stack<Integer> stack = new Stack<>();
        if(!graph.containsKey(source)) return false; // <-- ?
        if(graph.containsKey(destination)) return false;// <-- ?
        stack.add(source);

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> leadToDestination = new HashSet<>();
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            visited.add(node); //<<<--?
            if(!graph.containsKey(node)) return false; // we found end of path and it is not destination
            ArrayList<Integer> neighbours = graph.get(node);
            for (Integer neigh : neighbours){
                if(neigh == destination){
                    leadToDestination.addAll(visited);
                    continue;
                }else{
                    if(!visited.contains(neigh)){
                        stack.add(neigh);
                    }else{
                        //we already have seen this node. If it does not lead to destination than it is a cycle
                        if(!leadToDestination.contains(neigh))
                            return false;
                    }

                }
            }
        }


        return true;
    }
}
