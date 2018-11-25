package array.Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/2.
 */
public class Find_All_Numbers_Disappeared_in_an_Array
{
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        for (int i = 0; i < nums.length;)
        {
            if(nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i] - 1);
            } else  //这里不能把i++写在上面，因为换完以后i位置本身的数可能还要进行调整。（双指针）
            {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != i+1) {
                ans.add(i + 1);
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
        int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums1 = {1,2,3};
        Find_All_Numbers_Disappeared_in_an_Array t = new Find_All_Numbers_Disappeared_in_an_Array();
        System.out.println(t.findDisappearedNumbers(nums));
    }
}
