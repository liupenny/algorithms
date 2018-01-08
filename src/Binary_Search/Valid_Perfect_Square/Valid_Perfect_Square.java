package Binary_Search.Valid_Perfect_Square;

/**
 * Created by PennyLiu on 2017/10/27.

 * 367. Valid Perfect Square
 */
public class Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {  //二分法
        int lo = 0, hi = num, mid;
        long res = 0;
        while(lo<=hi) //最后一个数字也要看
        {
            mid = lo + (hi - lo)/2;
            res = mid * mid;
            if(num > res)
                lo = (int) mid + 1;  //注意这里类型转换
            else if(num == res)
                return true;
            else
                hi = (int)mid - 1;   //mid -1
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {  //Newton
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;  //除以2
        }
        return x * x == num;
    }

    public static void main(String[] algs)
    {
        Valid_Perfect_Square t = new Valid_Perfect_Square();
        System.out.println(t.isPerfectSquare(34));
    }

}
