package Dynamic_Programming.WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: dp[i]表示i之前的s[0,i)符合题意。dp[i] = dp[j](j属于[0,i) && set.contains(s[j,i))). 注意都是[)区间，符合s.substring[)的规律，dp长度为n+1
 * @date 2018/12/7
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        Solution a = new Solution();
        System.out.println(a.wordBreak(s,wordDict));
    }
}
