package String.To_Lower_Case;/**
 * Created by PennyLiu on 2018/7/18.
 */

public class Solution{
    public String toLowerCase(String str) {
        if(str == null || str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 65 && c <= 90)
            {
                // sb不认得 c+32是整数还是字符，所以要指定
                sb.append((char)(c + 32));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String a = "(LET x 2 (ADD (let x 3 (let x 4 x)) x))";
        System.out.println(s.toLowerCase(a));
    }
}