package Array.Maximum_Product_Subarray;

/**
 * Created by PennyLiu on 2018/5/4.
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxLast = nums[0], minLast = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            // 这么写是错的，因为上一步已经改了maxLast，所以在用一个循环体内部计算minLast的时候会用改过的，所以要向下面1算法中一样声明两个变量
            maxLast = Math.max(nums[i], Math.max(maxLast * nums[i], minLast * nums[i]));
            minLast = Math.min(nums[i], Math.min(maxLast * nums[i], minLast * nums[i]));
            res = Math.max(res, maxLast);
        }
        return res;
    }

    public int maxProduct1(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxAll = nums[0];       //global maximum
        int maxLast = nums[0];      //maximum including last element
        int maxCur;                 //maximum including current element
        int minLast = nums[0];      //minimum including current element
        int minCur;                 //minimum including last element
        for(int i = 1; i < nums.length; i ++)
        {

            maxCur = Math.max(nums[i], Math.max(maxLast*nums[i], minLast*nums[i]));
            minCur = Math.min(nums[i], Math.min(maxLast*nums[i], minLast*nums[i]));
            maxLast = maxCur;
            minLast = minCur;
            maxAll = Math.max(maxAll, maxCur);
        }
        return maxAll;
    }


    public static void main(String[] args)
    {
        Maximum_Product_Subarray t = new Maximum_Product_Subarray();
        int[] nums = {-4,-3,-2};
        System.out.println(t.maxProduct(nums));
    }
}
