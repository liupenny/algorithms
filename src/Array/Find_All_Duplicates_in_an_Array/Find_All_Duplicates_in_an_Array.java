package Array.Find_All_Duplicates_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/2.
 */
public class Find_All_Duplicates_in_an_Array
{
    public List<Integer> findDuplicates(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        for (int i = 0; i < nums.length; i++)
        {
            int correctPos = Math.abs(nums[i]) - 1;
            if(nums[correctPos]< 0) {
                ans.add(correctPos + 1);
            } else {
                nums[correctPos] = -nums[correctPos];
            }
        }
        return ans;
    }

    public List<Integer> findDuplicates1(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        for (int i = 0; i < nums.length;)
        {
            if(nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != i+1) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int i, int j)
    {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args)
    {
        Find_All_Duplicates_in_an_Array t = new Find_All_Duplicates_in_an_Array();
        int[] nums = {4,3,2,7,8,2,3,1};
        t.findDuplicates(nums);
    }
}
