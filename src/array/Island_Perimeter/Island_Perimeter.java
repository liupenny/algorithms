package array.Island_Perimeter;

/**
 * Created by PennyLiu on 2018/4/18.
 */
public class Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int perim = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perim += 4;
                    if ((j + 1) < grid[0].length && grid[i][j + 1] == 1) {
                        perim -= 2;
                    }
                    if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
                        perim -= 2;
                    }
                }
            }
        }
        return perim;
    }

    public static void main(String[] args)
    {
        int[][] num = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        // char[][] num1 = {{0,1},
        //        {1,1}};
        Island_Perimeter a = new Island_Perimeter();
        System.out.println(a.islandPerimeter(num));
        //a.islandPerimeter(num);
    }
}
