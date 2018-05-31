package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        case3();
    }

    static void case4()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();  //m是小美要喝的可乐数
        int[][] happy = new int[k][2];
        for (int i = 0; i < k; i++) {
            happy[i][0] = in.nextInt();
            happy[i][1] = in.nextInt();
        }

        int t = n - m; //小团要喝的可乐数目
        int[] score = new int[k];
        for (int i = 0; i < k; i++) {

        }

    }

    static void case3()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        Map<Integer, Integer> prices = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int price = in.nextInt(), coupon = in.nextInt();
            prices.put(price, coupon);
            if(coupon == 1)
                sum += price;
        }

        Map<Integer, Integer> reduc = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            int full = in.nextInt(), reduction = in.nextInt();
            reduc.put(full, reduction);
        }

        double discount = (double)sum * 0.8;
        // int dis = reduc.
    }

    class codeM1 {
        public void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            double[][] prices = new double[n][2];
            for (int i = 0; i < n; i++) {
                prices[i][0] = in.nextDouble();
                prices[i][1] = in.nextDouble();
            }
            double[][] sales = new double[m][2];
            for (int i = 0; i < m; i++) {
                sales[i][0] = in.nextDouble();
                sales[i][1] = in.nextDouble();
            }
//        System.out.println(Arrays.deepToString(prices));
//        System.out.println(Arrays.deepToString(sales));
            double res = 0, sum = 0;
            for (int i = 0; i < n; i++) {
                sum += prices[i][0];
                res += prices[i][1] == 1 ? prices[i][0] * 0.8 : prices[i][0];
            }

            for (int i = 0; i < m; i++) {
                if (sum >= sales[i][0]) {
                    res = Double.min(res, sum - sales[i][1]);
                }
            }

            System.out.printf("%.2f", res);
        }
    }

    static void case2() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            System.out.println(case2(nums, k));
        }
    }

    static int case2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int coin : nums) {
            for (int i = coin; i <= target; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % 100000007;
            }
        }
        return dp[target];
    }

    static void case1() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(sell(nums));
        }
    }

    static int sell(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(sell(nums, 0, nums.length - 2), sell(nums, 1, nums.length - 1));
    }

    static int sell(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
}
