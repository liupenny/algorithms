package Dynamic_Programming.JumpGame;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/18
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && nums[j] >= i-j){
                    dp[i] = 1;
                }
            }
        }
        return dp[nums.length - 1] == 1;
    }

    public static void main(String[] args) {
        int[] a = {0,0};
        System.out.println(canJump(a));
    }
}
