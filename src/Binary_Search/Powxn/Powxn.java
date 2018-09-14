package Binary_Search.Powxn;

/**
 * Created by PennyLiu on 2018/1/12.
 */
public class Powxn {
    public double myPow(double x, int n) {
        if(x==0) {
            return 0;
        }
        double ans = 1;
        long absn = Math.abs((long) n);
        while (absn > 0)
        {
            if((absn&1) == 1) {
                ans *= x;   //移位后的absn如果当前位置是1就×
            }
            absn >>= 1;   //absn向右移位，就是/2
            x *= x;   //计算x^i的值
        }
        return n<0?1/ans:ans;   //如果n<0，取倒数就行
    }

    public double myPow1(double x, int n) {
        if(n==0) {
            return 1;
        }
        if(n<0)
        {
            n = -n;
            x = 1/x;
        }
        return n%2==0? myPow1(x*x,n/2): x*myPow1(x*x,n/2);
    }

        public static void main(String[] algs)
    {
        Powxn t = new Powxn();
        System.out.println(t.myPow(2.00000, 10));
    }
}
