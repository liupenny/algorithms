package Array.Max_Consecutive_Ones;

/**
 * Created by PennyLiu on 2018/4/12.
 */
public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            }
            else {
                count = 0;
            }
        }

        return result;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums) {
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] num = {1,1,0,1,1,1};
        Max_Consecutive_Ones a = new Max_Consecutive_Ones();
        System.out.println(a.findMaxConsecutiveOnes(num));
    }
}
