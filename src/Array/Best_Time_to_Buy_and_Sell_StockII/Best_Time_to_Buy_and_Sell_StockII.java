package Array.Best_Time_to_Buy_and_Sell_StockII;

/**
 * Created by PennyLiu on 2018/5/10.
 */
public class Best_Time_to_Buy_and_Sell_StockII {
    public int maxProfit(int[] prices)
    {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int minprice = prices[0];
        for (int i = 0; i < prices.length; i++)
        {
            if(minprice > prices[i]) {
                minprice = prices[i];
            } else
            {
                profit += prices[i] - minprice;
                minprice = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_StockII t = new Best_Time_to_Buy_and_Sell_StockII();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(t.maxProfit(prices));
    }
}
