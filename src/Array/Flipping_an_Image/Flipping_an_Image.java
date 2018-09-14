package Array.Flipping_an_Image;

/**
 * Created by PennyLiu on 2018/5/15.
 */
public class Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A)
    {

        if(A == null || A.length == 0) {
            return new int[0][0];
        }

        int row = A.length, col = A[0].length;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j <= col/2-1; j++)
            {
                swap(A[i],j,col - j - 1);
            }
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                A[i][j] = A[i][j]==0 ? 1 : 0;
            }
        }

//        for (int i = 0; i < row; i++)
//        {
//            for (int j = 0; j < col; j++)
//            {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
        return A;
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Flipping_an_Image t = new Flipping_an_Image();
        int[][] input = {{1,1,0},{1,0,1},{0,0,0},{0,1,1}};
        t.flipAndInvertImage(input);
    }
}
