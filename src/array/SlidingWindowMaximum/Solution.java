package array.SlidingWindowMaximum;

import java.util.LinkedList;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k < 1 || nums.length < k) {
            return null;
        }
        LinkedList<Integer> max = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
                max.pollLast();
            }
            max.offerLast(i);
            if (max.peekFirst() == i - k) {
                max.pollFirst();
            }
            if (i >= k -1) {
                ans[index++] = nums[max.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        int[] aa = maxSlidingWindow(a,3);
        for(int num : aa) {
            System.out.print(num + " ");
        }
    }
}
