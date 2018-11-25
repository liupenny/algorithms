package array.Remove_Duplicates_from_Sorted_ArrayII;

/**
 * Created by PennyLiu on 2018/4/30.
 */
public class Remove_Duplicates_from_Sorted_ArrayII {
    public int removeDuplicates(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int num:nums)
        {
            if (i<2 || num > nums[i-2])  //利用数组有序的特性
            {
                nums[i++] = num;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums1 = {1,2,3};
        Remove_Duplicates_from_Sorted_ArrayII t = new Remove_Duplicates_from_Sorted_ArrayII();
        System.out.println(t.removeDuplicates(nums));
    }
}
