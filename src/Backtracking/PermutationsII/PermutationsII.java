package Backtracking.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/12.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        help(nums, temp, res, new boolean[nums.length]);
        return res;
    }

    public void help(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited)
    {
        if(list.size() == nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
//            if ( visited[i] || i > 0 && nums[i] == nums[i-1] && visited[i-1])  //当情况为1,1,2.这个判断在衡量第一个1的时候，无法成功组成长度为3的数组，只添加了0位置和2位置，但是衡量第二个1的时候能成功
//                continue;
//            if ( i > 0 && nums[i] == nums[i-1] && visited[i-1]) //不加visited[i]会导致再次进入循环时从i=0开始
//                continue;
            if ( visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1]) //这个条件能确保重复数字的第一个一定是访问过的，所以后面再遇到重复的就跳过了，而第一个写法是通过个数来判断，用这个
            {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            help(nums, list, res, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsII t = new PermutationsII();
        int[] nums = {1,1,1,2};
        System.out.println(t.permuteUnique(nums));
    }
}
