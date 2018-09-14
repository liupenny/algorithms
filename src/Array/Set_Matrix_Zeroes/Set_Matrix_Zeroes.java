package Array.Set_Matrix_Zeroes;

/**
 * Created by PennyLiu on 2018/6/1.
 */
public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int[] row = new int[matrix.length], col = new int[matrix[0].length]; //记录一下要变为0的行和列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if(row[i] == 1)
            {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if(col[i] == 1)
            {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes1(int[][] matrix) { //更节省空间的做法，直接将要变为0的那一行的首位设置0，要变成0的那一列的首位设置成0。
        if (matrix == null || matrix.length == 0) //但是第一行和第一列的0会冲突，所以原来位置保存第一行的状态，用一个变量保存第一列是否为0
        {
            return;
        }

        int row = matrix.length, col = matrix[0].length, col0 = 1;
        for (int i = 0; i < row; i++) { //一次遍历就解决行，列两个问题
            if(matrix[i][0] == 0) //用变量保存第一列是否为0
            {
                col0 = 0;
            }
            for (int j = 1; j < col; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

//        for (int i = 0; i < row; i++) {  //不能从前往后改，否则改了一个是0的，其他都要改了
//            for (int j = 1; j < col; j++) {
//                if(matrix[i][0] == 0 || matrix[0][j] == 0)
//                    matrix[i][j] = 0;
//                if(col0 == 0)
//                    matrix[i][0] = 0;
//            }
//        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Set_Matrix_Zeroes t = new Set_Matrix_Zeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix1 = {{-1},{2},{3}};
        t.setZeroes1(matrix);
    }
}
