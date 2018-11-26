package Dynamic_Programming.Minimum_Falling_Path_Sum;

import java.util.Map;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/22
 */
public class Solution {
    private Integer[][] dp;

    // dp[i][j]表示A[i][j]到底部的最小值
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            dp[n-1][i] = A[n-1][i];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = A[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
                if (j == n-1) {
                    dp[i][j] = A[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                }
                dp[i][j] = A[i][j] + Math.min(Math.min(dp[i + 1][j - 1], dp[i + 1][j]), dp[i+1][j + 1]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x:dp[0]) {
            ans = Math.min(ans,x);
        }

        return ans;
    }



    public static void main(String[] args) {
        // int[][] A =  {{1,2,3},{4,5,6},{7,8,9}};
        int[][] A =  {{-19,57},{-40,-5}};
        Solution s = new Solution();
        System.out.println(s.minFallingPathSum(A));
    }
}
