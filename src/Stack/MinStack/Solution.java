package Stack.MinStack;

import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/29
 */

public class Solution {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(2147483646);
        s.push(2147483646);
        s.push(2147483647);
        System.out.println(s.top());
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        s.push(2147483647);
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.push(-2147483648);
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> stackmin;
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        stackmin = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (stackmin.isEmpty()) {
            min = x;
            stackmin.push(x);
        } else {
            min = Math.min(min,x);
            stackmin.push(min);
        }
    }

    public void pop() {
        stack.pop();
        stackmin.pop();
        min = stackmin.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackmin.peek();
    }
}
