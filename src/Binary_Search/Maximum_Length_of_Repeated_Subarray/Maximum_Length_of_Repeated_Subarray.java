package Binary_Search.Maximum_Length_of_Repeated_Subarray;

/**
 * Created by PennyLiu on 2017/10/31.
 *
 * findLength：动态规划
 * findLength1: 动态规划的进阶，左老师，根据表达式
 */
public class Maximum_Length_of_Repeated_Subarray {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int max=0;
        int[][] ans = new int[lenA+1][lenB+1];
        for (int i=0; i<=lenA; i++)
            for (int j=0; j<=lenB; j++)
            {
                if(i==0 || j==0)
                    ans[i][j] = 0;
                else
                {
                    if(A[i-1]==B[j-1])
                        ans[i][j] = ans[i-1][j-1] + 1;
                    max = Math.max(max,ans[i][j]);
                }
            }
        return max;
    }

    public int findLength2(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int max=0;
        int[] ans = new int[lenB+1];
        for (int i=1; i<=lenA; i++)
            for (int j=1; j<=lenB; j++)
            {
                    if(A[i-1] == B[j-1])
                        ans[j] = ans[j-1]+1;
                    max = Math.max(max,ans[j]);
            }
        return max;
    }

    public static void main(String[] algs)
    {
       // int[] A = {1,2,3,2,1};
        // int[] B = {3,2,1,4,7};
        int[] A = {1,0,0,0,1};
        int[] B = {1,0,0,1,1};
        Maximum_Length_of_Repeated_Subarray t = new Maximum_Length_of_Repeated_Subarray();
        System.out.println(t.findLength2(A,B));
    }
}
