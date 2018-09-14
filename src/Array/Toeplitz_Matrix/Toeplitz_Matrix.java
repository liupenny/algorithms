package Array.Toeplitz_Matrix;

// 每个数(i,j)只要和（i+1,j+1）比就行
public class Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length - 1; i++)
        {
            for (int j = 0; j < matrix[0].length - 1; j++)
            {
                if(matrix[i][j] != matrix[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Toeplitz_Matrix t = new Toeplitz_Matrix();
        System.out.println(t.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
    }
}
