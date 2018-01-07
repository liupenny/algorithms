package Binary_Search.Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2017/10/25.
 * 300. Longest Increasing Subsequence
 */
public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] help = new int[nums.length];

        for (int i=0; i<nums.length; i++)
        {
            help[i] = 1;
            for (int j=0; j<i; j++)
            {
                if(nums[i] > nums[j])
                    help[i] = Math.max(help[i],help[j]+1);
            }
        }


        int ans=0;
        for (int i=0; i<help.length; i++)
            ans = Math.max(ans,help[i]);

        return ans;
    }

    public int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    public  int lengthOfLIS1(int A[])
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
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }

        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

        public static void main(String[] algs)
    {

        //List<Integer> starts = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,8));
        int[] a = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        Longest_Increasing_Subsequence t = new Longest_Increasing_Subsequence();
        int ans = t.lengthOfLIS1(a);
        System.out.println(ans);
    }

}
