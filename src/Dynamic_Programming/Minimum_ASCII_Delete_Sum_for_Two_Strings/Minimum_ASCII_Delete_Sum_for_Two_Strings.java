package Dynamic_Programming.Minimum_ASCII_Delete_Sum_for_Two_Strings;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Minimum_ASCII_Delete_Sum_for_Two_Strings {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) return s1 == null || s1.isEmpty() ? s2.length() : s1.length();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];  //后面的数组下标从1开始
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);  //算s1的每个字符和s1的0位（空串）之间要减去多少
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }

        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++)
            {
                int tmp = (s1.charAt(i-1) == s2.charAt(j-1)) ? 0 : s1.charAt(i-1) + s2.charAt(j-1);
                dp[i][j] = Math.min(dp[i-1][j-1] + tmp, Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1)));
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }



        public static void main(String[] algs)
    {
        Minimum_ASCII_Delete_Sum_for_Two_Strings t = new Minimum_ASCII_Delete_Sum_for_Two_Strings();
        System.out.println(t.minimumDeleteSum("dasda","dadw"));
    }
}
