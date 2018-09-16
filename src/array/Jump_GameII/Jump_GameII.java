package array.Jump_GameII;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/6/7.
 */
public class Jump_GameII {
    public int jump_brute(int[] nums) { //从后往前比较，依次选择走的步数较少的，超时
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int lastPos = i + nums[i];
            if(lastPos >= nums.length - 1) {
                dp[i] = 1;
            } else {
                for (int j = i; j <= i + nums[i]; j++) {
                    if (dp[j] != -1) {
                        dp[i] = dp[i] == -1 ? dp[j] + 1: Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[0];
    }

    public int jump(int[] nums) { //从后往前比较，依次选择走的步数较少的，超时
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int step = 0, possibleEnd = 0, lastPos = 0; //possibleEnd是走step步最远可能到达的index
        for (int i = 0; i < nums.length - 1; i++) { //lastPos是从 0 -- i 能走的最远距离
            lastPos = Math.max(lastPos, i + nums[i]);
            if( i == possibleEnd)  //当i到了possibleEnd,我们知道我们要再走一步了，所以step++
            {
                step++;
                possibleEnd = lastPos; //题目中说了一定能到最后，所以possibleEnd 和 lastPos >= num.length - 1
            }
        }
        return step;
    }

    public int jump_window(int[] nums) {
        int window_left = 0;
        int window_right = 0;
        int steps = 0;

        while (window_right < nums.length - 1) {
            steps ++;
            int j = window_right;
            while (window_left <= j) {
                window_right = Math.max(window_right, nums[window_left] + window_left);
                if (window_right >= nums.length - 1) {
                    break; // reaches the end, no need to continue
                }
                window_left ++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        Jump_GameII t = new Jump_GameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(t.jump(nums));
    }
}
