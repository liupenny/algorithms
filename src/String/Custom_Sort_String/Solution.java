package String.Custom_Sort_String;/**
 * Created by PennyLiu on 2018/7/3.
 */

public class Solution{
    public String customSortString(String S, String T) {
        if(S == null || T == null)
            return T;

        StringBuilder common = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(T.contains(S.substring(i,i+1)))
                common.append(S.charAt(i));
        }
        String before = common.toString();

        StringBuilder uncommon = new StringBuilder();
        for (int i = 0; i < T.length(); i++) {
            int index = common.indexOf(T.substring(i,i+1));
            if(index != -1)
            {
                common.deleteCharAt(index);
            }
            else
                uncommon.append(T.charAt(i));
        }

        return before + uncommon.toString();
    }

    public static void main(String[] args)
    {
        // String S = "cba" , T = "abcd";
        String S = "kqep", T = "pekeq";
        Solution solution = new Solution();
        System.out.println(solution.customSortString(S, T));
    }
}