package Depth_first_Search.Number_of_Islands;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

/**
 * Created by PennyLiu on 2018/4/12.
 */
public class Number_of_Islands {
    public int numIslands(char[][] grid)
    {
        if(grid == null || grid.length == 0)
            return 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j]=='1')
                {
                    num++;
                    clearIslans(grid, i, j);
                }
            }
        return num;
    }

    public void clearIslans(char[][] grid, int i, int j)
    {
        if(i>=0 && i< grid.length && j>=0 && j<grid[0].length && grid[i][j]=='1')
        {
            grid[i][j]='0';
            clearIslans(grid,i+1, j);
            clearIslans(grid,i-1, j);
            clearIslans(grid, i, j-1);
            clearIslans(grid, i, j+1);
        }
    }



    public static void main(String[] args)
    {
        char[][] num = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','1'}};
        // char[][] num1 = {{0,1},
        //        {1,1}};
        Number_of_Islands a = new Number_of_Islands();
        System.out.println(a.numIslands(num));
        //a.test();
    }
}
