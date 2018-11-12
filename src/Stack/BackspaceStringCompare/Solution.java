package Stack.BackspaceStringCompare;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/10/25
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String s) {
        Stack<Character> ans = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c != '#') {
                ans.push(c);
            } else if (!ans.isEmpty()) {
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        String s = getString(S);
        String t = getString(T);
        return s.equals(t);
    }

    private String getString(String s) {
        StringBuilder str = new StringBuilder();
        char[] c = s.toCharArray();
        for (char ch : c) {
            if (ch == '#') {
                if ( str.length() != 0) {
                    str.deleteCharAt(str.length() - 1);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}

class Solution2 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        // While there may be chars in build(S) or build (T)
        while (i >= 0 || j >= 0) {
            // Find position of next possible char in build(S)
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Find position of next possible char in build(T)
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 a = new Solution2();
        System.out.println(a.backspaceCompare( "ab#c", "ad#c"));
        ArrayList<Integer> a1 = new ArrayList<>();
    }
}