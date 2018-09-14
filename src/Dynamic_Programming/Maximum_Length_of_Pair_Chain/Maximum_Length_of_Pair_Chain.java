package Dynamic_Programming.Maximum_Length_of_Pair_Chain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(b[0] >= a[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int pre = Integer.MIN_VALUE, len=0;
        for (int[] a:pairs)
        {
            if(a[0] > pre)
            {
                len++;
                pre = a[1];
            }
            else if (a[1] > pre)
            {
                pre = a[1];
            }
        }
        return len;
    }

    public int findLongestChain1(int[][] pairs)
    {
        if(pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs,(a,b) -> (a[0]- b[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp , 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }
        return dp[pairs.length - 1];
    }
    public static void main(String[] args) {
        Maximum_Length_of_Pair_Chain t = new Maximum_Length_of_Pair_Chain();
        System.out.println(t.findLongestChain(new int[][] {{3,4},{2,3},{1,2}}));
    }
}
