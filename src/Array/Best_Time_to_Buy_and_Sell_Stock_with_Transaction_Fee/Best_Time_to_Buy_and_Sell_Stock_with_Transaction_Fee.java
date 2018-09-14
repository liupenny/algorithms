package Array.Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

/**
 * Created by PennyLiu on 2018/5/15.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public int maxProfit(int[] prices, int fee)
    {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int cash = 0; //the maxPro you have if you don't have a stock that day
        int hold = -prices[0];  //the maxPro you have if you have a stock that day, if you have a stock the first day,hold=-prices[0]
        for (int i = 1; i < prices.length; i++)
        {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }



    public int maxProfit2(int[] prices, int fee)
    {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0, maxPrice = prices[0], res = 0, start = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[start] - fee > maxProfit) {
                maxPrice = prices[i];
                maxProfit = prices[i] - prices[start] - fee;
            } else if (prices[i] < maxPrice - fee || prices[i] < prices[start]) {
                start = i;
                res += maxProfit;
                maxProfit = 0;
                maxPrice = prices[i];
            }
        }
        if (maxProfit != 0) {
            res += Math.max(maxProfit, prices[prices.length - 1] - prices[start] - fee);
        }
        return res;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee t = new Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int[] prices1 = {1,3,7,5,10,3};
        int fee1 = 3;
        // System.out.println(t.maxProfit1(prices, fee));
        System.out.println(t.maxProfit2(prices1, fee1));
    }
}
