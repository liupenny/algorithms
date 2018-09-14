package Binary_Search.Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * Created by PennyLiu on 2017/10/27.
 */
public class Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) { //并没有找到反转的位置，第一个最小值的index
        int left = 0, right = nums.length-1, mid = 0;
        while (left <= right)  //加=是因为有可能 right就判断不到了
        {
            if (nums[left] < nums[right] || left==right)  //在这里跳出是因为可能 left=right就一直死循环
            {
                return nums[left];
            }
            mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right])  //e.g. 3 3 1 3 / 3 1 3 3 这两种情况下没法判断该去哪，所以right-1
            {
                right--;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }


    public static void main(String[] algs)
    {
        int[] nums = {3, 1, 3};
        Find_Minimum_in_Rotated_Sorted_Array_II test = new Find_Minimum_in_Rotated_Sorted_Array_II();
        System.out.println(test.findMin(nums));
    }
}
