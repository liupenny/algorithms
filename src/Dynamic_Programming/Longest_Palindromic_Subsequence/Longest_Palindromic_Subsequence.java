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
            dp[i][i] = 0;
            for (int j=i+1; j<len; j++)
            {
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;  //因为这里是从里向外扩，要先知道 i之后的，j之前的  所以循环体外层i从后往前，j从前往后
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }

//    public int longestPalindromeSubseq1(String s) {
//        int len = s.length();
//        int[] dp = new int[len];
//        for ()
//    }

    public static void main(String[] algs)
    {
        String A="bbbcb";
        Longest_Palindromic_Subsequence t = new Longest_Palindromic_Subsequence();
        System.out.println(t.longestPalindromeSubseq(A));
    }
}
