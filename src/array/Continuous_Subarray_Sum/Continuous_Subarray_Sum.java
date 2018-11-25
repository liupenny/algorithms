package array.Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/5/9.
 */
public class Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k)
    {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        Map<Integer, Integer> arrSum = new HashMap<>();
        arrSum.put(0,-1);
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(k != 0)
            {
                sum %= k;
            }
            Integer pos = arrSum.get(sum);
            if (pos != null)   //不等于null的时候判断一下pos跟i的差距是否有2
            {
                if(i -pos > 1) {
                    return true;
                }
            }
            else  //等于Null的时候，才加入数据。否则出现就加，会导致相同元素更新了两次位置
            {
                arrSum.put(sum,i);
            }
        }
        return false;
    }

    public boolean checkSubarraySum1(int[] nums, int k)
    {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        Map<Integer, Integer> arrSum = new HashMap<>();
        arrSum.put(0,-1);
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(k != 0) {
                sum %= k;
            }
            Integer pos = arrSum.get(sum);
            if (pos != null && (i -pos) > 1)  //这里逻辑有问题
            {
                return true;
            } else {
                arrSum.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Continuous_Subarray_Sum t = new Continuous_Subarray_Sum();
        int[] nums = {0,0};
        int k=0;
        System.out.println(t.checkSubarraySum(nums,k));
    }
}
