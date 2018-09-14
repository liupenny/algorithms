package Array.Maximum_Average_SubarrayI;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Maximum_Average_SubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            ans = Math.max(ans, sum);
        }
        double res = (double) ans / (double)k;
        return res;
    }

    // 存一个累加和数组
    public double findMaxAverage_Cumulative_Sum(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        double res = sum[k-1]/k;
        for (int i = k; i < nums.length; i++) {
            res = Math.max(res, (sum[i] - sum[i-k]) * 1.0 / k);
        }
        return res;
    }

    public double findMaxAverage_Sliding_Window(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        double sum = 0;
        for(int i = 0; i < k; i++)  //先算一下前4个数的和，后面每次增加一个就减去最前面那个
        {
            sum += nums[i];
        }

        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            res = Math.max(res, sum);
        }
        return res/k;
    }

    public static void main(String[] args) {
        Maximum_Average_SubarrayI t = new Maximum_Average_SubarrayI();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(t.findMaxAverage(nums, k));
    }
}
