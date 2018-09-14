package String.Sort_Characters_By_Frequency;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> tmp = list.get(i);
            for (int j = 0; j < tmp.getValue(); j++) {
                ans.append(tmp.getKey());
            }
        }
        return ans.toString();
    }



    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.frequencySort("Aabb"));
    }
}