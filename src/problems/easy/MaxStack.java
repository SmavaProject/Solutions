package problems.easy;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxStack {
    /***
     * #716. Max Stack - EASY
     * https://leetcode.com/problems/max-stack/
     */
    private PriorityQueue<Integer> pk;
    private LinkedList<Integer> list;
    public MaxStack() {
        this.pk = new PriorityQueue<>((a1, a2) -> a2 - a1); //maxHeap
        this.list = new LinkedList();
    }

    public void push(int x) {
        this.list.addFirst(x);
        this.pk.add(x);
    }

    public int pop() {
        Integer result = list.getFirst();
        pk.remove(result);
        list.remove(result);
        return result;
    }

    public int top() {
        return this.list.getFirst();
    }

    public int peekMax() {
        return this.pk.peek();
    }

    public int popMax() {
        Integer result = pk.poll();
        list.remove(result);
        return result;
    }

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
