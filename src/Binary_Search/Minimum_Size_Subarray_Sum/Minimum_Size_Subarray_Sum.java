package Binary_Search.Minimum_Size_Subarray_Sum;

import java.util.Arrays;
import java.util.EventListener;

/**
 * Created by PennyLiu on 2018/1/15.
 * minSubArrayLen1: 自己写的，nlogn的复杂度
 * minSubArrayLen2：复杂度为n,左右指针
 */
public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;   //nums=[]的特殊情况一开始没考虑到
        }
        int[] sum = new int[nums.length + 1];
        int index, ans = Integer.MAX_VALUE;
        sum[0] = 0;
        for (int i=0; i<nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        if(sum[sum.length-1] < s) {
            return 0;
        }
        if(sum[sum.length-1] == s) {
            return nums.length;
        }
        for (int i=0; i<sum.length; i++)
        {
            if (sum[i]-s<0) {
                continue;
            }
            index = Arrays.binarySearch(sum, 0, sum.length, sum[i] - s);
            if(index<0) {
                index = -(index + 1) - 1;
            }
            ans = Math.min(ans, i - index);
        }
        return ans;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int sum = 0, from = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                win = Math.min(win, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }

    public static void main(String[] algs)
    {
        int s = 7;
        //int[] nums = {1,1};
        int[] nums = {1,2,3,4,5};
        Minimum_Size_Subarray_Sum t = new Minimum_Size_Subarray_Sum();
        System.out.println(t.minSubArrayLen2(s,nums));
    }
}
