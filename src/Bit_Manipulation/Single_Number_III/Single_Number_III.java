package Bit_Manipulation.Single_Number_III;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int bit = 0, sum = 0;
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }
        bit = (sum & (~(sum -1)));
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&bit) == 0)
            {
                res[0] ^= nums[i];
            }
            else
            {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Single_Number_III t = new Single_Number_III();
        System.out.println(t.singleNumber(new int[]{2,2,4,5})[0]);
    }
}
