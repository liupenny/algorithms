package String.First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;

        // boolean isFirst = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Solution a = new Solution();
        String s = "leetcode";
        System.out.println(a.firstUniqChar(s));
    }
}