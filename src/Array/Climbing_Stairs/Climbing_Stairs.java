package Array.Climbing_Stairs;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Climbing_Stairs {
    //动态规划
    public int climbStairs(int n) {
        if(n <= 0)
            return 0;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[n] = dp[n-1] + dp[n-2];
        }
        return dp[n];
    }

    //斐波那契数
    public int climbStairs_Fibonacci_Number(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    //斐波那契公式
    public int climbStairs_Fibonacci_Formula(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String[] args) {
        Climbing_Stairs t = new Climbing_Stairs();
        int n = 2;
        System.out.println(t.climbStairs(n));
    }
}
