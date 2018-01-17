package Binary_Search.Find_Kth_Smallest_Pair_Distance;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/1/17.
 * 滑动窗口 + 二分
 */
public class Find_Kth_Smallest_Pair_Distance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, left = 0, right = nums[len-1] - nums[0], ans = -1;
        while (left <= right)
        {
            int cnt = 0, j = 0, mid = left + (right - left)/2;
            for (int i=0; i<len; ++i)   //这里算出对于数组中数对差《k的一共有多少个
            {
                while (j < len && nums[j]-nums[i]<=mid) ++j;
                cnt += j - i - 1;
            }
            if(cnt >= k )
            {
                ans = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return ans;
    }

    public static void main(String[] algs)
    {
        int s = 3;
        //int[] nums = {1,1};
        int[] nums = {1,2,3,4,5};
        Find_Kth_Smallest_Pair_Distance t = new Find_Kth_Smallest_Pair_Distance();
        System.out.println(t.smallestDistancePair(nums,s));
    }
}
