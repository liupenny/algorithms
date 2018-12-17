package Dynamic_Programming.Decode_Ways;

/**
 * Created by PennyLiu on 2018/3/5.
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if(s.charAt(0)=='0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= len; i++)
        {
            int first = Integer.valueOf(s.substring(i-2,i));
            int second = Integer.valueOf(s.substring(i-1,i));
            if (second == 0)  //如果当前位置是0，就考虑前面一个数，前面只能是1/2，不然就是非法数据
            {
                if(s.charAt(i-2)=='0' || s.charAt(i-2) - '0' > 2) {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
                continue;
            }  //当前不是0，先考虑单独一个数字，继承前面的结果
            dp[i] = dp[i-1];
            if (first > 10 && first <= 26)  //如果能跟前面构成组合的数，再加上前面的
            {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    // 上面方法的辅助数组简化版本
    public int numDecodings1(String s)
    {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
        {
            return 0;
        }

        int res1 = 1, res2 = 1, res = 0;
        for (int i = 2; i <= s.length(); i++)
        {
            int first = Integer.valueOf(s.substring(i-2,i));
            int second = Integer.valueOf(s.substring(i-1,i));
            if (second == 0)  //如果当前位置是0，就考虑前面一个数，前面只能是1/2，不然就是非法数据
            {
                if(s.charAt(i-2)=='0' || s.charAt(i-2) - '0' > 2) {
                    return 0;
                } else {
                    res = res1;
                }
                continue;
            }  //当前不是0，先考虑单独一个数字，继承前面的结果
            res = res2;
            if (first > 10 && first <= 26)  //如果能跟前面构成组合的数，再加上前面的
            {
                res += res1;
            }
        }
        return res;
    }

    public int numDecodings2(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }
        if(s.charAt(0)=='0') {
            return 0;
        }

        int [] number = new int[s.length() + 1];
        number[0] = 1;
        number[1] = 1;
        int tmp;
        for(int i=2;i<=s.length();i++) {
            //检查当前字符是不是'0'
            tmp = Integer.parseInt(s.substring(i-1,i));
            if(tmp!=0) {
                number[i] = number[i-1];
            }
            //检查当前字符和前一个字符组合在一起是否在1-26之间
            if(s.charAt(i-2)!='0') {
                tmp = Integer.parseInt(s.substring(i-2,i));
                if(tmp>0&&tmp<=26) {
                    number[i] += number[i-2];
                }
            }
        }
        return number[s.length()];
    }

    public int numDecodings3(String s) {
        if (s == null || s.length() <= 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1] + isPair(s, i, i + 1) * dp[i + 2];
            }
        }
        return dp[0];
    }

    public int isPair(String s, int i, int j) {
        if(s.charAt(i) == '0') {
            return 0;
        } else {
            String tmp = s.substring(i,j+1);
            int digit = Integer.valueOf(tmp);
            if (digit <= 26) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int numDecodings4(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public int numDecodings5(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int pp = 1, p = 1;
        for (int i = 2; i <= s.length(); i++) {
            int ways = 0;
            int digit2 = s.charAt(i - 1) - '0';
            if (digit2 != 0) {
                ways += p;
            }
            int digit1 = s.charAt(i - 2) - '0';
            int num = digit1 * 10 + digit2;
            if (num >= 10 && num <= 26) {
                ways += pp;
            }
            pp = p;
            p = ways;
        }
        return p;
    }

    public static void main(String[] args) {
        Decode_Ways a = new Decode_Ways();
        System.out.println(a.numDecodings5( "50"));
        //System.out.println(a.numDecodings3("50"));
    }
}
