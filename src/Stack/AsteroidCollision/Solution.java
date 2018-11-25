package Stack.AsteroidCollision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/25
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> ans;
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            // 栈是空的
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                //栈不为空
                //栈顶元素向左。那这个元素向左，或向右都没关系，所以直接入栈
                if (stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else {
                    //栈顶向右
                    //当前元素向左
                    int top = asteroids[i];
                    if (asteroids[i] < 0) {
                        // 栈不为空，且栈顶元素和每次对冲完的元素符号相反
                        while (!stack.isEmpty() && stack.peek()>0 && top<0) {
                            int ast = stack.pop();
                            if (ast == Math.abs(top)) {
                                top = 0;
                                break;
                            } else if (ast > Math.abs(top)) {
                                top = ast;
                            }
                        }
                        if (top != 0) {
                            stack.push(top);
                        }
                    } else {
                        //当前元素向右
                        stack.push(asteroids[i]);
                    }
                }
            }
        }
        ans = new ArrayList(stack);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println((8 ^ 8) >> 31);
        Solution a = new Solution();
        int[] aa = {-2,-2,2,-1};
        int[] ans = a.asteroidCollision(aa);
        System.out.println(Arrays.toString(ans));
    }
}