package Binary_Search.Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2017/10/25.
 * 300. Longest Increasing Subsequence
 *
 * LengthOfLIS：得到每个位置的递增序列长度，n^2
 * LengthOfLIS1：跟2一样，只不过二分查找的过程自己写的
 * LengthOfLIS2:新建一个数组长度跟初始数值一样，对于每个元素都在新数组中去二分查找应该在的位置，找到就直接替换，所以整个数组自动递增
 */
public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }
        int[] help = new int[nums.length]; //help数组存的是对应每个位置的元素，加上该元素共有多少个组成递增序列

        for (int i=0; i<nums.length; i++)
        {
            help[i] = 1;
            for (int j=0; j<i; j++)
            {
                if(nums[i] > nums[j]) {
                    help[i] = Math.max(help[i], help[j] + 1);  //+1就是加上自己
                }
            }
        }


        int ans=0;
        for (int i=0; i<help.length; i++) {
            ans = Math.max(ans, help[i]);
        }

        return ans;
    }

    public int CeilIndex(int[] A, int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    public  int lengthOfLIS1(int[] A)  //跟lengthOfLIS2一样的思路
    {
        // Add boundary case, when array size is one

        int size = A.length;
        int[] tailTable   = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
            {
                tailTable[0] = A[i];
            } else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
            {
                tailTable[len++] = A[i];
            } else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
            {
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
            }
        }

        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);  //如果key在数组中，则返回搜索值的索引；否则返回-1或“-（插入点）“。插入点是索引键将要插入数组的那一点，即第一个大于该键的元素的索引。
            if(i < 0) {
                i = -(i + 1);
            }
            dp[i] = x; //在这里会直接将原来位置上的元素替换掉，一开始2在dp[0],后来1过来了，1在dp[0]
            if(i == len) {
                len++;
            }
        }

        return len;
    }

        public int lengthOfLIS4(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] tails = new int[n];
            int end = 0;
            for (int i = 0; i < n; i++) {
                int pos = lowerBound(tails, nums[i], end);
                if (pos == end) {
                    tails[end++] = nums[i];
                } else {
                    tails[pos] = nums[i];
                }
            }
            return end;
        }

        private int lowerBound(int[] tails, int target, int end) {
            int start = 0;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (tails[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            return start;
        }


        public static void main(String[] algs)
    {

        //List<Integer> starts = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,8));
        int[] a = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        Longest_Increasing_Subsequence t = new Longest_Increasing_Subsequence();
        int ans = t.lengthOfLIS(a);
        System.out.println(ans);
    }

}
