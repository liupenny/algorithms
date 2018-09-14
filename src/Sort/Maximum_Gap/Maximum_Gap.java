package Sort.Maximum_Gap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by PennyLiu on 2017/9/23.
 */
public class Maximum_Gap {
// 使用桶排序。桶为一个数据容器，每个桶存储一个区间内的数。依然有一个待排序的整数序列A，元素的最小值不小于0，最大值不超过K。
// 假设我们有M个桶，第i个桶Bucket[i]存储i*K/M至(i+1)*K/M之间的数。
// 思路：假设有N个元素A到B。
//    那么最大差值不会小于ceiling[(B - A) / (N - 1)](***向上取整***)
//    令bucket（桶）的大小len = ceiling[(B - A) / (N - 1)]，则最多会有(B - A) / len + 1个桶
//    对于数组中的任意整数K，很容易通过算式loc = (K - A) / len找出其桶的位置，然后维护每一个桶的最大值和最小值
//    由于同一个桶内的元素之间的差值至多为len - 1，因此最终答案不会从同一个桶中选择。
//    对于每一个非空的桶p，找出下一个非空的桶q，则q.min - p.max可能就是备选答案。返回所有这些可能值中的最大值。
    public int maximumGap(int[] nums) {
        int len = nums.length;
        int index;
        if(len < 2 || nums==null) {
            return 0;
        }
        if(len == 2) {
            return (nums[1] - nums[0]);
        }
        int big = nums[0],small = nums[0];
        for(int i = 0; i < len; i++)   //计算出整个数组的最大值和最小值
        {
            big = Math.max(big, nums[i]);
            small = Math.min(small, nums[i]);
        }
        int[] bucketMax = new int[len-1];  //维护两个数组保存每个桶中的最大值和最小值。
        int[] bucketMin = new int[len-1];
        Arrays.fill(bucketMax,small);  //先对数组填充,否则不好通过数组元素判断桶是不是空的
        Arrays.fill(bucketMin,big);
        int gap = (int)Math.ceil((double) (big - small) / (len -1));
        for(int i = 0; i < len; i++)  //填补桶的最大值和最小值数组
        {
            if(nums[i] == small || nums[i] == big) {
                continue;
            }
            index = (nums[i] - small)/gap;
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
        }
        int previous = small, ans = Integer.MIN_VALUE;  //先用最小值作为答案
        for(int i = 0; i < bucketMin.length; i++)  //不能提前算bucketMin[0] - small，因为bucketMin[0]可能是没修改过的
        {
            if(bucketMax[i] == small && bucketMin[i] == big)    //先不考虑最大值和最小值,一定是当前桶的最大值和下一个桶的最小值相邻，所以算的是这部分
            {
                continue;
            }
            ans = Math.max(bucketMin[i] - previous, ans);
            previous = bucketMax[i];  //变量保存桶中最大值
        }
        ans = Math.max(big - previous,ans);   //最后一个gap是 big - 上一个桶中的最大值
        return ans;
    }

    public static void main(String[] algs)
    {
        Maximum_Gap t = new Maximum_Gap();
        int[] nums = {5, 8, 10, 2, 6, 7};
        System.out.println(t.maximumGap(nums));
    }
}
