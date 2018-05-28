package Dynamic_Programming.Longest_Increasing_Subsequence;

/**
 * Created by PennyLiu on 2018/5/23.
 */
public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int len = 0;
        for (int num: nums)
        {
            int i = 0, j = len;
            while (i != j)
            {
                int mid = (i + j)/2;
                if( dp[mid] < num)
                    i = mid + 1;
                else
                    j = mid;
            }
            dp[i] = num;
            if(i == len)
                ++len;
        }
        return len;
    }

    public int lengthOfLIS1(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int len = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            int temp = 0;
            for (int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                    temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    public static void main(String[] args) {
        Longest_Increasing_Subsequence t = new Longest_Increasing_Subsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(t.lengthOfLIS(nums));
    }
}
