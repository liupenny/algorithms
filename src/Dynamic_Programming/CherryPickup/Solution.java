package Dynamic_Programming.CherryPickup;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/17
 */
public class Solution {
    public static int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // M是步数t的最大值
        int N = grid.length, M = (N << 1) - 1;
        int[][] dp = new int[N][N];
        dp[0][0] = grid[0][0];
        int tmp = 0;

        for (int i = 1; i < N; i++) {
            if (grid[0][i] == -1) {
                dp[0][i] = -1;
            } else {
                dp[0][i] = grid[0][i] + dp[0][i-1];
            }
        }

        for (int i = 1; i < N; i++) {
            if (grid[i][0] == -1) {
                dp[i][0] = -1;
            } else {
                dp[i][0] = grid[i][0] + dp[i-1][0];
            }
        }
        for (int t = 2; t < N; t++) {
            for (int r1 = 1; r1 < N; r1++) {
                for (int r2 = 1; r2 < N; r2++) {
                    int c1 = t - r1, c2 = t - r2;
                    if (c1 < 0 || c1 >= N || c2 < 0 || c2 >= N) {
                        dp[r1][r2] = -1;
                        continue;
                    }
                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        dp[r1][r2] = -1;
                        continue;
                    }
                    if (r1 == r2) {
                        tmp += grid[r1][c1];
                    } else {
                        tmp += (grid[r1][c1] + grid[r2][c2]);
                    }
                    dp[r1][r2] = Math.max(Math.max(dp[r1-1][r2],dp[r1][r2-1]), Math.max(dp[r1][r2],dp[r1-1][r2-1])) + tmp;
                }
            }
        }
        return Math.max(dp[N-1][N-1],0);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, -1},
                        {1, 0, -1},
                        {1, 1, 1}};
        System.out.println(cherryPickup(grid));
    }
}
