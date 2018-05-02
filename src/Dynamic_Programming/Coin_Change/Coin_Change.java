package Dynamic_Programming.Coin_Change;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/4/24.
 */
public class Coin_Change {
    public int coinChange(int[] coins, int amount)
    {
        // return coinChange(0,coins,amount);
        // return coinChange1(coins.length-1,coins,amount);
        // return coinChange(coins,amount,new int[amount]);
        return coinChangesub(coins, amount);
    }

    //需要用的硬币数逐渐向上加，最后返回的minCost是正确的。但是会超时
    public int coinChange(int idxCoin, int[] coins, int amount)
    {
        if(amount == 0)
            return 0;
        if(idxCoin < coins.length && amount > 0)
        {
            int maxVal = amount/coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++)
            {
                if (amount >= x * coins[idxCoin])
                {
                    int res = coinChange(idxCoin+1, coins, amount - x * coins[idxCoin]);
                    if(res != -1)
                        minCost = Math.min(minCost,res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }

    // 从上往下，但是一下子就到最底部，从下面的挨个算上来，就得到的最后的结果
    public int coinChange(int[] coins, int rem, int[] count)
    {
        if(rem < 0) return -1;
        if(rem == 0) return 0;
        if(count[rem-1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;
        for (int coin: coins)
        {
            int res = coinChange(coins,rem - coin,count);
            if(res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

    //从下向上,在算出 amount 之前，把amount前面的求出来，
    public int coinChangesub(int[] coins, int amount)
    {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max); //
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < coins.length; j++)
            {
                if(coins[j] <= i)

                {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; //用这个条件判断该数无法被组成
        // return dp[amount]==max ? -1 : dp[amount];  这么判断也可以

    }


    public static void main(String[] args) {
        int[] coins = {1,3,5};
        int amount = 11;
        Coin_Change t = new Coin_Change();
        System.out.println(t.coinChange(coins,amount));
    }
}
