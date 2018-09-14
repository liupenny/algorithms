package Array.Remove_Duplicates_from_Sorted_Array;

/**
 * Created by PennyLiu on 2018/4/30.
 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }
//        if(nums.length == 2)
//        {
//            if(nums[0] == nums[1])
//                return 1;
//            else
//                return 2;
//        }

        int newNumpos = 0;
        for (int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[newNumpos]) {
                swap(nums, ++newNumpos, i);
            }
        }

        for (int i = 0; i <= newNumpos; i++)
        {
            System.out.print(nums[i] + " ");
        }
        return newNumpos + 1;

    }

    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums1 = {1,2,3};
        Remove_Duplicates_from_Sorted_Array t = new Remove_Duplicates_from_Sorted_Array();
        System.out.println(t.removeDuplicates(nums1));
    }
}
