package Array.Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Shortest_Unsorted_Continuous_Subarray {
    // 克隆一个数组，对他进行排序，比较一下
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] num = nums.clone();  //这里要克隆，不然会修改原来数组
        Arrays.sort(num);
        int begin = 0, end = 0;
        for (int i = 0; i < num.length; i++) {
            if(nums[i] != nums[i])
            {
                begin = Math.min(begin, i);  //这里的比较方法记一下，很有意义
                end = Math.max(end,i);
            }
        }
        return end-begin >= 0 ? end - begin + 1: 0;
    }

    //利用数组性质，寻找数值本来该在的位置
    public int findUnsortedSubarray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int begin = -1, end = -2;
        int min = nums[nums.length - 1], max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - 1 - i]);

            if(max > nums[i])
                end = i;
            if(nums[nums.length - 1 - i] > min)
                begin = nums.length - 1 - i;
        }
        return end - begin + 1; //// if array is already in ascending order, -2 - (-1) + 1 = 0
    }

    public int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Shortest_Unsorted_Continuous_Subarray t = new Shortest_Unsorted_Continuous_Subarray();
        // int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums = {1,2,3,2,3,4,3,4,5};
        System.out.println(t.findUnsortedSubarray1(nums));
    }
}
