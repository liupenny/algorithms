package array.MajorityElement;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/4
 */
public class Solution {
//    public int MoreThanHalfNum_Solution(int [] array) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        int pivot = array[0];
//        int low = -1, high = array.length , cur = 0;
//        while (cur < high) {
//            if (array[cur] < pivot) {
//                swap(array, ++low, cur++);
//            } else if (array[cur] > pivot) {
//                swap(array, --high, cur);
//            } else {
//                cur++;
//            }
//        }
//        int ans = array[array.length/2];
//        if (checkArray(array, ans) == true) {
//            return ans;
//        } else {
//            return 0;
//        }
//    }
//
//    public void swap(int[] array, int x, int y) {
//        int tmp = array[x];
//        array[x] = array[y];
//        array[y] = tmp;
//    }
//
//    // 题目没说一定会有这个数存在，所以要验证
//    public boolean checkArray(int[] array, int num) {
//        int times = 0;
//        int len = array.length;
//        for (int a : array) {
//            if (a == num) {
//                times++;
//            }
//        }
//        return times > len/2;
//    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int pivot = nums[0];
        int low = -1, high = nums.length, cur = 0;
        while (cur < high) {
            if (nums[cur] < pivot) {
                swap(nums, ++low, cur++);
            } else if (nums[cur] > pivot) {
                swap(nums, --high, cur);
            } else {
                cur++;
            }
        }
        return nums[nums.length/2];
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {-1,1,1,1,2,1};
        Solution s = new Solution();
        System.out.println(s.majorityElement(a));
    }
}