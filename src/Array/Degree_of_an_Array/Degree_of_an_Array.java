package Array.Degree_of_an_Array;

import java.util.*;

/**
 * Created by PennyLiu on 2018/5/15.
 */
public class Degree_of_an_Array {
    public int findShortestSubArray(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            int x = nums[i];
            if(left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x,i);  //后面加进来的会一直覆盖，所以这里不用单独考虑最后一个加进来的数字
            count.put(x,count.getOrDefault(x,0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet())
        {
            if(count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1); //长度的判断
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Degree_of_an_Array t = new Degree_of_an_Array();
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(t.findShortestSubArray(nums));
    }
}
