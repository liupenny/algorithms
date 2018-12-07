package Two_Pointers.BinarySubarraysWithSum;

import java.util.HashMap;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/7
 */
public class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0,1);
        for (int x : A) {
            sum += x;
            ans += map.getOrDefault(sum - S,0);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,0,1,0,1};
        s.numSubarraysWithSum(A,2);
    }
}
