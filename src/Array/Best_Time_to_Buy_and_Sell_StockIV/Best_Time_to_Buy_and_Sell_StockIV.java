package Array.Best_Time_to_Buy_and_Sell_StockIV;

/**
 * Created by PennyLiu on 2018/5/10.
 */
public class Best_Time_to_Buy_and_Sell_StockIV {
    public int maxProfit(int k, int[] prices)
    {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        if(k >= prices.length/2)
        {
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
            {
                if(prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int n = prices.length, diff = 0;
        int[][] locolProfit = new int[n][k+1];
        int[][] globalProfit = new int[n][k+1];

        for (int i = 1; i < n; ++i)
        {
            diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; ++j)
            {
                locolProfit[i][j] = Math.max(locolProfit[i-1][j] + diff, globalProfit[i-1][j-1] + Math.max(0,diff));
                globalProfit[i][j] = Math.max(locolProfit[i][j], globalProfit[i-1][j]);
            }
        }
        return globalProfit[n-1][k];
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_StockIV t = new Best_Time_to_Buy_and_Sell_StockIV();
        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 3;
        System.out.println(t.maxProfit(k,prices));
    }
}
