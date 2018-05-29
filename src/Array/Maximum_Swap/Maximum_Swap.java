package Array.Maximum_Swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Maximum_Swap {
    public int maximumSwap(int num) {
        if(num <= 10)
            return num;

        int[] nums = new int[9];
        Arrays.fill(nums, -1);
        int index = 1;
        // LinkedList<Integer> ans = new LinkedList<>();  // 这里如果写 List<Integer> ans = new LinkedList<>(); 是没有addFirst方法的
        while (num > 0)
        {
            int left = num % 10;
            nums[index++] = left;
            num /= 10;
        }

        int bigIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            //biggest = Math.max(biggest, nums[i]);
            if(nums[i] == -1)
                break;
            if(nums[bigIndex] < nums[i])
                bigIndex = i;
        }

        if(bigIndex == 2 && nums[1] >= nums[bigIndex])
        {
           return num;
        }
        else if(bigIndex != 2 && nums[1] >= nums[bigIndex])
        {

            swap(nums, 2, bigIndex);
        }
        else// if(bigIndex == 2 && nums[1] < nums[2])
        {
            swap(nums, 1, bigIndex);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == -1)
                break;
            sb.append(nums[i]);
        }
        int ret = Integer.valueOf(sb.toString());
        return ret;
    }

    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Maximum_Swap t = new Maximum_Swap();
        int num = 9730;
        System.out.println(t.maximumSwap(num));
    }
}
