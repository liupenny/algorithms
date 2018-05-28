package Array.Increasing_Triplet_Subsequence;

/**
 * Created by PennyLiu on 2018/5/23.
 */
public class Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums)
    {
        if (nums == null || nums.length < 3)
            return false;

        int[] dp = new int[3];
        int len = 0;
        for (int num: nums)
        {
            int i = 0, j = len;
            while (i != j)
            {
                int mid = (i + j)/2;
                if( dp[mid] < num)
                    i = mid + 1;
                else
                    j = mid;
            }
            dp[i] = num;
            if(i == len)
                ++len;
            if(len == 3)
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Increasing_Triplet_Subsequence t = new Increasing_Triplet_Subsequence();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(t.increasingTriplet(nums));
    }
}
