package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleV2 {

/***
 * # 207. Course Schedule - MEDIUM
 * https://leetcode.com/problems/course-schedule/
 */

public boolean canFinish(int numCourses, int[][] prerequisites) {
    if(numCourses==0){
        return false;
    }
    //<course, list Of prerequisites>
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    for(int i = 0; i< prerequisites.length; i++){
        int[] prereq = prerequisites[i];
        map.computeIfAbsent(prereq[0], v -> new ArrayList<Integer>()).add(prereq[1]);
    }

    //queue with courses that have no prerequisites
    Queue<Integer> noPrereq = new LinkedList<Integer>();
    for(int i = 0; i<numCourses; i++){
        if(!map.containsKey(i)){
            noPrereq.add(i);
        }
    }

    //iterate via map and remove from the list of prerequisites which are "taken"
    while(!noPrereq.isEmpty()){
        Integer freeNode = noPrereq.poll();
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, ArrayList<Integer>> entry = iter.next();
            ArrayList dependencies =  entry.getValue();
            dependencies.remove(freeNode);
            if(dependencies.isEmpty()){
                Integer i = entry.getKey();
                noPrereq.add(i);
                iter.remove(); // remove entry from the map if it has no dependencies
            }
        }
    }
    return map.isEmpty();
}
}