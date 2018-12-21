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
    /*
    了最后水平的一段（黑色水平那段）之外，其余部分满足二分性质：竖直虚线左边的数满足 nums[i]≥nums[0]并且 nums[i]>nums[n−1]，其中 nums[n−1]是数组最后一个元素；而竖直虚线右边的数不满足这个条件。分界点就是整个数组的最小值。

1. 所以我们先将最后水平的一段删除即可。
2. 不要忘记处理数组完全单调的特殊情况。
     */
    public int findMin1(int[] nums) {
        int lo = 0, hi = nums.length-1, mid = 0;
        while (lo < hi && nums[lo] == nums[hi]) {
            hi--;
        }
        if (nums[0] <= nums[hi]) {
            return nums[0];
        } else {
            while (lo < hi) {
                mid = lo + (hi - lo) / 2;
                if (nums[mid] >= nums[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        return nums[lo];
    }


    public static void main(String[] algs)
    {
        int[] nums = {3, 1, 3};
        Find_Minimum_in_Rotated_Sorted_Array_II test = new Find_Minimum_in_Rotated_Sorted_Array_II();
        System.out.println(test.findMin(nums));
    }
}
