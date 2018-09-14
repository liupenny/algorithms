package Dynamic_Programming.Target_Sum;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/7/12.
 */

public class Solution{
    public int ans = 0;
    public int findTargetSumWays_brute(int[] nums, int S) {
        if(nums == null || nums.length == 0 && S != 0) {
            return 0;
        }

        isSum(nums, 0, 0, S);
        return ans;
    }

    public void isSum(int[] nums, int index, int sum, int S)
    {
        if(index == nums.length)
        {
            if(sum == S) {
                ans++;
            }
            return;
        }

        isSum(nums, index+1, sum - nums[index], S);
        isSum(nums, index+1, sum + nums[index], S);

    }


    public int findTargetSumWays_mem(int[] nums, int S) {
        if (nums == null || nums.length == 0 && S != 0) {
            return 0;
        }
        // memo[i][j]表示计算到第i个数字，目前的和为j时：后面的数字加减起来，符合条件要求的S有多少种。
        // 和最高设定为2001是因为，题目中给出所有数字的和不超过1000，但有可能要求的S是-1000
        // 为了保证所有数字的和都能有合法的下标，所以加上1000这个offset
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calaulate(nums, 0, 0, S, memo);
    }

    public int calaulate(int[] num, int index, int sum, int S, int[][] memo)
    {
        if(index == num.length)
        {
            if(sum == S) {
                return 1;
            } else {
                return 0;
            }
        }
        else {
            //计算到Index,且和为sum+1000时的答案已经算了
            if(memo[index][sum+1000] != Integer.MIN_VALUE) {
                return memo[index][sum + 1000];
            }
            int add = calaulate(num, index + 1, sum + num[index], S, memo);
            int substract = calaulate(num, index + 1, sum - num[index], S, memo);
            // 计算到index时得到的和为sum+1000，
            memo[index][sum + 1000] = add + substract;
            return memo[index][sum + 1000];
        }
    }

    public int findTargetSumWays_dp(int[] nums, int S) {
        if (nums == null || nums.length == 0 && S != 0) {
            return 0;
        }

        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if(sum < S) {
            return 0;
        }

        int[][] ways = new int[nums.length][2001];
        ways[0][nums[0] + 1000] = 1;
        // 这里写 += 1，是因为0的时候，+0，-0都是可以的，且+0，-0 + 1000 的结果都是1000
        // 所以必须要写上 +=
        ways[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if(ways[i - 1][j + 1000] > 0)
                {
                    ways[i][j + 1000 + nums[i]] += ways[i - 1][j + 1000];
                    ways[i][j + 1000 - nums[i]] += ways[i - 1][j + 1000];
                }
            }
        }
        return ways[nums.length - 1][S + 1000];
    }

    //只用一维数组
    public int findTargetSumWays_onearray(int[] nums, int S) {
        if (nums == null || nums.length == 0 && S != 0) {
            return 0;
        }

        int[] ways = new int[2001];
        ways[nums[0] + 1000] = 1;
        ways[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] tmp = new int[2001];
            for (int j = -1000; j <= 1000 ; j++) {
                if(ways[j + 1000] > 0)
                {
                    tmp[j + 1000 + nums[i]] += ways[j + 1000];
                    tmp[j + 1000 - nums[i]] += ways[j + 1000];
                }
            }
            ways = tmp;
        }
        return S > 1000 ? 0 : ways[S + 1000];
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int S = 3;
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.findTargetSumWays_mem(nums, S));
    }
}