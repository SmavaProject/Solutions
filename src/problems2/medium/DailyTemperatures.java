package problems2.medium;

public class DailyTemperatures {

    //https://leetcode.com/problems/daily-temperatures/description/

    public int[] dailyTemperatures(int[] temperatures) {
        int answer[] = new int[temperatures.length];
        //Stack stores the indices of High temperatures
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i< temperatures.length; i++){


            //if the current temp is higher than the one in stack - take index from stack
            //if not, just keep pushing the indexes of low temperature into the stack
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevIndev = stack.pop();
                answer[prevIndev] = i - prevIndev;
            }
            stack.push(i);
        }
        return answer;
    }

}
