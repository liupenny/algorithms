package Dynamic_Programming.Combination_SumIV;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/11.
 */
public class Combination_SumIV {
    public int combinationSum4(int[] nums, int target)
    {
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums); //如果target远大于nums数组的个数的话，先排序，
        for (int i = 1; i <= target; i++)
        {
            for (int num:nums)
            {
                if(i < num) //然后从1遍历到target，对于i小于数组中的数字x时，我们直接break掉，因为后面的数更大，节省了一些遍历
                {
                    break;
                }
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Combination_SumIV t = new Combination_SumIV();
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(t.combinationSum4(nums, target));
    }
}
