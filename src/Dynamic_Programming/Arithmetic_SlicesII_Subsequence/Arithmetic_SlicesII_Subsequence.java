package Dynamic_Programming.Arithmetic_SlicesII_Subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/1/25.
 */
public class Arithmetic_SlicesII_Subsequence {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <3) return 0;

        // dp[i]代表以i结尾的等差数列有多少个，map中d作为开头代表以i结尾，d为等差的数列的个数
        Map<Integer,Integer>[] dp = new Map[A.length];  //Map声明的时候可以指定类型也可以不指定
        int res = 0;  //最终答案
        for (int i = 0; i < A.length; i++)
        {
            dp[i] = new HashMap<>(i); //i是hashmap的容量

            for (int j = 0; j < i; j++)
            {
                long diff = (long)A[i] - A[j];
                if(diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int) diff;
                int c1 = dp[i].getOrDefault(d,0); //如果是两个连续数，c1也要更新一下
                int c2 = dp[j].getOrDefault(d,0);  //c2记录了以j结尾d为差的子序列个数，长度至少是2，现在有了i，长度>=3,满足条件
                res += c2;
                dp[i].put(d, c1 + c2 +1);  //更新dp[i]，也就是c1
            }
        }
        return res;
    }

    public static void main(String[] algs)
    {
        Arithmetic_SlicesII_Subsequence t = new Arithmetic_SlicesII_Subsequence();
        System.out.println(t.numberOfArithmeticSlices(new int[]{1, 1, 1, 1}));
    }
}
