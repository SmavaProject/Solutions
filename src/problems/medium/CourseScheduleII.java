package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/***
 * https://leetcode.com/problems/course-schedule-ii/
 * #210 MEDIUM Graph, topological sorting
 * очень много corner cases, чтобы пройти все тест кейсы нужно учесть много исключений
 */
public class CourseScheduleII
{

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses<1){
            //-???
        }
        if(prerequisites.length == 0){
            int[] result = new int[numCourses];
            for(int i = 0; i< result.length;i++){
                result[i] = i;
            }
            return result;
        }
        //<course,numOfPrereqs>
        HashMap<Integer, Integer> numOfPrereq = new HashMap<Integer, Integer>();//create map with indegree
        //<course, list of courses for which it is a prereq>
        HashMap<Integer, ArrayList<Integer>> isPrereqFor = new HashMap<>();

        for (int[] prereq: prerequisites){
            //1) first map
            Integer currNumOfPrereq = numOfPrereq.getOrDefault(prereq[0], 0);
            currNumOfPrereq++;
            numOfPrereq.put(prereq[0], currNumOfPrereq);
            //add the prereq course itself. This way we will guarantee that courses with 0 prereqs will be in the map as well
            if(!numOfPrereq.containsKey(prereq[1])){
                numOfPrereq.put(prereq[1], 0);
            }
            //2)second map
            ArrayList<Integer> listPrereq = isPrereqFor.getOrDefault(prereq[1], new ArrayList<>());
            listPrereq.add(prereq[0]);
            isPrereqFor.put(prereq[1],listPrereq);
        }

        //handle the case when courses dont have prereqs and are not prereqs for others
        if(numOfPrereq.size()<numCourses){
            for(int i = 0; i< numCourses; i++){
                if(!numOfPrereq.containsKey(i)){
                    numOfPrereq.put(i, 0);
                }
            }
        }

        Queue<Integer> queue  = new LinkedList<>();
        //get courses with 0 prereqs and add them to the queue
        for(Integer i: numOfPrereq.keySet()){
            if(numOfPrereq.get(i)==0)
                queue.add(i);
        }

        //if there are no courses with indegree==0, we cannot build any schedule
        if(queue.isEmpty()){
            return  new int[0];
        }

        int[]res = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            Integer currCourse  = queue.poll();
            res[index] = currCourse;
            index++;

            ArrayList<Integer> prereqCurr = isPrereqFor.get(currCourse); //get list of courses for which currCourse is a prepreq
            if(prereqCurr!=null){
                //reduce indegree of all courses in prereqCurr
                for(Integer in: prereqCurr){
                    Integer indegree = numOfPrereq.get(in) -1;
                    if(indegree==0){
                        queue.add(in);
                    }else{
                        numOfPrereq.put(in, indegree);
                    }
                }
            }

        }

        //if at some point there were no courses with indegree==0 and we did not finish filling the res array-> return empty array []
        if(index<numCourses-1){
            return new int[0];
        }

        return res;
    }
}
