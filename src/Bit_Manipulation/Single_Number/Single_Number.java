package Bit_Manipulation.Single_Number;

/**
 * Created by PennyLiu on 2017/10/22.
 * 136. Single Number
 * 思路：因为都出现两次，所以异或值=0
 */
public class Single_Number {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i=0; i<nums.length; i++)
            ans ^= nums[i];
        return ans;
    }
}
