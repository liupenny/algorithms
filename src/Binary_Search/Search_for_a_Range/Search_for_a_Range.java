package Binary_Search.Search_for_a_Range;

/**
 * Created by PennyLiu on 2018/1/16.
 * searchRange1：只写一个找出第一个》target的数的角标即可
 * searchRange2：两次查找，分别找左边和右边
 */
public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1}, ansr = {0,0};
        if(nums.length == 0 || nums==null) return ans;
        if(nums.length == 1) return nums[0]==target?ansr:ans;

        int begin , end , left = 0, right = nums.length-1, mid=0;
        while (left <= right)   //先找出等于的位置
        {
            mid = left + (right - left)/2;
            if(nums[mid] == target)
                break;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        if(nums[mid]!=target) return ans;
        begin = searchleft(nums, left, mid -1 , target);
        end = searchright(nums, mid + 1, right, target);
        ans[0] = nums[begin]==target?begin:mid;
        ans[1] = nums[end]==target?end:mid;
        return ans;
    }

    public int searchleft(int[] nums, int begin, int end, int target)   //在左半部分找第一个=target
    {
        if(begin == end) return begin;
        int left = begin, right = end, mid;
        while (left<right)
        {
            mid = left + (right - left)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left]==target?left:right;
    }

    public int searchright(int[] nums, int begin, int end, int target)   //在右半部分找最后一个=target
    {
        if(begin == end) return begin;
        int left = begin, right = end, mid;
        while (left<right)
        {
            mid = left + (right - left + 1)/2;
            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        return nums[right]==target?right:left;
    }

        public int[] searchRange1(int[] A, int target) {
            int start = firstGreaterEqual(A, target);
            if (start == A.length || A[start] != target) {  //在这里进行了只有一个元素时候的判断
                return new int[]{-1, -1};
            }
            return new int[]{start, firstGreaterEqual(A, target + 1) - 1};   //这里找target+1的第一个位置
        }

        //find the first number that is greater than or equal to target.
        //could return A.length if target is greater than A[A.length-1].
        //actually this is the same as lower_bound in C++ STL.
        private static int firstGreaterEqual(int[] A, int target) {
            int low = 0, high = A.length;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                //low <= mid < high
                if (A[mid] < target) {
                    low = mid + 1;
                } else {
                    //should not be mid-1 when A[mid]==target.
                    //could be mid even if A[mid]>target because mid<high.
                    high = mid;
                }
            }
            return low;
        }


        public  int[] searchRange2(int[] nums, int target) {
            int hi = nums.length - 1;
            int low = 0;
            int[] rs = new int[2];
            // base case
            if(nums == null || nums.length == 0)
                return new int[]{-1, -1 };

            //left side
            while(low < hi){
                int mid = low + (hi - low) /2;
                if(target > nums[mid]){
                    low = mid + 1;
                }else{
                    hi = mid;
                }
            }
            if(target == nums[low]){
                rs[0] = low;
            }else{
                rs[0] = -1;
            }

            //right side，不用设置lo=0,lo从前面找到的位置开始
            hi = nums.length - 1;
            while(low < hi){
                int mid = (low + (hi - low) /2 ) + 1;

                if(target < nums[mid]){
                    hi = mid - 1;
                }else{
                    low = mid;
                }
            }
            if(target == nums[hi]){
                rs[1] = hi;
            }else{
                rs[1] = -1;
            }

            return rs;
        }

    public static void main(String[] algs)
    {
        int[] nums = {0,0,1,1,2,2,2,2,3,3,4,4,4,5,6,6,6,7,8,8};
        int target = 4;
        Search_for_a_Range t = new Search_for_a_Range();
        int[] ans = t.searchRange(nums, target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
