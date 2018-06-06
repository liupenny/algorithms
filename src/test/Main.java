package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         caseM4();
    }

    static void caseM4()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt(), C = in.nextInt();

        int[] weight = new int[m]; //m轮比赛的权重
        int weightSum = 0;  //m轮比赛的权重和
        for (int i = 0; i < m; i++) {
            weight[i] = in.nextInt();
            weightSum += weight[i];
        }

        int[][] score = new int[n][m];
        int[] maxScore = new int[m]; //m轮比赛中，每轮比赛中的最高分
        int lostN = 0, lostM = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = in.nextInt();
                if(score[i][j] == -1)
                {
                    lostN = i;  //缺失的数据是第i个人的
                    lostM = j;  //缺失的数据是第j轮比赛的
                }
                if(score[i][j] > maxScore[j])
                    maxScore[j] = score[i][j];
            }
        }

        HashMap<Integer, Double> weighted_score = new HashMap<>(); //存放权重分数的map
        // int[] weighted_score = new int[n];
        for (int i = 0; i < n; i++) {
            if(i != lostN) {
                for (int j = 0; j < m; j++) {
                    double tmpScore = 0;
                    if(j != lostM && maxScore[j] != 0)
                    {
                        tmpScore += (double)score[i][j] / (double)maxScore[j] * (double) weight[j] / (double) weightSum;
                    }
                    weighted_score.put(i, tmpScore);
                }
            }
        }

        class ValueComparator implements Comparator<Map.Entry<Integer, Double>>
        {
            public int compare(Map.Entry<Integer, Double> map1, Map.Entry<Integer, Double> map2)
            {
                double ret = map2.getValue() - map1.getValue();
                if (ret > 0.0)
                    return 1;
                else if(ret == 0.0)
                    return 0;
                else
                    return -1;
            }
        }

        if(C <= maxScore[lostM]) {
            double tmpScore = 0.0;
            for (int i = 0; i < n; i++) {
                if (maxScore[lostM] != 0 && i != lostN) {
                    tmpScore = (double) score[i][lostM] / (double) maxScore[lostM] * (double) weight[lostM] / (double) weightSum;
                }
                weighted_score.put(i, tmpScore);
            }
            double tmplostNScore = (double) C / (double) maxScore[lostM] * (double) weight[lostM] / (double) weightSum;
            weighted_score.put(lostN, tmplostNScore);
        }

        else
        {
            double tmpScore = 0.0;
            for (int i = 0; i < n; i++) {
                if (maxScore[lostM] != 0 && i != lostN) {
                    tmpScore = (double) score[i][lostM] / (double) C * (double) weight[lostM] / (double) weightSum;
                }
                weighted_score.put(i, tmpScore);
            }
            double tmplostNScore = 1.0 * (double) weight[lostM] / (double) weightSum;
            weighted_score.put(lostN, tmplostNScore);
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>();
        list.addAll(weighted_score.entrySet());
        ValueComparator vc = new ValueComparator();
        Collections.sort(list,vc);
    }




    static void caseM2()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt(), t = n - m;  //m是小美要喝的可乐数,t是小团要喝的可乐数
        int[][] happy = new int[k][2];
        int ansIndex = 0;
        for (int i = 0; i < k; i++) {
            happy[i][0] = in.nextInt(); //小美的快乐
            happy[i][1] = in.nextInt(); //小团的快乐
        }

        int expectTemp = 0, expectMax = 0;
        for (int i = 0; i < k; i++) {
            expectTemp = happy[i][0] * m + happy[i][1] * t;
            if(expectTemp > expectMax)
                ansIndex = i;
        }

        for (int i = 0; i < k - 1; i++) {
            if(i == ansIndex)
                System.out.print(n);
            else
                System.out.print(0);
            System.out.print(" ");
        }
        if(ansIndex == k - 1)
            System.out.print(n);
        else
            System.out.print(0);
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
