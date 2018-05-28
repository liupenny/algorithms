package Array.Maximum_Swap;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Maximum_Swap {
    public int maximumSwap(int num) {
        if(num <= 10)
            return num;

        String strNum = String.valueOf(num);
        char big = '0';
        for (int i = 0; i < strNum.length(); i++) {
            if(strNum.charAt(i) > big)
                big = strNum.charAt(i);
        }
    }

    public static void main(String[] args) {
        Maximum_Swap t = new Maximum_Swap();
    }
}
