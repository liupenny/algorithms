package Dynamic_Programming.MaxValueOfGift;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class Solution {
    public static int maxValue(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public static int maxValue1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        // 存放着：这一行的左边f(i,0)...f(i,j-1) + 这一行的上面到末尾f(i-1,j)...f(i-1,n-1)
        int[] dp = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int left = 0, up = 0;
                if (i > 0) {
                    up = dp[j];
                }
                if (j > 0) {
                    left = dp[j-1];
                }
                dp[j] = Math.max(up,left) + matrix[i][j];
            }
        }
        return dp[col-1];
    }

        public static void main(String[] args) {
        int[][] matrix = {{1,10,3,8}
                         ,{12,2,9,6}
                         ,{5,7,4,11}
                         ,{3,7,16,5}};
        System.out.println(maxValue1(matrix));
    }
}
