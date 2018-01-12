package Binary_Search.Smallest_Good_Base;


import java.math.BigInteger;

/**
 * Created by PennyLiu on 2018/1/11.
 */
public class Smallest_Good_Base {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        BigInteger bn = BigInteger.valueOf(num);
        int max_m = (int) (Math.log(num) / Math.log(2));  //m的范围
        for (int m = max_m; m >= 1; m--) {
            BigInteger k = BigInteger.valueOf((long) Math.floor(Math.pow(num, 1.0 / m)));  //唯一一个需要验证的值
            BigInteger left = k.pow(m + 1).subtract(BigInteger.ONE);
            BigInteger right = bn.multiply(k.subtract(BigInteger.ONE));
            if (left.equals(right)) {  //比较 n* (k - 1) ？= (k^(m+1) - 1)
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }

    public static void main(String[] algs)
    {
        String n="13";
        Smallest_Good_Base test = new Smallest_Good_Base();
        System.out.println(test.smallestGoodBase(n));
    }
}
