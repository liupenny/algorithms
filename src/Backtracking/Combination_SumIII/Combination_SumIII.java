package Backtracking.Combination_SumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/11.
 */
public class Combination_SumIII {
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 1 || k <= 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        help(1, n, k, temp, res);
        return res;
    }

    public void help(int start, int remain, int len, List<Integer> temp, List<List<Integer>> res)
    {
        if(remain < 0 || len < 0) {
            return;
        }
        if(remain == 0 && len == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= 9; i++)
        {
            if(remain < start) {
                break;
            }
            temp.add(i);
            help(i+1, remain - i, len -1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_SumIII t = new Combination_SumIII();
        int k = 3, n = 9;
        System.out.println(t.combinationSum3(k,n));
    }
}
