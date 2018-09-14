package Array.Reshape_the_Matrix;

public class Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c != nums.length*nums[0].length) {
            return nums;
        }

        int[][] ans = new int[r][c];
        int row = nums.length;
        int col = nums[0].length;
        for (int i = 0; i < row*col; i++)
        {
            ans[i/c][i%c] = nums[i/col][i%col];
        }
        return ans;
    }

    public static void main(String[] args) {
        Reshape_the_Matrix t = new Reshape_the_Matrix();
        System.out.println(t.matrixReshape(new int[][]{{1,2},{3,4}}, 1,  4));
    }
}
