package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    /**
     * #133. Clone Graph
     * https://leetcode.com/problems/clone-graph/
     */

    public Node cloneGraph(Node node) {
        if(node == null)return null;
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.put(node, new Node(node.val, new ArrayList<Node>()));
        queue.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors){
                if(!visited.containsKey(neighbor)){
                    queue.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val,  new ArrayList<Node>()));
                }
                //add clone(!!) of the neighbor to the list of neighbors of a curr clone
                Node currClone = visited.get(curr);
                currClone.neighbors.add(visited.get(neighbor)); //<<<<<<-------------------
            }


        }
        return visited.get(node);
    }

    /**
     * DOES NOT WORK:
     Node copyCurr =visited.get(curr);
     ArrayList neighbours = new ArrayList<Node>();
     for (Node neighbor : curr.neighbors){
     neighbours.add(neighbor); // <--- :(
     if(!visited.containsKey(neighbor)){
     queue.add(neighbor);
     visited.put(neighbor, new Node(neighbor.val,  new ArrayList<Node>()));
     }
     copyCurr.neighbors = neighbors;
     visited.put(curr, copyCurr);
     }
     *
     */

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


