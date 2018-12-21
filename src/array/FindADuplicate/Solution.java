package array.FindADuplicate;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/21
 */
public class Solution {
    public int duplicateInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        // 要一开始单独判断一次，不然在后面交换的过程中，会将不在范围内的数组元素交换到前面已经处理过的位置，就漏掉了
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] >= n) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == nums[i]) {
                continue;
            } else {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    swap(nums, i, nums[i]);
                }
            }
        }
        return -1;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int duplicateInArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 1, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start)/2;
            int count = countRange(nums, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                }
                break;
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] nums, int begin, int end) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= begin && nums[i] <= end) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution a = new Solution();
        int[] aa = {};
        System.out.println(a.duplicateInArray1(aa));
    }
}
