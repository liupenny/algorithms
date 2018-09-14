package Array.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/1.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }

        int size = triangle.get(triangle.size() - 1).size();  //dp数组，长度是三角形最后一行的长度
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int len = triangle.get(i).size() - 1;
            dp[len] = dp[len - 1] + triangle.get(i).get(len); //先更新最后一个数
            for (int j = len - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);  //更新第一个数，最后一个和第一个数都是只能通过上一行的最后一个和第一个下来
        }
        for (int len : dp) {
            ans = Math.min(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        // List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 1), Arrays.asList(1, 6, 8), Arrays.asList(8, 8, 8, 8));
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2));
        // List<Integer> triangle = Arrays.asList(2,3,4);
        System.out.println(t.minimumTotal(triangle));
    }
}
