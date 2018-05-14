package Array.Best_Time_to_Buy_and_Sell_StockIII;

/**
 * Created by PennyLiu on 2018/5/10.
 */
public class Best_Time_to_Buy_and_Sell_StockIII {
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0)
            return 0;

        int[] local = new int[3]; //每一天都算一下当前天数只进行2次交易
        int[] global = new int[3];

        for (int i = 1; i < prices.length; i++)
        {
            int diff = prices[i] - prices[i-1];
            for (int j = 2; j >= 1; j--) //这里要从2开始是因为，到了新的一天，其交易是最新的，应该从后面开始更新
            {
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }

    public int maxProfit1(int[] prices)
    {
        if (prices == null || prices.length <= 1)
            return 0;
        int profit = 0;
        int min = prices[0];
        int[] arrFor = new int[prices.length];
        int max = prices[prices.length - 1];
        int[] arrBack = new int[prices.length];

        for (int i = 1; i < prices.length; i++)  //从前往后算一遍
        {
            min = Math.min(min, prices[i]);
            arrFor[i] = Math.max(arrFor[i-1], prices[i] - min);
        }

        for (int i = prices.length - 2; i >= 0; i--)
        {
            max = Math.max(max, prices[i]);
            arrBack[i] = Math.max(arrFor[i+1], max - prices[i]);
        }

        for (int i = 0; i < prices.length; i++)
        {
            profit = Math.max(profit,arrFor[i] + arrBack[i]);
        }
        return profit;
    }

    public int maxProfit2(int[] prices) 
    {
        if (prices == null || prices.length <= 1)
            return 0;
        
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < prices.length; i++)
        {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_StockIII t = new Best_Time_to_Buy_and_Sell_StockIII();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(t.maxProfit(prices));
    }
}
