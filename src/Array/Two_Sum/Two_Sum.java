package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2017/10/20.
 * 1. Two Sum
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] ans = new int[2];
        for (int i=0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))  //这里只用一个循环完成，当不包含就添加，因为只有一个答案
            {
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] algs)
    {
        int[] A = {1, 0, -1, 0, -2, 2};
        Two_Sum t = new Two_Sum();
        int[] ans = t.twoSum(A,0);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
