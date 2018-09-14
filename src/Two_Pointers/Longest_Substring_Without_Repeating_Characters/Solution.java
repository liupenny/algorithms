package Two_Pointers.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/7/29.
 */

public class Solution{
    // 滑动窗口，遇到重复的之后，左边一直移到重复字母之后即可
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int ans = 0, left = 0, right = 0;
        while (left < s.length() && right < s.length()){
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right++));
                ans = Math.max(ans, right - left);
            }
            else {
                set.remove(left++);
            }
        }
        return ans;
    }

    /*
    int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    int[128] for ASCII
    int[256] for Extended ASCII
     */
    //记录下每个字母位置，遇到重复的，直接Left移到重复的之后，不用一个一个移了
    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0, n = s.length();
        int[] index = new int[128];
        for (int right = 0, left = 0; right < n ; right++) {
            left = Math.max(index[s.charAt(right)], left);
            ans = Math.max(ans, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String a = "p";
        // System.out.println(s.reorganizeString(a));
        // System.out.println(s.reorganizeString_sort(a));
        // s.isPalindrome1(a);
        System.out.println(s.lengthOfLongestSubstring(a));
    }
}