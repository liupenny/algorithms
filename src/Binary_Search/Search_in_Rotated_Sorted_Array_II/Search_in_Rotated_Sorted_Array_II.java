package Binary_Search.Search_in_Rotated_Sorted_Array_II;

/**
 * Created by PennyLiu on 2018/1/11.
 */
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int left=0, right=nums.length-1, mid;
        if(nums.length == 0) return false;

        while (left < right)
        {
            mid = left + ((right-left)>>1);
            if(nums[mid] == target)
                return true;

            if (nums[mid] > nums[left])  //左半部分是有序的 子集！
            {
                if(target >= nums[left] && target < nums[mid]) //在左半部分里
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else if (nums[mid] < nums[left])
            {
                if(target <= nums[right] && target > nums[mid])  //这两个判断找到了一定范围的有序区间
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else  //此时因为知道 mid==left,mid!=target,所以left!=target，所以只能左移一步。所以情况最糟糕可能是O（n）
                left++;
        }
        return nums[left]==target?true:false;
    }

    public static void main(String[] algs)
    {
        int[] arr={1,3,1,1,1};
        int target = 3;
        Search_in_Rotated_Sorted_Array_II test = new Search_in_Rotated_Sorted_Array_II();
        System.out.println(test.search(arr,target));
    }
}
