package Bit_Manipulation.Binary_Number_with_Alternating_Bits;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Binary_Number_with_Alternating_Bits {
    public boolean hasAlternatingBits(int n) {
        if(n <= 1) return true;

        int bit = -1;
        while (n>0)
        {
            if((n&1) == 1)
            {
                if(bit == 1) return false;
                bit = 1;
            }
            else
            {
                if(bit == 0) return false;
                bit = 0;
            }
            n>>=1;
        }
        return true;
    }

    public static void main(String[] args) {
        Binary_Number_with_Alternating_Bits t = new Binary_Number_with_Alternating_Bits();
        System.out.println(t.hasAlternatingBits(5));
    }
}
