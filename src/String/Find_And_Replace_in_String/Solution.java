package String.Find_And_Replace_in_String;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/7/13.
 */

public class Solution{
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(S == null || S.length() == 0)
            return S;

        // match[i] = index 记录S中i位置的字符可以替换为targets[index]
        int[] match = new int[S.length()];
        Arrays.fill(match, -1);
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if(S.indexOf(sources[i], index) == index)
                match[index] = i;
        }

        // 用S.length进行对准，sb在append的时候也能添加原来S中没被替换的数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length();) {
            if(match[i] >= 0)
            {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();
            }
            else
                sb.append(S.charAt(i++));
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        // String S = "abcd";
        String S = "abcd";
        int[] indexes = {0,2};
        // String[] sources = {"ab","ec"}, targets = {"eee","ffff"};
        String[] sources = {"a","cd"}, targets = {"eee","ffff"};
        Solution a = new Solution();

        System.out.println(a.findReplaceString(S,indexes,sources,targets));
    }
}