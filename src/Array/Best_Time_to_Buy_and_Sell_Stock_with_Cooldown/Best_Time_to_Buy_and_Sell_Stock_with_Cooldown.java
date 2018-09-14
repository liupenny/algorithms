package Array.Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

/**
 * Created by PennyLiu on 2018/5/16.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for (int price: prices)
        {
            int T_ik0_old = T_ik0; //记录T[i-1][k][0]
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old; //记录T[i-2][k][0]
        }
        return T_ik0;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_with_Cooldown t = new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(t.maxProfit(prices));
    }
}
