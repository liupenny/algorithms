package String.Delete_Operation_for_Two_Strings;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Delete_Operation_for_Two_Strings {
    public int minDistance(String word1, String word2)
    {
        if(word1 == null || word1.isEmpty() || word2 == null || word2.isEmpty()) return word1 == null || word1.isEmpty() ? word2.length() : word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];  //后面的数组下标从1开始
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
            {
                if (word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        return word1.length() + word2.length() - 2*dp[word1.length()][word2.length()];
    }

    public static void main(String[] algs)
    {
        Delete_Operation_for_Two_Strings t = new Delete_Operation_for_Two_Strings();
        System.out.println(t.minDistance("dasda","dadw"));
    }
}
