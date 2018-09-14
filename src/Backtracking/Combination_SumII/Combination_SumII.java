package Backtracking.Combination_SumII;

import java.util.*;

/**
 * Created by PennyLiu on 2018/5/11.
 */
public class Combination_SumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);  //有重复的话先排序
        List<Integer> temp = new ArrayList<>();
        help(0, candidates, target, res, temp);
        return res;
    }

    public void help(int start, int[] candidates, int remain, List<List<Integer>> res, List<Integer> temp)
    {
        if (remain < 0)  //小于0直接返回
        {
            return;
        }
        if(remain == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++)
        {
            if(i > start && candidates[i] == candidates[i-1])  //跳过重复值，因为排序过，所以重复值只会跟之前的一样
            {
                continue;
            }
            temp.add(candidates[i]);
            help(i+1, candidates, remain - candidates[i], res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_SumII t = new Combination_SumII();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(t.combinationSum2(candidates, target));
    }
}
