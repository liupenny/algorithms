package String.Group_Anagrams;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/13.
 */

public class Solution{
    // 通过排序实现
    public List<List<String>> groupAnagrams_sort(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs == null || strs.length == 0)
            return ans;

        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            //tmp.toString();
            String tmpStr = String.valueOf(tmp);
            if (!map.containsKey(tmpStr))
                map.put(tmpStr, new ArrayList<>());
            map.get(tmpStr).add(strs[i]);
        }

        for (ArrayList<String> arr: map.values()) {
            ans.add(arr);
        }
        return ans;
    }

    // 通过统计两个字符串中含有的字符种类和个数
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        // 这里的map类型可以不写list<>
        Map<String, List> map= new HashMap<>();
        int[] count = new int[26];
        for (String a: strs) {
            Arrays.fill(count, 0);
            for(char c : a.toCharArray())
                count[c-'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(a);
        }

        // 注意这种构建arraylist的方法
        return new ArrayList(map.values());
    }

    public static void main(String[] args)
    {
        // String e = "hjdasi";

        // ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("aaa","dddd"));
        //System.out.println(arrayList.toString());
        Solution s  = new Solution();
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(a));
    }
}