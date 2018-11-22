package Hash_table.Top_K_Frequent_Words;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if(words == null || words.length == 0) {
            return ans;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o2.getValue().equals(o1.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        } else {
                            return o2.getValue() - o1.getValue();
                        }
                    }
                }
        );
        priorityQueue.addAll(map.entrySet());

        while (!priorityQueue.isEmpty() && k-- > 0)
        {
                ans.add(priorityQueue.poll().getKey());
        }
        return ans;
    }

    public static void main(String[] args)
    {
     // String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
     // int k = 2;
     String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
     int k = 4;
     Solution s = new Solution();
     System.out.println(s.topKFrequent(words,k));
    }
}