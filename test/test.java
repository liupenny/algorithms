package Array.Two_Sum;

import Dynamic_Programming.Wildcard_Matching.Wildcard_Matching;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by PennyLiu on 2018/4/7.
 */
public class test {
    public static void main(String[] args) {
        case15();
    }

    private static void case15() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int res = 0, a = 0, b = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int tmp = fab(i, j);
                    if (tmp > res) {
                        res = tmp;
                        a = i;
                        b = j;
                    }
                }
            }
            System.out.printf("%d %d %d\n", res, a, b);
        }
    }

    private static int fab(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return fab(b % a, a) + 1;
    }

    public static void Mex()
    {
        Scanner sb = new Scanner(System.in);
        int T = sb.nextInt();
        while (T-->0)
        {
            // int ans = 0;
            int n = sb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                int t = sb.nextInt();
                if(t >= n)
                    continue;
                arr[t] = 1;
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0)
                {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void beautiful()
    {
        // 预处理出10^6以内所有数字的质因数
        int[] factors = new int[2000002];
        for (int i=1; i<=1000000; i++)
        {
            factors[i] = Decompose(i);
        }

        Scanner sb = new Scanner(System.in);
        int T = sb.nextInt();
        while (T-- >0)
        {
            int x = sb.nextInt();
            int y = sb.nextInt();

            int[] ans = new int[2];
            ans[0] = 1;
            ans[1] = x;

            int[][] dp = new int[y][x];
            for (int i)

            // x是质数/合数，都需要这个结果
            int negonePairs = (y - 2) / 2;  //其他位置可以有negonePairs对 -1
            int xPos = y * (y - 1); // x自己有两个位置选择
            int negonePos = 0;
            for (int i = 0; i <= negonePairs; i++) // 0到negonePairs对 -1的位置选择加起来，其余位置都是1
                negonePos += factorialSec(2 * i, y - 2);
            int primePos = xPos * negonePos * negonePos * 2;

            // x是合数
            if(isPrimeNumber(x) == false)
            {
                int lenans1 = factors[x];
                if (lenans1 < y)
                {

                }
                else
            }
        }
    }



    public static long leftOnes(int y)
    {
        int negonePairs = y / 2;  //其他位置可以有negonePairs对 -1
        int negonePos = 0;
        for (int i = 0; i <= negonePairs; i++) // 0到negonePairs对 -1的位置选择加起来，其余位置都是1
            negonePos += factorialSec(2 * i, y - 2);
        return negonePos;
    }

    public static long factorialSec(int m, int n) {
        /**
         * 替换阶乘的另一种方式(从n开始递减相乘，乘m个数)
         * @param n
         * @param m
         * @return
         */
        long sum = 1;

        while(m > 0 && n > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }

    public static long arrangementSec(int m, int n) {
        /**
         * 排列
         * @param m
         * @param n
         * @return
         */
        return m <= n ? factorialSec(m, n) : 0;
    }

    public static long combinationSec(int m, int n) {
        /**
         * 组合
         * @param m
         * @param n
         * @return
         */
        if( m > n )
            return 0;
        if( m > n/2 )
        {
            m = n - m;
        }
        return factorialSec(m, n)/factorialSec(m, m);
    }


    private static void Decompose1(int n){
        System.out.print(n+"=");
        for(int i=2;i<=n;i++){
            while(n%i==0 && n!=i){
                n=n/i;
                System.out.print(i+"*");
            }
            if(n==i){
                System.out.println(i);
                break;
            }
        }
    }

    private static int Decompose(int n){
        int num=0;
        for(int i=2;i<n;i++){
            while(n%i==0 && n!=i){
                n=n/i;
                num++;
            }
        }
        return num;
    }

    public static boolean isPrimeNumber(int num){
        if(num == 2) return true;//2特殊处理
        if(num < 2 || num % 2 == 0) return false;//识别小于2的数和偶数
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0){//识别被奇数整除
                return false;
            }
        }
        return true;
    }


}
