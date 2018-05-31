package Array.Largest_Number_At_Least_Twice_of_Others;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i == maxIndex)
                continue;
            if(nums[maxIndex] < nums[i] * 2)
                return -1;
        }
        return maxIndex;
    }


    public static void main(String[] args) {
        Largest_Number_At_Least_Twice_of_Others t = new Largest_Number_At_Least_Twice_of_Others();
        int[] nums = {1, 2, 3, 4};
        System.out.println(t.dominantIndex(nums));
    }
}
