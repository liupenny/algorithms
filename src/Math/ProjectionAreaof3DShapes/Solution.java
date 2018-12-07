package Math.ProjectionAreaof3DShapes;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: 从上面看：整个矩阵中不为0的数的个数。从yz角度看：每一行最大值。从xz角度看：每一列最大值
 * @date 2018/12/7
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    res += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int rowMax = 0;
            for (int j = 0; j < m; j++) {
                rowMax = Math.max(rowMax, grid[i][j]);
            }
            res += rowMax;
        }

        for (int j = 0; j < m; j++) {
            int colMax = 0;
            for (int i = 0; i < n; i++) {
                colMax = Math.max(colMax, grid[i][j]);
            }
            res += colMax;
        }
        return res;
    }
}
