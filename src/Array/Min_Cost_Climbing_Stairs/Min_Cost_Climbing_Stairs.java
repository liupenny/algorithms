package Array.Min_Cost_Climbing_Stairs;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i-1] + cost[i - 1]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs t = new Min_Cost_Climbing_Stairs();
        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(t.minCostClimbingStairs(nums));
    }
}
