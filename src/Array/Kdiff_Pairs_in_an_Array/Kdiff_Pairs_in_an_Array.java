package Array.Kdiff_Pairs_in_an_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/5/30.
 */
public class Kdiff_Pairs_in_an_Array {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(k == 0)
            {
                if(entry.getValue() >= 2) //不能用hashset，否则k==0的时候没法弄
                    ans ++;  //只加一是因为不能有重复值
            }
            else
            {
                if(map.containsKey(entry.getKey() + k))  //对于每一项都是往上找比他大的，所以不会重复计算
                    ans ++;
            }
        }
        return ans;
    }

    public int findPairs1(int[] nums, int k) { //这里想的有问题，在一开始把重复的过滤掉只是过滤了相同开头的那些，但是第一个开头的可能后面会有重复的子段
        if(nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        if(nums[nums.length - 1] - nums[0] < k)
            return 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[i] > k)
                    break;
                else if(nums[j] - nums[i] == k)
                    ans++;
            }
        }
        return ans;
    }

    public static int findPairs2(int[] nums, int k) { //暴力遍历
        Arrays.sort(nums);
        int res = 0;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++)
                if(nums[j] - nums[i] == k) {
                    res++;
                    break;
                }
            while(i<nums.length-1 && nums[i] == nums[i+1]) //过滤重复值
                i++;
        }
        return res;
    }

    public int findPairs3(int[] nums, int k) { //滑动窗口思想，在left -- right间找
        if (nums == null || nums.length == 0 || k < 0)
            return 0;

        Arrays.sort(nums);
        int ans = 0, left = 0, right = 1;
        while (right < nums.length)
        {
            int first = nums[left];
            int second = nums[right];
            if(second - first < k)
                right++;
            else if(second - first > k)
                left++;
            else
            {  //等于的时候就++，遇到重复的就一直往后移动left , right
                ans++;
                while (left<nums.length && nums[left]==first){
                    left++;
                }
                while(right<nums.length && nums[right]==second){
                    right++;
                }
            }
            if(right == left)
                right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Kdiff_Pairs_in_an_Array t = new Kdiff_Pairs_in_an_Array();
        int[] nums = {3, 3, 1, 1, 5, 5, 1, 5};
        int k = 2;
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 1;
        int[] nums2 = {1, 3, 1, 5, 4};
        int k2 = 0;
        int[] nums3 = {1, 1, 1, 1, 1};
        int k3 = 0;
        System.out.println(t.findPairs3(nums2, k2));

    }
}
