package Dynamic_Programming.Arithmetic_Slices;

/**
 * Created by PennyLiu on 2018/1/25.
 */
public class Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length <3) {
            return 0;
        }

        int[][] dp = new int[A.length][A.length];  //dp[i][j]标明A[i]到A[j]是不是递增序列，是=1，不是=0
        int ans = 0;
        for (int i = 0; i < A.length - 2; i++)
        {
            dp[i][i] = 0;
            dp[i][i+1] = 0;
            for (int j = i + 2; j < A.length; j++)
            {
                if (A[j] - A[j-1] == A[i+1] - A[i] && (j == i + 2 || dp[i][j-1] == 1))
                {
                    dp[i][j] = 1;
                    ans ++;
                }
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices1(int[] A)   //只用一维数组表示，遍历一次
    {
        if(A == null || A.length <3) {
            return 0;
        }

        int[] dp = new int[A.length];
        int res=0;
        for (int i=2; i<A.length; i++)
        {
            if(A[i] - A[i-1] == A[i-1] - A[i-2])  //如果是连续的等差数列，dp[i] = dp[i-1] + 1是算上了所有长度的，如果中间有一个不等就变为0，所以不会错过
            {
                dp[i] = dp[i - 1] + 1;  //dp[i-1]代表以i-1为结尾的等差数列的个数，那加上i位置一定也是等差数列，所以再加上后面三个构成了新的
            }
            res += dp[i];
        }
        return res;
    }



    public static void main(String[] algs)
    {
        Arithmetic_Slices t = new Arithmetic_Slices();
        System.out.println(t.numberOfArithmeticSlices(new int[]{1, 3, 5, 7}));
    }
}
