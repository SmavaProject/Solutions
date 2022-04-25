package problems.medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    /***
     * #636. Exclusive Time of Functions
     * https://leetcode.com/problems/exclusive-time-of-functions/
     * Stack should store not only the information about the function start time,
     * but also all time during which the function was inactive.
     * A notActiveTime for a function is the sum of executionTime for every function executed before
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>(); // id, startTime, notActiveTime
        for(int i = 0; i< logs.size(); i++){
            String l = logs.get(i);
            String[] log = l.split(":");
            if(log[1].equals("start")){
                stack.push(new int[]{Integer.valueOf(log[0]), Integer.valueOf(log[2]), 0}); //notActiveTime for the top element is 0
            }else{
                int[] startLog = stack.pop();
                int index = startLog[0];
                int previousTime = result[index]; //"result" stores accumulated execution time for each function so far
                int currentExecutionTime = Integer.valueOf(log[2]) - startLog[1] +1;
                int newTime = previousTime + currentExecutionTime - startLog[2];
                result[index] = newTime;

                //update log on the top of the stack with new inactive time
                if(stack.isEmpty()) continue;
                int[] logToUpdate = stack.pop();
                logToUpdate[2] += currentExecutionTime;
                stack.push(logToUpdate);

            }
        }
        return result;
    }
}