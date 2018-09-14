package String.Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) {
            return s;
        }
        if(s.length() <= t.length()) {
            return "";
        }

        // map中存储t中每个字符及他们出现的次数
        Map<Character, Integer> charT = new HashMap<>();
        for (char c: t.toCharArray()) {
            charT.put(c, charT.getOrDefault(c,0) + 1);
        }

        // 遍历寻找符合条件的,每找到一个符合的就直接更新字符串
        int fast, slow = 0, match_count = t.length();
        int min_len = Integer.MAX_VALUE, start_index = -1;
        String ret = "";
        for (fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (charT.containsKey(ch)) {
                int num = charT.get(ch);
                if (num > 0) {
                    match_count--;
                }
                charT.put(ch, num - 1);
            }
            //找到满足条件的
            while (match_count == 0) {
                if (fast - slow + 1 < min_len) {
                    min_len = fast - slow + 1;
                    start_index = slow;
                }
                //最左边的字符,分为三种情况考虑：不在charT中--slow++; 在且次数为负，次数加一，继续判断；在且次数为0，次数加一，且不再匹配，待匹配个数加一。
                char tmp = s.charAt(slow);
                if(charT.containsKey(tmp))
                {
                    if(charT.get(tmp) == 0) {
                        match_count++;
                    }
                    charT.put(tmp, charT.get(tmp) + 1);
                }
                slow++;
            }
        }
        ret = start_index == -1 ? ret :s.substring(start_index, start_index + min_len);
        return ret;
    }

    public String minWindow_shrink(String s, String t) {
        String result ="";
        if(s==null || t == null){
            return result;
        }
        Map<Character, Integer> charToCount = new HashMap();
        for(char c : t.toCharArray()){
            charToCount.put(c, charToCount.getOrDefault(c,0)+1);
        }

        int start = 0;
        int counter = t.length();
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(charToCount.containsKey(ch)){
                int prevC = charToCount.get(ch);
                if(prevC>0) {
                    counter--;
                }
                charToCount.put(ch, prevC-1);
            }

            // 跟上面一样，只不过等于0的时候再进行更新
            if(counter==0){
                start= doShrinkWindow(charToCount, s,start, i);
                String candidate = s.substring(start,i+1);
                result = result==null || result.length()==0 ||result.length()>candidate.length() ? candidate : result;
            }

        }

        return result;

    }

    private int doShrinkWindow(Map<Character,Integer> temp, String str, int start, int end){
        while(start<end){
            char ch = str.charAt(start);
            if(temp.containsKey(ch)){
                if(temp.get(ch)<0){
                    temp.put(ch, temp.get(ch)+1);
                } else {
                    return start;
                }
            }
            start++;
        }
        return start;

    }

    // 用数组实现，每次找到符合条件的子串时更新方便
    public String minWindow_array(String s, String t) {

        int s_len = s.length();
        int t_len = t.length();
        int ruler = t_len;

        int res = Integer.MAX_VALUE;
        int start = 0;

        int[] freq = new int[128];

        char[] c_s = s.toCharArray();
        char[] c_t = t.toCharArray();

        // count char in t
        for (char c : c_t) {
            freq[c]++;
        }

        int i = 0, j = 0;
        while (j < s_len) {

            // whether ruler can expand
            if (freq[c_s[j++]]-- >= 1) {
                ruler--;
            }

            // if ruler == 0, it means all char in t has been contained in window now
            while (ruler == 0) {

                // choose min window
                if (res > j - i) {
                    res = j - i;
                    start = i;
                }

                // narrow left border
                // 下面这个表达式不太好懂：首先i表示slow,先取出s串中slow这个位置的字符，在freq中看这个字符对应的要匹配的次数是否为0，若为0就满足条件，剩余待匹配的个数加一。判断完以后，再给这个字符对应的次数加一。同时slow++,移到下个位置
                // 这里不管怎么样，slow和对应位置的待匹配个数都要加一
                // ruler是否加一取决于原来的结果
                if (freq[c_s[i++]]++ == 0) {
                    ruler++;
                }

            }

        }

        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);

    }


    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(solution.minWindow(S,T));
    }
}