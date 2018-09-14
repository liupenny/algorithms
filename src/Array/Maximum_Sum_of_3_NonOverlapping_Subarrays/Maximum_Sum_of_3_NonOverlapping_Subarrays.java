package Array.Maximum_Sum_of_3_NonOverlapping_Subarrays;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/24.
 */
public class Maximum_Sum_of_3_NonOverlapping_Subarrays
{
    //滑动窗口
    public int[] maxSumOfThreeSubarrays(int[] nums, int k)
    {
        int[] ans = new int[3];
        if(nums == null || nums.length == 0) {
            return ans;
        }

        // 目前找到的最大的长度为1/2/3的序列的起始位置
        int bestSeq = 0;
        int[] bestTwoSeq = {0, k};
        int[] bestThreeSeq = {0, k, k*2};

        // 计算出来每个子序列的和
        int seqSum = 0;
        int seqTwoSum = 0;
        int seqThreeSum = 0;
        for (int i = 0; i < k; i++)
        {
            seqSum += nums[i];
        }
        for (int i = k; i < 2*k; i++)
        {
            seqTwoSum += nums[i];
        }
        for (int i = 2*k; i < 3*k; i++)
        {
            seqThreeSum += nums[i];
        }

        //求出最优的子段和
        int bestSeqSum = seqSum;
        int bestTwoSum = seqSum + seqTwoSum;
        int bestThreeSum = seqSum + seqTwoSum + seqThreeSum;

        //记录当前窗口位置
        int seqIndex = 1;
        int twoSeqIndex = k + 1;
        int threeSeqIndex = k*2 + 1;

        while (threeSeqIndex <= nums.length - k)
        {
            seqSum = seqSum - nums[seqIndex - 1] + nums[seqIndex + k - 1];
            seqTwoSum = seqTwoSum - nums[twoSeqIndex - 1] + nums[twoSeqIndex + k - 1];
            seqThreeSum = seqThreeSum - nums[threeSeqIndex - 1] + nums[threeSeqIndex + k - 1];

            //根据当前结果更新第一个子段
            if(seqSum > bestSeqSum)
            {
                bestSeq = seqIndex;
                bestSeqSum = seqSum;
            }

            //根据当前结果更新第二个子段
            if (seqTwoSum + bestSeqSum > bestTwoSum)
            {
                bestTwoSeq[0] = bestSeq;
                bestTwoSeq[1] = twoSeqIndex;
                bestTwoSum = seqTwoSum + bestSeqSum;
            }

            //根据当前结果更新第三个子段
            if (seqThreeSum + bestTwoSum > bestThreeSum)
            {
                bestThreeSeq[0] = bestTwoSeq[0];
                bestThreeSeq[1] = bestTwoSeq[1];
                bestThreeSeq[2] = threeSeqIndex;
                bestThreeSum = seqThreeSum + bestTwoSum;
            }

            // 更新当前窗口位置
            seqIndex += 1;
            twoSeqIndex += 1;
            threeSeqIndex += 1;
        }
        return bestThreeSeq;
    }

    // 动态规划
    public int[] maxSumOfThreeSubarrays1(int[] nums, int K)
    {
        int[] ans = {-1,-1,-1};  //记录答案位置
        if(nums == null || nums.length == 0) {
            return ans;
        }

        int n = nums.length, maxsum = 0;
        int[] sum = new int[n - K + 1]; //用来计算区间和的数组

        for (int i = 0; i < nums.length; i++) //从前往后计算(i-k+1) -- i的累积和，坐标按照i-k+1即区间的起始位置算
        {
            maxsum += nums[i];
            if(i >= K) {
                maxsum -= nums[i - K];
            }
            if(i >= K-1) {
                sum[i - K + 1] = maxsum;
            }
        }

        int[] posLeft = new int[sum.length];
        int best = 0;
        for (int i = 0; i < sum.length; i++)  //从前往后比较到当前位置，左半部分累积和最大的角标是哪个，有更大的就更新，没有就还是原来的
        {
            if (sum[i] > sum[best]) {
                best = i;
            }
            posLeft[i] = best;
        }

        int[] posRight = new int[sum.length];
        best = sum.length - 1;
        for (int i = sum.length - 1; i >= 0 ; i--) //从后往前比较到当前位置，右半部分累积和最大的角标是哪个，有更大的就更新，没有就还是原来的
        {
            if (sum[i] >= sum[best]) {
                best = i;
            }
            posRight[i] = best;
        }

        for (int i = K; i < sum.length - K; i++)
        {
            int l = posLeft[i-K], r = posRight[i+K];
            if(ans[0] == -1 || sum[l] + sum[i] + sum[r] > sum[ans[0]] + sum[ans[1]] + sum[ans[2]])
            {
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Maximum_Sum_of_3_NonOverlapping_Subarrays t = new Maximum_Sum_of_3_NonOverlapping_Subarrays();
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        System.out.println(Arrays.toString(t.maxSumOfThreeSubarrays1(nums,k)));
    }
}
