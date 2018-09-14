package String.Buddy_Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/7/10.
 */

public class Solution{
    public boolean buddyStrings(String A, String B) {
        // A.B长度不等时，一定是false
        if(A == null || A.length() == 0 || B == null || B.length() == 0 || A.length() != B.length()) {
            return false;
        }

        // 当A和B相等，需要A中包含至少两个相同的元素
       if(A.equals(B))
       {
           Set<Character> s = new HashSet<>();
           for (char c: A.toCharArray()) {
               s.add(c);
           }
           return s.size() < A.length();
       }

        //只有在A,B长度相等 & 有且仅有两个对应位置的元素互为相反才返回true，其他都是false
        // A,B长度一定相等,记录两个不等的字符的位置，还有不等的位置一共多少个，如果大于3个就返回false
        int[] index = new int[2];
        int num = 0;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                if (num == 2) {
                    return false;
                }
                index[num++] = i;
            }
        }

        if(num == 2 && A.charAt(index[0]) == B.charAt(index[1]) && A.charAt(index[1]) == B.charAt(index[0])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.buddyStrings("aa","aa"));
    }
}