package Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by PennyLiu on 2017/10/25.
 * 35. Search Insert Position
 */
public class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==1) return nums[0]>=target ? 0 : 1;
        int lo = 0, hi = nums.length-1, mid;
        while (lo<=hi)
        {
            mid = lo + (hi-lo)/2;
            if(target > nums[mid])
                lo = mid +1;
            else if(target < nums[mid]) //如果严格小，就hi = mid -1，因为返回值不会是mid或比mid大的
                hi = mid-1;
            else if(target == nums[mid])
                return mid;
        }
        return lo;
    }

    public int searchInsert1(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] algs)
    {
        //List<Integer> starts = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,8));
        int[] a = {1,3};
        Search_Insert_Position t = new Search_Insert_Position();
        int ans = t.searchInsert(a,0);
        System.out.println(ans);
    }
}
