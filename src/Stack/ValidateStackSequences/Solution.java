package Stack.ValidateStackSequences;

import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/2
 */
public class Solution {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null && popA == null) {
            return true;
        } else if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int a:pushA) {
            while(!stack.isEmpty() && stack.peek() == popA[idx]){
                stack.pop();
                idx++;
            }
            stack.push(a);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
        IsPopOrder(pushed,popped);
    }
}
