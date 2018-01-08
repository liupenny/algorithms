package Binary_Search.Search_a_2D_Matrix_II;

/**
 * Created by PennyLiu on 2017/10/22.
 * 240. Search a 2D Matrix II
 * 思路：如果矩阵右上角的值比target大，那那一列都不符合，删除所在的列，列号-1，在剩下的元素中继续找；如果矩阵右上角的值不大于target，那一行都不符合，删除所在的行，行号+1，在剩下的元素中继续找，找到相等的元素就退出.
 */
public class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int row = matrix.length-1, column = matrix[0].length-1;
        for (int i=0, j=column; i<=row && j>=0;)
        {
            if(target==matrix[i][j])  return true;
            else if(target>matrix[i][j]) i++;
            else if(target<matrix[i][j]) j--;
        }
        return false;
    }

    public static void main(String[] algs)
    {
        int[][] matrix = {{1,   4,  7, 11, 15},
                          {2,   5,  8, 12, 19},
                          {3,   6,  9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
//        int sum = matrix[0].length;
//        System.out.println(sum);
        Search_a_2D_Matrix_II t = new Search_a_2D_Matrix_II();
        boolean ans = t.searchMatrix(matrix,11);
        System.out.println(ans);
    }

}
