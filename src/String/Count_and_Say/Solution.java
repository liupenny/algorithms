package String.Count_and_Say;/**
 * Created by PennyLiu on 2018/7/10.
 */

public class Solution{
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        } else
        {
            String last = countAndSay(n-1);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < last.length(); i++) {
                int j = i;
                while (j < last.length() && last.charAt(j) == last.charAt(i)) {
                    j++;
                }
                stringBuilder.append(j-i).append(last.charAt(i));
                // 因为上面j的循环最后会多加一位
                i = j - 1;
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.countAndSay(4));
    }
}