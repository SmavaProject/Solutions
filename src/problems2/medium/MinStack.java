package problems2.medium;

public class MinStack {

    //nodeVal, minStackVal
    Stack<problems.medium.BinaryTreeVerticalOrderTraversal.Pair<Integer, Integer>> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        Integer currMin = this.getMin();
        Integer newMin = Math.min(value, currMin);
        this.stack.push(new problems.medium.BinaryTreeVerticalOrderTraversal.Pair(value, newMin));
    }

    public void pop() {
        this.stack.pop().getKey();
    }

    public int top() {
        return this.stack.peek().getKey();
    }

    public int getMin() {
        if(stack.size() == 0) return Integer.MAX_VALUE;
        return this.stack.peek().getValue();
    }

}
