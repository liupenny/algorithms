package Dynamic_Programming.Number_of_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/5/17.
 */
public class Number_of_Longest_Increasing_Subsequence {
    public int findNumberOfLIS(int[] nums)
    {
        int N = nums.length;
        if(N <= 1) {
            return N;
        }

        int[] length = new int[N];  //lengths[i] = 以nums[i]结尾的最长序列的长度
        int[] count = new int[N];   //count[i] = 以nums[i]结尾的最长序列的个数
        Arrays.fill(count,1);

        for (int j = 0; j < N; j++)
        {
            for (int i = 0; i < j; i++)
            {
                if(nums[i] < nums[j])
                {
                    if(length[i] >= length[j])
                    {
                        length[j] = length[i] + 1;
                        count[j] = count[i];
                    }
                    else if (length[i] + 1 == length[j])
                    {
                        count[j] += count[i];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int len:length)  //找出最长的子序列的长度
        {
            longest = Math.max(len, longest);
        }
        for (int i = 0; i < N; i++)  //把这个长度的都加起来
        {
            if(length[i] == longest) {
                ans += count[i];
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Number_of_Longest_Increasing_Subsequence t = new Number_of_Longest_Increasing_Subsequence();
        int[] nums = {1,3,5,4,7};
        System.out.println(t.findNumberOfLIS(nums));
    }
}
