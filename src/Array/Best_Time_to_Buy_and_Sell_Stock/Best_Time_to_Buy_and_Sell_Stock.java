package Array.Best_Time_to_Buy_and_Sell_Stock;

/**
 * Created by PennyLiu on 2018/5/10.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit_burte(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++)
        {
            int begin = prices[i];
            for (int j = i+1; j < prices.length; j++)
            {
                profit = Math.max(profit,prices[j] - begin);
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices)
    {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++)
        {
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock t = new Best_Time_to_Buy_and_Sell_Stock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(t.maxProfit(prices));
    }
}
