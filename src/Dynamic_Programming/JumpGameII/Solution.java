package Dynamic_Programming.JumpGameII;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/18
 */
public class Solution {
    public static int jump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, last = 0;
        int[] f = new int[n];
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            while (i > last + nums[last]) {
                last++;
            }
            f[i] = f[last] + 1;
        }
        return f[n-1];
    }

    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //last是上一步能到达的最远位置，cur是当前能到达的最远位置
        int step = 0, last = 0, cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = Math.max(cur, i + nums[i]);
            if( i == last)
            {
                step++;
                last = cur;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        //System.out.println(jump1(a));
        System.out.println(jump(a));
    }
}
