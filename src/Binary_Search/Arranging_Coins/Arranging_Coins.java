package Binary_Search.Arranging_Coins;

/**
 * Created by PennyLiu on 2018/1/8.
 */
public class Arranging_Coins {
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }

    public static void main(String[] algs)
    {
        int nums=3;
        Arranging_Coins test = new Arranging_Coins();
        System.out.println(test.arrangeCoins(nums));
    }
}
