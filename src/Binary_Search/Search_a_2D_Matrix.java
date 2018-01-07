package Binary_Search;

/**
 * Created by PennyLiu on 2017/10/22.
 * 74. Search a 2D Matrix
 */
public class Search_a_2D_Matrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int column = matrix.length-1,row = matrix[0].length-1;  //列数
        int lo = 0, hi = column, mid, tmprow;
        while (lo<hi)
        {
            mid = lo + (hi-lo)/2;
            if (target > matrix[mid][row]) lo = mid + 1;
            else if (target < matrix[mid][0]) hi = mid - 1;
            else if (target >= matrix[mid][0] && target <= matrix[mid][row])  //找到指定的那一行
            {
                lo = mid;
                break;
            }
        }
        tmprow = lo; lo=0; hi = row;
        while (lo <= hi)
        {
            mid = lo + (hi-lo)/2;
            if (target > matrix[tmprow][mid]) lo = mid + 1;
            else if (target < matrix[tmprow][mid]) hi = mid - 1;
            else if (target == matrix[tmprow][mid]) return true;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {  //这个很好
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {  //直接把二维数组当做一维数组做
        if (matrix.length==0) return false;
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];

            if( mid_value == target){
                return true;

            }else if(mid_value < target){
                //Should move a bit further, otherwise dead loop.
                begin = mid+1;
            }else{
                end = mid-1;
            }
        }

        return false;
    }

    public static void main(String[] algs)
    {
        int[][] matrix = {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}};
//        int sum = matrix[0].length;
//        System.out.println(sum);
        Search_a_2D_Matrix t = new Search_a_2D_Matrix();
        boolean ans = t.searchMatrix1(matrix,11);
        System.out.println(ans);
    }
}
