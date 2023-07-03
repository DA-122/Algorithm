// 力扣155
// 思路分析： 两个栈，一个栈存元素，一个栈存最小元素

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    int capacity;
    public MinStack() {
        capacity = 0;
    }
    
    public void push(int val) {
        stack.push(val);
        if(capacity == 0){
            minStack.push(val);
        }else{
            minStack.push(Math.min(val,minStack.peek()));
        }
        capacity++;
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        capacity--;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */