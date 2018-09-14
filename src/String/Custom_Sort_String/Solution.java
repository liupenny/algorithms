package String.Custom_Sort_String;/**
 * Created by PennyLiu on 2018/7/3.
 */

public class Solution{
    public String customSortString(String S, String T) {
        if(S == null || T == null) {
            return T;
        }

        // s和t共有的字符串
        StringBuilder common = new StringBuilder();
        // t中删除和s共有的之后剩下的
        StringBuilder builderT = new StringBuilder(T);
        for (int i = 0; i < S.length(); i++) {
            int commonIndex = builderT.indexOf(S.substring(i,i+1));
            if(commonIndex != -1)
            {
                common.append(S.charAt(i));
                builderT.deleteCharAt(commonIndex);
            }
        }
        String leftT = builderT.toString();

        StringBuilder uncommon = new StringBuilder();
        for (int i = 0; i < leftT.length(); i++) {
            int index = common.indexOf(leftT.substring(i,i+1));
            if(index != -1)
            {
                common.insert(index, leftT.charAt(i));
            }
            else {
                uncommon.append(leftT.charAt(i));
            }
        }

        return common.toString() + uncommon.toString();
    }

    // 用数组，直接记录一下字符串中每个字符出现的次数
    public String customSortString_array(String S, String T) {
        int[] count = new int[26];
        for (char c: T.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            while (count[c - 'a'] > 0)
            {
                sb.append(c);
                count[c - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0)
            {
                sb.append((char)('a' + i));
                count[i]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String S = "cba" , T = "abcd";
        //String S = "kqep", T = "pekeq";
        Solution solution = new Solution();
        System.out.println(solution.customSortString(S, T));
    }
}