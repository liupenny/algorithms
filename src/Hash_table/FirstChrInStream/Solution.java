package Hash_table.FirstChrInStream;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class Solution {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    public void Insert(char ch)
    {
        map.put(ch,map.getOrDefault(ch,0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (!map.isEmpty()) {
            for(Map.Entry<Character, Integer> entry: map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return '#';
        } else {
            return '#';
        }
    }
}
