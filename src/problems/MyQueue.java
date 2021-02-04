package problems;
import java.util.Stack;

class MyQueue {

    /***
     *  Leetcode problem #232. Implement Queue using Stacks . EASY
     */
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    private int size;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
        this.size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.inStack.push(x);
        this.size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //move elements from inStack to outStack
        if(this.outStack.isEmpty()){
            while(!this.inStack.isEmpty()){
                this.outStack.push(this.inStack.pop());
            }
        }
        this.size--;
        return this.outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!this.outStack.isEmpty()){
            return this.outStack.peek();
        }else{
            while(!this.inStack.isEmpty()){
                this.outStack.push(this.inStack.pop());
            }
        }
        return this.outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
