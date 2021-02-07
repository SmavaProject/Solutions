package problems.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum
{
    /***
     * https://leetcode.com/problems/nested-list-weight-sum/ - Problem # 339 MEDIUM
     */

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
        public int depthSum(List<NestedInteger> nestedList) {
            if (nestedList.size()<1){
                return 0;
            }

            Queue<NestedInteger> queue = new LinkedList<>(nestedList);
            int level = 1;
            int sum = 0;
            int levelLength = queue.size();
            while(!queue.isEmpty()){
                /***
                 * We need to keep track of the level, because the Queue will not                       * distinguish the Depth of NestedInteger
                 * The length of each level is the size of the Queue after we took all
                 * NestedInteger from previous level
                 */
                if(levelLength<1){
                    levelLength = queue.size();
                    level++;
                }

                NestedInteger  currInt = queue.poll();
                if(currInt.isInteger()){
                    int integ = currInt.getInteger();
                    sum = sum + level*integ;
                }else{
                    List<NestedInteger> currList = currInt.getList();
                    for(NestedInteger cInt: currList){
                        queue.offer(cInt);
                    }
                }
                // decrement the level size after processing each NestedInteger
                levelLength--;
            }
            return sum;
        }

}
