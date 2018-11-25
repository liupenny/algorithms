package array.Valid_Triangle_Number;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int num = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = i + 2; k < nums.length ; k++) {
                while (j < k && (nums[i] + nums[j] <= nums[k])) {
                    j++;
                }
                num += k - j;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Valid_Triangle_Number t = new Valid_Triangle_Number();
        int[] nums = {2,2,3,4};
        System.out.println(t.triangleNumber(nums));
    }
}
