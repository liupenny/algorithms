package String.Score_of_Parentheses;/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public int scoreOfParentheses_recur(String S) {
        if(S == null || S.length() == 0)
            return 0;

        return score(S, 0, S.length() - 1);
    }

    public int score(String s, int begin, int end)
    {
        int ans = 0, balance = 0;

        for (int i = begin; i <= end ; i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if(balance == 0)
            {
                if(i - begin == 1)
                    ans++;
                else
                    ans += 2 * score(s, begin + 1, i);
                begin = i + 1;
            }
        }
        return ans;
    }

    public int scoreOfParentheses_add(String S)
    {
        if(S == null || S.length() == 0)
            return 0;

        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(')
                bal++;
            else
            {
                bal--;
                if(S.charAt(i-1) == '(')
                    ans += 1<<bal;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String a = "(()(()))";
        System.out.println(s.scoreOfParentheses_recur(a));
    }
}