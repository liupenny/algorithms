package array.Increasing_Triplet_Subsequence;

/**
 * Created by PennyLiu on 2018/5/23.
 */
public class Increasing_Triplet_Subsequence {
    // 遍历更新最小的数和次小的数，如果某个数大于这两个数，则有三个数递增，返回true.
    public boolean increasingTriplet(int[] nums)
    {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= firstMin) {
                firstMin = nums[i];
            } else if(nums[i] <= secondMin) {
                secondMin = nums[i];
            } else {
                return true;
            }
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
