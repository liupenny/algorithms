package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        t.caseM4_Answer();
    }

    // 对着正确的思路改
    class Person implements Comparable<Person>{  //因为最后要对所有人分数进行排序，所以定义一个结构体比较方便
        int index;
        double score;

        @Override
        public int compareTo(Person p)
        {
            if (Double.doubleToLongBits(this.score) > Double.doubleToLongBits(p.score))
                return -1;
            else if (Double.doubleToLongBits(this.score) == Double.doubleToLongBits(p.score))
                return 0;
            else
                return 1;
        }
    }

    public void caseM4_Answer()
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt(), C = in.nextInt();

        int[] weight = new int[m]; //m轮比赛的权重
        long  weightSum = 0;  //m轮比赛的权重和
        for (int i = 0; i < m; i++) {
            weight[i] = in.nextInt();
            weightSum += weight[i];
        }

        int[][] score = new int[n][m];
        int lostN = 0, lostM = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = in.nextInt();
                if(score[i][j] == -1)
                {
                    lostN = i;  //缺失的数据是第i个人的
                    lostM = j;  //缺失的数据是第j轮比赛的
                }
            }
        }

        Person[] people = new Person[n];  //对象数组中每个对象也要初始化
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person();
        }

        int[] ans = new int[n];  //每一轮比赛算完的结果
        Arrays.fill(ans, -1);

        for (int c = 0; c <= C; c++) {  //从0到C模拟缺失的分数
            for (int i = 0; i < n; i++) { //重新给当前的人赋值
                people[i].index = i;
                people[i].score = 0.0;
            }

            score[lostN][lostM] = c;

            for (int j = 0; j < m; j++) { // 当前C下每个人的总分
                int max = -1;
                for (int i = 0; i < n; i++) {
                    max = Math.max(max, score[i][j]); //每一轮的最高分
                }
                for (int i = 0; i < n; i++) {
                    if(max > 0) //当max>0的时候计算
                    {
                        people[i].score += 1.0 * score[i][j] / max * (1.0 * weight[j] / weightSum);
                    }
                }
            }

            Arrays.sort(people);  //按照这一个C的情况进行分数排序

            for (int i = 0; i < n; i++) {
                if(i < k)
                {
                    if(ans[people[i].index] == -1)
                    {
                        ans[people[i].index] = 1;
                    }
                    else if(ans[people[i].index] == 1)
                    {
                        ans[people[i].index] = 1;
                    }
                    else
                    {
                        ans[people[i].index] = 3;
                    }
                }
                else
                {
                    if(ans[people[i].index] == -1)
                    {
                        ans[people[i].index] = 2;
                    }
                    else if(ans[people[i].index] == 1)
                    {
                        ans[people[i].index] = 3;
                    }
                }
            }

            // 只对成绩在k周围
            if(k < n && people[k-1].score == people[k].score)
            {
                for (int i = 0; i < n; i++) {
                    if (people[i].score == people[k-1].score)
                        ans[people[i].index] = 3;
                }
            }
        }
        // 打印结果
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }

    // 对着官方答案改的
    static void caseM2_Answer() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();

        long maxE = Long.MIN_VALUE;
        int pos = 0;

        for (int i = 1; i <= k; i++) {
            int a = in.nextInt(), b = in.nextInt();
            long E = 1L * m * a + 1L * (n - m) * b;
            if(E >= maxE)
            {
                maxE = E;
                pos = i;
            }
        }

        // 格式化输出，解决空格问题
        for (int i = 1; i <= k; i++) {
            System.out.printf("%d%c", i == pos ? n : 0, i == k ? '\n' : ' ');
        }
    }

    // 自己写的
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

        // 输出的问题
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
