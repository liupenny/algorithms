package array.arraypartitionI;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/4/12.
 */
public class arraypartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        array.arraypartitionI.arraypartitionI a = new array.arraypartitionI.arraypartitionI();
        System.out.println(a.arrayPairSum(test));
    }
}
