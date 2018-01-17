package Binary_Search.Divide_Two_Integers;

/**
 * Created by PennyLiu on 2018/1/17.
 */
public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(divisor == 1 || divisor == -1) return divisor==-1? -dividend: dividend;

        int sign = ((dividend<0)^(divisor<0)) ? -1:1;

        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int ans = 0;

        while (dvd >= dvs)
        {
            long multiple = 1, tmp = dvs;
            while (dvd>=(tmp<<1))
            {
                tmp <<= 1;
                multiple <<= 1;
            }
            dvd -= tmp;
            ans += multiple;
        }
        return sign==1?ans:-ans;
    }

    public static void main(String[] algs)
    {
        int dividend = -2147483648, divisor = 2;
        Divide_Two_Integers t = new Divide_Two_Integers();
        System.out.println(t.divide(dividend,divisor));
    }
}
