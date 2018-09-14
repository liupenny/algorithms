package Binary_Search.Sqrtx;

/**
 * Created by PennyLiu on 2018/1/12.
 */
public class Sqrtx {
    public int mySqrt(int x) {  //牛顿法
        long r = x;
        while (r*r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public int mySqrt1(int x) {
        long start = 0, end = x;
        while(start + 1 < end){
            long mid = start + (end - start) / 2;
            if(mid * mid == x){
                return (int)mid;
            }else if(mid * mid < x){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(end*end <= x){
            return (int)end;
        }else{
            return (int)start;
        }

    }

    public int mySqrt2(int x) {
        if(x==0) {
            return 0;
        }
        long left = 0, right = x, mid;
        while (left < right)
        {
            mid = left + (right - left + 1)/2;  //这里用+1会导致mid越界
            if (x/mid >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right*right<=x?(int)right:(int)left;
    }

    public int mySqrt3(int x) {  //最开始自己写的错的
        if(x==0) {
            return 0;
        }
        int left = 0, right = x, mid;
        while (left + 1 < right)
        {
            mid = left + (right - left)/2;  //这里用+1会导致mid越界
            if (x/mid >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] algs)
    {
        Sqrtx t = new Sqrtx();
        System.out.println(t.mySqrt2(2147483647));
    }
}
