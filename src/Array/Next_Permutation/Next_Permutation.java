package Array.Next_Permutation;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by PennyLiu on 2018/5/12.
 */
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i+1] <= nums[i])
        {
            i--;
        }

        if(i >= 0)
        {
            int j = nums.length - 1;
            while (j >=0 && nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums,i+1);
    }

    public void reverse(int[] nums, int start)
    {
        int i = start, j = nums.length - 1;
        while (i < j)
        {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Next_Permutation t = new Next_Permutation();
        int[] nums = {1,2,3};
        t.nextPermutation(nums);
    }
}
