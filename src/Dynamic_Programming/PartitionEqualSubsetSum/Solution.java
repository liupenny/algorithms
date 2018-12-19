package Dynamic_Programming.PartitionEqualSubsetSum;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/19
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int n = nums.length;
        int c = sum/2;

        boolean[] dp = new boolean[c + 1];
        for (int i = 0; i <= c; i++) {
            dp[i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = c; j >= nums[i] ; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[c];
    }
}
