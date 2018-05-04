package Array.Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/4.
 */
public class Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return 0;

        int res = 1;
        if(nums.length <= 3)
        {
            for (int num:nums)
            {
                res *= num;
            }
            return res;
        }

        Arrays.sort(nums);
        // 最大的数小于0，全是负数
        if( nums[nums.length - 1] <= 0)
            return nums[0]*nums[1]*nums[2];
        // 有正有负
        else
        {
            int maxEnd = 0, maxHead = 0;
            // 最小的两个数都是负数
            if (nums[0] < 0 && nums[1] < 0)
                maxEnd = nums[0] * nums[1];
            // 最大的后面两个都是正数
            if(nums[nums.length - 2] > 0 && nums[nums.length - 3] > 0)
                maxHead = nums[nums.length - 2] * nums[nums.length - 3];
            return Math.max(maxEnd, maxHead) * nums[nums.length - 1];
        }
    }

    public static void main(String[] args)
    {
        Maximum_Product_of_Three_Numbers t = new Maximum_Product_of_Three_Numbers();
        int[] nums = {1,2,3,4};
        int[] nums1 = {-710,-107,-851,657,-14,-859,278,-182,-749,718,-640,127,-930,-462,
                694,969,143,309,904,-651,160,451,-159,-316,844,-60,611,-169,-73,721,-902,
                338,-20,-890,-819,-644,107,404,150,-219,459,-324,-385,-118,-307,993,202,
                -147,62,-94,-976,-329,689,870,532,-686,371,-850,-186,87,878,989,-822,-350,
                -948,-412,161,-88,-509,836,-207,-60,771,516,-287,-366,-512,509,904,-459,683,
                -563,-766,-837,-333,93,893,303,908,532,-206,990,280,826,-13,115,-732,525,
                -939,-787};
        System.out.println(t.maximumProduct(nums1));
    }
}
