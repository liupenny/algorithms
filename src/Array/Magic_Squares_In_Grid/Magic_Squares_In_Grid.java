package Array.Magic_Squares_In_Grid;

/**
 * Created by PennyLiu on 2018/5/30.
 */
public class Magic_Squares_In_Grid {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if(magic(grid[i][j], grid[i][j+1], grid[i][j+2],
                        grid[i+1][j], grid[i+1][j+1], grid[i+1][j+2],
                        grid[i+2][j], grid[i+2][j+1], grid[i+2][j+2])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean magic (int... vals)
    {
        for (int val:vals)
        {
            if (val > 9 || val < 1) {
                return false;
            }
        }

        int[] count = new int[9];
        for (int val:vals) {
            count[val-1] = 1;
        }
        for (int c:count) {
            if(c != 1) {
                return false;
            }
        }

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);

    }

    public static void main(String[] args) {
        Magic_Squares_In_Grid t = new Magic_Squares_In_Grid();
        int[][] grid = {{4,3,8,4}, {9,5,1,9}, {2,7,6,2}};
        System.out.println(t.numMagicSquaresInside(grid));
    }
}
