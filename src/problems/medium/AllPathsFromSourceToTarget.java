package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * https://leetcode.com/problems/all-paths-from-source-to-target/ #797 MEDIUM
 */
public class AllPathsFromSourceToTarget
{
    public List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        LinkedList<Integer> currPath = new LinkedList<>(); //we need to use LinkedList for path because we want to remove last element when we check all combinations
        if(graph.length<1){
            return null; //???
        }
        currPath.add(0);
        recursion(graph, result, visited,currPath, 0);
        return result;
    }

    public void recursion(int[][] graph, List<List<Integer>> result, boolean[] visited, LinkedList<Integer> currPath, int currVertex){
        if(currPath.size()>0 && currPath.get(currPath.size()-1) == graph.length-1){
            this.result.add(new ArrayList<Integer>(currPath));
            return;
        }
        if(visited[currVertex]){
            return;
        }

        //process current Vertex
        visited[currVertex] = true;
        int[] neighbours = graph[currVertex];

        //call recursion
        for(int i: neighbours){
            currPath.add(i);
            recursion(graph, result, visited, currPath, i);
            //undo the changes to try other paths for every Vertex. If not, the algorithm will find only one path
            currPath.removeLast(); //remove i
            visited[i] = false;
        }
    }

}
