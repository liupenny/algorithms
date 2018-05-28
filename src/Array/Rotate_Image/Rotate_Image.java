package Array.Rotate_Image;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int n = matrix.length;
        for (int x = 0; x < (n+1)/2; x++) //走几圈
        {
            for (int y = x; y < n - 1 - x; y++) {  //每圈到从左上角开始，到右上角结束
                int m = matrix[x][y];
                matrix[x][y] = matrix[n - 1 - y][x];
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];
                matrix[y][n - 1 - x] = m;
            }
        }
    }

    public void rotate1(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return;

        for (int i = 0; i < matrix.length; i++) //先沿着对角线交换
        {
            for (int j = i; j < matrix.length; j++)
            {
                int m = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = m;
            }
        }

        for (int i = 0; i < matrix.length; i++)  //再沿着中线，左右交换
        {
            for (int j = 0; j < matrix.length/2; j++) {
                int m = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = m;
            }
        }
    }

    public static void main(String[] args) {
        Rotate_Image t = new Rotate_Image();
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        t.rotate(matrix);
        // System.out.println(t.rotate(matrix));
    }
}
