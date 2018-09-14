package Hash_table.Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/7/29.
 */

public class Solution{
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return ans;
        }

        int[] vp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            vp[p.charAt(i) - 'a']++;
        }

        int count = p.length(), left = 0, right = 0;
        while (right < s.length()) {
            // 每遇到一个字母，其个数都要--，
            // 注意 --操作是在比较玩后发生，所以>=1判断的是减之前的值
            // 如果这个字母的个数减之前 >= 1，而count是来判断总共需要的字母个数，count++
            if(vp[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }

            if(count == 0) {
                ans.add(left);
            }
            // 窗口元素不够p.length，但已经遇到了不在p中的字符也不管,窗口加到元素满了以后再从左边减
            // 左边元素不出现在p中时，count不变，
            // 只有左边元素个数加之后>0,则证明需要被满足，才会count++
            if(right - left == p.length() && ++vp[s.charAt(left++) - 'a'] > 0) {
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        //String a = "abab", p = "ab";
        String a ="ecbaeee" , p= "abc";
        System.out.println(s.findAnagrams(a,p));
    }
}