package Array.Unique_PathsII;

/**
 * Created by PennyLiu on 2018/5/17.
 */
public class Unique_PathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
//        for (int i = 0; i < row; i++)  //因为如果第一行或第一列有障碍，就不能继续往下走，所以若只有一行或只有一列，就要把这个考虑进去
//        {
//            if(obstacleGrid[i][0] == 0)
//                dp[i][0] = 1;
//        }
//        for (int i = 0; i < col; i++)
//        {
//            if(obstacleGrid[0][i] == 0)
//                dp[0][i] = 1;
//        }

        // 第一行只能从左边过来
        // 第一列只能从上面下来
        // 所以如果这两个一遇到1，后面的就都无法过，直接跳出即可
        for(int i =0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }

        for(int i =0; i < col; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }

        // 从本身的位置去考虑，如果本身自己是0那就直接加上上面，左边能到的路径即可。
        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++)
            {
                if(obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        // 这个考虑有点问题，我是考虑了上面、左边能否到达，却没考虑本身
//        for (int i = 1; i < row; i++)
//        {
//            for (int j = 1; j < col; j++)
//            {
//                 if(obstacleGrid[i][j] != 1)  //所以在这里加这个条件即可
//                {
//                if(obstacleGrid[i-1][j] != 1 && obstacleGrid[i][j-1] != 1)
//                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
//                else if(obstacleGrid[i-1][j] != 1)
//                    dp[i][j] += dp[i-1][j];
//                else if(obstacleGrid[i][j-1] != 1)
//                    dp[i][j] += dp[i][j-1];
//                else
//                    dp[i][j] = 0;
//                  }
//            }
//        }

        return dp[row-1][col-1];
    }

    public static void main(String[] args)
    {
        Unique_PathsII t = new Unique_PathsII();
        int[][] path = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] path1 = {{1,0}};
        System.out.println(t.uniquePathsWithObstacles(path1));
    }

}
