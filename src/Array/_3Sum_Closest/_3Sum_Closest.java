package Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2017/10/20.
 * 16. 3Sum Closest
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 思路：因为算的是三个数字的和最接近，所以在比较的时候用当前三个数字的加和-target的绝对值比较，这样方便。如果还是算剩下的数不太方便。
 */
public class _3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3)  return nums[0]+nums[1]+nums[2];
        int lo, hi, sum;  //三个辅助变量
        int ans = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++)
        {
            lo = i + 1;
            hi = nums.length - 1;
            while (lo < hi)
            {
                sum = nums[i] + nums[lo] + nums[hi];
                if (sum > target)
                    hi--;
                else if (sum < target)
                    lo++;
                else if (sum == target)
                    return target;
                if (Math.abs(sum - target) < Math.abs(ans - target)) //每一个都要比较
                    ans = sum;
            }
        }
        return ans;
    }

    public static void main(String[] algs)
    {
        int[] A = {1,2,5,10,11};
        A3Sum_Closest t = new A3Sum_Closest();
        int ans = t.threeSumClosest(A,12);
        System.out.println(ans);
    }
}
