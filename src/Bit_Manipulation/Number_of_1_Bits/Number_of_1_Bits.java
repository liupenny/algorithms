package Bit_Manipulation.Number_of_1_Bits;

/**
 * Created by PennyLiu on 2018/1/22.
 */
public class Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n==Integer.MAX_VALUE) {
            return 1;
        }
        int ans = 0;
        while (n!=0)
        {
            if((n&1)==1) {
                ans++;
            }
            n>>>=1;
        }
        return ans;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] algs)
    {
        int n=214748364;
        Number_of_1_Bits t = new Number_of_1_Bits();
        System.out.println(t.hammingWeight1(n));
    }
}
