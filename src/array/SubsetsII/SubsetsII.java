package array.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/14.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        help(res, temp, nums, 0);
        return res;
    }

    public void help(List<List<Integer>> res, List<Integer> temp, int[] nums, int start)
    {
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++)
        {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            help(res, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII t = new SubsetsII();
        int[] nums = {1,2,2};
        System.out.println(t.subsetsWithDup(nums));
    }
}
