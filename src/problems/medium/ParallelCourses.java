package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ParallelCourses {
    /***
     * #1136. Parallel Courses
     */
    public int minimumSemesters(int n, int[][] relations) {

        //prereq, list<courses>
        HashMap<Integer, ArrayList<Integer>> isPrereqFor = new HashMap<>();
        int[] indegree = new int[n+1];

        for(int i = 0; i< relations.length; i++){

            ArrayList<Integer> num = isPrereqFor.getOrDefault(relations[i][0], new ArrayList<Integer>());
            num.add(relations[i][1]);
            isPrereqFor.put(relations[i][0],num);
            indegree[relations[i][1]]++;
        }
        Queue<Integer> coursesToTake = new LinkedList<Integer>();
        for(int i = 1; i< indegree.length; i++){
            if(indegree[i]==0){
                coursesToTake.offer(i);
            }
        }

        int numOfSemesters = 0;
        int takenCourses = 0;

        while(!coursesToTake.isEmpty()){
            numOfSemesters++;
            Integer numOfCursesInCurrentSemester = coursesToTake.size();
            for(int i = 0; i< numOfCursesInCurrentSemester; i++){
                Integer prereq = coursesToTake.poll();
                takenCourses++;
                ArrayList<Integer> courses = isPrereqFor.getOrDefault(prereq, new ArrayList<Integer>());
                for(int j = 0; j< courses.size(); j++){
                    indegree[courses.get(j)]--;
                    if(indegree[courses.get(j)]==0)coursesToTake.offer(courses.get(j));
                }

            }
        }

        return takenCourses!=n ? -1: numOfSemesters;
    }
}
