package Greedy.Split_Array_into_Consecutive_Subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
//    public boolean isPossible(int[] nums) {
//        if(nums == null || nums.length == 0)
//            return false;
//
//        //用来统计num中每个字符和出现次数
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int num: nums) {
//            count.put(num, count.getOrDefault(num, 0) + 1);
//        }
//        //记录以key-1结尾的字符串出现的次数val
//        Map<Integer, Integer> tails = new HashMap<>();
//
//        for (int num: nums) {
//            if(count.get(num) <= 0)
//                continue;
//            // 已经有一个以num此结尾的,就连起来
//            else if(tails.getOrDefault(num,0) > 0)
//            {
//                tails.put(num, tails.get(num) - 1);
//                tails.put(num + 1, tails.getOrDefault(num + 1, 0) + 1);
//            }
//            // 没有以num结尾的，看够不够连续三个字符，够就创建一个以Num+2结尾的序列,tails中的key代表以key-1结尾的字符串，所以要存num+3
//            else if(count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0)
//            {
//                count.put(num + 1, count.get(num + 1) - 1);
//                count.put(num + 2, count.get(num + 2) - 1);
//                tails.put(num + 3, tails.getOrDefault(num + 3,0) + 1);
//            }
//            //都不行，就返回false
//            else
//                return false;
//            count.put(num, count.get(num) - 1);
//        }
//        return true;
//    }

    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;

        //用来统计num中每个字符和出现次数
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        //记录以key结尾的字符串出现的次数val
        Map<Integer, Integer> tails = new HashMap<>();

        for (int num: nums) {
            if(count.get(num) <= 0)
                continue;
                // 已经有一个以num此结尾的,就连起来
            else if(tails.getOrDefault(num - 1,0) > 0)
            {
                tails.put(num - 1, tails.get(num - 1) - 1);
                tails.put(num, tails.getOrDefault(num, 0) + 1);
            }
            // 没有以num结尾的，看够不够连续三个字符，够就创建一个以Num+2结尾的序列,tails中的key代表以key-1结尾的字符串，所以要存num+3
            else if(count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0)
            {
                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);
                tails.put(num + 2, tails.getOrDefault(num + 2,0) + 1);
            }
            //都不行，就返回false
            else
                return false;
            count.put(num, count.get(num) - 1);
        }
        return true;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] nums ={1,2,3,3,4,4,5,5};
        System.out.println(s.isPossible(nums));
    }
}