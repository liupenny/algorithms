package Binary_Search.Search_in_Rotated_Sorted_Array;

/**
 * Created by PennyLiu on 2018/1/8.
 * search1: 先分段再找
 * search2:直接找
 */
public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int pivot=0;
        int left, right, mid;
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        for (int i=1; i<nums.length; i++)  //找到分界点pivot
        {
            if(nums[i] < nums[i-1])
            {
                pivot = i-1;
                break;
            }
        }

        if (target >= nums[0] && target <= nums[pivot])  //找到target属于的那个段
        {
            left = 0;
            right = pivot;
        }
        else if (target >= nums[pivot+1] && target <= nums[nums.length-1])
        {
            left = pivot + 1;
            right = nums.length -1;
        }
        else {
            return -1;
        }

        while (left <= right)  //当这里是 《 的时候，下面就应该是 mid-1 且 mid+1；如果是 < ,那就是 mid-1 或者 mid+1
        {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) {
                return mid;
            }

            if (A[lo] <= A[mid]) { //左半部分一定是有序的 子集！
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {  //右半部分一定是有序的  子集！
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1; //出来的时候 lo 没考虑到，单独判断
    }

    public static void main(String[] algs)
    {
        int[] nums = {3, 4, 5, 6, 1, 2};
        int target = 2;
        Search_in_Rotated_Sorted_Array test = new Search_in_Rotated_Sorted_Array();
        System.out.println(test.search(nums,target));
    }
}
