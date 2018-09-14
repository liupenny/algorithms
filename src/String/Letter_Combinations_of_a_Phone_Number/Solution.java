package String.Letter_Combinations_of_a_Phone_Number;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/16.
 */

public class Solution {
    // 初始版本，比较简单
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('1', Arrays.asList());
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        help(map, ans, digits,digits.length() - 1);
        return ans;
    }

    // dfs
    public List<String> help(Map<Character, List<Character>> map, LinkedList<String> ans, String digits, int index)
    {
        if(index == 0)
        {
            List<Character> tmp = map.get(digits.charAt(index));
            for (Character c : tmp) {
                ans.add(String.valueOf(c));
            }
            return ans;
        }

        help(map, ans, digits, index - 1);
        List<Character> tmp = map.get(digits.charAt(index));
        int size = ans.size();
        while (size-- > 0)
        {
            String str = ans.poll();
            for (Character c: tmp) {
                ans.add(str + c);
            }
        }
        return ans;
    }

    // 用字符串存储，题目说了只包含2-9，所以不用写0，1的
    String[] mapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations_str(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return ans;
        }
        String cur = "";
        combine(ans, digits, 0, cur);
        return ans;
    }

    public void combine(List<String> ans, String digits, int index, String cur)
    {
        if(index == digits.length())
        {
            ans.add(cur);
            return;
        }
        int digit = digits.charAt(index) - '2';
        String map = mapping[digit];
        for (int i = 0; i < map.length(); i++) {
            combine(ans, digits, index + 1, cur + map.charAt(i));
        }
    }

    public static void main(String[] args)
    {
        String s = "234";
        Solution a = new Solution();
        System.out.println(a.letterCombinations(s));
    }
}