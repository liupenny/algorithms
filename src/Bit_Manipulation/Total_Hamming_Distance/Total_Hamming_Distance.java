package Bit_Manipulation.Total_Hamming_Distance;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int res , cnt = 0;
        for (int i = 0; i < 32; i++)  //这里必须是从0开始，不能从1.因为是进位的数
        {
            res = 0;
            for (int j = 0; j < nums.length; j++) {
                if((nums[j]&(1<<i))!=0)
                {
                    res++;
                }
            }
            cnt += res * (nums.length - res);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Total_Hamming_Distance t = new Total_Hamming_Distance();
        System.out.println(2&(1<<1));
        System.out.println(t.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
