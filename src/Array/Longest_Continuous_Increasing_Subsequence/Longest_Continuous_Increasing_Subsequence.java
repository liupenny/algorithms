package Array.Longest_Continuous_Increasing_Subsequence;

/**
 * Created by PennyLiu on 2018/5/17.
 */
public class Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int res = 1, temp = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i] > nums[i-1])
            {
                temp++;
            }
            else
            {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        res = Math.max(res, temp);
        return res;
    }

    // 滑动窗口
    public int findLengthOfLCIS1(int[] nums)
    {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            if (i > 0 && nums[i-1] >= nums[i])    //记录起始位置
                anchor = i;
            ans = Math.max(ans, i - anchor + 1);  //每次更新最大距离
        }
        return ans;
    }

    public static void main(String[] args) {
        Longest_Continuous_Increasing_Subsequence t = new Longest_Continuous_Increasing_Subsequence();
        int[] nums = {1,3,5,4,7};
        int[] nums1 = {2,2,2,2,2};
        int[] nums2 = {1,3,5,7};
        System.out.println(t.findLengthOfLCIS(nums2));
    }
}
