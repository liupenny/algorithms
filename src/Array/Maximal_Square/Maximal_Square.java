package Array.Maximal_Square;

import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/8.
 */
public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int ans = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;  //每一行累加起来，算此时的连续的高度
            }
            ans = Math.max(ans, area(height));
        }
        return ans;
    }

    public int area(int[] heights)
    {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
            {
                int center = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int len = Math.min(heights[center], i - left - 1);  //选出两条边中较小的一边
                maxArea = Math.max(maxArea, len * len);
            }
            stack.push(i);
        }
        while (!stack.isEmpty())
        {
            int center = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int len = Math.min(heights[center], heights.length - left - 1);  //选出两条边中较小的一边
            maxArea = Math.max(maxArea, len * len);
        }
        return maxArea;
    }

    public int maximalSquare_brute(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int maxlen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == '1')
                {
                    int sqlen = 1;  //正方形边长
                    boolean isSquare = true;
                    while (sqlen + i < rows && sqlen + j < cols && isSquare)
                    {
                        for (int k = j; k < sqlen + j; k++) {
                            if(matrix[i + sqlen][k] == '0')
                            {
                                isSquare = false;
                                break;
                            }
                        }
                        for (int k = i; k < sqlen + i; k++) {
                            if(matrix[k][j + sqlen] == '0')
                            {
                                isSquare = false;
                                break;
                            }
                        }
                        if(isSquare) {
                            sqlen++;
                        }
                    }
                    if (maxlen < sqlen) {
                        maxlen = sqlen;
                    }
                }
            }
        }
        return maxlen * maxlen;
    }

    public int maximalSquare_dp(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int maxlen = 0;

        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {  //因为后面算dp的时候有-1，所以从1，1位置开始
                if(matrix[i-1][j-1] == '1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                }
            }
        }

        return maxlen * maxlen;
    }

    public int maximalSquare_betterdp(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int maxlen = 0, prev = 0;
        int[] dp = new int[cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int tmp = dp[j];
                if(matrix[i-1][j-1] == '1')
                {
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                    maxlen = Math.max(maxlen, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return maxlen * maxlen;
    }

    public static void main(String[] args) {
        Maximal_Square t = new Maximal_Square();
        char[][] matrix= {
                {'1','0','1','0','0'},
                {'1','0','0','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(t.maximalSquare(matrix));
    }
}
