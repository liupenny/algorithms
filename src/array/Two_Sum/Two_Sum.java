package array.Two_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2017/10/20.
 */
public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] ans = new int[2];
        for (int i=0; i < nums.length; i++)  //用target-当前值，不断判断
        {
            if(map.containsKey(target - nums[i]))  //这里只用一个循环完成，当不包含就添加，因为只有一个答案，能尽快找到答案
            {
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (array == null || array.length == 0) {
            return ans;
        }
        int start = 0, end = array.length - 1, mulMin = Integer.MAX_VALUE;
        Integer ans1 = null, ans2 = null;
        int head, tail;
        while(start < end) {
            head = array[start];
            tail = array[end];
            if (head + tail == sum) {
                if (head * tail < mulMin) {
                    mulMin = head * tail;
                    ans1 = head;
                    ans2 = tail;
                }
                start++;
            } else if (head + tail > sum) {
                end--;
            } else {
                start++;
            }
        }
        if (ans1 != null && ans2 != null) {
            ans.add(ans1);
            ans.add(ans2);
        }
        return ans;
    }

    public static void main(String[] algs)
    {
        int[] A = {-1, 3, 4, 7, 11, 15};
        Two_Sum t = new Two_Sum();
        // int[] ans = t.twoSum(A,0);
        ArrayList<Integer> ans = t.FindNumbersWithSum(A,14);
        System.out.println(ans.get(0));
        System.out.println(ans.get(1));
    }
}
