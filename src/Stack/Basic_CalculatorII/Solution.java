package Stack.Basic_CalculatorII;

import java.util.Stack;

/**
 * Created by PennyLiu on 2018/7/11.
 */

public class Solution{
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.replace(" ","");
        // 这时候从数字开始处理，针对
        Stack<Integer> stack = new Stack<>();
        int result = 0, number = 0;
        // sign保存的是当前数字前面的符号
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                number = number * 10 + c - '0';
            }
            // 当签数是符号或者是最后一个数的时候需要处理
            if(!Character.isDigit(c) || i == s.length() - 1) {
                //number之前是+
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                }
                // number之前是*，
                else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = s.charAt(i);
                number = 0;
            }
        }
        //stack也能用foreach
        for (int i: stack) {
            result += i;
        }
        return result;
    }


    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String S = "3+2*2";
        System.out.println(solution.calculate(S));
    }
}