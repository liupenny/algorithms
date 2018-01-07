package Array._4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2017/10/20.

 * 实际上也是三轮循环，省去了很多没必要的判断，所以快很多
 */
public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4)  //异常处理，这题没说一定有答案
            return ans;

        Arrays.sort(nums);  //排序，排除重复值

        int max = nums[nums.length - 1];
        if (4 * nums[0] > target || 4 * max < target)  //边界处理
            return ans;

        for (int i = 0; i < nums.length-3; i++)
        {
            if(i>0 && nums[i] == nums[i-1])  continue;  //重复
            if(nums[i] + 3*max < target)  continue;    //太小
            if(nums[i]*4 > target)  break;        //太大
            if(nums[i]*4 == target)
            {
                if(i+3<nums.length && nums[i+3]==nums[i])
                    ans.add(Arrays.asList(nums[i],nums[i],nums[i],nums[i]));
                break;
            }
            threeSumForFourSum(nums, target - nums[i], i + 1, nums.length - 1, ans, nums[i]);
        }
        return ans;
    }

    public void threeSumForFourSum(int[] nums, int target, int begin, int end, List<List<Integer>> ans, int first)
    {
        if(begin + 1 >= end) return;
        int max = nums[end];

        if (3 * nums[begin] > target || 3 * max < target) //边界处理
            return;

        for (int i = begin; i < end-1; i++)
        {
            if(i>begin && nums[i]==nums[i-1])  continue;
            if(nums[i] + 2*max<target)  continue;
            if(nums[i]*3 > target) break;
            if(nums[i]*3 == target)
            {
                if(i+2<nums.length && nums[i+2]==nums[i])
                    ans.add(Arrays.asList(first,nums[i],nums[i],nums[i]));
                break;
            }
            twoSumForThreeSum(nums, target - nums[i], i + 1, nums.length - 1, ans, first, nums[i]);
        }
    }

    public void twoSumForThreeSum(int[] nums, int target, int begin, int end, List<List<Integer>> ans, int first, int second)
    {
        if(begin >= end) return;
        if (2 * nums[begin] > target || 2 * nums[end] < target) //边界处理
            return;

        int lo = begin, hi = end,sum;
        while (lo<hi)
        {
            if(lo==begin || nums[lo]!=nums[lo-1])
            {
                sum = nums[lo] + nums[hi];
                if (sum == target)
                {
                    ans.add(Arrays.asList(first, second, nums[lo], nums[hi]));
                    lo++; hi--;
                }
                else if (sum < target)
                    lo++;
                else
                    hi--;
            }
            else
                lo++;
        }
    }


    public static void main(String[] algs)
    {
        int[] A = {1, 0, -1, 0, -2, 2};
        _4Sum t = new _4Sum();
        List<List<Integer>> ans = t.fourSum(A,0);
        System.out.println(ans);
    }
}
