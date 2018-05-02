package Array.First_Missing_Positive;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/2.
 */
public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 1;

        int ans = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] == ans)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        First_Missing_Positive t = new First_Missing_Positive();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.print(t.firstMissingPositive(nums));
    }

}
