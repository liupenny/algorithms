package Dynamic_Programming.Palindromic_Substrings;

/**
 * Created by PennyLiu on 2018/1/24.
 */
public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        if(s.length() == 0 || s.length()==1) return s.length();
        int[][] dp = new int[s.length()][s.length()];    //dp[i]=从i到结尾有多少个重复序列
        int res = 0;

        for (int i=0; i<s.length(); i++)
        {
            dp[i][i] = 1;
            ++res;
            for (int j=0; j<i; j++)
            {
                if(s.charAt(j)==s.charAt(i) && (j+1>=i-1 || dp[j+1][i-1]==1))   //后面的循环条件是判断当s[i]==s[j]之后，有可能两个字符是相邻的即j+1=i-1,也有可能不相邻 dp[][]=1.这两种情况都可以
                {
                    dp[j][i] = 1;
                    ++res;
                }
            }
        }
        return res;
    }

    public int countSubstrings1(String s)
    {
        if(s.length() == 0 || s.length()==1) return s.length();
        int ans = 0;
        for (int i=0; i<s.length(); i++)
            ans += count(s,i,i) + count(s,i,i+1);
        return ans;
    }

    public int count(String s, int left, int right)
    {
        int num = 0;
        while (left>=0 && right<s.length() && s.charAt(left--) == s.charAt(right++))
            num++;
        return num;
    }



    public static void main(String[] algs)
    {
        String A="aaa";
        Palindromic_Substrings t = new Palindromic_Substrings();
        System.out.println(t.countSubstrings1(A));
    }
}
