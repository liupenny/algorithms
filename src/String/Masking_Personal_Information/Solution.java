package String.Masking_Personal_Information;/**
 * Created by PennyLiu on 2018/7/12.
 */

public class Solution{
    public String maskPII(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }

        if(S.contains("@"))
        {
            S = S.toLowerCase();
            int last = S.indexOf('@');
            String before = S.charAt(0) + "*****" + S.charAt(last - 1);
            return before + S.substring(last);
        }
        else
        {
            // S = S.replace(" ","");
            // S = S.replaceAll("[\\pP\\p{Punct}]","");//完全清除标点
            S = S.replaceAll("\\D+", "");
            int length = S.length();
            if(length == 10)
            {
                return "***-***-" + S.substring(6);
            }
            else
            {
                int headLen = length - 10;
                String head = "";
                for (int i = 0; i < headLen; i++) {
                    head += "*";
                }
                return "+" + head + "-***-***-" + S.substring(S.length() - 4);
            }
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String a = "LeetCode@LeetCode.com";
        //String b = "1(234)567-890";
        //String b = "86-(10)12345678";
        String b = "+(501321)-50-23431";
        System.out.println(s.maskPII(b));
    }
}