package Dynamic_Programming.House_Robber;

/**
 * Created by PennyLiu on 2018/5/4.
 */
public class House_Robber {
    public int rob(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            if(i == 0) {
                dp[i] = nums[i];
            } else if(i == 1) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[nums.length - 1] > dp[nums.length - 2] ? dp[nums.length - 1] : dp[nums.length - 2];
    }

    public static void main(String[] args)
    {
        House_Robber t = new House_Robber();
        int[] nums = {1,2,3,1};
        System.out.println(t.rob(nums));
    }
}
