package Bit_Manipulation.Single_Number_II;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Single_Number_II {
    public int singleNumber(int[] nums) {
        int res = 0, sum;
        for (int i = 0; i < 32; i++)
        {
            sum = 0;
            for (int j = 0; j < nums.length; j++)
            {
                sum += (nums[j]>>i) & 1;
            }
            res |= (sum%3)<<i;
        }
        return res;
    }

    public int singleNumbe1(int[] nums)
    {
        int low=0, high=0;
        for (int i=0; i < nums.length; i++)
        {
            low = (low ^ nums[i]) & ~high;
            high = (high ^ nums[i]) & ~low;
        }
        return high;
    }

    public static void main(String[] args) {
        Single_Number_II t = new Single_Number_II();
        System.out.println(t.singleNumber(new int[]{2,2,2,5}));
    }
}
