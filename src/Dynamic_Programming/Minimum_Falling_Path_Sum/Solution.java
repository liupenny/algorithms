package Dynamic_Programming.Minimum_Falling_Path_Sum;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/22
 */
public class Solution {
    private int ans = Integer.MAX_VALUE;
    private int sum = 0;

    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            MinSum(A,0, i);
        }
        return ans;
    }

    //返回A[0-n]这些行的最小路径和,sum。
    private void MinSum(int[][] A, int n, int index) {
        if (n == A.length) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = -1; i < 2; i++) {
            if (index + i >= 0 && index + i < A.length) {
                sum += A[n][index];
                MinSum(A,  n+1, index + i);
                sum -= A[n][index];
            } else {
                continue;
            }
        }
        return;
    }

    public static void main(String[] args) {
        // int[][] A =  {{1,2,3},{4,5,6},{7,8,9}};
        int[][] A =  {{-19,57},{-40,-5}};
        Solution s = new Solution();
        System.out.println(s.minFallingPathSum(A));
    }
}
