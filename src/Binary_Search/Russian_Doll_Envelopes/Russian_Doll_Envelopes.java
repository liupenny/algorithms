package Binary_Search.Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by PennyLiu on 2018/1/15.
 *
 * 思路：按照左神课程上讲的，
 */
public class Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes==null || envelopes.length==0 || envelopes[0].length == 1)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });

        int[] ends = new int[envelopes.length];
        int len = 0;
        for (int[] envelope:envelopes)
        {
            int index = Arrays.binarySearch(ends, 0,len,envelope[1]);
            if(index<0)
                index = -(index + 1);
            ends[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }



    public static void main(String[] algs)
    {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        Russian_Doll_Envelopes t = new Russian_Doll_Envelopes();
        System.out.println(t.maxEnvelopes(envelopes));
    }
}
