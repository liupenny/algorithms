package Binary_Search;

/**
 * Created by PennyLiu on 2017/10/24.
 * 153. Find Minimum in Rotated Sorted Array
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 Find the minimum element.

 You may assume no duplicate exists in the array.
 思路：还是用二分搜索去不断判断
 */
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1, mid;
        while (lo < hi)
        {
            if(nums[lo] < nums[hi])     //每次都在这里判断一下，
                return nums[lo];
            mid = lo + (hi-lo)/2;
            if (nums[lo] <= nums[mid])     //lo<mid,但lo>hi,所以最小的在后半部分
                lo = mid+1;
            else
                hi = mid;   //lo>mid,但lo>hi,所以最小的在前半部分
            // 以小的在前半部分
        }
        return nums[lo];
    }

    public static void main(String[] algs)
    {
        Find_Minimum_in_Rotated_Sorted_Array t = new Find_Minimum_in_Rotated_Sorted_Array();
        int A[] = {3,4,5,6,1,2};
        int ans = t.findMin(A);
        System.out.println(ans);

    }
}
