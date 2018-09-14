package heap.Sliding_Window_Maximum;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2018/7/10.
 */

public class Solution{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return null;
        }
        if(nums.length == 0) {
            return new int[0];
        }

        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        ans[0] = queue.peek();
        // 以数组元素角标为标准考虑ans的下标
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            ans[i - k + 1] = queue.peek();
        }
        ans[ans.length-1] = queue.peek();
        return ans;
    }

    public int[] maxSlidingWindow_array(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }

        int[] max_left = new int[nums.length];
        int[] max_right = new int[nums.length];

        max_left[0] = nums[0];
        max_right[nums.length-1] = nums[nums.length-1];

        for (int i = 1, j ; i < nums.length; i++) {
            max_left[i] = ( i%k == 0) ? nums[i] : Math.max(max_left[i-1], nums[i]);

            j = nums.length - i - 1;
            max_right[j] = ( j%k == 0) ? nums[j] : Math.max(max_left[j+1], nums[j]);
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = 0; j < nums.length - k + 1; i++) {
            res[j++] = Math.max(max_right[i], max_left[i + k - 1]);
        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = s.maxSlidingWindow_array(nums,k);
        for (int a: ans) {
            System.out.print(a + " ");
        }
    }
}