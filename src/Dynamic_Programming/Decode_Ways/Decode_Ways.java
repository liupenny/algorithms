package Dynamic_Programming.Decode_Ways;

/**
 * Created by PennyLiu on 2018/3/5.
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
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
                if(s.charAt(i-2)=='0' || s.charAt(i-2) - '0' > 2)
                    return 0;
                else
                    dp[i] = dp[i-2];
                continue;
            }  //当前不是0，先考虑单独一个数字，继承前面的结果
            dp[i] = dp[i-1];
            if (first > 10 && first <= 26)  //如果能跟前面构成组合的数，再加上前面的
                dp[i] += dp[i-2];
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
                if(s.charAt(i-2)=='0' || s.charAt(i-2) - '0' > 2)
                    return 0;
                else
                    res = res1;
                continue;
            }  //当前不是0，先考虑单独一个数字，继承前面的结果
            res = res2;
            if (first > 10 && first <= 26)  //如果能跟前面构成组合的数，再加上前面的
                res += res1;
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

    public static void main(String[] args) {
        Decode_Ways a = new Decode_Ways();
        System.out.println(a.numDecodings( "110"));
        System.out.println(a.numDecodings1("110"));
    }
}
