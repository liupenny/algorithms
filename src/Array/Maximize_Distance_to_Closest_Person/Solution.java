package Array.Maximize_Distance_to_Closest_Person;

/**
 * Created by PennyLiu on 2018/6/14.
 */

public class Solution {
    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length == 0) {
            return 0;
        }

        int ans = 0;
        int begin = 0, end = seats.length - 1;
        boolean isbegin = false, isend = false;
        if(seats[0] == 0)
        {
            isbegin = true;
        }
        if(seats[seats.length-1] == 0)
        {
            isend = true;
        }
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 1)
            {
                if(isbegin == true)
                {
                    ans = Math.max(ans, (i - begin));
                    isbegin = false;
                    begin = i;
                }
                else
                {
                    ans = Math.max(ans, (i - begin)/2);
                    begin = i;
                }
            }
        }
        if(isend == true)
        {
            ans = Math.max(ans, end - begin);
        }
        return ans;
    }


    public int maxDistToClosest_more_decent(int[] seats) {
        int max = 0;
        for(int left = -1, right = 0; right <= seats.length; ++right) {
            if (right == seats.length || seats[right] == 1) {
                if (left == -1 || right == seats.length) {
                    max = Math.max(right - left - 1, max);
                } else {
                    max = Math.max((right - left) / 2, max);
                }
                left = right;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        //int[] seats = {1,0,0,0,1,0,1};
        //int[] seats = {1,0,0,0};
        int[] seats = {0,1,0,0,0,0};
        System.out.println(t.maxDistToClosest(seats));
    }
}
