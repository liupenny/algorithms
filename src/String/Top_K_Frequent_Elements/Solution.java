package String.Top_K_Frequent_Elements;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                }
        );
        priorityQueue.addAll(map.entrySet());

        for (int i = 0; i < k; i++) {
            ans.add(priorityQueue.poll().getKey());
        }
        return ans;
    }

    public static void main(String[] args)
    {
    
    }
}