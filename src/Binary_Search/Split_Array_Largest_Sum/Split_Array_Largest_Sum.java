package Binary_Search;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2017/10/27.
 * 410. Split Array Largest Sum
 * 1：动态规划做法
 * 我们建立一个二维数组dp，其中dp[i][j]表示将数组中前j个数字分成i组所能得到的最小的各个子数组中最大值，初始化为整型最大值，
 * 如果无法分为i组，那么还是保持为整型最大值。为了能快速的算出子数组之和，我们还是要建立累计和数组，难点就是在于要求递推公式了。
 * 我们来分析，如果前j个数字要分成i组，那么i的范围是什么，由于只有j个数字，如果每个数字都是单独的一组，那么最多有j组；
 * 如果将整个数组看为一个整体，那么最少有1组，所以i的范围是[1, j]，所以我们要遍历这中间所有的情况，
 * 假如中间任意一个位置k，dp[i-1][k]表示数组中前k个数字分成i-1组所能得到的最小的各个子数组中最大值，而sums[j]-sums[k]就是后面的数字之和，
 * 我们取二者之间的较大值，然后和dp[i][j]原有值进行对比，更新dp[i][j]为二者之中的较小值，这样k在[1, j]的范围内扫过一遍，dp[i][j]就能更新到最小值，
 * 我们最终返回dp[m][n]即可。
 *
 * 2：二分法
 * 如果m和数组nums的个数相等，那么每个数组都是一个子数组，所以返回nums中最大的数字即可，如果m为1，那么整个nums数组就是一个子数组，
 * 返回nums所有数字之和，所以对于其他有效的m值，返回的值必定在上面两个值之间，所以我们可以用二分搜索法来做。
 * 我们用一个例子来分析，nums = [1, 2, 3, 4, 5], m = 3，我们将left设为数组中的最大值5，right设为数字之和15，然后我们算出中间数为10，
 * 我们接下来要做的是找出和最大且小于等于10的子数组的个数，在具体找分组的过程中使用贪心算法。
 * [1, 2, 3, 4], [5]，可以看到我们无法分为3组，说明mid偏大，所以我们让right=mid，
 * 然后我们再次进行二分查找哦啊，算出mid=7，再次找出和最大且小于等于7的子数组的个数，[1,2,3], [4], [5]，我们成功的找出了三组，
 * 说明mid还可以进一步降低，我们让right=mid，然后我们再次进行二分查找哦啊，算出mid=6，再次找出和最大且小于等于6的子数组的个数，[1,2,3], [4], [5]，
 * 我们成功的找出了三组，我们尝试着继续降低mid，我们让right=mid，然后我们再次进行二分查找哦啊，算出mid=5，再次找出和最大且小于等于5的子数组的个数，[1,2], [3], [4], [5]，
 * 发现有4组，此时我们的mid太小了，应该增大mid，我们让left=mid+1，此时left=6，right=5，循环退出了，我们返回left即可
 *
 *
 3: 二分法的具体解释
 Introduction to this problem:
 We can break this problem into two smaller problems:

 Given an array (A), number of cuts (CUTS), and the Largest sum of sub-arrays (MAX). Can you use at most CUTS cuts to segment array A into CUTS + 1 sub-arrays, such that the sum of each sub-array is smaller or equal to MAX?
 Given a lower bound (left), an upper bound (right), an unknown bool array (B), and an API uses i as input and tells you whether B[i] is true. If we know there exists an index k, that B[i] is false when i < k, and B[i] is true when i >= k. What is the fastest way to find this k (the lower bound)?
 Solution to the first sub-problem (Skip this part if you already knew how to solve 1st sub-problem):
 For the first question, we can follow these steps:

 For each element in the array, if its value is larger than MAX, we know it's not possible to cut this array into groups that the sum of all groups are smaller than MAX. (Reason is straightforward, if A is [10, 2, 3, 5] and MAX is 6, even you have 3 cuts by which you can cut A as [[10], [2], [3], [5]], the group containing 10 will still be larger than 6).
 Use greedy algorithm to cut A. Use an accumulator ACC to store the sum of the currently processed group, and process elements in A one by one. For each element num, if we add num with ACC and the new sum is still no larger than MAX, we update ACC to ACC + num, which means we can merge num into the current group. If not, we must use a cut before num to segment this array, then num will be the first element in the new group.
 If we didn't go through A but already used up all cuts, then it's not possible only using CUTS cuts to segment this array into groups to make sure sum of each sub-array is smaller than MAX. Otherwise, if we can reach the end of A with cuts left (or use exactly CUTS cuts). It's possible to do so.
 Then the first question is solved.

 Solution to the second sub-problem(Skip this part if you already knew how to solve 2nd sub-problem):
 The array B will be something like [false, false, ..., false, true, true, ..., true]. We want to find the index of the first true.
 Use binary search to find this k. Keep a value mid, mid = (left + right) / 2. If B[mid] = false, then move the search range to the upper half of the original search range, a.k.a left = mid + 1, otherwise move search range to the lower half, a.k.a right = mid.
 Why this algorithm is correct...
 No matter how we cut the array A, the Largest sum of sub-arrays will fall into a range [left, right]. Left is the value of the largest element in this array. right is the sum of this array. (e.g., Given array [1, 2, 3, 4, 5], if we have 4 cuts and cut it as [[1], [2], [3], [4], [5]], the Largest sum of sub-arrays is 5, it cannot be smaller. And if we have 0 cut, and the only sub-array is [[1, 2, 3, 4, 5]], the Largest sum of sub-arrays is 15, it cannot be larger).
 However, we cannot decide the number of cuts (CUTS), this is an given constraint. But we know there must be a magic number k, which is the smallest value of the Largest sum of sub-arrays when given CUTS cuts. When the Largest sum of sub-arrays is larger than k, we can always find a way to cut A within CUTS cuts. When the Largest sum of sub-arrays is smaller than k, there is no way to do this.
 Example
 For example, given array A [1, 2, 3, 4, 5]. We can use 2 cuts.

 No matter how many cuts are allowed, the range of the possible value of the Largest sum of sub-arrays is [5, 15].
 When given 2 cuts, we can tell the magic number k here is 6, the result of segmentation is [[1, 2, 3], [4], [5]].
 When Largest sum of sub-arrays is in range [6, 15], we can always find a way to cut this array within two cuts. You can have a try.
 However, when Largest sum of sub-arrays is in range [5, 5], there is no way to do this.
 This mapped this problem into the second sub-problem. Bool array B here is [5:false, 6:true, 7:true, 8:true, ..., 15:true]. We want to find the index i of the first true in B, which is the answer of this entire question, and by solving the first sub-problem, we have an API that can tell us given an i (Largest sum of sub-arrays), whether B[i] is true (whether we can find a way to cut A to satisfy the constraint).
 */
public class Split_Array_Largest_Sum {
    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m+1][n+1];
        int[] sum = new int[n+1];
        for(int i=0; i<m+1; i++)
            for (int j=0; j<n+1; j++)
                dp[i][j] = Integer.MAX_VALUE;
        dp[0][0] = 0;
        sum[0] = 0;
        for (int i=1; i<=n; i++)
            sum[i]= sum[i-1] + nums[i-1];

        for (int i=1; i<=m; ++i)
            for (int j=1; j<=n; ++j)
                for (int k=i-1; k<j; ++k)
                {
                    int val=Math.max(dp[i-1][k],sum[j]-sum[k]);   //因为最后要求dp[m][n],需要的是n那一列，那一列的数值由那一行之前的挨个比较得出
                    dp[i][j] = Math.min(dp[i][j],val);
                }
        return dp[m][n];
    }

//    public int splitArray2(int[] nums, int m) {
//        int n = nums.length;
//        int[] dp = new int[n+1];
//        int[] sum = new int[n+1];
//        for (int j=1; j<n+1; j++)
//            dp[j] = Integer.MAX_VALUE;
//        sum[0] = 0;
//        for (int i=1; i<=n; i++)
//            sum[i]= sum[i-1] + nums[i-1];
//
//        for (int i=1; i<m; i++)
//            for (int j=1; j<n; j++)
//                for (int k=i-1; k<j; k++)
//                {
//                    int tmp = dp[k+1];
//                    int val = Math.max(dp[k],sum[j] - sum[k]);
//                    dp[j] = Math.min()
//                }
//    }

    public int splitArray4(int[] nums, int m)
    {
        int L = nums.length;
        int[] S = new int[L+1];
        S[0]=0;
        for(int i=0; i<L; i++)
            S[i+1] = S[i]+nums[i];

        int[] dp = new int[L];
        for(int i=0; i<L; i++)
            dp[i] = S[L]-S[i];

        for(int s=1; s<m; s++)
        {
            for(int i=0; i<L-s; i++)
            {
                dp[i]=Integer.MAX_VALUE;
                for(int j=i+1; j<=L-s; j++)
                {
                    int t = Math.max(dp[j], S[j]-S[i]);
                    if(t<=dp[i])
                        dp[i]=t;
                    else
                        break;
                }
            }
        }

        return dp[0];
    }

    public int splitArray3(int[] nums, int m)
    {
        int max = 0; long sum = 0;
        for (int num:nums)
        {
            max = Math.max(max,num);
            sum += num;
        }

        if(m==1)  return (int)sum;
        long left = max, right = sum;
        while (left <= right)  //注意 =
        {
            long mid = left + (right - left)/2;
            if(valid(mid, nums, m))
                right = mid - 1;  //注意这里的 -1 和下面的 +1
            else
                left = mid + 1;
        }
        return (int)left;
    }

    public boolean valid(long target, int[] nums, int m)
    {
        int count = 1;  //原题目要求分成m个，所以划m-1次
        long total = 0;
        for (int num:nums)
        {
            total += num;
            if(total > target)
            {
                total = num;  //如果加和值大于规定值，就开始重新加和
                count++;
                if (count > m)
                    return false;
            }
        }
        return true;
    }

        public static void main(String[] algs)
    {
        //int[] a = {1,3,5,8,6,4,7};
        int[] a = {7,2,5,10,8};
        Split_Array_Largest_Sum t = new Split_Array_Largest_Sum();
        int ans = t.splitArray4(a,2);
        System.out.println(ans);
    }

}
