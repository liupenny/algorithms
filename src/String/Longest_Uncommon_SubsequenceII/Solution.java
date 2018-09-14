package String.Longest_Uncommon_SubsequenceII;/**
 * Created by PennyLiu on 2018/7/19.
 */

public class Solution{
    public int findLUSlength(String[] strs) {
        if(strs == null || strs.length == 0) {
            return 0;
        }

        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() < ans) {
                continue;
            }
            int j = 0;
            for (; j < strs.length; j++) {
                if(j == i) {
                    continue;
                }
                if(isSubseq(strs[i], strs[j])) {
                    break;
                }
            }
            if(j == strs.length) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    // 判断a是否是b的子序列
    public boolean isSubseq(String a, String b)
    {
        int ia = 0;
        for (int i = 0; i < b.length() && ia < a.length(); i++) {
            if(a.charAt(ia) == b.charAt(i)) {
                ia++;
            }
        }
        return ia == a.length();
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String[] strings = {"aaa","aaa","aa"};
        System.out.println(s.findLUSlength(strings));
    }

}