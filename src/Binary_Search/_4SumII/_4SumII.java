package Binary_Search._4SumII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2017/10/19.

 * 思路：暴力方法，四个数组之和=0，则前两个的和 + 后两个的和 = 0. 先算A的元素 + B的元素的所有结果值和次数，再算C+D的，再匹配。
 */
public class _4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length ; i++)
            for (int j = 0; j < B.length; j++)
                map.put(A[i] + B[j],map.getOrDefault(A[i] + B[j], 0) + 1);  //map.getOrDefault(key,defaultval)返回map键对应的map值，如果不存在map键，返回默认值.+1是要把对应的个数也存起来

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
        _4SumII t = new _4SumII();
        int ans = t.fourSumCount(A,B,C,D);  //一共有几个这样的数对
        System.out.println(ans);
    }
}
