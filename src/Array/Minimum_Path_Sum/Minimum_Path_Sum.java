package Array.Minimum_Path_Sum;

/**
 * Created by PennyLiu on 2018/5/17.
 */
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid)
    {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++)
        {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++)
        {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
            {
                dp[i][j] = Math.min(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j]);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        Minimum_Path_Sum t = new Minimum_Path_Sum();
        int[][] path = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] path1 = {{0,1},{1,0}};
        System.out.println(t.minPathSum(path1));
    }
}
