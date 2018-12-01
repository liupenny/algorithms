package String.ReplaceEmpty;

import java.util.ArrayList;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/26
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer ret = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c != ' ') {
                ret = ret.insert(0,c);
            } else {
                ret = ret.insert(0,"%20");
            }
        }
        ArrayList<Integer> a = new ArrayList<>(3);
        return ret.toString();
    }
}
