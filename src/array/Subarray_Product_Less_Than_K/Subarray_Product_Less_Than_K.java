package array.Subarray_Product_Less_Than_K;

/**
 * Created by PennyLiu on 2018/5/9.
 */
public class Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 1;
            for (int j = i; j < nums.length; j++)
            {
                sum *= nums[j];
                if(sum < k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++]; //除完，left自动增加
            }
            ans += right - left + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        Subarray_Product_Less_Than_K t = new Subarray_Product_Less_Than_K();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(t.numSubarrayProductLessThanK1(nums,k));
    }
}
