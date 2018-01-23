package Dynamic_Programming.Counting_Bits;

/**
 * Created by PennyLiu on 2018/1/22.
 */
public class Counting_Bits {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i =1; i<=num; i++)
            ans[i] = ans[i/2] + i%2;
        return ans;
    }

    public int[] countBits1(int num) {
        int result[] = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index){
            if (offset * 2 == index){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }

    public static void main(String[] algs)
    {
        int A = 8;
        Counting_Bits t = new Counting_Bits();
        System.out.println(t.countBits(A));
    }
}
