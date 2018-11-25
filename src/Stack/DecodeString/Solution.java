package Stack.DecodeString;

import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/25
 */
// 递归的方法，之所以加上k是因为，要让整个字符串都遍历一遍。不然遇到]直接return了。
public class Solution {
    int i = 0;
    public String decodeString(String s) {
        return dfs(s,0);
    }

    public String dfs(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int times = 1;
        int N = s.length();
        while (i < N ) {
            if (s.charAt(i) == '[') {
                i++;
                String tmp = dfs(s,i);
                for (int j = 0; j < times; j++) {
                    ans.append(tmp);
                }
                times = 1;
            } else if (Character.isDigit(s.charAt(i))){
                int start = i;
                while (i < N && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                times = Integer.parseInt(s.substring(start,i));
            } else if(s.charAt(i) == ']') {
                i++;
                return new String(ans);
            } else {
                while (i < N && Character.isLetter(s.charAt(i))) {
                    ans.append(s.charAt(i));
                    i++;
                }
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        SolutionStack s = new SolutionStack();
        System.out.println(s.decodeString("3[a]2[b4[F]c]"));
    }
}

// 用栈，每统计出数字和字符串就放入对应的栈里面。
// 遇到]的时候，拿出最顶部的字符串和数字，连起来。
class SolutionStack {
    public String decodeString(String s) {
        String ans = "";
        Stack<Integer> times = new Stack<>();
        Stack<String> item = new Stack<>();
        int idx = 0;
        int N = s.length();

        while (idx < N) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                times.push(count);
            } else if (s.charAt(idx) == '[') {
                item.push(ans);
                ans = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder tmp = new StringBuilder(item.pop());
                // ans是[]内乘以前面数字的结果，把上一轮的取出来，直接加在后面。
                int count = times.pop();
                for (int i = 0; i < count; i++) {
                    tmp.append(ans);
                }
                ans = tmp.toString();
                idx++;
            } else {
                ans += s.charAt(idx++);
            }
        }
        return ans;
    }
}
