package Backtracking.Combination_Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/11.
 */
public class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return res;

        ArrayList<Integer> temp = new ArrayList<Integer>();
        help(0,target, candidates, temp, res);
        return res;
    }

    public void help(int start, int remain, int[] candidates, ArrayList<Integer> list, List<List<Integer>> res)
    {
        if (remain < 0)
            return;
        if (remain == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) //这里传过来start,每次都是从start位置开始往后找，这样才能不重复
        {
            list.add(candidates[i]);
            help(i,remain - candidates[i], candidates, list, res); //从i开始继续向后找
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_Sum t = new Combination_Sum();
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(t.combinationSum(candidates,target));
    }
}
