package array.Product_of_Array_Except_Self;

/**
 * Created by PennyLiu on 2018/5/4.
 */
public class Product_of_Array_Except_Self
{
    public int[] productExceptSelf(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length];
        res[0] = 1;
        int prod = 1;

        for (int i = 1; i < nums.length; i++)
        {
            prod *= nums[i-1];
            res[i] = prod;
        }

        prod = 1;
        for (int i = nums.length - 2; i >= 0 ; i--)
        {
            prod *= nums[i+1];
            res[i] *= prod;
        }
        return res;
    }

    public static void main(String[] args)
    {
        Product_of_Array_Except_Self t = new Product_of_Array_Except_Self();
        int[] nums = {1,2,3,4};
        System.out.println(t.productExceptSelf(nums));
    }
}
