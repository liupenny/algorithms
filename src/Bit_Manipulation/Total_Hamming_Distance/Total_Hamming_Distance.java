package Bit_Manipulation.Total_Hamming_Distance;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int tmp = 0, res = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i+1; j < nums.length; j++)
            {
                tmp = nums[i] ^ nums[j];
                res += Integer.bitCount(tmp);
            }
        return res;
    }

    public static void main(String[] args) {
        Total_Hamming_Distance t = new Total_Hamming_Distance();
        System.out.println(t.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
