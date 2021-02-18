package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/***
 * https://leetcode.com/problems/course-schedule/ #207 MEDIUM
 * Topological sort
 */
public class CourseSchedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }

        /***
         * Создаем 2 HashMap:
         * В numberOfPrereqsForCourse сохраняем КОЛИЧЕСТВО пререквизитов для каждого курса (это indegree map)
         * В courseIsPrereqFor сохраняем список ПРЕРЕКВИЗИТОВ для каждого КУРСА
         */
        Map<Integer, ArrayList<Integer>> courseIsPrereqFor = new HashMap<>();
        Map<Integer, Integer> numberOfPrereqsForCourse = new HashMap<>();

        for(int[] link: prerequisites){
            //1. process numberOfPrereqsForCourse
            Integer prereqNum = numberOfPrereqsForCourse.getOrDefault(link[0], 0);
            prereqNum++;
            numberOfPrereqsForCourse.put(link[0], prereqNum);

            //add default value to the prereq course itselt
            if(!numberOfPrereqsForCourse.containsKey(link[1]))
                numberOfPrereqsForCourse.put(link[1], 0);

            //2. process courseIsPrereqFor
            ArrayList<Integer> prereqs = courseIsPrereqFor.getOrDefault(link[1],new ArrayList<>());
            prereqs.add(link[0]);
            courseIsPrereqFor.put(link[1],prereqs);
            //default empty list of prereqs
            if(!courseIsPrereqFor.containsKey(link[0]))
                courseIsPrereqFor.put(link[0], new ArrayList<Integer>());

        }

        //3. создаем Queue в которой будем сохранять курсы БЕЗ пререквизитов
        Queue<Integer> queueOfZeroPrereqs = new LinkedList<>();

        for (Integer i: numberOfPrereqsForCourse.keySet()){
            if(numberOfPrereqsForCourse.get(i) ==0){
                queueOfZeroPrereqs.add(i);
            }
        }

        //4. Итоговый лист очередности курсов. В него попадут курсы когда у них не будет пререквизитов
        List<Integer> order = new LinkedList<>();
        //5. Особый случай: если у курса нет пререквизитов и он не является пререквизитом для других - его можно
        //проходить в любой очередности. Просто добавим его в order. Это для unconnected graph
        if(courseIsPrereqFor.size()<numCourses){
            int coursesWithoutAnyPrerequisites = numCourses-courseIsPrereqFor.size();
            while(coursesWithoutAnyPrerequisites>0){
                order.add(-1);
                coursesWithoutAnyPrerequisites--;
            }
        }

        //6. "Проходим" курсы без пререквизитов и уменьшаем количество пререквизитов для тех курсов для которых curr был пререквизитом
        while(!queueOfZeroPrereqs.isEmpty()){

            Integer curr = queueOfZeroPrereqs.poll();
            order.add(curr);
            ArrayList<Integer> neighbours = courseIsPrereqFor.get(curr);

            //delete curr course from all neighbours in map
            for (Integer course: neighbours){
                numberOfPrereqsForCourse.put(course, numberOfPrereqsForCourse.get(course)-1);
                if(numberOfPrereqsForCourse.get(course)==0){ //если у курса больше нет пререквизитов - добавляем его в Queue для обработки
                    queueOfZeroPrereqs.add(course);
                }
            }
        }
        if(order.size() == numCourses){
            return true;
        }
        return false;
    }
}
