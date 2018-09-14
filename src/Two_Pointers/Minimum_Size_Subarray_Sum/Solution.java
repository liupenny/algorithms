package Two_Pointers.Minimum_Size_Subarray_Sum;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/7/10.
 */

public class Solution{
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0 || s == 0) {
            return 0;
        }

        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i - 1];
        }

        if(sum[sum.length-1] < s) {
            return 0;
        }
        if(sum[sum.length-1] == s) {
            return nums.length;
        }

        int res = Integer.MAX_VALUE, tmpSum = 0;
        for (int i = 0; i < sum.length; i++) {
            tmpSum = sum[i];
            int target = Arrays.binarySearch(sum, i, sum.length, tmpSum + s);
            if(target < 0)
            {
                if(target == - sum.length - 1) {
                    continue;
                } else {
                    target = -target - 1;
                }
            }
            res = Math.min(res, target - i);
        }
        return res;
    }


    public int minSubArrayLen_pointer(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s)
            {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++];
            }
        }
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

    public static void main(String[] args)
    {
        Solution a = new Solution();
        int s = 4;
        int[] nums = {1,4,4};
        //System.out.println(a.minSubArrayLen(s,nums));
        System.out.println(a.minSubArrayLen_pointer(s,nums));
    }
}