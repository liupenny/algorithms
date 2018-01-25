package Bit_Manipulation.Prime_Number_of_Set_Bits_in_Binary_Representation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/1/25.
 */
public class Prime_Number_of_Set_Bits_in_Binary_Representation {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));

        int res = 0;
        for (int i = L; i <= R ; i++) {
            if(primes.contains(Integer.bitCount(i))) res += 1;
        }
        return res;
    }

    public static void main(String[] algs)
    {
        Prime_Number_of_Set_Bits_in_Binary_Representation t = new Prime_Number_of_Set_Bits_in_Binary_Representation();
        System.out.println(t.countPrimeSetBits(3,5));
    }
}
