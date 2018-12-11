package array.Maximum_Subarray;

/**
 * Created by PennyLiu on 2018/5/4.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < nums.length; i++)
        {
            cur += nums[i];
            max = Math.max(max, cur);  //先计算出最大值
            if (cur <= 0)  //再进行当前最大值的修改
            {
                cur = 0;
            }
        }
        return max;
    }

    public int maxSubArraydp(int[] nums){
        int res = 0, cur = 0;
        if (nums == null || nums.length <= 0) {
            return res;
        }

        for (int i = 0; i < nums.length - 1; i++) {
           if (i == 0 || cur <= 0) {
               cur = nums[i];
           } else if (i != 0 && cur > 0) {
               cur += nums[i];
               res = Math.max(res,cur);
           }
        }
        return res;
    }

    public static void main(String[] args)
    {
        Maximum_Subarray t = new Maximum_Subarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(t.maxSubArray(nums));
        System.out.println(t.maxSubArraydp(nums));
    }
}
