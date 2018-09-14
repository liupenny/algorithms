package Dynamic_Programming.Longest_Palindromic_Subsequence;

/**
 * Created by PennyLiu on 2018/1/23.
 */
public class Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i=len-1; i>=0; i--)
        {
            dp[i][i] = 1;
            for (int j=i+1; j<len; j++)
            {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;  //因为这里是从里向外扩，要先知道 i之后的，j之前的  所以循环体外层i从后往前，j从前往后
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len-1];
    }

    public int longestPalindromeSubseq1(String s) {
        int len = s.length(), res=0;
        int[] dp = new int[len];
        for (int i=len-1; i>=0; i--)
        {
           int length = 0;  //本轮计算到i-j的最长子序列
            for (int j=i+1; j<len; j++)
            {
                int t = dp[j];  //上一轮i+1轮中，i+1位置到j位置的最长子序列
                if(s.charAt(i) == s.charAt(j)) //不等的时候对答案没贡献，所以不考虑
                {
                    dp[j] = length + 2;  //j是不断向后移的，所以length记录j之前的最长序列，所以这里可以直接加
                }
                length = Math.max(length,t);  //更新i到j时的最长子序列长度
            }
        }
        for (int num:dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] algs)
    {
        String A="bbbab";
        Longest_Palindromic_Subsequence t = new Longest_Palindromic_Subsequence();
        System.out.println(t.longestPalindromeSubseq1(A));
    }
}
