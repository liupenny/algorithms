package Bit_Manipulation.Sum_of_Two_Integers;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        if(a==0) return b;

        int carry = 0, sum = 0;
        sum = a ^ b;
        carry = (a&b)<<1;
        return getSum(carry,sum);
    }

    public static void main(String[] args) {
        Sum_of_Two_Integers t = new Sum_of_Two_Integers();
        System.out.println(t.getSum(4,5));
    }
}
