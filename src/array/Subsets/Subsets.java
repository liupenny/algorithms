package array.Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/14.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();
        help(res, temp, 0, nums);
        return res;
    }

    void help(List<List<Integer>> res, List<Integer> temp, int start, int[] nums)
    {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++)
        {
            temp.add(nums[i]);
            help(res, temp, i+1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets t = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(t.subsets(nums));
    }
}
