package Hash_table.Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/7/30.
 */

public class Solution{
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }
            else {
                if(!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) {
                    continue;
                } else {
                    return false;
                }
            }else{
                if(!map.containsValue(b)) {
                    map.put(a, b);
                } else {
                    return false;
                }

            }
        }
        return true;

    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String pattern = "ab", str = "ca";
        System.out.println(s.isIsomorphic1(pattern, str));
    }
}