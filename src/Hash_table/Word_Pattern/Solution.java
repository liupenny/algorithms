package Hash_table.Word_Pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/7/29.
 */

public class Solution{
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }

        // 这里不指明类型，应该是object，因为后面put的key类型不一致
        Map map = new HashMap();
        // 这里用Integer是因为：
        // Integer有个cache，在-128 -- 127 之间是已经有的。
        // 而map中要插入的是集合类型，如果i 到了129，map插入的key就要新建Integer，此时上一步插入的128是两个不同的Integer对象，
        // 对象比较的是地址，所以就会不一样
        for (Integer i = 0; i < words.length ; i++) {
            // put插入时候的返回值：
            // 如果key之前不存在：返回null
            // key之前存在：返回之前的value

            if(map.put(pattern.charAt(i),i) != map.put(words[i],i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
            else if(map.containsKey(words[i])){
                if(!map.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
            else {
                map.put(pattern.charAt(i), words[i]);
                map.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String pattern = "abba", str = "dog dog dog dog";
        // String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        // String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(s.wordPattern1(pattern, str));
    }
}