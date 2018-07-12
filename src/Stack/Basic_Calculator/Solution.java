package Stack.Basic_Calculator;

import java.util.Stack;

/**
 * Created by PennyLiu on 2018/7/11.
 */

public class Solution{
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        //栈用来存一个括号内的结果，没有括号就一次算完
        Stack<Integer> stack = new Stack<>();
        // result是一个括号内的计算结果，number是当前这个数，sign对应number前面的符号或result的符号
        // 设定最开始的数字的符号是1，数是0
        int result = 0, number = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //用来算这个用字符串表示的数字本身值，高位乘以10的次数就是他所在的位-1，e.g. 756中7乘以10，2次
            if(Character.isDigit(c))
                number = 10 * number + (int)(c - '0');

                // 判断c只是为了确定后面那个数的符号
            else if(c == '+')
            {
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if(c == '-')
            {
                result += sign * number;
                number = 0;
                sign = -1;
            }
            //把前面算出来的值存起来，先放值，再放符号
            else if(c == '(')
            {
                stack.push(result); //括号前算出来的结果
                stack.push(sign); //括号前的符号
                sign = 1;
                result = 0;
            }
            // 取出前面算的值
            else if(c == ')')
            {
                result += sign * number;
                number = 0;
                result *= stack.pop(); //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        // 如果只有一个数，要判断是否为0
        if(number != 0)
            result += sign * number;
        return result;
    }

    public int calculatea(String s) {
        if (s == null || s.length() == 0)
            return 0;

        s = s.replace(" ","");
        Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1, number = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                number = number * 10 + c - '0';
            else
            {
                if(c == '(')
                {
                    stack.push(result);
                    stack.push(sign);
                    sign = 1;
                    result = 0;
                }
                else if(c == ')')
                {
                    result += sign * number;
                    result *= stack.pop();
                    result += stack.pop();
                }
                else
                {
                    result += sign*number;
                    sign = c == '+' ? 1 : -1;
                }
                number = 0;
            }
        }
        result += sign*number;
        return result;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String S = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(solution.calculatea(S));
    }
}