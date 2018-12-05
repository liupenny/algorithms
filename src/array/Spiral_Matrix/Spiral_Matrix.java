package array.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return ans;
        }

        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int row1 = 0, col1 = 0, row2 = matrix.length - 1, col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int c = col1; c <= col2; c++) {
                ans.add(matrix[row1][c]);
            }
            for (int r = row1 + 1; r <= row2; r++) {
                ans.add(matrix[r][col2]);
            }
            //if (row1 < row2 && col1 < col2) {
                for (int c = col2 - 1; c > col1; c--) {
                    ans.add(matrix[row2][c]);
                }
                for (int r = row2; r > row1; r--) {
                    ans.add(matrix[r][col1]);
                }
            //}
            row1++;
            col1++;
            row2--;
            col2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Spiral_Matrix t = new Spiral_Matrix();
        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        int[][] matrix = {{1},{2},{3},{4}};
        System.out.println(t.printMatrix(matrix));
    }

}
