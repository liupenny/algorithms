package String.Valid_PalindromeII;/**
 * Created by PennyLiu on 2018/7/18.
 */

public class Solution{
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        int left = -1, right = s.length();
        // 涉及到当字符串长度是奇数，比较到最中间的时候left=right，此时应该返回true
        while (++left < --right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return (check(s,left + 1,right) == true || check(s, left, right - 1) == true);
            }
        }
        return true;
    }

    //检查s[begin,end](闭区间)是否是回文的
    public boolean check(String s, int begin, int end)
    {
        while (begin < end){
            //比较当前值，并自动加减位置。
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String a = "abc";
        // System.out.println(s.reorganizeString(a));
        // System.out.println(s.reorganizeString_sort(a));
        System.out.println(s.validPalindrome(a));
    }
}