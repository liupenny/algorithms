package BFS.Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/9/10.
 */

public class Solution{
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;

        for (char ch:s.toCharArray()) {
            if (ch == '(') {
                l++;
            } else if (ch == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }

        List<String> ans = new ArrayList<>();
        dfs(s,0,l,r,ans);
        return ans;
    }

    public boolean isValid(String s){
        int count = 0;
        for (char ch:s.toCharArray()) {
            if(ch == '(') {
                count++;
            }
            if(ch == ')') {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return count==0;
    }

    public void dfs(String s, int start, int l, int r, List<String> ans){
        if(l == 0 && r == 0){
            if(isValid(s)) {
                ans.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(i != start && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                // 先考虑删除右括号，再考虑左括号
                if(r > 0 && s.charAt(i) == ')') {
                    dfs(sb.toString(), i, l, r - 1, ans);
                } else if(l > 0 && s.charAt(i) == '(') {
                    dfs(sb.toString(), i, l - 1, r, ans);
                }
            }
        }
    }

    public static void main(String[] args){
    
    }
}

class Solution1 {
    int index = 1;
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0, numClosedParen = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == openParen) {
                numOpenParen++;
            }
            if (s.charAt(i) == closedParen) {
                numClosedParen++;
            }
            if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)) {
                        // System.out.println("s: " + s);
                        // System.out.println(index++);
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                    }
                }
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        // System.out.println("s: " + s);
        String reversed = new StringBuilder(s).reverse().toString();
        // System.out.println("reversed: " + reversed);
        if (openParen == '('){
            // System.out.println(index++);
            removeHelper(reversed, output, 0, 0, ')','(');
        }
        else {
            // System.out.println("result: "+reversed);
            output.add(reversed);
        }

    }
}