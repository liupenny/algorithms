package array.Max_Area_of_Island;

/**
 * Created by PennyLiu on 2018/4/12.
 */
public class Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int maxlen=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxlen = Math.max(maxlen, AreaOfIsland(grid, i, j));
                }
            }
        }
        return maxlen;
    }

    public int AreaOfIsland(int[][] grid, int i, int j)
    {
        if(i>=0 && i< grid.length && j>=0 && j<grid[0].length && grid[i][j]==1)
        {
            grid[i][j]=0;
            return 1 + AreaOfIsland(grid,i+1, j) + AreaOfIsland(grid,i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }


    public static void main(String[] args)
    {
        int[][] num = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                       {0,0,0,0,0,0,0,1,1,1,0,0,0},
                       {0,1,1,0,1,0,0,0,0,0,0,0,0},
                       {0,1,0,0,1,1,0,0,1,0,1,0,0},
                       {0,1,0,0,1,1,0,0,1,1,1,0,0},
                       {0,0,0,0,0,0,0,0,0,0,1,0,0},
                       {0,0,0,0,0,0,0,1,1,1,0,0,0},
                       {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] num1 = {{0,1},
                        {1,1}};
        Max_Area_of_Island a = new Max_Area_of_Island();
        System.out.println(a.maxAreaOfIsland(num1));
    }
}
