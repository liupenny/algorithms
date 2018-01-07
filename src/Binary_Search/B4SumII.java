package Binary_Search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2017/10/19.
 * 454. 4Sum II
 Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:
 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 思路：暴力方法，四个数组之和=0，则前两个的和 + 后两个的和 = 0. 先算A的元素 + B的元素的所有结果值和次数，再算C+D的，再匹配。
 */
public class B4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length ; i++)
            for (int j = 0; j < B.length; j++)
                map.put(A[i] + B[j],map.getOrDefault(A[i] + B[j], 0) + 1);  //要把对应的个数也存起来

        int res = 0;
        for (int i = 0; i < C.length ; i++)
            for (int j = 0; j < D.length; j++)
                res += map.getOrDefault(-1 * (C[i]+D[j]), 0); //直接取相反数的个数即可

        return res;
    }

    public static void main(String[] algs)
    {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        B4SumII t = new B4SumII();
        int ans = t.fourSumCount(A,B,C,D);
        System.out.println(ans);
    }
}
