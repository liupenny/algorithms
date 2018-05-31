package Maximum_Swap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Maximum_Swap {
    public int maximumSwap(int num) {
        if(num <= 10)
            return num;

        char[] digits = Integer.toString(num).toCharArray(); //记录num中的每一位
        int[] buckets = new int[10];

        for (int i = 0; i < digits.length; i++) { 
            buckets[digits[i] - '0'] = i;  //从最高位开始，记录num中每个数最后出现的index
        }

        for (int i = 0; i < digits.length; i++) {   //从num的最高位开始，从9依次往下，找到num中后面的某一位比当前位大，进行交换
            for (int d = 9; d > digits[i] - '0'; d--) {  //d需要比数字digits[i]大
                if (buckets[d] > i) {  //如果d的位置在i后面,则交换
                    char tmp = digits[i];
                    digits[i] = digits[buckets[d]];
                    digits[buckets[d]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Maximum_Swap t = new Maximum_Swap();
        int num = 222;
        System.out.println(t.maximumSwap(num));
    }
}
