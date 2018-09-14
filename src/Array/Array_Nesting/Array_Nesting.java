package Array.Array_Nesting;

import java.util.HashSet;

/**
 * Created by PennyLiu on 2018/5/7.
 */
public class Array_Nesting {
    // 最基础的办法是轮流算一下从每个数开始加入，最多能加多少个
    public int arrayNesting(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int start = nums[i], count = 0;
            do
            {
                start = nums[start];
                count++;
            }
            while (start != nums[i]); //当前的角标和加入角标对比
            res = Math.max(res,count);
        }
       return res;
    }

    // 访问数组标记
    public int arrayNesting1(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            if(!visited[i])
            {
                int start = nums[i], count = 0;
                do
                {
                    start = nums[start];
                    count++;
                }
                while (start != nums[i]);
                res = Math.max(res,count);
            }
        }
        return res;
    }


    // 不用访问数组
    public int arrayNesting2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }


    public static void main(String[] args)
    {
        Array_Nesting t = new Array_Nesting();
        int[] nums = {0,3,4,5,1,2};
        System.out.println(t.arrayNesting(nums));
    }
}
