package problems.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    /***
     * #895. Maximum Frequency Stack - HARD
     * https://leetcode.com/problems/maximum-frequency-stack/
     */
    class FreqStack {

        //<value, frequency>
        HashMap<Integer, Integer> freq;
        int maxFreq;
        //frequency, value
        Map<Integer, Stack<Integer>> equalFreq; //map хранит frequency и Stack из всех элементов с таким frequency

        public FreqStack() {
            this.freq = new HashMap<>();
            this.equalFreq = new HashMap<>();
            this.maxFreq = 0;
        }

        public void push(int val) {
            //update freq map
            Integer currFreq = freq.getOrDefault(val, 0);
            freq.put(val, currFreq +1);

            //update equalFreq map
            Stack<Integer> freqStack = equalFreq.getOrDefault(currFreq +1, new Stack<Integer>());
            freqStack.push(val);
            equalFreq.put(currFreq+1, freqStack);

            if(currFreq+1 > maxFreq){
                maxFreq = currFreq+1;
            }
        }

        public int pop() {
            Stack<Integer> freqStack = equalFreq.get(maxFreq);
            Integer maxVal = freqStack.pop();

            //update freq map
            int currFreq = freq.get(maxVal)-1;
            freq.put(maxVal, currFreq);

            if(freqStack.size()==0){
                //update equalFreq map
                equalFreq.remove(maxFreq);
                //update maxFreq
                maxFreq--;
                /*
                maxFreq достаточно обновлять только когда freqStack.size()
                 */
            }

            return maxVal;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
