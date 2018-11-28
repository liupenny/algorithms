package Backtracking.RobotPath;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/27
 */
public class Solution {
    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private int row,col,k;
    private boolean[][] visited;
    public int movingCount(int threshold, int rows, int cols)
    {
        row = rows;
        col = cols;
        k = threshold;
        visited = new boolean[rows][cols];
        int count = maxStep(0,0);
        return count;
    }

    public int maxStep(int x, int y) {
        int count = 0;
        if (check(x,y) == true) {
            count = 1;
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                count += maxStep(newx,newy);
            }
            visited[x][y] = false;
        }
        return count;
    }

    public boolean check(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < col && visited[x][y] == false) {
            int sum = getSum(x) + getSum(y);
            return sum <= k;
        } else {
            return false;
        }
    }

    public int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x%10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(3,3,3));
    }
}